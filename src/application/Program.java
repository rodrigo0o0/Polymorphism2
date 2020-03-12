package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List <Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price : ");
			double price = sc.nextDouble();
			
			switch (type) {
			case 'c': {
				products.add(new Product(name,price));
				break;
			}
			case 'u': {
				System.out.print("Manufacture date (DD/MM/YYY) : ");
				sc.nextLine();
				String date = sc.nextLine();
				products.add(new UsedProduct(name,price,sdf.parse(date)));
				break;
			}
			case 'i': {
				System.out.print("Customs Fee : ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name,price,customsFee));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}
		}
		System.out.println("PRICE TAGS: ");
		for(Product product : products){
			System.out.println(product.priceTag());
		}
		
		
		
		
		
		
		sc.close();
	}

}
