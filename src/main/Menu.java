package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {

    ArrayList<SinhVien> ListSinhVien = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void show(){
        for (SinhVien x:ListSinhVien){
            System.out.println(x.toString());
        }
    }

    public void add(){
            SinhVien sinhVien = new SinhVien();
            sinhVien.nhap();
            ListSinhVien.add(sinhVien);
    }
    public void change(){
        System.out.println("Nhập mã sinh viên cần sửa");
        String id = scanner.nextLine();
        for (int i = 0; i<ListSinhVien.size();i++){
            if (ListSinhVien.get(i).getId().equals(id)){
                SinhVien sinhVien = new SinhVien();
                sinhVien.nhap();
                ListSinhVien.set(i, sinhVien);
                return;
            }
        }
        System.out.println("Không tìm được sinh viên với mã sinh viên trên");
    }

    public void delete(){
        System.out.println("Nhập mã sinh viên muốn xóa");
        String id = scanner.nextLine();
        for ( int i=0; i<ListSinhVien.size(); i++){
            if (ListSinhVien.get(i).getId().equals(id)){
                ListSinhVien.remove(i);
                return;
            }
        }
        System.out.println("Không tìm được sinh viên với mã sinh viên trên. Nhập lại");
    }

    public void sapxepDStangdan(){

            Comparator<SinhVien> com1 = (o1, o2) -> {
                if (o1.getAvg() < o2.getAvg()) {
                    return -1;
                }else if (o1.getAvg() == o2.getAvg()){
                    return 0;
                }else {
                    return 1;
                }

            };
            Collections.sort(ListSinhVien,com1);
    }

    public void sapxepDSgiamdan(){

        sapxepDStangdan();
        Collections.reverse(ListSinhVien);
    }
    public static Comparator<SinhVien> diemtrungbinhtangdan = (o1, o2) -> (int) (o2.getAvg() - o1.getAvg());
    public static Comparator<SinhVien> diemtrungbinhgiamdan = (o1, o2) -> (int) (o1.getAvg() - o2.getAvg());

    public void readFromFile() {
        ListSinhVien = IOReadAndWrite.read();
    }
    public void writeToFile() {
        IOReadAndWrite.write(ListSinhVien);
    }

    public void menu() {
        int choice = 0;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
            System.out.println("Chọn chức năng theo số ( để tiếp tục )");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi từ file");
            System.out.println("8. Thoát");
            while (true) {
                System.out.println("Chọn chức năng: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập sai rồi, nhập lại");
                }
            }
                switch (choice) {
                    case 1:
                        show();
                        break;
                    case 2:
                        add();
                        break;
                    case 3:
                        change();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        try {
                            System.out.println("1. Sắp xếp điểm trung bình tăng dần");
                            System.out.println("2. Sắp xếp điểm trung bình giảm dần");
                            System.out.println("3. Thoát");
                            int case5 = Integer.parseInt(scanner.nextLine());
                            switch (case5){
                                case 1:
                                    sapxepDStangdan();
                                    break;
                                case 2:
                                    sapxepDSgiamdan();
                                    break;
                                case 3:
                                    menu();
                                    break;
                            }
                            break;
                        } catch (Exception e){
                            System.out.println("Bạn đã nhập sai định dạng");
                        }
                        break;
                    case 6:
                        readFromFile();
                        break;
                    case 7:
                        writeToFile();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Nhập lại đi, nhập sai rồi");
                        break;
                }
        }while(choice!=8);
    }
}




