package exercise3;

public class Order {
private int id;
private String date;
private String[] orderInfo;
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
