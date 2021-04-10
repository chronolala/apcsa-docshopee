import java.util.ArrayList;

public class DocshopUtil {
	private static ArrayList<User> users = new ArrayList<User>();
	
	public static void itemList(ArrayList<Item> products){
		for(Item product: products){
			System.out.println(product);
		}
	}
	
	
	public static void initializeData() {
		users.add(new Customer("Timothy"));
		users.add(new Owner("Ji-eun"));
	}
	
	public static User login(String name) {
		for(User user : users) {
			if(user.getName().equals(name)) return user;
		}
		
		return null;
	}

}
