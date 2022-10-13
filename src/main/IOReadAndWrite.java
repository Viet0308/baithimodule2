package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOReadAndWrite {
    static File file = new File("E:\\module2\\casestudy\\baithimodule2\\src\\filetxt\\csv.txt");

    public static void write (ArrayList<SinhVien> ListSinhVien) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (SinhVien sinhVien : ListSinhVien ) {
                bufferedWriter.write(sinhVien.getId()+ "," + sinhVien.getFullname() + "," + sinhVien.getAge()+ ","+ sinhVien.getGender()+ "," + sinhVien.getAddress() + "," + sinhVien.getAvg());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<SinhVien> read (){
        ArrayList<SinhVien> ListSinhVien =new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                String id = arr[0];
                String fullname = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                double avg = Double.parseDouble(arr[5]);
                SinhVien student = new SinhVien(id, fullname, age, gender, address,avg);
                ListSinhVien.add(student);
                str = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListSinhVien;
    }


}

//        public void write(File file, ArrayList<E> list){
//            try {
//                FileOutputStream fileOutputStream = new FileOutputStream(file);
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//                objectOutputStream.writeObject(list);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        public ArrayList<E> read(File file){
//            try{
//                FileInputStream fileInputStream = new FileInputStream(file);
//                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//                ArrayList<E> list = (ArrayList<E>) objectInputStream.readObject();
//                return list;
//            }catch (Exception e){
//                e.printStackTrace();
//                return new ArrayList<>();
//            }
//        }
//    }
