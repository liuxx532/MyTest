public class ComputeTest {
    public static void main(String[] args) {
        int a = -10;
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80000000 >>> 1) >>> (31 - i);
            System.out.print(t);
        }
    }
}
