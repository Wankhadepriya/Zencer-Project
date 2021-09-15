package restaurant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean validateName(String n) {
		String name = "^[a-zA-Z0-9]+$";
		Pattern p = Pattern.compile(name);
		Matcher m = p.matcher(n);
		boolean b = m.matches();

		if (n == null) {
			return false;
		} else if (b) {
			return true;
		} else {
			throw new Invalid();

		}

	}

	public boolean validatePhone(String p) {
		String phone = "\\d{10}";
		Pattern p1 = Pattern.compile(phone);
		Matcher m1 = p1.matcher(p);
		boolean b = m1.matches();
		if (p == null) {
			return false;
		} else if (b) {
			return true;
		} else {
			throw new Invalid();

		}
	}

	public boolean validateOpeningTime(String o) {
		String opentime = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern pt = Pattern.compile(opentime);
		Matcher m = pt.matcher(o);
		boolean b = m.matches();
		if (o == null) {
			return false;
		} else if (b) {
			return true;
		} else {
			throw new Invalid();

		}

	}

	public boolean validateClosingTime(String c) {
		String closetime = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern ptc = Pattern.compile(closetime);
		Matcher m = ptc.matcher(c);
		boolean b = m.matches();
		if (c == null) {
			return false;
		} else if (b) {
			return true;
		} else {
			throw new Invalid();

		}
	}

	public boolean validateCuisine(String cu) {

		if (cu == null) {
			return false;
		} else if (cu.equalsIgnoreCase("indian")) {
			return true;
		} else if (cu.equalsIgnoreCase("maxican")) {
			return true;
		} else if (cu.equalsIgnoreCase("italian")) {
			return true;
		} else if (cu.equalsIgnoreCase("chinese")) {
			return true;
		} else {
			throw new Invalid();

		}
	}

}

class Invalid extends RuntimeException {

	private static final long serialVersionUID = 1L;

	Invalid() {
		System.out.println("Input is Invalid");
	}
}
