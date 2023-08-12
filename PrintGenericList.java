import java.util.List;
/*mencetak daftar item dari tipe generik T */
public class PrintGenericList<T> {
    public void printList(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
}
