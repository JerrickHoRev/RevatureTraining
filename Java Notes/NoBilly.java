public class NoBilly extends RuntimeException{
    /*
     * There are two ways to create your own exceptions, and this is accomplished by either extending the 
     * Exception or RuntimeException classes. If your custom exception extends Exception it will be a 
     * "checked exception", meaning that any code that could throw the exception MUST be handled.
     * If the exception extends RuntimeException then it is a "unchecked exception"
     */
}
