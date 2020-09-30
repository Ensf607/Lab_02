package exercise3;

public class Order {
public int id;
public String date;
public String[] orderInfo;
public Order( String date,String[] orderInfo) {
	this.id= (int)Math.round(Math.random()*100000);
	this.orderInfo=orderInfo;
}
public String printOrder() {
	StringBuffer sb =new StringBuffer();
	sb.append("Order ID\t\t\t\t"+id+"\n");
	sb.append("Supplier\t\t\t\t"+orderInfo[2]+"\n");
	sb.append("****************************\n");
	return sb.toString();
}
}
