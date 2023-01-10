package ryu.useless.project03.data;

import javafx.scene.control.Alert;
import ryu.useless.project03.api.*;
import ryu.useless.project03.config.DataSetupConfig;
import ryu.useless.project03.exceptions.DataAccessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    /**
     * LOGIN things: -------------------------------------------------------------------------------------
     **/
    public AuthenticationView findPersonByEmail(String email) {
        try (Connection connection = DataSetupConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT email, password FROM bds.person p JOIN bds.login l ON p.id_person = l.id_login " +
                             "JOIN bds.roles r ON p.id_person = r.id_roles" +
                             " WHERE (type_of_role = 'admin' or type_of_role = 'maintainer') AND p.email = ?;")) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapToPersonAuth(resultSet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private AuthenticationView mapToPersonAuth(ResultSet rs) throws SQLException {
        AuthenticationView person = new AuthenticationView();
        person.setEmail(rs.getString("email"));
        person.setPassword(rs.getString("password"));
        return person;
    }

    /**
     * BASIC VIEW: -------------------------------------------------------------------------------------
     **/
    public List<PersonBasicView> getPersonsBasicView() {
        try (Connection connection = DataSetupConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     " SELECT id_person, name, surname, email, city, phone_number " +
                             "FROM bds.person p LEFT JOIN bds.address c ON p.id_person = c.id_address;");
             ResultSet resultSet = preparedStatement.executeQuery();) {
            List<PersonBasicView> personBasicViews = new ArrayList<>();
            while (resultSet.next()) {
                personBasicViews.add(mapToPersonBasicView(resultSet));
            }
            return personBasicViews;
        } catch (SQLException e) {
            throw new DataAccessException("Persons basic view could not be loaded.", e);
        }
    }

    private PersonBasicView mapToPersonBasicView(ResultSet rs) throws SQLException {
        PersonBasicView personBasicView = new PersonBasicView();
        personBasicView.setId(rs.getLong("id_person"));
        personBasicView.setName(rs.getString("name"));
        personBasicView.setSurname(rs.getString("surname"));
        personBasicView.setEmail(rs.getString("email"));
        personBasicView.setCity(rs.getString("city"));
        personBasicView.setPhoneNumber(rs.getLong("phone_number"));
        return personBasicView;
    }

    /**
     * EDIT | CREATE : -------------------------------------------------------------------------------------
     **/
    //DELETE HAS QUERY IN THE CONTROLLER ITSELF

    //CREATE PERSON ----------------------------------------
    private boolean didCreateRun;
    public boolean didCreateRunned() {
        return didCreateRun;
    }

    public void createPerson(PersonCreateView personCreateView) { //TODO: dodelat insert pro heslo :)
        String insertPersonSQL = "INSERT INTO bds.person (name, surname, email, phone_number) VALUES(?,?,?,?);";
        try (Connection connection = DataSetupConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, personCreateView.getName());
            preparedStatement.setString(2, personCreateView.getSurename());
            preparedStatement.setString(3, personCreateView.getEmail());
            preparedStatement.setLong(4, personCreateView.getPhoneNumber());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new DataAccessException("Creating person failed, no rows affected.");
            } else {
                didCreateRun = true;
            }
        } catch (SQLException e) {
            System.out.println("I AM THE ERROR" + e.getMessage());
        }
    }

    //EDIT PERSON ----------------------------------------
    private boolean didItRun;

    public boolean isDidItRun() {
        return didItRun;
    }

    public void editPerson(PersonEditView personEditView) {
        String insertPersonSQL = "UPDATE bds.person p SET name = ?, surname = ?, email = ?, phone_number = ? WHERE p.id_person = ?"; //update
        String checkIfExists = "SELECT id_person FROM bds.person p WHERE p.id_person = ?"; //Finding zi person
        try (Connection connection = DataSetupConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(checkIfExists, Statement.RETURN_GENERATED_KEYS)) {
             ps.setLong(1, personEditView.getID());
             ps.execute();
            try (ResultSet resultSet = ps.executeQuery()) {
                if(!resultSet.next()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Something died!");
                    alert.setContentText("invalid id");
                    alert.showAndWait();
                    return;
                }
            }
            try { connection.setAutoCommit(false);
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertPersonSQL, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, personEditView.getName());
                    preparedStatement.setString(2, personEditView.getSurname());
                    preparedStatement.setString(3, personEditView.getEmail());
                    preparedStatement.setInt(4, personEditView.getPhoneNumber());
                    preparedStatement.setLong(5, personEditView.getID());

                    int affectedRows = preparedStatement.executeUpdate();
                    if (affectedRows == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("Something died!");
                        alert.setContentText("Creating person failed, no rows affected.");
                        alert.showAndWait();
                        return;
                    }
                } catch (SQLException e) {
                    throw new DataAccessException("La error"+e.getCause());
                }
                connection.commit();
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("What did died: \n" + e.getMessage());
                alert.setContentText("What was the cause: \n" + e.getCause());
                alert.showAndWait();
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Something died!");
            alert.setContentText("What did died: \n" + e.getMessage());
            alert.showAndWait();
            throw new RuntimeException(e);
        }
        didItRun = true;
    }
    /**
     * SQL INJECTION ATTACK: -------------------------------------------------------------------------------------
     **/
    public List<SQLinjectionView> getSQLview() { //view for the table, not the actual attack
        try (Connection connection = DataSetupConfig.getConnection();
             PreparedStatement prpmtstmnt = connection.prepareStatement(
                     "SELECT capybara01, capybara02 FROM bds.dummytable;");
             ResultSet resultSet = prpmtstmnt.executeQuery();) {
            List<SQLinjectionView> sqlbasicView = new ArrayList<>();
            while (resultSet.next()) {
                sqlbasicView.add(mapToSQL(resultSet));
            }
            return sqlbasicView;
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succesfull operation");
            alert.setHeaderText("Dummy table was succesfully killed");
            alert.setContentText("Error print: \n" + e.getMessage());
            alert.showAndWait();
            throw new DataAccessException("ERROR: ", e);
        }
    }

    private SQLinjectionView mapToSQL(ResultSet cappy) throws SQLException { //map for the table, not for the attack
        SQLinjectionView sqLinjectionView = new SQLinjectionView();
        sqLinjectionView.setCapybara1(cappy.getString("capybara01"));
        sqLinjectionView.setCapybara2(cappy.getString("capybara02"));
        return sqLinjectionView;
    }

    //SQL attack things starts now ---
    public void getSQLviewAttack(String input) {
        String noPreparedSatement = "SELECT capybara01, capybara02 FROM bds.dummytable WHERE capybara01 = '" + input + "';";
        try (Connection connection = DataSetupConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(noPreparedSatement)) {
            List<SQLinjectionView> sqlbasicView = new ArrayList<>();
            while (resultSet.next()) {
                sqlbasicView.add(mapToSQL(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getSQLviewAttackPrprstmnt(String input) {
        try (Connection connection = DataSetupConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT capybara01, capybara02 FROM bds.dummytable WHERE capybara01 = ?;");) {
            preparedStatement.setString(1, input);
            List<SQLinjectionView> sqlbasicView = new ArrayList<>();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    while (resultSet.next()) {
                        sqlbasicView.add(mapToSQL(resultSet));
                    }
                }
            } catch (SQLException e) {
                throw new DataAccessException("findByEmailPreparedStatement SQL failed.", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * DETAILED VIEW: -------------------------------------------------------------------------------------
     **/
    public PersonDetailedView findPersonDetailedView(String  email) {
        try (Connection connection = DataSetupConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT name, surname, email, phone_number, city, zip_code, street "+
                             "FROM bds.person p LEFT JOIN bds.address a ON p.id_person = a.id_address WHERE p.email = ?;")) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapToPersonDetailView(resultSet);
                }
                if(!resultSet.next()){ //bit lame, but at least there is some info :)
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("invalid email!!!");
                    alert.setContentText("Detailed view will be empty");
                    alert.showAndWait();
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("Find person by EMAIL with addresses failed.", e);
        }
        return null;
    }
    private PersonDetailedView mapToPersonDetailView(ResultSet rs) throws SQLException {
        PersonDetailedView detailedView = new PersonDetailedView();
        detailedView.setName(rs.getString("name"));
        detailedView.setSurname(rs.getString("surname"));
        detailedView.setEmail(rs.getString("email"));
        detailedView.setPhoneNumber(rs.getInt("phone_number"));
        detailedView.setCity(rs.getString("city"));
        detailedView.setZipCode(rs.getInt("zip_code"));
        detailedView.setStreet(rs.getString("street"));
        return detailedView;
    }
    /**
     * FILTER VIEW: -------------------------------------------------------------------------------------
     **/
    public List<PersonFilterView> filterPersonView(String name) {
        try (Connection connection = DataSetupConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id_person, name, surname, email, city, phone_number FROM bds.person p LEFT JOIN bds.address c ON p.id_person = c.id_address WHERE p.name LIKE ?;");
            preparedStatement.setString(1,   name);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<PersonFilterView> personBasicViews = new ArrayList<>();
            while (resultSet.next()) {
                personBasicViews.add(mapToFilterView(resultSet));
            }
            return personBasicViews;
        } catch (SQLException e) {
            System.out.println("MI ERRORES"+e.getCause());
            throw new DataAccessException("Persons basic view could not be loaded.", e); //this is return statement thing
        }
    }
    private PersonFilterView mapToFilterView(ResultSet rs) throws SQLException {
        PersonFilterView personFilterView = new PersonFilterView();
        personFilterView.setId(rs.getLong("id_person"));
        personFilterView.setName(rs.getString("name"));
        personFilterView.setSurname(rs.getString("surname"));
        personFilterView.setEmail(rs.getString("email"));
        personFilterView.setCity(rs.getString("city"));
        personFilterView.setPhoneNumber(rs.getLong("phone_number"));
        return personFilterView;
    }
}
