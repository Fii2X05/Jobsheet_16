import java.util.Scanner;

class KafeProgram {
    // Deklarasi Scanner dan Array
    static Scanner sc = new Scanner(System.in);
    static String[][] daftarPesanan = new String[10][4];
    static int totalPesanan = 0;

    public static void main(String[] args) {

        menuUtama();
    }

    static void menuUtama() {

        System.out.println("===== MENU UTAMA =====");
        System.out.println("1. Tambahkan Pesanan");
        System.out.println("2. Tampilkan Daftar Pesanan");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
        int pilihan = sc.nextInt();
        sc.nextLine();

        switch (pilihan) {
            case 1: tambahPesanan();
            case 2: tampilkanPesanan(0);
            case 3: {
                System.out.println("Terima kasih telah menggunakan program!");
                System.exit(0);
            }
            default: {
                System.out.println("Pilihan tidak valid, coba lagi.");
                menuUtama();
            }
        }
    }

    static void tambahPesanan() {

        if (totalPesanan >= 10) {
            System.out.println("Daftar pesanan penuh!");
            menuUtama();
            return;
        }

        System.out.print("Masukkan nama pelanggan: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan nomor meja: ");
        String meja = sc.nextLine();

        System.out.println("===== MENU KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15000");
        System.out.println("2. Latte - Rp 22000");
        System.out.println("3. Teh Tarik - Rp 12000");
        System.out.println("4. Mie Goreng - Rp 18000");

        int totalHarga = 0;
        while (true) {
            System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
            int nomorMenu = sc.nextInt();
            sc.nextLine();

            if (nomorMenu == 0) break;

            if (nomorMenu < 1 || nomorMenu > 4) {
                System.out.println("Menu tidak valid. Coba lagi.");
                continue;
            }

            System.out.print("Masukkan jumlah item: ");
            int jumlah = sc.nextInt();
            sc.nextLine();

            if (jumlah <= 0) {
                System.out.println("Jumlah item harus lebih dari 0.");
                continue;
            }

            int harga = switch (nomorMenu) {
                case 1 -> 15000;
                case 2 -> 22000;
                case 3 -> 12000;
                case 4 -> 18000;
                default -> 0;
            };
            totalHarga += harga * jumlah;
        }

        daftarPesanan[totalPesanan][0] = nama;
        daftarPesanan[totalPesanan][1] = meja;
        daftarPesanan[totalPesanan][2] = String.valueOf(totalHarga);
        daftarPesanan[totalPesanan][3] = "Pesanan ke-" + (totalPesanan + 1);
        totalPesanan++;

        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: Rp " + totalHarga);
        menuUtama();
    }

    static void tampilkanPesanan(int index) {
        if (index >= totalPesanan) {
            menuUtama();
            return;
        }

        System.out.println("Pesanan ke-" + (index + 1));
        System.out.println("Nama Pelanggan: " + daftarPesanan[index][0]);
        System.out.println("Nomor Meja: " + daftarPesanan[index][1]);
        System.out.println("Total Harga: Rp " + daftarPesanan[index][2]);
        System.out.println("===================================");
        tampilkanPesanan(index + 1);
    }
}
