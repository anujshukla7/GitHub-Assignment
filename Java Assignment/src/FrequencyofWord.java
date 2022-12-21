import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyofWord {

	
		static void countWord(String filename, Map<String, Integer>words) throws FileNotFoundException {
			Scanner file = new Scanner(new File(filename));
			while(file.hasNext()) { 
				String word = file.next(); 
				Integer count = words.get(word); 
				if(count != null) 
					count++; 
				else
					count = 1;
				words.put(word, count); 
			}file.close();

 } 
		public static void main(String[] args) throws FileNotFoundException {
			Map<String, Integer> words = new HashMap<String, Integer>(); 
			countWord("C:\\Users\\anujshukla\\eclipse-workspace\\Java Assignment\\src\\Data", words);
			System.out.println(words);

}

}


