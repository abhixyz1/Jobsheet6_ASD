package latihanpraktikum06modif;

import java.util.Arrays; // untuk mengimport class Arrays agar bisa digunakan pada program ini

/**
 * @author Abhinaya
 */

// Membuat class Mahasiswa
public class PencarianMhs {
    Mahasiswa listMhs[];
    int idx;

    // Membuat constructor PencarianMhs
    public PencarianMhs(int jumMhs) { // parameter jumMhs
        listMhs = new Mahasiswa[jumMhs];
        idx = 0;
    }

    // Membuat method tambah
    void tambah(Mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        }
    }

    // Membuat method tampil
    void tampil() {
        for (Mahasiswa m : listMhs) { // berfungsi untuk menampilkan data mahasiswa dengan perulangan for each
            if (m != null) { // jika m tidak sama dengan null
                m.tampil(); // maka akan menampilkan data mahasiswa
                System.out.println("--------------------");
            }
        }
    }

    // Membuat method FindBinarySearch
    public int[] FindBinarySearch(String cari, int left, int right) { 
        int[] result = new int[listMhs.length];  // membuat array result dengan panjang listMhs
        Arrays.fill(result, -1); // mengisi array result dengan -1 agar tidak ada data yang kosong
        int count = 0; // membuat variabel count dengan nilai 0 
        if (right >= left) { 
            int mid = (left + right) / 2; // berfungsi untuk mencari nilai tengah dari left dan right
            if (cari.equalsIgnoreCase(listMhs[mid].nama)) { // berfungsi untuk membandingkan nama mahasiswa dengan data yang dicari
                result[count] = mid; // jika data yang dicari sama dengan nama mahasiswa maka akan menampilkan indeks mid
                count++;
                int[] leftResult = FindBinarySearch(cari, left, mid - 1); // berfungsi untuk mencari data yang dicari pada bagian kiri
                for (int i : leftResult) { // perulangan for each
                    if (i != -1) { // jika i tidak sama dengan -1
                        result[count] = i; // maka akan menampilkan indeks i
                        count++;
                    }
                }
                int[] rightResult = FindBinarySearch(cari, mid + 1, right); // berfungsi untuk mencari data yang dicari pada bagian kanan
                for (int i : rightResult) {
                    if (i != -1) {
                        result[count] = i; // maka akan menampilkan indeks i
                        count++;
                    }
                }
            } else if (listMhs[mid].nama.compareToIgnoreCase(cari) > 0) { // jika nama mahasiswa lebih besar dari data yang dicari
                return FindBinarySearch(cari, left, mid - 1); // maka akan mencari data yang dicari pada bagian kiri
            } else {
                return FindBinarySearch(cari, mid + 1, right); // jika tidak maka akan mencari data yang dicari pada bagian kanan
            }
        }
        return Arrays.copyOf(result, count); // berfungsi untuk mengembalikan nilai result, copyOf digunakan untuk menyalin array
    }

    public void TampilPosisi(String x, int[] posisi) {
        if (posisi.length == 0) {
            System.out.println("Data " + x + " tidak ditemukan");
        } else if (posisi.length > 1) {
            System.out.println("Peringatan! Data " + x + " duplikasi ditemukan pada indeks ke : ");
            for (int pos : posisi) {
                if (pos != -1) {
                    System.out.println("Data " + x + " ditemukan pada indeks ke : " + pos);
                    System.out.println("===================================");
                }
            }
        } else {
            System.out.println("Data " + x + " ditemukan pada indeks ke : " + posisi[0]);
            System.out.println("===================================");
        }
    }
}
