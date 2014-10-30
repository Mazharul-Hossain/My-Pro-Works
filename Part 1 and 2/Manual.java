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

    public static void main(String[] args) {

        Library library = new Library();

        library.addManual();
        library.addManual();
        library.addManual();
        library.addManual();
        library.addManual();

        //print all the values to console
        library.printDetailsAllManuals();
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

        System.out.println("Enter a string");
        String s = in.nextLine();
        System.out.println("You entered string " + s);

        serial_number = "???????";
        title = "Untitled";
        author = "Unknown";

    }
}
