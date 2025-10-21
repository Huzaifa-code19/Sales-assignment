import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sale {
	public static void main(String[] args) {
		//map to store each products total amount
		Map<String,Double> prodss =new HashMap<>();
		double Total =0;
		
		try {String fileName ="C:\\Users\\Lab User\\Desktop\\EVE01Sales.txt";
		FileReader filePath =new FileReader(fileName);
		Scanner fileToRead =new Scanner(filePath);
		
		
		if(fileToRead.hasNextLine()) {
			fileToRead.nextLine();
			
		}
		while(fileToRead.hasNextLine()) {
			String line =fileToRead.nextLine().trim();
			String[] parts =line.split("\t");
			
			String product =parts[3];
			int qty =Integer.parseInt(parts[4]);
			double unitPrice = Double.parseDouble(parts[5]);
			
			double amount =qty*unitPrice;
			
			if(prodss.containsKey(product)) {//if product a ki oldamount pata he to ye chalega
				double oldTotal = prodss.get(product);
				double newTotal = oldTotal + amount;
				prodss.put(product, newTotal);
			}else {
				//agar new product he like B to ye chale ga
				prodss.put(product, amount);
			}
			
			Total =Total +amount;
		}
		fileToRead.close();
		
		for(String product : prodss.keySet()) { //for ever product a b c d etc
			System.out.println(product +": "+prodss.get(product));//get product se amount pata chale gi
		}
		System.out.println("Total: "+ Total);
		
		}catch(Exception e) {
			System.out.println("Error reading file: "+e.getMessage());
			
		}
	}

}
