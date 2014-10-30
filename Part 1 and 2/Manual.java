import java.util.Scanner;

public class Manual {

    private String serial_number = new String();
    private String title = new String();
    private String author = new String();

    public void Manual() {
        serial_number = "???????";
        title = "Untitled";
        author = "Unknown";
    }

    public void Manual(String sr_num) {
        this.serial_number = sr_num;
        title = "Untitled";
        author = "Unknown";

    }

    public void Manual(String sr_num, String Title, String Author) {
        this.serial_number = sr_num;
        this.title = Title;
        this.author = Author;

    }

    public void Manual(String sr_num, String Title) {
        this.serial_number = sr_num;
        this.title = Title;
        author = "Unknown";

    }
	private void print_2_console(){
			System.out.println("serial_number:"+ serial_number+"title:"+title+"author:"+author);
	}

<<<<<<< HEAD
    private void print_2_console(String src_num, String Title, String Author) {
        System.out.println("serial_number:" + src_num + "title:" + Title + "author:" + Author);
=======
    public void print_2_console() {
        System.out.println("serial_number:" + serial_number + "title:" + title + "author:" + author);
>>>>>>> origin/master
    }

    public static void main(String[] args) {

        Library library = new Library();

        library.addManual();
        library.addManual();
        library.addManual();
        library.addManual();
        library.addManual();

        //print all the values to console
<<<<<<< HEAD
        manObj1.print_2_console();
        manObj2.print_2_console();
        manObj3.print_2_console();
        manObj4.print_2_console();
		
		//Added code for storing user value 
		manObj1.getDetails();
		manObj1.print_2_console(getSerialNumber(),getTitle(),getAuthor());
=======
        library.printDetailsAllManuals();
>>>>>>> origin/master
    }

    /**
     * methods to set the properties of a Manual
     *
     * @param s
     */
    public void setSerialNumber(String s) {
        serial_number = s;
    }

    /**
     * methods to set the properties of a Manual
     *
     * @param s
     */
    public void setTitle(String s) {
        title = s;
    }

    /**
     * methods to set the properties of a Manual
     *
     * @param s
     */
    public void setAuthor(String s) {
        author = s;
    }

    /**
     * methods to get the properties of a Manual
     *
     * @return
     */
    public String getSerialNumber() {
        return serial_number;
    }

    /**
     * methods to get the properties of a Manual
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * methods to get the properties of a Manual
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    public void getDetails() {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the serial number of your manual");
        String s = in.nextLine();
<<<<<<< HEAD
		setSerialNumber(s);
		System.out.println("Enter title of your manual");
		s = in.nextLine();
		setTitle(s);
		System.out.println("Enter Author name of your manual");
		s = in.nextLine();
		setAuthor(s);
=======
        System.out.println("You entered string " + s);

        serial_number = "???????";
        title = "Untitled";
        author = "Unknown";
>>>>>>> origin/master

    }
	
}
