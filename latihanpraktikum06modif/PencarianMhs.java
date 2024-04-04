package latihanpraktikum06modif;

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
        for (Mahasiswa m : listMhs) { //berfungsi untuk menampilkan data mahasiswa dengan perulangan for each
            if (m != null) { // jika m tidak sama dengan null
                m.tampil(); // maka akan menampilkan data mahasiswa
                System.out.println("--------------------");
            }
        }
    }

    // Membuat method FindBinarySearch
    public int FindBinarySearch(String cari, int left, int right) { // berfungsi untuk mencari data dengan metode binary search
        int mid;
        if (right >= left) { // jika right lebih besar sama dengan left
            mid = (left + right) / 2; // mid adalah left ditambah right dibagi 2 berfungsi untuk menentukan nilai tengah
            if (cari.equalsIgnoreCase(listMhs[mid].nama)) { // jika cari sama dengan listMhs[mid].nama
                return (mid); // mengembalikan nilai mid
            } else if (listMhs[mid].nama.compareToIgnoreCase(cari) > 0) { // jika listMhs[mid].nama lebih besar dari cari
                return FindBinarySearch(cari, left, mid - 1); // maka akan mengembalikan nilai FindBinarySearch(cari, left, mid - 1)
            } else {
                return FindBinarySearch(cari, mid + 1, right); // jika tidak maka akan mengembalikan nilai FindBinarySearch(cari, mid + 1, right)
            }
        }
        return -1; // mengembalikan nilai -1 jika tidak ada data yang ditemukan
    }

    public void TampilPosisi(String x, int pos) {
        if (pos != -1) {
            System.out.println("data : " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }
}
