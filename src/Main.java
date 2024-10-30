import java.util.Scanner;

/**
 * Kelas ini merepresentasikan detail pemesanan untuk sebuah perjalanan kapal pesiar.
 */
class BookingDetails {
    String customerName;
    String cruiseName;
    int numberOfPassengers;

    /**
     * Konstruktor untuk menginisialisasi detail pemesanan.
     *
     * @param customerName      Nama pelanggan yang memesan.
     * @param cruiseName        Nama kapal pesiar yang dipesan.
     * @param numberOfPassengers Jumlah penumpang dalam pemesanan.
     */
    public BookingDetails(String customerName, String cruiseName, int numberOfPassengers) {
        this.customerName = customerName;
        this.cruiseName = cruiseName;
        this.numberOfPassengers = numberOfPassengers;
    }
}

/**
 * Kelas ini mengelola proses pemesanan kapal pesiar, termasuk pengumpulan data
 * pemesanan, perhitungan harga, dan pencetakan ringkasan pemesanan.
 */
class CruiseBooking {
    // Harga per penumpang (konstanta)
    private static final double PRICE_PER_PASSENGER = 500.0;

    /**
     * Metode utama (main) untuk menjalankan program.
     *
     * @param args Argumen baris perintah (jika ada).
     */
    public static void main(String[] args) {
        CruiseBooking booking = new CruiseBooking();

        // Memproses pemesanan dan mencetak ringkasan pemesanan
        booking.processBooking();
    }

    /**
     * Metode ini mengumpulkan detail pemesanan dari pengguna melalui input konsol.
     *
     * @return Objek {@link BookingDetails} yang berisi data pemesanan.
     */
    private BookingDetails collectBookingDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String customer = scanner.nextLine();

        System.out.print("Masukkan nama kapal pesiar: ");
        String cruise = scanner.nextLine();

        System.out.print("Masukkan jumlah penumpang: ");
        int passengers = scanner.nextInt();

        // Mengembalikan objek BookingDetails yang berisi data pemesanan
        return new BookingDetails(customer, cruise, passengers);
    }

    /**
     * Menghitung total harga berdasarkan jumlah penumpang dan harga per penumpang.
     *
     * @param passengers Jumlah penumpang dalam pemesanan.
     * @return Total harga untuk semua penumpang.
     */
    private double calculateTotalPrice(int passengers) {
        return passengers * PRICE_PER_PASSENGER;
    }

    /**
     * Mencetak ringkasan pemesanan berdasarkan detail pemesanan.
     *
     * @param details Objek {@link BookingDetails} yang berisi data pemesanan.
     */
    public void printBookingSummary(BookingDetails details) {
        double totalPrice = calculateTotalPrice(details.numberOfPassengers);

        System.out.println("Detail Pemesanan:");
        System.out.println("Nama Pelanggan: " + details.customerName);
        System.out.println("Nama Kapal Pesiar: " + details.cruiseName);
        System.out.println("Jumlah Penumpang: " + details.numberOfPassengers);
        System.out.println("Total Harga: Rp" + totalPrice);
    }

    /**
     * Memproses pemesanan dengan mengumpulkan detail pemesanan dan mencetak ringkasannya.
     */
    public void processBooking() {
        BookingDetails details = collectBookingDetails();
        printBookingSummary(details);
    }
}