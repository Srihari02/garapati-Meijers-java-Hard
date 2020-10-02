import java.util.ArrayList;


/** Http Interface */
interface HttpInterface {

    /** Example for interface with concatenation **/
    String getRecipeDetails(String name, String category, String price);

    /** Java Streams filters based on string contains **/
    void getStreamDetails(ArrayList<String> arrayList);
}
