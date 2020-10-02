import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HttpUrlConnection {

        public void callAPI() {
            try {
                URL url = new URL("http://starlord.hackerearth.com/recipe");
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader((huc.getInputStream())));
                String inputLine;
                StringBuilder outputResponse = new StringBuilder();
                while ((inputLine = br.readLine()) != null) {
                    outputResponse.append(inputLine);
                }

                /**Json parsing**/
                JSONArray jsonArray = new JSONArray(outputResponse.toString());
                System.out.println("Complete JsonArray Respose from REST API " + jsonArray);
                System.out.println("-------------");

                ArrayList<String> arrlist = new ArrayList<String>();
                HttpInterface demo = new HttpImpl();

                FileWriter writer = new FileWriter("recipes.csv");
                BufferedWriter bwr = new BufferedWriter(writer);
                for (int i = 0; i < jsonArray.length(); i++) {
                    HttpBean bean = new HttpBean();
                    JSONObject jobj = jsonArray.getJSONObject(i);

                    bean.setName(jobj.get("name").toString());
                    bean.setCategory(jobj.get("category").toString());
                    bean.setLabel(jobj.get("label").toString());
                    bean.setPrice(jobj.get("price").toString());
                    bean.setId(jobj.get("id").toString());
                    bean.setImage(jobj.get("image").toString());
                    bean.setDescription(jobj.get("description").toString().replaceAll(",",""));

                    arrlist.add(bean.getCategory());

                    /** Call getRecipe to concatenate the string variables**/
                    demo.getRecipeDetails(bean.getName(), bean.getCategory(), bean.getPrice());

                    /** singleton pattern with one variable **/
                    SampleSingleton string1 = SampleSingleton.getInstance(bean.getName());
                    SampleSingleton string2 = SampleSingleton.getInstance(bean.getCategory());

                    //changing variable of instance x converting string1 to Upper case, strint2 will automatically converts to upper case as using single ton pattern.
                    string1.value = (string1.value).toUpperCase();
                    System.out.println("single ton pattern with two strings"+ string1.value);
                    System.out.println(string1.value);
                    System.out.println(string2.value);
                    System.out.println("---------------");

                    /** writing the recipe details to a csv file. recipes.csv stored under files section of this project **/

                    bwr.write(bean.getId());
                    bwr.write(",");
                    bwr.write(bean.getCategory());
                    bwr.write(",");
                    bwr.write(bean.getName());
                    bwr.write(",");
                    bwr.write(bean.getDescription());
                    bwr.write(",");
                    bwr.write(bean.getPrice());
                    bwr.write(",");
                    bwr.write(bean.getLabel());
                    bwr.write("\n");

                }
                bwr.close();
                System.out.println("CSV file is created and stored in project strcuture");
                System.out.println("-------------");

                /** Calling getStream for java stream filters**/
                demo.getStreamDetails(arrlist);
                huc.disconnect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
    }

}
