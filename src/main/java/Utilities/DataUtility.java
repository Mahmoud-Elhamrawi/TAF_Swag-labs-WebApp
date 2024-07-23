package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class DataUtility {
    //read data from json file
    public static String readJsonFile(String fileName , String key)
    {
        String path_file ="src/test/resources/";

        try {
            FileReader reader = new FileReader(path_file+fileName+".json");
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return  jsonElement.getAsJsonObject().get(key).getAsString();

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
      return "";

    }

        public static String readPropertyFile(String fileName , String key)
        {
            String path_file ="src/test/resources/";
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream(path_file+fileName+".properties"));
                return properties.getProperty(key);

            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return "";
        }


}
