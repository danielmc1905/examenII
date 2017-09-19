/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.orm;

import java.io.Serializable;

/**
 *
 * @author Admin01
 */
public class Student implements Serializable {

    public enum Gender {
        M,
        F
    }
    private int id;
    private String name;
    private String lastName;
    private String birthDate;
    private int age;
    private String email;
    private String phone;
    private String career;
    private Address address;
    private Gender gender;

    public Student() {
    }

    public Student(int id, String name, String lastName,
            String birthDate, int age, String email, String phone,
            String career, Address address, Gender gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.career = career;
        this.address = address;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", lastName="
                + lastName + ", birthDate=" + birthDate + ", age=" + age
                + ", email=" + email + ", phone=" + phone + ", career="
                + career + ", address=" + address + ", gender=" + gender + '}';
    }

}
