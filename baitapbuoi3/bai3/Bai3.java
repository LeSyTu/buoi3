package baitapbuoi3.bai3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Bai3 {

	 public boolean joinFile(String source) throws FileNotFoundException, IOException {
//	    name file
	        String sourceFile = source.substring(0, source.lastIndexOf('.'));
	        File file = new File(sourceFile);
	        OutputStream os = new FileOutputStream(file);
	        InputStream is;
	        int count = 1;
	        while (true) {
	            String path = file + "." + count;
	            File eachFile = new File(path);
	            if (eachFile.exists()) {
	                is = new FileInputStream(eachFile);
	                int i = 0;
	                byte[] arr = new byte[1024];
	                while ((i = is.read(arr)) != -1) {
	                    os.write(arr, 0, i);
	                }
	                os.flush();
	                is.close();
	                count++;
	            } else {
	                System.out.println("file không tồn tại");
	                break;
	            }
	        }
	        os.close();
	        return false;
	    }
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Bai3 sdsd = new  Bai3();
		System.out.println(sdsd.joinFile("D:\\demo.txt.3"));
		
	}

}
