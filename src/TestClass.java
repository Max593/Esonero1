/**
 * Created by max on 12/04/17.
 */
public class TestClass {
    public static void main(String[] args) {
        MyBinTree t0 = new MyBinTree(6, new MyBinTree(4,7, 5), new MyBinTree(7, 2,1));
        MyBinTree t = new MyBinTree(2, new MyBinTree(2, new MyBinTree(4,8,2), new MyBinTree(0,2,5)), new MyBinTree(2,7,3));
        t0.printIntTree();
        t.printIntTree();
        t0.times(t);
        t0.printIntTree();
    }
}
