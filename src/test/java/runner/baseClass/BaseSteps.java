package runner.baseClass;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BaseSteps {
    public static JSONObject loadJson(String _nameFile) throws FileNotFoundException {

        InputStream inputStream = new FileInputStream(
                new File("src/test/resources/jsons/" + _nameFile));

        return new JSONObject(new JSONTokener(inputStream));
    }
}
