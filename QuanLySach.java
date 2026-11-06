package Baithuchanh5;

import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    String maSach, tenSach, tacGia;
    int namXuatBan, soLuong;
    double donGia;

    double thanhTien() {
        return donGia * soLuong;
    }

    void nhap(Scanner sc) {
        System.out.print("Ma sach: ");
        maSach = sc.nextLine();

        System.out.print("Ten sach: ");
        tenSach = sc.nextLine();

        System.out.print("Tac gia: ");
        tacGia = sc.nextLine();

        System.out.print("Nam xuat ban: ");
        namXuatBan = Integer.parseInt(sc.nextLine());

        System.out.print("Don gia: ");
        donGia = Double.parseDouble(sc.nextLine());

        System.out.print("So luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
    }

    void xuat() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Thanh tien: " + thanhTien());
        System.out.println("-------------------------");
    }
}

public class QuanLySach {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Sach> danhSach = new ArrayList<>();

    static void nhapDanhSach() {
        System.out.print("Nhap so luong sach: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap sach thu " + (i + 1));
            Sach s = new Sach();
            s.nhap(sc);
            danhSach.add(s);
        }
    }

    static void hienThiDanhSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach sach rong!");
            return;
        }

        for (Sach s : danhSach) {
            s.xuat();
        }
    }

    static void tinhTong() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (Sach s : danhSach) {
            tongSoLuong += s.soLuong;
            tongGiaTri += s.thanhTien();
        }

        System.out.println("Tong so luong sach: " + tongSoLuong);
        System.out.println("Tong gia tri sach: " + tongGiaTri);
    }

    static void timSach() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();

        boolean timThay = false;

        for (Sach s : danhSach) {
            if (s.maSach.equalsIgnoreCase(ma)) {
                s.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach!");
        }
    }

    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n========== QUAN LY SACH ==========");
            System.out.println("1. Nhap n sach");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tinh tong so luong va tong gia tri sach");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    nhapDanhSach();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    tinhTong();
                    break;
                case 4:
                    timSach();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}

