package praktikum06;

import java.util.Scanner;

/**
 * @author Abhinaya
 */
public class MahasiswaMain {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Scanner sl = new Scanner(System.in);

        PencarianMhs data = new PencarianMhs();
        System.out.println("---------------------------------------");
        System.out.print("Masukkan jumlah data mahasiswa : ");
        int jumMhs = s.nextInt();
        

        System.out.println("---------------------------------------");
        System.out.println("Masukkan data mahasiswa secara Urut dari NIM terkecil");
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("---------------------------------------");
            System.out.print("NIM\t: ");
            int nim = s.nextInt();
            System.out.print("Nama\t: ");
            String nama = sl.nextLine();
            System.out.print("Umur\t: ");
            int umur = s.nextInt();
            System.out.print("IPK\t: ");
            double ipk = s.nextDouble();

            Mahasiswa m = new Mahasiswa(nim, nama, umur, ipk);
            data.tambah(m);
        }

            System.out.println("---------------------------------------");
            System.out.println("Data keseluruhan mahasiswa : ");
            data.tampil();

            System.out.println("_____________________________________");
            System.out.println("_____________________________________");
            System.out.println("Pencarian Data : ");
            System.out.println("Masukkan NIM Mahasiswa yang dicari :");
            System.out.print("NIM : ");
            int cari = s.nextInt();
            System.out.println("Menggunakan Sequential Search");
            int posisi = data.FindSeqSearch(cari);

            data.TampilPosisi(cari, posisi);
            data.TampilData(cari, posisi);

            System.out.println("=====================================");
            System.out.println("Menggunakan Binary Search");
            posisi = data.FindBinarySearch(cari, 0, jumMhs - 1);
            data.TampilPosisi(cari, posisi);
            data.TampilData(cari, posisi);
        }
    }


