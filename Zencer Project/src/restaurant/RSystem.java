package restaurant;

import java.util.*;

public class RSystem extends Implementation 
{

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		RSystem rest = new RSystem();
		Implementation imp = new Implementation();

		boolean flag = true;

		while (flag) {
			System.out.println("---------Enter one choice from following-------\n");
			System.out.println("1. Search reastuarant by name");
			System.out.println("2. For display all details of reastuarants");
			System.out.println("3. Add new reastuarant");
			System.out.println("4. Update details of an restuarant");
			System.out.println("5. Delete reastuarant");
			System.out.println("6. Activate or deactivate reastuarant");
			System.out.println("7. Exit from system");
			

			int userInput = sc.nextInt();

			switch (userInput) 
			{

				case 1:
	
					imp.searchRestuarant();
					break;
				case 2:
					imp.displayDetailsOfRestarant();
	
					break;
				case 3:
					imp.addRestuarant();
					break;
				case 4:
					rest.updateDetailsOfRestuarent();
					break;
				case 5:
					rest.deleteDetailsOfRestuarant();
					break;
				case 6:
					rest.activateDeactivate();
					break;
				case 7:
					flag = false;
					System.out.println("Bye...Thank You");
					break;
	
				default:
					System.out.println("Enter proper choise");
					break;

			}

		}
	}
}
