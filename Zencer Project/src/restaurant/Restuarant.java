package restaurant;

public class Restuarant {
	private String name;
	private String opening_time;
	private String closing_time;
	private long phone_no;
	private String address;
	private String cuisine;
	private int status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpening_time() {
		return opening_time;
	}

	public void setOpening_time(String opening_time) {
		this.opening_time = opening_time;
	}

	public String getClosing_time() {
		return closing_time;
	}

	public void setClosing_time(String closing_time) {
		this.closing_time = closing_time;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
