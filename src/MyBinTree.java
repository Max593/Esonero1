import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 12/04/17.
 */
public class MyBinTree implements BinTree {
    private int root;
    private List<BinTree> children = new ArrayList<>();
    private boolean leaf;

    public MyBinTree(int n, BinTree t1, BinTree t2) {
        this.root = n;
        children.add(t1);
        children.add(t2);
    }
    public MyBinTree(int n, int t1, int t2) {  //Nodo con 2 foglie
        this.root = n;
        children.add(new MyBinTree(t1));
        children.add(new MyBinTree(t2));
        leaf = false;
    }
    public MyBinTree(int n) {  //Foglia
        this.root = n;
        leaf = true;
    }

    @Override
    public int root() { return root; }

    @Override
    public BinTree leftChild() {
        if(!leaf) { return children.get(0); }
        return null;
    }

    @Override
    public BinTree rightChild() {
        if(!leaf) { return children.get(1); }
        return null;
    }

    @Override
    public void times(BinTree t) {
        for(BinTree n : this.children) {
            if(n.leftChild() == null || n.rightChild() == null) {
                this.children = Arrays.asList(t, t);
            }
            else { n.times(t); }
        }
    }
/*  //Metodo riservato esclusivamente al test dei nodi. Non necessario per la consegna
    public void printIntTree() { printIntTree("", true); }
    private void printIntTree(String prefix, boolean isTail) {  //Utilizzato operatore condizionale ternario per leggibilità generale
        System.out.println(prefix + (isTail ? "└── " : "├── ") + this.root);
        for (int i = 0; i < this.children.size() - 1; i++) {
            ((MyBinTree)this.children.get(i)).printIntTree(prefix + (isTail ? "    " : "│   "), false);
        }
        if (this.children.size() > 0) {
            ((MyBinTree)this.children.get(this.children.size() - 1)).printIntTree(prefix + (isTail ?"    " : "│   "), true);
        }
    }
*/
}
