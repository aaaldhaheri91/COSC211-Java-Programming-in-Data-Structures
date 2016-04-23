/*
 * creating binary files
 */
/*import java.util.*;
import java.io.*;

public class BinaryFile {

	public static void main(String[] args) {
		
		//creating a binary file using objects
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//reading from binary file
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fos = new FileOutputStream("mybinNumbers.dat"); //.dat: data file
			oos = new ObjectOutputStream(fos);
			for(int i = 1; i < 11; i++){
				oos.write(i);
				oos.writeUTF("Ahmed\n");
			}
			oos.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		//reading binary file created above
		try{
			fis = new FileInputStream("mybinNumbers.dat"); //.dat: data file
			ois = new ObjectInputStream(fis);
			
			//create an infinite loop inside try and when end of file it throws EOFException and stops loop
			try{
				while(true){
					System.out.println(ois.readInt() + ois.readUTF());
					
				}
			}//end try
			catch(EOFException e){
				System.out.println("No more data");
			}
			ois.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		
	

	}//end main

}//end class
*/

/*
 * creating binary files
 */
import java.util.*;
import java.io.*;

public class BinaryFile {

	public static void main(String[] args) {
		
		//creating a binary file using objects
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//reading from binary file
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fos = new FileOutputStream("mybinNumbers.dat"); //.dat: data file
			oos = new ObjectOutputStream(fos);
			for(int i = 1; i < 11; i++){
				oos.writeInt(i);
			}
			oos.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		//reading binary file created above
		try{
			fis = new FileInputStream("mybinNumbers.dat"); //.dat: data file
			ois = new ObjectInputStream(fis);
			
			//create an infinite loop inside try and when end of file it throws EOFException and stops loop
			try{
				while(true){
					System.out.println(ois.readInt());
					
				}
			}//end try
			catch(EOFException e){
				System.out.println("No more data");
			}
			ois.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		

	}//end main

}//end class