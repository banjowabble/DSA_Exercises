public class Hi {
    public static void main(String[] args) {
        System.out.print("Hi, ");
        System.out.print(args[0]);
        System.out.println(". How are you?");
    }
}
/* java Hi: Hi, Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 at Hi.main
   java Hi @!&^%: The ampersand (&) character is not allowed. The & operator is reserved for future use; wrap an ampersand in double quotation marks ("&") to pass it as part of a string.
   java Hi 1234: Hi, 1234. How are you?
   java Hi.class Bob: Error: Could not find or load main class Hi.class
   java Hi.java Bob: Hi, Bob. How are you?
   java Hi Alice Bob: Hi, Alice. How are you?
 */
