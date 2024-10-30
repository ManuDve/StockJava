import java.time.LocalDate;
import java.util.ArrayList;

public class Stock {

    private String name;
    private ArrayList<LocalDate> dates;
    private ArrayList<Integer> prices;

    public Stock(String name) {
        this.name = name;
        this.dates = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    // Podría ser boolean si se agrega una validación para fechas y precios
    public void addPrice(LocalDate date, int price) {
        dates.add(date);
        prices.add(price);
    }

    public int getPrice(LocalDate searchDate) {
        int counter = 0;
        for (LocalDate date : this.dates) {
            if (date.equals(searchDate)) {
                return prices.get(counter);
            }
            counter++;
        }
        // No se encuentra la fecha, no estaba seguro si colocar 0, -1 u otra opción
        return 0;
    }

    public void printStockValueByDate(LocalDate searchDate) {
        System.out.println("----------------------------");
        System.out.println("Fecha de búsqueda: " + searchDate);
        System.out.println("Stock: " + this.name);
        int stockValue = getPrice(searchDate);
        if (stockValue == 0) {
            System.out.println("No se ha encontrado un valor de stock para esta fecha");
            return;
        }
        System.out.println("Valor: " + stockValue);
    }
}
