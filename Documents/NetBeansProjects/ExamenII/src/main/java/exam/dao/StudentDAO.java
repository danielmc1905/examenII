/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.dao;

import exam.orm.Student;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin01
 */
public class StudentDAO implements Serializable {

    private ArrayList<Student> studentList;

    public StudentDAO() {
        if (studentList == null) {
            studentList = new ArrayList();
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Adds a new student
     *
     * @param Student
     * @author Admin01
     */
    public void addStudent(Student student) {
        if (studentList.contains(student)) {
            return;
        } else {
            studentList.add(student);
        }
    }

    /**
     * Return the position in the list
     *
     * @param id
     * @author Admin01
     */
    public int position(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return (studentList.indexOf(id));
            }
        }
        return -1;
    }

    /**
     * Removes a student by id
     *
     * @param id
     * @author Admin01
     */
    public boolean delete(int id) {
        int index = position(id);
        if (index != -1) {
            return false;
        }
        studentList.remove(index);
        return true;
    }

    /**
     * Updates a Student
     *
     * @param Student
     * @author Admin01
     */
    public Student update(Student updatedStudent) throws Exception {
        if (delete(updatedStudent.getId())) { // if delete return true, add the new student
            addStudent(updatedStudent);
        } else {
            throw new Exception(String.format("Student %s not found", updatedStudent));
        }
        return updatedStudent;
    }

    /**
     * Looks for a student
     *
     * @param id
     * @author Admin01
     */
    public Student find(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Prints all the students
     *
     * @author Admin01
     * @return
     */
    public DefaultTableModel printStudents() {
        DefaultTableModel model = new DefaultTableModel();
        String labels[] = {
            "ID", "NAME", "LAST NAME", "BIRTH DATE",
            "AGE", "GENDER", "EMAIL", "PHONE", "CAREER", "ADDRESS"};
        model.setColumnIdentifiers(labels);
        String row[] = new String[10];
        for (Student student : studentList) {
            row[0] = "" + student.getId();
            row[1] = student.getName();
            row[2] = student.getLastName();
            row[3] = student.getBirthDate();
            row[4] = "" + student.getAge();
            row[5] = "" + student.getGender();
            row[6] = student.getEmail();
            row[7] = student.getPhone();
            row[8] = student.getCareer();
            row[9] = "" + student.getAddress();
            model.addRow(row);
        }
        return model;
    }

    /**
     * Read the students from the file
     *
     * @author Admin01
     */
    public void readStudents() {
        try {
            File file = new File("students.txt");
            if (file.exists()) {
                ObjectInputStream inputFile = new ObjectInputStream(
                        new FileInputStream(file));
                studentList = (ArrayList) inputFile.readObject();
                inputFile.close();
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error: class couldn't be found");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: file couldn't be found!");
        } catch (IOException ioe) {
            System.out.println("Error: file couldn't be read!");
        }
    }

    /**
     * Add students to the file
     *
     * @author Admin01
     */
    public void saveStudent() {
        String file = "students.txt";
        if (!studentList.isEmpty()) {
            try {
                ObjectOutputStream outputFile = new ObjectOutputStream(
                        new FileOutputStream(file));
                outputFile.writeObject(studentList);
                outputFile.flush();
                outputFile.close();
            } catch (FileNotFoundException fnte) {
                System.out.println("Error: file couldn't be found!");
            } catch (IOException ioe) {
                System.out.println("Error: failed to write in the file " + file + ".");
            }
        } else {
            System.out.println("There aren't students to save, the list is empty!");
        }
    }
}
