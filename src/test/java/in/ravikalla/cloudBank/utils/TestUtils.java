package in.ravikalla.cloudBank.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TestUtils {
	public static String readFileFromDisk(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	@SuppressWarnings("rawtypes")
	public static List jsonToList(String json, TypeToken token) {
		Gson gson = new Gson();
		return gson.fromJson(json, token.getType());
	}

	public static String objectToJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	public static <T> T jsonToObject(String json, Class<T> classOf) {
		Gson gson = new Gson();
		return gson.fromJson(json, classOf);
	}

	public static <T> T jsonToObject(String json, Type typeOf) {
		Gson gson = new Gson();
		return gson.fromJson(json, typeOf);
	}

	public static void compareActualAndExpectedJSONFiles(String strExpectedJSONFileName, String strActualJSONFileName) {
		// TODO : Write comparison logic here
	}
	public static void compareActualAndExpectedXMLFiles(String strExpectedXMLFileName, String strActualXMLFileName) {
		// TODO : Write comparison logic here
	}
}
