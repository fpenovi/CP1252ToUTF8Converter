package converter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLister {

	
	public static List<File> listAllFilesInDir(String rootDir) {
		
		List<File> allFiles = new ArrayList<>();
		populateFileList(rootDir, allFiles);
		return allFiles;
	}
	

	private static void populateFileList(String dir, List<File> allFiles) {
		
		File directory = new File(dir);
		File[] filesOrFolders = directory.listFiles();
		
		for (File file : filesOrFolders) {
			if (file.isFile())
				allFiles.add(file);
			
			else if (file.isDirectory())
				populateFileList(file.getAbsolutePath(), allFiles);				
		}
	}

}
