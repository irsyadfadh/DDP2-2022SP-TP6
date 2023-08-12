abstract class Product {
    // TODO: Implement this class.
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock){
        this.name= name;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public String getName(){
        return this.name;
    }
    /*mengurangi stock yang telah dibeli */
    public void decreaseStock(int quantity){
        this.stock -= quantity;
    }

    public String toString(){
        return String.format("Produk %s memiliki stok %s", this.name, this.stock);  
    }

    /*menghitung diskon berdasarkan kriteria tertentu. */
    public abstract int checkDiscount(int quantity);

}
