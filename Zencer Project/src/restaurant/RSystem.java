package restaurant;


import java.util.*;

public class RSystem extends Implementation
{

	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		RSystem rest = new RSystem();
		Implementation imp =new Implementation();

		while (true)
		{
			System.out.println("Enter one choice from following...");
			System.out.println("1. Search reastuarant by name");
			System.out.println("2. Show details of reastuarant");
			System.out.println("3. Add new reastuarant");
			System.out.println("4. Update details of an restuarant");
			System.out.println("5. Delete reastuarant");
			System.out.println("6. Activate or deactivate reastuarant");
			// System.out.println("************************************************************************************************************************************************************");

			int userInput = sc.nextInt();

			switch (userInput) {
		     
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

			}

		}
	}	
}
