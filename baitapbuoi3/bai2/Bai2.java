package baitapbuoi3.bai2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Bai2 {

	 public boolean splitFile(String source, String dest, int nuberFile) throws FileNotFoundException, IOException {
	        File sourceFile = new File(source);
	        if (sourceFile.exists() && sourceFile.isFile()) {
	            long sizeFile = sourceFile.length();
	            long sizeSplitFile = (sizeFile / nuberFile);
	            InputStream fis = new FileInputStream(sourceFile);
	            byte[] arr = new byte[1024];
	            for (int i = 1; i <= nuberFile; i++) {
	                int j = 0;
	                long a = 0;
	                OutputStream fos = new FileOutputStream(dest + sourceFile.getName()+"." + i  );
	                System.out.println("file cắt được "+sourceFile.getName()+"."+i);
	                while ((j = fis.read(arr)) != -1) {
	                    fos.write(arr, 0, j);
	                    a += j;
	                    if (a >= sizeSplitFile) {
	                        break;
	                    }
	                }
	                fos.flush();
	                fos.close();
	            }
	            fis.close();
	            return true;
	        } else {
	            System.out.println("file không tồn tại");
	            return false;
	        }
	    }
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Bai2 css = new Bai2();
		css.splitFile("D:\\Sinhvien.txt", "D:\\", 5);
	}
}
