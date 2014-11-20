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

    public void print_2_console() {
        System.out.println("serial_number:" + serial_number + "title:" + title + "author:" + author);
    }

    public void print_2_console(String src_num, String Title, String Author) {
        System.out.println("serial_number:" + src_num + "title:" + Title + "author:" + Author);
    }
    /*
     public static void main(String[] args) {
     Manual manObj1 = new Manual();

     Manual manObj2 = new Manual("123");
     Manual manObj3 = new Manual("114", "Value of life");
     Manual manObj4 = new Manual("115", "Value of Death", "Robert C Brown");
     //print all the values to console
     manObj1.print_2_console();
     manObj2.print_2_console();
     manObj3.print_2_console();
     manObj4.print_2_console();
        
     //Added code for storing user value 
     manObj1.getDetails();
     //  manObj1.print_2_console(getSerialNumber(),getTitle(),getAuthor());
     }
     */

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

        Manual manual = new Manual();
        ValidationEngine vEngine = new ValidationEngine();

        System.out.println("Enter the serial number of your manual");
        String s = in.nextLine();
        if (vEngine.checkString(s)) {
            setSerialNumber(s);
        }

        System.out.println("Enter title of your manual");
        s = in.nextLine();
        if (vEngine.checkString(s)) {
            setTitle(s);
        }
        System.out.println("Enter Author name of your manual");
        s = in.nextLine();
        if (vEngine.checkString(s)) {
            setAuthor(s);
        }
        in.close();
    }

}
