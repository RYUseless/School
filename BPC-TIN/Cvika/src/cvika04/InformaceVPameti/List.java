package cvika04.InformaceVPameti;

public class List {

    private Uzel prvni;
    private Uzel posledni;


    public void addFirst(int Data){
        Uzel uzel = new Uzel(Data);
        if(prvni == null){
            uzel.setData(Data);
            prvni = uzel;
            posledni = uzel;
        } else {
            uzel.setData(Data);
            uzel.setNext(prvni);
            uzel.setPrev(null);
            prvni = uzel;
        }
    }

    public void addLast(int Data){
        if(prvni == null){
            prvni = new Uzel(Data);
            posledni = prvni;
            return;
        }
        Uzel last = posledni;
        Uzel novyUzel = new Uzel(Data);
        last.setNext(novyUzel);
        novyUzel.setPrev(last);
        posledni = novyUzel;
    }
    public void removeFirst(){
        if (prvni == null){
            return;
        }
        prvni = prvni.getNext();
        prvni.setPrev(null);
    }

    public void removeLast(){
        if(prvni == null){
            return;
        }
        Uzel bajUzel = posledni;
        bajUzel.getPrev().setNext(null);
    }
    public boolean contains(int Data, int option){
        switch(option){
            case 1: //Is empty
                if(prvni != null){
                    System.out.println("list neni empty");
                    return true;
                } else {
                    System.out.println("list je empty");
                    return false;
                }
            case 2: // is this value here?
                Uzel uzel = prvni;
                if(uzel.getData() == Data){
                    System.out.println("toto cislo: "+ Data +" zde je");
                    return true;
                }
                while(uzel.hasNext()){
                    if(uzel.getData() == Data){
                        System.out.println("toto cislo: "+ Data +" zde je");
                        return true;
                    }
                uzel = uzel.getNext();
                }
                break;

        }
        return false;
    }


    public void print(List list,String akce){
        Uzel uzel = list.prvni;
        System.out.println("\n" + "Akce listu je: "+akce + "\nList:");
        int counter = 0;
        while(uzel != null){
            System.out.println("cislo uzlu "+ counter + " | data: " +uzel.getData());
            uzel = uzel.getNext();
            counter++;
        }
    }
}
