import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        int count = 0;
        boolean connectCheck = false;
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            count++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                for (int i = 0; i < N-2; i++) {
                    if (!uf.connected(i, i + 1)){
                        connectCheck = false;
                        break;
                    }
                    else{ connectCheck = true;}
                }
                if (connectCheck){
                    System.out.println(count);
                    return;
                }
            }
        }
        System.out.println("FAILED");
    }
}