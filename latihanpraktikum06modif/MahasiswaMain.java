package latihanpraktikum06modif;

import java.util.Scanner;

/**
 * @author Abhinaya
 */
public class MahasiswaMain {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        Scanner sl = new Scanner(System.in);


        System.out.println("---------------------------------------");
        System.out.print("Masukkan jumlah data mahasiswa : ");
        int jumMhs = s.nextInt();

        PencarianMhs data = new PencarianMhs(jumMhs);
        

        System.out.println("---------------------------------------");
        System.out.println("Masukkan data mahasiswa : ");
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
            System.out.println("Masukkan Nama Mahasiswa yang dicari :");
            String cari = sl.nextLine();

            System.out.println("_____________________________________");
            System.out.println("Pencarian Data dengan Binary Search");
            int[] posisi = data.FindBinarySearch(cari, 0, jumMhs - 1);
            data.TampilPosisi(cari, posisi);
    }
}


