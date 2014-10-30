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

    public Library() {
        this.lists = new ArrayList();
    }

    public void addManual() {

        Manual manual = new Manual();
        manual.getDetails();

        lists.add(manual);
    }

    public void printDetailsAllManuals() {

        for (Object list : lists) {
            Manual manual = (Manual) list;
            manual.print_2_console();
        }
    }

}
