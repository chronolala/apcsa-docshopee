import java.util.ArrayList;
public class Owner extends User {
	private ArrayList<Item> products;

	public Owner(String name){
		super(name, "owner");
		products = new ArrayList<Item>();
	}

	public void registerProduct(Item thing) {
		products.add(thing);
	}
	

	
	public void removeProduct(int index) {
		products.remove(index);
	}
	
	public ArrayList<Item> getProducts(){
		return products;
	}
}
