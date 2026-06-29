package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

    public static Map<String, String> getJsonData(String fileName) {

        ObjectMapper mapper = new ObjectMapper();

        try {

        	return mapper.readValue(
        	        new File("src/test/resources/testdata/" + fileName),
        	        new TypeReference<Map<String, String>>() {});
        	
        } catch (IOException e) {

            throw new RuntimeException(
                    "Failed To Read JSON File : " + fileName, e);
        }
    }
}