/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Student;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author CongThanh
 */
public class Algorithm extends ArrayList<Student> {

    Library library = new Library();
    Scanner sc = new Scanner(System.in);

    public void creating() {
        int count = 1;
        while (count <= 2) {
            String studentId = library.inputString("Input student ID: ");
            String studentName = library.inputString("Input name student: ");
            String semester = library.inputString("Input semester: ");
            String sourseName = library.inputString("Input sourse name: ");
            System.out.println("");
            this.add(new Student(studentId, studentName, semester, sourseName));
            count++;
        }
        if (count <= 3) {
            while (true) {
                String s = library.inputString(" Do you want to continue (Y/N)?: ");
                System.out.println("");
                if (s.equalsIgnoreCase("N")) {
                    return;
                } else if (s.equalsIgnoreCase("Y")) {
                    String studentId = library.inputString("Input student ID: ");
                    String studentName = library.inputString("Input name student: ");
                    String semester = library.inputString("Input semester: ");
                    String sourseName = library.inputString("Input sourse name: ");
                    this.add(new Student(studentId, studentName, semester, sourseName));
                } else {
                    System.out.println("Try gaint!!!");
                    System.out.println("");
                }
            }
        }
    }

    public void update_deleting(String studentID) {
        String s = library.inputString("Do you want to update (U) or delete (D) student: ");
        System.out.println("");

        if (s.equalsIgnoreCase("U")) {
            for (Student stu : this) {
                if (stu.getStudentId().equalsIgnoreCase(studentID)) {

                    String semester = library.inputString("Input semester: ");
                    stu.setSemester(semester);
                    String sourseName = library.inputString("Input sourse name: ");
                    stu.setCourseName(sourseName);
                }
            }
//               
        } else if (s.equalsIgnoreCase("D")) {
            try {
                for (Student thi : this) {
                    if (thi.getStudentId().equalsIgnoreCase(studentID)) {
                        this.remove(thi);
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public List<Student> searchByName(String studentName) {
        return this.stream().filter(s -> s.getStudentName().contains(studentName)).collect(Collectors.toList());
    }

    public Student searchById(String studentId) {
        for (Student student : this) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> sort(List<Student> list) {
        Collections.sort(list, (a, b) -> a.getStudentName().compareTo(b.getStudentName()));
        return list;
    }

    public void report() {

        String studentNamePrev = null;
        String coursePrev = null;
        int count = 0;
        sort(this);
        for (Student thi : this) {
            if (thi.getStudentName().equalsIgnoreCase(studentNamePrev)
                    && thi.getCourseName().equalsIgnoreCase(coursePrev)) {
                count++;

            } else {
                count = 1;
            }
            studentNamePrev = thi.getStudentName();
            coursePrev = thi.getCourseName();
            System.out.println(thi.getStudentName() + " | " + thi.getCourseName() + " | " + count);
        }

    }

    public void display(List<Student> list) {
        for (Student stu : this) {
            System.out.println(stu);
        }
    }
}
