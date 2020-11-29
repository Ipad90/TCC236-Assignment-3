package tcc236.sep2020.assignment3.assign_3.james_ong_rui_ming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TreeDriver {
    public static void main(String[] args) {
        TreeModule bst = new TreeModule();
        
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
			String new_line;

			long start_time = System.nanoTime();
			
			while ((new_line = reader.readLine()) != null) {
				String[] line = new_line.split("\\|");
				DetailsModule details = new DetailsModule(line[0], line[1], line[2]);
				bst.insert(details);
			}
					
			long end_time = System.nanoTime();
	    	long time_taken = end_time - start_time;
			time_taken /= 1000000;
			
			System.out.println("Time taken (Milliseconds): " + time_taken);
			
			reader.close();
			bst.inOrder();
			bst.search("Denesik and Sons");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
}
