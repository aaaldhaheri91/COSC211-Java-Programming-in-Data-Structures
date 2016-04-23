package projRecursion3_4;
/*
 * user gives you a folder and measure the folder and subfolders and give back size of the folder
 */

import java.io.File;
import java.util.*;

public class FolderSize {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String folderDirectory = null;
		
		System.out.println("Enter a folder directory: ");
		folderDirectory = input.nextLine();
		
		System.out.println(calcSize(new File(folderDirectory)) + " bytes");
		
	}
	
	//method calculate the size
	public static long calcSize(File folder){
		long size = 0;
		
		if(folder.isDirectory()){
			File[] array = folder.listFiles();		//takes all files in that foler and put them in array
			for(int i = 0; array != null && i < array.length; ++i){
				size += calcSize(array[i]);
			}
		}
		else{
			size += folder.length();	//length of file is the size of it
		}
		
		return size;
	}

}
