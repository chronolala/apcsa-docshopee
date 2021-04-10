import java.util.ArrayList;

public class Customer extends User{
	private ArrayList<Item> cart;
	private ArrayList<Item> wishList;

	public Customer(String name){
		super(name, "customer");
		cart=new ArrayList<Item>();
		wishList=new ArrayList<Item>();
	}

	public void addToCart(Item product){
		cart.add(product);
	} 
	
	public void removeToCart(int index) {
		cart.remove(index);
	}
	
	public void showCart() {
		for (Item thing : cart) {
			// print item
		}
	}

 }
