package exercise3;

import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
HashMap <Integer,String> supplierList;
ArrayList<Order> orderList;
public App() {
	supplierList=new HashMap<Integer, String>();
	orderList=new ArrayList<Order>();
}
public String generateOrder(ArrayList<String[]> lis) {
	for(int i=0;i<lis.size();i++) {
		orderList.add(new Order("2020", lis.get(i)));
	}
	StringBuffer sb= new StringBuffer();
	for(int i=0;i<orderList.size();i++) {
		sb.append(orderList.get(i).printOrder()+"\n");
	}
	return sb.toString();
}
public void getSupplierList(String fileName) {
	try {
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		String line=reader.readLine();
		while (line!=null) {
			String temp[];
			temp=line.split("[;]");
			if (!supplierList.containsKey(Integer.parseInt(temp[0])))
			{
				supplierList.put(Integer.parseInt(temp[0]), temp[1]);
			}
			line=reader.readLine();
		}
		reader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	public static void main(String[] args) throws FileNotFoundException {
		App app =new App();
		app.getSupplierList("suppliers.txt");
		Inventory inventory =new Inventory(app.supplierList);
		
		BufferedReader reader=new BufferedReader(new FileReader("items.txt"));
		try {
			String line=reader.readLine();
			while (line!=null) {
				String temp[];
				
				temp=line.split("[;]");
				inventory.addTool(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3]), Integer.parseInt(temp[4]));
				line=reader.readLine();
}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String[]> lis=new ArrayList<String[]>();
				lis=inventory.checkStock();
		System.out.println(app.generateOrder(lis));
	
		
	}
	
}
