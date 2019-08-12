package utility;

import static org.lwjgl.BufferUtils.*;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.*;

import org.lwjgl.*;

 
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

	
    public static ByteBuffer ioResourceToByteBuffer(String resource, int bufferSize) throws IOException {
        ByteBuffer buffer = null;

        Path path = Paths.get("res/FiraSans.ttf");
         if (Files.isReadable(path)) {
            try (SeekableByteChannel fc = Files.newByteChannel(path)) {
                buffer = BufferUtils.createByteBuffer((int)fc.size() + 1);
                while (fc.read(buffer) != -1) {
                    ;
                }
            }
        } else {
            try {
                InputStream source = Utility.class.getClassLoader().getResourceAsStream(resource);

            	ReadableByteChannel rbc = Channels.newChannel(source);
                buffer = createByteBuffer(bufferSize);

                while (true) {
                    int bytes = rbc.read(buffer);
                    if (bytes == -1) {
                        break;
                    }
                    if (buffer.remaining() == 0) {
                        buffer = resizeBuffer(buffer, buffer.capacity() * 3 / 2); // 50%
                    }
                }
            }catch (Exception e) {
            	e.printStackTrace();
 			}
        }

        buffer.flip();
        return buffer;
    }
    private static ByteBuffer resizeBuffer(ByteBuffer buffer, int newCapacity) {
        ByteBuffer newBuffer = BufferUtils.createByteBuffer(newCapacity);
        buffer.flip();
        newBuffer.put(buffer);
        return newBuffer;
    }


}
