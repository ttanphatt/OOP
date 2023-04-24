/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class demo {

    public static void main(String[] args) throws ParseException, Exception {
        boolean f = true;
        int chon1 = 0;
        KhachHang khDN;
        //-------------------- TEST------------------

        KhachHang kh1 = new KhachHang("hoang", "nam", "gl", "123123124", "23/09/2001", 2000000, "hoangou", new TaiKhoan(2000000));
        TaiKhoanCoKyHan acc2 = new TaiKhoanCoKyHan(KyHan.MOT_TUAN, 1500000);
        TaiKhoanCoKyHan acc3 = new TaiKhoanCoKyHan(KyHan.MOT_THANG, 2500000);
        kh1.getTk().themTKKH(acc2, acc3);
        acc2.setNgayDaoHan(new GregorianCalendar());
//        acc3.setNgayDaoHan(new GregorianCalendar());

        KhachHang kh2 = new KhachHang("phat", "nam", "ag", "2314412312", "03/01/2002", 5000000, "phatou", new TaiKhoan(5000000));
        TaiKhoanCoKyHan acc4 = new TaiKhoanCoKyHan(KyHan.SAU_THANG, 1900000);
        TaiKhoanCoKyHan acc5 = new TaiKhoanCoKyHan(KyHan.MUOIHAI_THANG, 2900000);
        kh2.getTk().themTKKH(acc4, acc5);
        acc4.setNgayDaoHan(new GregorianCalendar());
//        acc5.setNgayDaoHan(new GregorianCalendar());

        System.out.println("====== TK : hoangou ======");
        System.out.printf("*Password: %d\n", kh1.getTk().matKhau);
        System.out.printf("So tai khoan khong ky han: %s\n", kh1.getMaSoKH());
        System.out.printf("So tai khoan co ky han: %s\n", acc2.getSTKcoKyHan());
        System.out.printf("So tai khoan co ky han: %s\n", acc3.getSTKcoKyHan());

        System.out.println("\n====== TK : phatou ======");
        System.out.printf("*Password: %d\n", kh2.getTk().matKhau);
        System.out.printf("So tai khoan khong ky han: %s\n", kh2.getMaSoKH());
        System.out.printf("So tai khoan co ky han: %s\n", acc4.getSTKcoKyHan());
        System.out.printf("So tai khoan co ky han: %s\n", acc5.getSTKcoKyHan());

        QuanLyKhachHang qlKH = new QuanLyKhachHang();
        qlKH.themKH(kh1);
        qlKH.themKH(kh2);

        //-------------------------------------------------
        while (f) {
            System.out.println("");
            System.out.println("*********** MENU ***********");
            System.out.print("1. Nhap thong tin khach hang\n"
                    + "2. Xuat thong tin khach Hang\n"
                    + "3. Tinh tien lai theo STK khach hang\n"
                    + "4. Tim kiem khach hang\n"
                    + "5. Sap xep khach hang giam dan theo so du\n"
                    + "6. KHACH HANG DANG NHAP\n"
                    + "7. Thoat chuong trinh\n"
                    + "Ban chon?: ");
            chon1 = DungChung.sc.nextInt();
            switch (chon1) {
                case 1: {
                    System.out.print("\n==== NHAP THONG TIN KHACH HANG ==== \n");
                    KhachHang kh = new KhachHang();
                    kh.nhapKH();
                    if (qlKH.isKHDaCo(kh)) {
                        qlKH.themKH(kh);
                        System.out.printf("*Password: %d\n", kh.getTk().matKhau);
                        System.out.println("\nThem khach hang thanh cong!");
                    } else {
                        System.out.println("\nUsername da ton tai! Them khach hang that bai!");
                    }
                    break;
                }//cs1
                case 2: {
                    System.out.println("\n==== DANH SACH THONG TIN KHACH HANG ====");
                    qlKH.xuatDSKH();
                    break;
                }//cs2

                case 3: {
                    DungChung.sc.nextLine();
                    System.out.print("Nhap STK: ");
                    String stk = DungChung.sc.nextLine();
                    qlKH.tinhLaiTheoSTK(stk);
                    break;
                }//cs3

                case 4: {
                    int chon2;
                    System.out.println("\n=== TIM KIEM ===");
                    System.out.print("1. Tim kiem Khach Hang theo Ho & ten\n"
                            + "2. Tim kiem Khach Hang theo STK Khach Hang\n"
                            + "3. Tim kiem danh sach tai khoan cua Khach Hang\n"
                            + "4. Thoat\n"
                            + "Ban chon?: ");
                    chon2 = DungChung.sc.nextInt();
                    switch (chon2) {
                        case 1: {
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ho va ten Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qlKH.timKHTheoTen(s);

                            if (kh != null) {
                                System.out.println("\n==== THONG TIN KHACH HANG THEO HO&TEN ====");
                                kh.hienThiKH();
                            } else {
                                System.out.println("Khong tim thay khach hang nao!");
                            }
                            break;
                        }
                        case 2: {
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ma so Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qlKH.timKHTheoSTK(s);

                            if (kh != null) {
                                System.out.println("\n==== THONG TIN KHACH HANG THEO STK ====");
                                kh.hienThiKH();
                            } else {
                                System.out.println("Khong tim thay khach hang nao!");
                            }
                            break;
                        }
                        case 3: {
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ma so Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qlKH.timKHTheoSTK(s);

                            if (kh != null) {
                                System.out.println("\n==== THONG TIN DS TAI KHOAN CUA KHACH HANG THEO STK ====");
                                kh.getTk().hienThiTK();
                                kh.getTk().xuatTKKH();
                            } else {
                                System.out.println("Khong tim thay khach hang nao!");
                            }
                            break;
                        }
                        case 4: {
                            break;
                        }
                    }//sw2                   
                    break;
                }//cs4

                case 5: {
                    qlKH.sapXepKH();
                    System.out.println("\n===== SAP XEP KHACH HANG =====");
                    qlKH.xuatDSKH();
                    break;
                }//cs5
                case 6: {
                    String username;
                    int password;

                    DungChung.sc.nextLine();
                    System.out.print("Username: ");
                    username = DungChung.sc.nextLine();

                    System.out.print("Password: ");
                    password = DungChung.sc.nextInt();

                    khDN = qlKH.dangNhap(username, password);
                    if (khDN == null) {
                        System.out.println("SAI tai khoan hoac mat khau!!");
                        break;
                    }

                    int chon3;
                    do {
                        System.out.printf("\n==== MENU KHACH HANG ====\n*STK: %s\n*Ho & ten: %s\n", khDN.getMaSoKH(), khDN.getHoTen());
                        khDN.getTk().hienThiTK();
                        System.out.print(""
                                + "1. Mo Tai Khoan Co Ky Han\n"
                                + "2. Nop tien vao TK Chinh\n"
                                + "3. Rut tien TK Chinh\n"
                                + "4. Rut tien TK co ky han\n"
                                + "5. Doi mat khau\n"
                                + "6. Nap tien vao TK co ky han\n"
                                + "7. Dang xuat!\n"
                                + "Ban chon?: ");
                        chon3 = DungChung.sc.nextInt();

                        switch (chon3) {
                            case 1: {
                                double tiengui;
                                do {
                                    System.out.print("     Nhap so tien muon gui (>=100000): ");
                                    tiengui = DungChung.sc.nextDouble();
                                } while (tiengui < 100000);

                                double tienconlai = khDN.getTk().soDu - tiengui;
                                if (tienconlai < 50000 || tiengui < 100000) {
                                    System.out.print("\nSO DU khong du tien de mo tai khoan co ki han!\n");
                                } else {
                                    khDN.getTk().soDu = tienconlai;
                                    System.out.print("    Ky han: \n"
                                            + "     1. 1 tuan \n"
                                            + "     2. 1 thang \n"
                                            + "     3. 6 thang \n"
                                            + "     4. 1 nam\n"
                                            + "Ban chon ky han: ");
                                    int chonkyhan = DungChung.sc.nextInt();
                                    TaiKhoanCoKyHan acc;
                                    switch (chonkyhan) {
                                        case 1: {
                                            acc = new TaiKhoanCoKyHan(KyHan.MOT_TUAN, tiengui);
                                            khDN.getTk().themTKKH(acc);
                                            System.out.println("=== THONG TIN TAI KHOAN VUA TAO ===");
                                            acc.hienThiTK();
                                            break;

                                        }
                                        case 2: {
                                            acc = new TaiKhoanCoKyHan(KyHan.MOT_THANG, tiengui);
                                            khDN.getTk().themTKKH(acc);
                                            System.out.println("=== THONG TIN TAI KHOAN VUA TAO ===");
                                            acc.hienThiTK();

                                            break;
                                        }

                                        case 3: {
                                            acc = new TaiKhoanCoKyHan(KyHan.SAU_THANG, tiengui);
                                            khDN.getTk().themTKKH(acc);
//                                            khDN.themAccount(acc);
                                            System.out.println("=== THONG TIN TAI KHOAN VUA TAO ===");
                                            acc.hienThiTK();

                                            break;
                                        }

                                        case 4: {
                                            acc = new TaiKhoanCoKyHan(KyHan.MUOIHAI_THANG, tiengui);
                                            System.out.println("=== THONG TIN TAI KHOAN VUA TAO ===");
                                            khDN.getTk().themTKKH(acc);
                                            acc.hienThiTK();

                                            break;
                                        }
                                    }
                                }
                                break;
                            }

                            case 2: {
                                System.out.print("     So tien muon nap vao tai khoan chinh (>=50000): ");
                                double tiennapTKC = DungChung.sc.nextDouble();

                                try {
                                    if (tiennapTKC < 0) {
                                        throw new Exception("So tien nop khong hop le!");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("So tien nop khong hop le!");
                                    DungChung.sc.nextLine();
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }

                                do {
                                    if (tiennapTKC < 50000) {
                                        System.out.print("Vui long nhap lai! (>=50000): ");
                                        tiennapTKC = DungChung.sc.nextDouble();
                                    }
                                } while (tiennapTKC < 50000);
                                System.out.println("\nNap tien thanh cong!");
                                khDN.getTk().nopTien(tiennapTKC);
                                break;
                            }
                            case 3: {
                                System.out.print("   So tien muon rut tu tai khoan chinh: ");
                                double tienrutTKC = DungChung.sc.nextDouble();
                                try {
                                    if (tienrutTKC < 0) {
                                        throw new Exception("So tien khong hop le!");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("So tien khong hop le!");
                                    DungChung.sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                                double tienConLaiTKC = khDN.getTk().soDu - tienrutTKC;
                                if (tienrutTKC > khDN.getTk().soDu || tienConLaiTKC < 50000) {
                                    System.out.println("So du khong du de rut!");
                                } else {
                                    khDN.getTk().rutTien(tienrutTKC);
                                    System.out.println("\nRut tien thanh cong!!!\n");
                                }

                                break;
                            }
                            case 4: {
                                DungChung.sc.nextLine();
                                System.out.println("\n=== DANH SACH TAI KHOAN ===");
                                khDN.getTk().xuatTKKH();
                                double tienrutTKCKH;
                                int stt;

                                System.out.print("    Nhap so thu tu tai khoan co ky han ban muon rut: ");
                                stt = DungChung.sc.nextInt();

                                do {
                                    System.out.print("    Nhap so tien muon rut (=so du hien tai): ");
                                    tienrutTKCKH = DungChung.sc.nextDouble();
                                } while (tienrutTKCKH != khDN.getTk().getDsTKKH().get(stt).soDu);

                                khDN.getTk().getDsTKKH().get(stt).rutTien(tienrutTKCKH,khDN.getTk());
                                khDN.getTk().getDsTKKH().get(stt).hienThiTK();

                                break;
                            }
                            case 5: {
                                System.out.print("     Nhap mat khau moi: ");
                                int matkhauMoi = DungChung.sc.nextInt();
                                khDN.getTk().doiMatKhau(matkhauMoi);
                                System.out.println("\nDoi mat khau thanh cong!\n");
                                break;
                            }
                            case 6: {
                                DungChung.sc.nextLine();
                                System.out.println("=== DANH SACH TAI KHOAN ===");
                                khDN.getTk().hienThiTK();
                                khDN.getTk().xuatTKKH();
//                                khDN.xuatAccount();
                                System.out.print("    Nhap so thu tu tai khoan co ky han ban muon nop: ");
                                int stt = DungChung.sc.nextInt();
                                double tien;
                                do {
                                    System.out.print("    Nhap so tien muon nop (>=100000): ");
                                    tien = DungChung.sc.nextDouble();
                                } while (tien < 100000);
                                khDN.getTk().getDsTKKH().get(stt).nopTien(tien, khDN.getTk());

                                break;
                            }
                            default: {
                                break;
                            }
                        }//sw3
                    } while (chon3 < 7);
                    break;
                }//cs6
                case 7: {
                    System.out.println("Tam biet!");
                    f = false;
                    break;
                }
                default: {
                    System.out.println("Vui long nhap lai!!");
                }
            }//sw1

        }

    }//main
}
