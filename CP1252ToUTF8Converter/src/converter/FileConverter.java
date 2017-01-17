package converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import exceptions.ConvertingFileError;

public class FileConverter {
	
	
	private List<File> files;
	private int currentFile;
	
	public FileConverter(List<File> files) {
		this.files = files;	
		this.currentFile = 1;
	}
	

	public void convertFormats(String srcFormat, String destFormat) {
		
		for (File file : this.files) {
			
			System.out.println("Convirtiendo " + file.getName() + " (" + currentFile + "/" + files.size() + ")");
			
			List<String> lines = new ArrayList<>();
			
			try {
				InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), srcFormat);				
				BufferedReader reader = new BufferedReader(inputStreamReader);
				
				String line = null;
				
				while ( (line = reader.readLine()) != null)			
					lines.add(line + '\n');
				
				reader.close();
				OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), destFormat);	
				
				for (String line2 : lines)
					writer.write(line2);				
				
				writer.close();
			} catch (IOException e) {
				throw new ConvertingFileError("Error converting file: " + file.getName(), e);
			}
			
			this.currentFile++;
		}
		
	}
	
}
