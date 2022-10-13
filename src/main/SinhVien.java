package main;

import java.util.Scanner;

public class SinhVien {
    private String id;
    private String fullname;
    private int age;
    private String gender;
    private String address;
    private double avg;

    public SinhVien() {
    }

    public SinhVien(int id, String fullname, int age, String gender, String address, double avg) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", avg=" + avg +
                '}';
    }

    void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên");
        this.id= scanner.nextLine();
        System.out.println("Nhập tên sinh viên");
        this.fullname = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính học viên");
        this.gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ của sinh viên");
        this.address = scanner.nextLine();
        System.out.println("Nhập điểm trung bình của sinh viên");
        this.avg = Double.parseDouble(scanner.nextLine());
    }
}
