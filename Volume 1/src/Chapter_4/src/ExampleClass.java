package Chapter_4.src;

/**
 * ExampleClass is a demonstration of a class with Javadoc comments.
 * It contains a private field and a public method.
 */
public class ExampleClass {

    /**
     * This is an example field.
     */
    private String exampleField;

    /**
     * This is the constructor for ExampleClass.
     * @param exampleField the initial value for the exampleField
     */
    public ExampleClass(String exampleField) {
        this.exampleField = exampleField;
    }

    /**
     * This is an example method.
     * @return the value of the exampleField
     */
    public String exampleMethod() {
        return this.exampleField;
    }
}
