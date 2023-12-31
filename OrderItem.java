public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

    }
    /*menghitung harga akhir item pesanan setelah diberlakukan diskon. */
    public double getFinalPrice() {
        double discount = this.product.checkDiscount(this.quantity);
        double price = (double) this.product.getPrice() * this.quantity;

        return (price*(100-discount)/100);
    }
    /*mendapatkan produk pada item pesanan*/
    public Product getProduct() {
        return this.product;
    }
    /*mendapatkan jumlah produk dalam item pesanan. */
    public int getQuantity(){
        return this.quantity;
    }
    /*Representasi String pesanan dengan formatting */
    public String toString(){
        return String.format("%s  %d kg  %f", this.product.getName(), this.quantity, this.getFinalPrice());  
    }
}
