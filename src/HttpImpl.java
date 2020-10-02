import java.util.ArrayList;
import java.util.List;

public class HttpImpl implements HttpInterface{

    /** Example for interface with concatenation **/
    public String getRecipeDetails(String name, String category, String price) {

        String value = "";
        System.out.println("Interface method with concatenation");
        System.out.println("The recipe name is "+ name + " and it falls under the category " + category +" is just for "+ price);
        System.out.println("-------------");
        return  value;

    }
    /** Java Streams filters based on string contains **/
    public void getStreamDetails(ArrayList<String> arrayList) {

        List<String> stringList = arrayList;
        long count = stringList.parallelStream().filter(string -> string.contains("r")).count();
        System.out.println("Interface method also using java streams to get the count of category names with letter contains r");
        System.out.println("The count of categories with letter r is" +count);
        System.out.println("-------------");

    }
}
