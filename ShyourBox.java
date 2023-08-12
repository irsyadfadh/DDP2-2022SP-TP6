import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShyourBox {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Customer loginCustomer;

    public static void main(String[] args) {
        ShyourBox app = new ShyourBox();
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        app.initProducts();
        app.initCustomers();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu" +
                    "\n1. Login" +
                    "\n0. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Masukkan nama pengguna:");
                    String user = scanner.next();
                    app.loginCustomer = app.searchCustomer(user);
                    if (app.loginCustomer != null) {
                        app.customerMenu();
                    } else {
                        System.out.println("Customer tidak ditemukan");
                    }
                    break;
                case 0:
                    System.out.println("Sampai Jumpa!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }

        } while (choice != 0);
        scanner.close();
    }

    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------Customer " + this.loginCustomer.getName() + " Menu------------------" +
                    "\n1. Lihat Keranjang" +
                    "\n2. Tambah Produk ke Keranjang" +
                    "\n3. Checkout Keranjang" +
                    "\n4. Riwayat Pembelian" +
                    "\n0. Logout");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // System.out.println("List Produk Pada Keranjang Anda");
                    // PrintGenericList<OrderItem> printGenericList = new PrintGenericList<>();
                    // printGenericList.printList(this.loginCustomer.cart.getOrderList());
                    // break;
                    System.out.println("List Produk Pada Keranjang Anda");
                    List<OrderItem> orderItems = new ArrayList<>(this.loginCustomer.getOrderItemsInCart());
                    PrintGenericList<OrderItem> printGenericList = new PrintGenericList<>();
                    printGenericList.printList(orderItems);
                case 2:
                    System.out.println("List Produk Pada ShyourBox");
                    PrintGenericList<Product> printGenericList2 = new PrintGenericList<>();
                    printGenericList2.printList(this.products);
                    System.out.print("Nama produk yang ingin dibeli: ");
                    String productName = scanner.next();
                    System.out.print("Masukkan jumlah produk yang ingin dibeli : ");
                    int quantity = scanner.nextInt();
                    Product selectedProduct = searchProduct(productName);
                    if (selectedProduct != null) {
                        if (selectedProduct.getStock() >= quantity) {
                            this.loginCustomer.addToCart(selectedProduct, quantity);
                            System.out.println("Berhasil menambahkan " + productName + " ke keranjang");
                        } else {
                            System.out.println("Stok produk tidak mencukupi");
                        }
                    } else {
                        System.out.println("Produk tidak ditemukan");
                    }
                    break;
                case 3:
                    this.loginCustomer.checkout();
                    System.out.println("Berhasil Checkout");
                    break;
                case 4:
                    System.out.println("Daftar Pembelian Anda:");
                    List<Order> orderHistory = new ArrayList<>(this.loginCustomer.getOrderHistory());
                    PrintGenericList<Order> printGenericList3 = new PrintGenericList<>();
                    printGenericList3.printList(orderHistory);
                case 0:
                    System.err.println("Sampai Jumpa Kembali!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 0);
    }

    public void initProducts(){
        this.products.add(new Veggie("Bayam",1000, 20, false));
        this.products.add(new Veggie("Jamur",1000, 15, true));
        this.products.add(new Veggie("Wortel",1000, 15, true));

        this.products.add(new Fruit("Jeruk",10000, 20, false));
        this.products.add(new Fruit("Apel",13000, 50, true));
        this.products.add(new Fruit("Semangka",9000, 23, false));
        
        this.products.add(new Diary("Keju", 30000, 20, "06 08 2023"));
        this.products.add(new Diary("Yogurt", 15000, 10, "06 08 2026"));
    }

    public void initCustomers(){
        this.customers.add(new Customer("Hana"));
        this.customers.add(new Customer("Sakura"));
        this.customers.add(new Customer("Jennifer"));
        this.customers.add(new GoldCustomer("Anyujin"));
        this.customers.add(new GoldCustomer("Chaewon"));
    }


    /**
     * Method untuk mencari produk berdasarkan nama.
     * 
     * @param name
     * @return
     */
    public Product searchProduct(String name) {
        // TODO: Implement this method.
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public Customer searchCustomer(String name) {
        // TODO: Implement this method.
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

}

