package converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import exceptions.ConvertingFileError;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("______________________________________________________");
		System.out.println("CONVERSOR DE ENCODING cp1252 (windows-1252) --> UTF-8: \n\n");
		System.out.println("NO DEBE USARSE MÁS DE UNA VEZ CON LOS MISMOS ARCHIVOS!\n");
		
		System.out.print("Ingrese directorio padre: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String rootDirectory = null;
		
		try {
			rootDirectory = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// rootDirectory = "C:/Users/Chicho/Desktop/CP1252ToUTF8Converter/CP1252ToUTF8Converter/src/resources";
		
		List<File> files = FileLister.listAllFilesInDir(rootDirectory);
		FileConverter converter = new FileConverter(files);
		
		try {
			converter.convertFormats(Encodings.CP1252.getCode(), Encodings.UTF8.getCode());
		} catch (ConvertingFileError e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nFIN");
	}
}
