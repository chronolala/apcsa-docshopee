//Items 
public class Item{
	private String Name; //name
	private double Price; //price
	private int Quantity; //qty
	private boolean IsHidden;
	
	public Item (int qty, String name, double price, boolean isHidden){
		Name = name;
		Price = price; 
		Quantity = qty;
		IsHidden = isHidden;
	}
	
	public void setHide(){
		this.IsHidden = true;
	}
	
	public String toString() {
		return Name+" - Php"+Price;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public void setPrice(double price) {
		Price = price;
	}
	
	public void setQuantity(int qty) {
		Quantity = qty;
	}
	
	public void setHidden(boolean isHidden) {
		IsHidden = isHidden;
	}
}
