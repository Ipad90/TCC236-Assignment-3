package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class BuggedDriver {
    public static void main(String[] args) {
        TreeModule bst = new TreeModule();
        
		try {
			File file = new File("data.txt");
			Scanner reader = new Scanner(file);

			long start_time = System.nanoTime();
			
			while (reader.hasNextLine()) {
				String new_line = reader.nextLine();
				String[] line = new_line.split("|");
				System.out.println(Arrays.toString(line));
				System.out.println("line[0]: " + line[0].getClass());
				System.out.println("line[1]: " + line[1].getClass());
				System.out.println("line[2]: " + line[2].getClass());
				DetailsModule details = new DetailsModule(line[0], line[1], line[2]);
				bst.insert(details);
			}
					
			long end_time = System.nanoTime();
	    	long time_taken = end_time - start_time;
			time_taken /= 1000000;
			
			System.out.println("Time taken (Milliseconds): " + time_taken);
			
			reader.close();
			bst.inOrder();
			
			DetailsModule d0 = new DetailsModule("Pepega", "Cristoph", "Fiction");
			bst.insert(d0);
			bst.search("Denesik and Sons");
			bst.search("Pepega");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
    }
}
