package latihanpraktikum06modif;

import java.util.Arrays;

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

    public int[] FindBinarySearch(String cari, int left, int right) {
        int[] result = new int[listMhs.length];
        Arrays.fill(result, -1);
        int count = 0;
        if (right >= left) {
            int mid = (left + right) / 2;
            if (cari.equalsIgnoreCase(listMhs[mid].nama)) {
                result[count] = mid;
                count++;
                int[] leftResult = FindBinarySearch(cari, left, mid - 1);
                for (int i : leftResult) {
                    if (i != -1) {
                        result[count] = i;
                        count++;
                    }
                }
                int[] rightResult = FindBinarySearch(cari, mid + 1, right);
                for (int i : rightResult) {
                    if (i != -1) {
                        result[count] = i;
                        count++;
                    }
                }
            } else if (listMhs[mid].nama.compareToIgnoreCase(cari) > 0) {
                return FindBinarySearch(cari, left, mid - 1);
            } else {
                return FindBinarySearch(cari, mid + 1, right);
            }
        }
        return Arrays.copyOf(result, count);
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
