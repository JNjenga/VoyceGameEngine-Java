package utility;

import java.io.*;
import java.util.*;

public class Utility {
	public static String readLines(String path) {
		FileInputStream inputStream = null;
		Scanner sc = null;
		StringBuilder source = null;
		
		try {
			source = new StringBuilder();
				inputStream = new FileInputStream(Utility.class.getResource(path).toString());
			 
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		    	source.append(sc.nextLine()+'\n');
		    }
		    
 		    if (sc.ioException() != null) {
		        try {
					throw sc.ioException();
					
				} catch (IOException e) {
 					e.printStackTrace();
				}
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		return source.toString();
	}

	
	public static String loadAsString(String path) {
		
		try {
			StringBuilder result = new StringBuilder();
			path = Utility.class.getResource(path).toString();
			BufferedReader reader = new BufferedReader(new FileReader(path.split(":")[1]));
			String buffer = "";
			while ((buffer = reader.readLine()) != null) {
				result.append(buffer+"\n");
			}
			reader.close();
			
			return result.toString();
		} catch (Exception e) {
			BugTracker.LOG("ERROR", "Could not read/locate file "+ path);
		}
		return "";
	}

}
