/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Menu;
import common.Algorithm;
import common.Library;

/**
 *
 * @author CongThanh
 */
public class StudentManagement extends Menu<String> {

    static String[] mc = {"Create", "Find and Sort", "Update/Delete", "Report", "Exit"};

    protected Library library;
    protected Algorithm algorithm;

    public StudentManagement() {
        super("Student Programing", mc);
        library = new Library();
        algorithm = new Algorithm();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                algorithm.creating();
                break;
            case 2:
                String studentNameSearch = library.inputString("Input name of student to search: ");
                algorithm.display(algorithm.sort(algorithm.searchByName(studentNameSearch)));
                break;
            case 3:
                String s = library.inputString("Input studentID you want update/delete: ");
                if (algorithm.searchById(s) != null) {
                    algorithm.update_deleting(s);
                }else{
                    System.out.println("Eroll studentID not found!!!   \n");
                }
                break;
            case 4:
                algorithm.report();
                break;
            case 5:
                System.exit(0);
        }
    }

}
