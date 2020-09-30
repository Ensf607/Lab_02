package exercise3;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
public ArrayList<Tool>toolList;
public HashMap<Integer,String> supplier;

public Inventory(HashMap<Integer,String> supplier)
{	this.supplier=supplier;
	toolList=new ArrayList<Tool>();
}
public void addTool(int id, String name, int quantity, double price, int supplierID) {
	toolList.add(new Tool(id,name,quantity,price,supplierID));
}
public void deleteTool(int id,String name) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getId()==id && temp.getName()==name) {
			toolList.remove(i);
		}
	}
}
public Tool searchTool( int id, String name) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getId()==id && temp.getName().equals(name)) {
			return temp;
		}
	}
	return null;
}
public  ArrayList<String[]> checkStock (){
	ArrayList<String[]> newOrderList = new ArrayList<String[]>();
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getQuantity()<40) {
			String[] toolInfo=new String [3] ;
			toolInfo[0]=temp.getName();
			toolInfo[1]=String.valueOf(50-temp.getQuantity());
			toolInfo[2]=supplier.get(temp.getSupplierID());
			
		
		newOrderList.add(toolInfo);}}
	return newOrderList;

}}
