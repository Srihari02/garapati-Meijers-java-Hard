public class SampleSingleton {

    private static SampleSingleton singleInstance = null;

    public static SampleSingleton getInstance(String name) {
        if (singleInstance == null)
            singleInstance = new SampleSingleton(name);

       return singleInstance;
    }

    public String value;


    private SampleSingleton(String name) {
        value = "Name of recipe "+ name + " This is the appending string from Sample singleton";
    }

}
