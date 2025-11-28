import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class menu {
	public static void main(String[] args) {
		//map to store each products total amount
		Map<String,Double> prodss =new HashMap<>();
		double Total =0;
		
		try {String fileName ="C:\\Users\\Pc\\Desktop\\EVE01Sales.txt";
		FileReader filePath =new FileReader(fileName);
		Scanner fileToRead =new Scanner(filePath);
		
		
		if(fileToRead.hasNextLine()) {
			String headerLine = fileToRead.nextLine().trim();  //read line
			String[] headers = headerLine.split("\t");
			//menu options
			for(int i =0;i< headers.length; i++) {
				System.out.println((i+1)+ "." +headers[i]);
			}
			
				
		}
		System.out.println("Enter the number for how you want your total amounts(choose only from 1-4): ");
		
		Scanner scanner =new Scanner(System.in);
		int num =scanner.nextInt()-1;
		
				
		while(fileToRead.hasNextLine()) {
			String line =fileToRead.nextLine().trim();
			String[] parts =line.split("\t");
			
			String product =parts[num];
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