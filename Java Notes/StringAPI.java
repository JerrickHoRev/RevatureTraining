public class StringAPI {
    public static void main(String[] args) {
        String myName = "Eric";
        System.out.println(myName);

        myName += "Suminski"; // a new string object is being created here, and myName has its reference changed to the brand new string

        System.out.println(myName);

        String[] splitMyName = myName.split(" ");
        for (int x = 0; x < splitMyName.length; x++) {
            System.out.println(splitMyName[x]);
        }
        
        String numbers = "10 7 15 24 5";

        /*
         * So this begs the question, if you want to change your word/prhase, what tool would you use to do so? The easies tool to use would be the StringBuilder class
         */

        StringBuilder myWord = new StringBuilder(myName);

        System.out.println(myName);

        // myWord.reverese();  
        myWord.append(" the bold!");
        System.out.println(myWord);

        myWord.toString().split("");
    }
}
