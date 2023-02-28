package cvika05.Strom;

public class Tree {
    private Node root;
    public void insert(int data){ //INSERT volany z mainu
        if(root == null){ //pokud neni root clen stromu, zde se udela
            root = new Node(data);
            System.out.println("root je: "+data);
        }else {
            insert2(root,data); //jinak se jde na druhou insert vec
        }
    }
    private void insert2(Node node, int data) { //sorting nalevo nebo doprava
        if (data < node.getData()){ //LEVA STR
            if(node.getLevo() != null){ //uz ma kamarada nalevo
                insert2(node.getLevo(),data);
            }  else {
                System.out.println("vkladani uzlu: "+ data +" nalevo od " + node.getData());
                node.setLevo(new Node(data));
            }
        }
        if (data > node.getData()){ //PRAVA STR
            if(node.getPravo() != null){ //uz ma kamarada napravo
                insert2(node.getPravo(),data);
            }  else {
                System.out.println("vkladani uzlu: "+ data +" napravo od " + node.getData());
                node.setPravo(new Node(data));
            }
        }
    }

    // contains thing
    private boolean contains(Node node, int i){
        if (node == null) return false;
        if (node.getData() == i) return true;
        return contains(node.getLevo(), i) || contains(node.getPravo(), i);
    }
    public void contains(int data) {  //volani contains private veci
        System.out.println("cislo "+data+" je v systemu? --> "+contains(root, data));
    }

    // printovani
    public void print(){ //print void, co vola funkce dal
        System.out.print("PREORDER JE: ");
        printPreorder(root);
        System.out.print("\n");
        System.out.print("POSTORDER JE: ");
        printPostorder(root);
        System.out.print("\n");
        System.out.print("INORDER JE: ");
        printInorder(root);
        System.out.print("\n");
        System.out.print("LISTY JSOU: ");
        getLeaves(root);
        System.out.print("\n");
    }
    private void printPreorder(Node node) {
        if (node == null){ //pokud null, baj baj
            return;
        }
        System.out.print(node.getData() + " ");
        printPreorder(node.getLevo());
        printPreorder(node.getPravo());
    }
    private void printPostorder(Node node) {
        if (node == null){ //pokud null, baj baj
            return;
        }
        printPostorder(node.getLevo());
        printPostorder(node.getPravo());
        System.out.print(node.getData() + " ");
    }
    void printInorder(Node node) {
        if (node == null){
            return;
        }
        printInorder(node.getLevo());
        System.out.print(node.getData() + " ");
        printInorder(node.getPravo());
    }


    public void getLeaves(Node node) {
        if (root == null) {
            return;
        }
        if (node.getLevo() == null && node.getPravo() == null)
            System.out.print(node.getData() + " ");
        if (node.getLevo() != null)
            getLeaves(node.getLevo());
        if (node.getPravo() != null)
            getLeaves(node.getPravo());

    }

// Print reverse
    public void printReverse(){
        System.out.print("REVERSE PREORDER: ");
        printReversePreorder(root);
        System.out.print("\n");
        System.out.print("REVERSE POSTORDER: ");
        printReversePostorder(root);
        System.out.print("\n");
        System.out.print("REVERSE INORDER: ");
        printReverseInorder(root);
        System.out.print("\n");
    }
    private void printReversePreorder(Node node) {
        if (node == null){
            return;
        }
        printReversePreorder(node.getPravo());
        printReversePreorder(node.getLevo());
        System.out.print(node.getData() + " ");
    }
    private void printReversePostorder(Node node){
        if (node == null){ //pokud null, baj baj
            return;
        }
        System.out.print(node.getData() + " ");
        printReversePostorder(node.getPravo());
        printReversePostorder(node.getLevo());
    }
    private void printReverseInorder(Node node){
        if (node == null){
            return;
        }
        printReverseInorder(node.getPravo());
        System.out.print(node.getData() + " ");
        printReverseInorder(node.getLevo());
    }
}
