import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonSampleTestMock {

    private final String arrayStr =
            "[" +
                    "true," +
                    "false," +
                    "\"true\"," +
                    "\"false\"," +
                    "\"hello\"," +
                    "23.45e-4," +
                    "\"23.45\"," +
                    "42," +
                    "\"43\"," +
                    "[" +
                    "\"world\"" +
                    "]," +
                    "{" +
                    "\"key1\":\"value1\"," +
                    "\"key2\":\"value2\"," +
                    "\"key3\":\"value3\"," +
                    "\"key4\":\"value4\"" +
                    "}," +
                    "0," +
                    "\"-1\"" +
                    "]";

    @Test
    public void verifySimilar() {
        final String string1 = "HasSameRef";
        JSONArray obj1 = new JSONArray()
                .put("abc")
                .put(string1)
                .put(2);

        JSONArray obj2 = new JSONArray()
                .put("abc")
                .put(string1)
                .put(3);

        JSONArray obj3 = new JSONArray()
                .put("abc")
                .put(new String(string1))
                .put(2);

        assertFalse("Should eval to false", obj1.equals(obj2));
        assertTrue("Should eval to true", obj1.equals(obj3));
    }

    /**
     * Attempt to create a JSONArray with an empty string.
     * Expects a JSONException.
     */
    @Test
    public void emptStr() {
        String str = "";
        try {

            assertNull("Should throw an exception", new JSONArray(str));
        } catch (JSONException e) {
            assertEquals("Expected an exception message",
                    "A JSONArray text must start with '[' at 0 [character 1 line 1]",
                    e.getMessage());
        }
    }
}


