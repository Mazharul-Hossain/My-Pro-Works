import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tamanna Afreen
 */
public class Library {

    private ArrayList lists;

        int paginationIndex;
    int limit;

    public Library() {
        this.lists = new ArrayList();

        limit = 10;
    }

    public void addManual() {

        Manual manual = new Manual();
        manual.getDetails();

        lists.add(manual);
    }
	
	public void addManual(Manual manual) {
        lists.add(manual);
    }

    public void printDetailsAllManuals() {

        for (Object list : lists) {
            Manual manual = (Manual) list;
            manual.print_2_console();
        }
    }
	
	public String[][] Browse(int start, int limit) {
        paginationIndex = start;

        int end = paginationIndex + limit;

        String[][] resultData = new String[100][3];

        int index = 0;
        for (int i = start; i < end; i++) {
            Manual manual = (Manual) lists.get(i);

            resultData[index][0] = manual.getSerialNumber();
            resultData[index][1] = manual.getTitle();
            resultData[index][2] = manual.getAuthor();
        }

        return resultData;
    }

    public void addRow(JTable jtable, String[][] resultData) {

        DefaultTableModel model = (DefaultTableModel) jtable.getModel();

        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        int i, j;
        ValidationEngine vEngine = new ValidationEngine();
        for (i = 1; i < resultData.length; i++) {
            Object[] object = new Object[resultData[i].length];
            for (j = 0; j < resultData[i].length; j++) {
                object[j] = resultData[i][j];
            }
            if (!vEngine.checkString(resultData[i][j - 1])) {
                break;
            }
            model.addRow(object);
        }
        System.out.println("addRow : " + model.getRowCount());
    }

    /**
     * Functions for paginations
     *
     * @return
     *
     */
    public String[][] BrowseFirst() {
        return Browse(0, limit);
    }

    public String[][] BrowseLast() {

        int start = ((int) (lists.size() / limit)) * limit;
        System.out.println("start : " + start);
        return Browse(start, limit);
    }

    public String[][] BrowseNext() {

        int totalMax = lists.size();

        if (totalMax < (paginationIndex + limit)) {
            return BrowseLast();
        } else {
            return Browse((paginationIndex + limit), limit);
        }
    }

    public String[][] BrowsePrevious() {
        if (0 > (paginationIndex - limit)) {
            return BrowseFirst();
        } else {
            return Browse((paginationIndex - limit), limit);
        }
    }

}
