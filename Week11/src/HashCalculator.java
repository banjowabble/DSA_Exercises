public class HashCalculator {
    private static int hash(Integer key)
    { return (key.hashCode() & 0x7fffffff) % 17; }

    public static void main(String[] args) {
        Character character = 'K';
        Integer integer = 40;
        System.out.println(hash(integer));
    }
}
