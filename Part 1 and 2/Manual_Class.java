package custommaingui


public class Manual {

	private String serial_number = new String();
	private String title = new String();
	private String author = new String();


	public void Manual(){
		serial_number = "???????";
		title = "Untitled";
		author = "Unknown";

	}
	public void Manual(String sr_num){
		this.serial_number = sr_num;
		title = "Untitled";
		author = "Unknown";

	}

	public void Manual(String sr_num, String Title, String Author){
		this.serial_number = sr_num;
		this.title = Title;
		this.author = Author;

	}
	public void Manual(String sr_num, String Title){
		this.serial_number = sr_num;
		this.title = Title;
		author = "Unknown";

	}

	private print_2_console(){
			System.out.println("serial_number:"+ serial_number+"title:"+title+"author:"+author);
	}

	public static void main(String[] args){
		Manual manObj1 = new Manual();

		Manual manObj2 = new Manual("123");
		Manual manObj3 = new Manual("114","Value of life");
		Manual manObj4 = new Manual("115","Value of Death","Robert C Brown");
		//print all the values to console
		manObj1.print_2_console();
		manObj2.print_2_console();
		manObj3.print_2_console();
		manObj4.print_2_console();
	}
}