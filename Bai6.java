import java.util.ArrayList;
import java.util.Scanner;

public class Bai6 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> danhSachSach = new ArrayList<>();
    static ArrayList<Integer> soLuong = new ArrayList<>();
    static ArrayList<Double> donGia = new ArrayList<>();

    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n===== QUAN LY SACH =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSach();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    suaSach();
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 8);
    }

    static void themSach() {
        System.out.print("Nhap ten sach: ");
        String ten = sc.nextLine();

        System.out.print("Nhap so luong: ");
        int sl = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap don gia: ");
        double gia = Double.parseDouble(sc.nextLine());

        danhSachSach.add(ten);
        soLuong.add(sl);
        donGia.add(gia);

        System.out.println("Them sach thanh cong!");
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach trong!");
            return;
        }

        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println("Sach: " + danhSachSach.get(i)
                    + " | So luong: " + soLuong.get(i)
                    + " | Don gia: " + donGia.get(i));
        }
    }

    static void timSach() {
        System.out.print("Nhap ten sach can tim: ");
        String ten = sc.nextLine();

        boolean timThay = false;

        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).equalsIgnoreCase(ten)) {
                System.out.println("Tim thay sach!");
                System.out.println("Ten: " + danhSachSach.get(i));
                System.out.println("So luong: " + soLuong.get(i));
                System.out.println("Don gia: " + donGia.get(i));
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach!");
        }
    }

    static void xoaSach() {
        System.out.print("Nhap ten sach can xoa: ");
        String ten = sc.nextLine();

        int index = danhSachSach.indexOf(ten);

        if (index != -1) {
            danhSachSach.remove(index);
            soLuong.remove(index);
            donGia.remove(index);
            System.out.println("Xoa sach thanh cong!");
        } else {
            System.out.println("Khong tim thay sach!");
        }
    }

    static void suaSach() {
        System.out.print("Nhap ten sach can sua: ");
        String ten = sc.nextLine();

        int index = danhSachSach.indexOf(ten);

        if (index != -1) {
            System.out.print("Nhap ten sach moi: ");
            danhSachSach.set(index, sc.nextLine());

            System.out.print("Nhap so luong moi: ");
            soLuong.set(index, Integer.parseInt(sc.nextLine()));

            System.out.print("Nhap don gia moi: ");
            donGia.set(index, Double.parseDouble(sc.nextLine()));

            System.out.println("Sua sach thanh cong!");
        } else {
            System.out.println("Khong tim thay sach!");
        }
    }

    static void tinhTongSoLuong() {
        int tong = 0;

        for (int sl : soLuong) {
            tong += sl;
        }

        System.out.println("Tong so luong sach: " + tong);
    }

    static void tinhTongGiaTri() {
        double tong = 0;

        for (int i = 0; i < soLuong.size(); i++) {
            tong += soLuong.get(i) * donGia.get(i);
        }

        System.out.println("Tong gia tri sach: " + tong);
    }
}