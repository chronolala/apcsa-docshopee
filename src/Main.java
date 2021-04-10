import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DocshopUtil.initializeData();
		
		enterLogin();
		System.out.println("Thanks for stopping by! ^_^");
	}
	
	public static void enterLogin() {
		System.out.println("Enter a name (or \\q to quit):");
		Scanner sc = new Scanner(System.in);
		String enteredName = sc.next();
		
		if(enteredName.equals("\\q")) return;
		
		User loggedUser = DocshopUtil.login(enteredName);
		
		if(loggedUser == null) {
			System.out.println("That name doesn't exist here!");
			enterLogin();
		} else {
			if(loggedUser.getType().toLowerCase().equals("customer")) {
				customerPortal((Customer) loggedUser);
			} else {
				ownerPortal((Owner) loggedUser);
			}
		}
	}
	
	public static void customerPortal(Customer user) {
		System.out.println("Welcome! Customer "+user.getName());

		Scanner scan = new Scanner(System.in);
		System.out.println("B - Browse \n C - Check cart \n X - Checkout \n A - Add an address \n P - Add a payment method");

		System.out.print("What do you want to do?");
		String option = scan.nextLine();

			// C2. Browse
		if(option.equals("B"))	browseProducts();
			
		// C3. Check his cart
        if (option.equals("C")){
           //Call method that returns cart
           user.showCart();
        }

			// C4. Checkout
		if (option.equals("X")){
			user.showCart();
		}
				// C5. Add an address
		if (option.equals("A")){
			System.out.println("Please enter the desired address for the pickup.");
		}
			// C6. Add a payment method
		if(option.equals("P")){
			System.out.println("How would you like to pay, "+user.getName()+"?");
		}
	}
	

	public static void browseProducts(){
		//DocshopUtil.itemList();
	}

	public static void ownerPortal(Owner user) {
		System.out.println("Welcome! Shopowner "+user.getName());

		//O1. Ask the user for input
		System.out.println("What would you like to do?");
		// B - Browse
		// A - Add
		// E - Edit
		// D - Delete
		Scanner input = new Scanner(System.in);
		String decide = input.nextLine().toUpperCase();
			//O2. Browse owner’s items
			if(decide.equals("B")) 
				browseProducts();
			//O3. Add an item (user input)
			if(decide.equals("A")){
				System.out.println("Input the name of the product that you want to add to your store.");
				String productName = input.nextLine();
				System.out.println("Input the price of the product that you want to add to your store.");
				double productPrice= input.nextDouble();
				System.out.println("Input the quantity of the product that you want to add to your store.");
				int productQuantity = input.nextInt();
				System.out.println("Do you want your product to be hidden?");
				String hideItemInput = input.nextLine();
				Boolean hideItem = hideItemInput.toLowerCase().equals("yes");
						
				Item addedItem = new Item (productQuantity, productName, productPrice, hideItem);
				user.registerProduct(addedItem);
			}


			//O4. Edit an item (user input)
			if (decide.equals("E")){
				ArrayList<Item> ownerItems = user.getProducts();
				System.out.println("Select an item to edit.");
				String editItemName = input.nextLine();
				if (doesProductExist(editItemName, ownerItems)) {
					//O4a. Get index of existing item
					//O4b. Allow users to not edit a field
					//O4c. Update field of existing object
					//O4d. Add modified object back to the list
					System.out.println("Input the new name of the product."); // /p to pass
					String productName = input.nextLine();
					System.out.println("Input the new price of the product.");
					double productPrice= input.nextDouble();
					System.out.println("Input the new quantity of the product.");
					int productQuantity = input.nextInt();
					System.out.println("Do you want your product to be hidden?");
					String hideItemInput = input.nextLine();
					Boolean hideItem = hideItemInput.toLowerCase().equals("yes");
							
					Item editedItem = new Item (productQuantity, productName, productPrice, hideItem);
					//
				} 
				else {
					System.out.println("That item does not exist in our product listings.");
				}
				
			}
				
			//O5. Delete an item (user input)
			if (decide.equals("D")) {
				System.out.println("What item do you want to delete?");
				String del = input.nextLine();
				if(doesProductExist(del,user.getProducts())){
					//O5a. Get the index of the product
					user.removeProduct(0);	
				} else {
					System.out.println("That item’s not in your cart.");
				}
			}

	}
	
	public static Boolean doesProductExist(String name, ArrayList<Item> items) {
		//DP1. Check if product exists
		return true;
	}

}
