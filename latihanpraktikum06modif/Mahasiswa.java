package latihanpraktikum06modif;

/**
 * @author Abhinaya
 */

// Membuat class Mahasiswa
public class Mahasiswa {
    int nim;
    String nama;
    int umur;
    double ipk;

    // Membuat constructor Mahasiswa
    Mahasiswa(int ni, String n, int u, double i) {
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }

    // Membuat method tampil
    void tampil() {
        System.out.println("NIM\t: " + nim);
        System.out.println("Nama\t: " + nama);
        System.out.println("Umur\t: " + umur);
        System.out.println("IPK\t: " + ipk);
    }
}
