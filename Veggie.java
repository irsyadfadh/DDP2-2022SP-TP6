public class Veggie extends Product{
    
    private boolean isOrganic;

    public Veggie(String name, int price, int stok, boolean isOrganic){
        super(name, price, stok);
        this.isOrganic = isOrganic;
    }
    /*menghitung diskon berdasarkan jenis dan jumlah sayuran yang dibeli. */
    public int checkDiscount(int quantity){
        if(this.isOrganic){
            if(quantity >= 5)
                return 30;
            else if(quantity >=3 )
                return 20;
        }
        else{
             if(quantity >= 5)
                return 20;
            else if(quantity >=3 )
                return 15;
        }
        return 0;
    }
}
