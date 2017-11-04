package in.ravikalla.cloudBank.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {
	public static String readFileFromDisk(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	public static void compareActualAndExpectedJSONFiles(String strExpectedJSONFileName, String strActualJSONFileName) {
		// TODO : Write comparison logic here
	}
	public static void compareActualAndExpectedXMLFiles(String strExpectedXMLFileName, String strActualXMLFileName) {
		// TODO : Write comparison logic here
	}
}
