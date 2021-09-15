package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Implementation extends Restuarant
{
	Scanner sc = new Scanner(System.in);
	public static final String driverName = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/rsytem";
	public static final String userName = "root";
	public static final String passWord = "priya";

	Validation v = new Validation();

	void searchRestuarant() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			ps = con.prepareStatement("select *from restaurant where name=?");
			System.out.println("Enter name of Restaurant: ");
			String searchname = sc.next();
			ps.setString(1, searchname);
			rs = ps.executeQuery();

			if (rs.next()) 
			{
				System.out.println("Name: " + rs.getString("name") + "\t");
				System.out.println("Opening_time: " + rs.getString("opening_time") + "\t");
				System.out.println("Closing_time: " + rs.getString("closing_time") + "\t");
				System.out.println("Phone_no: " + rs.getLong("phone_no") + "\t");
				System.out.println("Adress: " + rs.getString("address") + "\t");
				System.out.println("Cuisine: " + rs.getString("cuisine") + "\t");
				System.out.println("Status: " + rs.getInt("status") + "\t");
				System.out.println(
						"                                                                                       ");
				System.out.println("Restaurant Search Succesfully");
				System.out.println(
						"************************************************************************************************************************************************************************************************************************************");
				System.out.println(
						"************************************************************************************************************************************************************************************************************************************");
			} 
			else 
			{

				System.out.println("Restaurant is not found");
				System.out.println(
						"**************************************************************************************************************************************************************************************************************************");
			}

		} catch (Exception e) {

			System.out.println("Error......");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void displayDetailsOfRestarant() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);
			ps = con.prepareStatement("select *from restaurant");
			rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("name") + "\t");
				System.out.println(rs.getString("opening_time") + "\t");
				System.out.println(rs.getString("closing_time") + "\t");
				System.out.println(rs.getString("phone_no") + "\t");
				System.out.println(rs.getString("address") + "\t");
				System.out.println(rs.getString("cuisine") + "\t");
				System.out.println(rs.getString("status") + "\t");
				System.out.println(
						"************************************************************************************************************************************************************************************************************************************");
				System.out.println(
						"************************************************************************************************************************************************************************************************************************************");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void addRestuarant() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			String query = "insert into restaurant(name, opening_time, closing_time, phone_no, address, cuisine, Status) values(?,?,?,?,?,?,?);";
			ps = con.prepareStatement(query);

			Restuarant rp = new Restuarant();
			System.out.println("Enter a name");
			String name = sc.next();

			System.out.println("Enter a opening_time");
			String opening_time = sc.next();

			System.out.println("Enter a closing_time");
			String closing_time = sc.next();

			System.out.println("Enter a phone_no");
			long phone_no = sc.nextLong();

			System.out.println("Enter a address");
			String address = sc.next();

			System.out.println("Enter a cuisine");
			String cuisine = sc.next();

			System.out.println("Enter a status");
			int status = sc.nextInt();

			if (v.validateName(name)) {
				rp.setName(name);
			} else {
				rp.setName(null);
			}

			if (v.validateOpeningTime(opening_time)) {
				rp.setOpening_time(opening_time);
			} else {
				System.out.println("Invalid Opening Time");
			}

			if (v.validateClosingTime(closing_time)) {
				rp.setClosing_time(closing_time);
			} else {
				System.out.println("Invalid Closing Time");
			}

			String no = String.valueOf(phone_no);
			if (v.validatePhone(no)) {
				rp.setPhone_no(phone_no);
			} else {
				System.out.println("Invalid Phone_no");
			}
			rp.setAddress(address);

			if (v.validateCuisine(cuisine)) {
				rp.setCuisine(cuisine);
			} else {
				rp.setCuisine("Invalid cuisine ");
			}

			rp.setStatus(status);

			ps.setString(1, rp.getName());
			ps.setString(2, rp.getOpening_time());
			ps.setString(3, rp.getClosing_time());
			ps.setLong(4, rp.getPhone_no());
			ps.setString(5, rp.getAddress());
			ps.setString(6, rp.getCuisine());
			ps.setInt(7, rp.getStatus());

			ps.executeUpdate();

			System.out.println("Restaurant Added Succesfully");
			System.out.println(
					"************************************************************************************************************************************************************************************************************************************");
			System.out.println(
					"************************************************************************************************************************************************************************************************************************************");
			System.out.println("After Adiition of data  Records are");
			displayDetailsOfRestarant();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void updateDetailsOfRestuarent() {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			System.out.println("---------------------Enter a choice for update:-------------------- ");
			System.out.println("If you want to update a whole values of Restaurant then enter 1");
			System.out.println("If you want to update values which you want, then enter 2");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				String query = "update restaurant set name=?, opening_time= ?,closing_time= ?,phone_no= ? , address= ? , cuisine= ?, Status=? where name = ?;";
				ps = con.prepareStatement(query);

				System.out.println("Enter a name of restaurant which you want to update");
				String name1 = sc.next();

				System.out.println("Enter the value for name to update");
				String name = sc.next();

				System.out.println("Enter the value for opening_time to update");
				String opening_time = sc.next();

				System.out.println("Enter the value for closing_time to update");
				String closing_time = sc.next();

				System.out.println("Enter the value for phone_no to update");
				long phone_no = sc.nextLong();

				System.out.println("Enter the value for adress to update");
				String adress = sc.next();

				System.out.println("Enter the value for cuisine to update");
				String cuisine = sc.next();

				System.out.println("Enter the value for Status to update");
				int status = sc.nextInt();

				ps.setString(8, name1);
				ps.setString(1, name);
				ps.setString(2, opening_time);
				ps.setString(3, closing_time);
				ps.setLong(4, phone_no);
				ps.setString(5, adress);
				ps.setString(6, cuisine);
				ps.setInt(7, status);

				ps.executeUpdate();
				System.out.println("Restaurant Updated Succesfully");
				System.out.println(
						"************************************************************************************************************************************************************************************************************************************");
				System.out.println(
						"************************************************************************************************************************************************************************************************************************************");

				break;

			case 2:
				System.out.println("Enter a choice for update value you want from following..... ");
				System.out.println("1. For update Name value");
				System.out.println("2. For update Opening Time value");
				System.out.println("3. For update Closing Time value");
				System.out.println("4. For update Phone No value");
				System.out.println("5. For update Adress value");
				System.out.println("6. For update Cuisine value");
				System.out.println("7. For update Status value");

				int choice1 = sc.nextInt();

				switch (choice1) {
				case 1:
					String query1 = "update restaurant set  name= ? where name = ?;";
					ps = con.prepareStatement(query1);

					System.out.println("Enter a name of restaurant which you want to update");
					String name2 = sc.next();
					System.out.println("Enter the value which you want to update");
					String nameu = sc.next();

					ps.setString(2, name2);
					ps.setString(1, nameu);

					ps.executeUpdate();
					System.out.println("Restaurant Name Updated Succesfully");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");

					break;

				case 2:
					String query2 = "update restaurant set opening_time = ? where name = ?;";
					ps = con.prepareStatement(query2);

					System.out.println("Enter a name of restaurant which you want to update");
					String name3 = sc.next();
					System.out.println("Enter the value which you want to update");
					String opening_time2 = sc.next();

					ps.setString(2, name3);
					ps.setString(1, opening_time2);

					ps.executeUpdate();
					System.out.println("Restaurant Opening_time Updated Succesfully");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");

					break;

				case 3:
					String query3 = "update restaurant set  closing_time= ? where name = ?;";
					ps = con.prepareStatement(query3);

					System.out.println("Enter a name of restaurant which you want to update");
					String name4 = sc.next();
					System.out.println("Enter the value which you want to update");
					String closing_time3 = sc.next();

					ps.setString(2, name4);
					ps.setString(1, closing_time3);

					ps.executeUpdate();
					System.out.println("Restaurant Closing_time= Updated Succesfully");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");

					break;
				case 4:
					String query4 = "update restaurant set  phone_no= ? where name = ?;";
					ps = con.prepareStatement(query4);

					System.out.println("Enter a name of restaurant which you want to update");
					String name5 = sc.next();
					System.out.println("Enter the value which you want to update");
					String phone_no3 = sc.next();

					ps.setString(2, name5);
					ps.setString(1, phone_no3);

					ps.executeUpdate();
					System.out.println("Restaurant Phone_no Updated Succesfully");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					break;
				case 5:
					String query5 = "update restaurant set  address= ? where name = ?;";
					ps = con.prepareStatement(query5);

					System.out.println("Enter a name of restaurant which you want to update");
					String name6 = sc.next();
					System.out.println("Enter the value which you want to update");
					String adress3 = sc.next();

					ps.setString(2, name6);
					ps.setString(1, adress3);

					ps.executeUpdate();
					System.out.println("Restaurant Adress Updated Succesfully");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");

					break;
				case 6:
					String query6 = "update restaurant set cuisine= ? where name = ?;";
					ps = con.prepareStatement(query6);

					System.out.println("Enter a name of restaurant which you want to update");
					String name7 = sc.next();
					System.out.println("Enter the value which you want to update");
					String cuisine3 = sc.next();

					ps.setString(2, name7);
					ps.setString(1, cuisine3);

					ps.executeUpdate();
					System.out.println("Restaurant Cuisine Updated Succesfully");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");

					break;

				case 7:
					String query7 = "update restaurant set Status = ? where name = ?;";
					ps = con.prepareStatement(query7);

					System.out.println("Enter a name of restaurant which you want to update");
					String name8 = sc.next();
					System.out.println("Enter the value which you want to update");
					int status2 = sc.nextInt();

					ps.setString(2, name8);
					ps.setInt(1, status2);

					ps.executeUpdate();
					System.out.println("Restaurant Status Updated Succesfully");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					break;

				default:
					System.out.println("Invalid choice");
					break;

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void deleteDetailsOfRestuarant() {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			String query = "delete from restaurant where name = ?;";
			ps = con.prepareStatement(query);
			System.out.println("Enter a name");
			String name = sc.next();
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("Restaurant Deleted Succesfully");
			System.out.println(
					"************************************************************************************************************************************************************************************************************************************");
			System.out.println(
					"************************************************************************************************************************************************************************************************************************************");
			System.out.println("After Deletion Records are");
			displayDetailsOfRestarant();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	void activateDeactivate() {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, userName, passWord);

			System.out.println("Enter a choice");
			System.out.println("1. Activate");
			System.out.println("2.Deactivate");
			int ch = sc.nextInt();
			switch (ch) {

			case 1:
				ps = con.prepareStatement("select * from restaurant where status=1");
				rs = ps.executeQuery();

				System.out.println("-------Activate Restaurant Data------ ");
				while (rs.next()) {

					System.out.println("Name " + rs.getString("name") + "\t");
					System.out.println("Opening_time " + rs.getFloat("opening_time") + "\t");
					System.out.println("Closing_time " + rs.getFloat("closing_time") + "\t");
					System.out.println("Phone_no" + rs.getString("phone_no") + "\t");
					System.out.println("Adress" + rs.getString("address") + "\t");
					System.out.println("Cuisine" + rs.getString("cuisine") + "\t");
					System.out.println("Status" + rs.getString("status") + "\t");
					System.out.println(
							"                                                                                       ");

					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
				}
			case 2:
				ps1 = con.prepareStatement("select * from restaurant where status=0");
				rs = ps1.executeQuery();

				System.out.println("-------Deactivate Restaurant Data------ ");
				while (rs.next()) {

					System.out.println("Name " + rs.getString("name") + "\t");
					System.out.println("Opening_time " + rs.getFloat("opening_time") + "\t");
					System.out.println("Closing_time " + rs.getFloat("closing_time") + "\t");
					System.out.println("Phone_no" + rs.getString("phone_no") + "\t");
					System.out.println("Adress" + rs.getString("address") + "\t");
					System.out.println("Cuisine" + rs.getString("cuisine") + "\t");
					System.out.println("Status" + rs.getString("status") + "\t");
					System.out.println(
							"                                                                                       ");

					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
					System.out.println(
							"************************************************************************************************************************************************************************************************************************************");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
