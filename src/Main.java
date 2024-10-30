import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Se crean 2 stocks con 4 fechas, 3 con datos y una vacía

        Stock stock1 = new Stock("Blissard");
        Stock stock2 = new Stock("Roit");
        LocalDate date1 = LocalDate.of(2024, 10, 31);
        LocalDate date2 = LocalDate.of(2024, 11, 1);
        LocalDate emptyDataDate = LocalDate.of(2024, 11, 2);
        LocalDate lateDate = LocalDate.of(2026, 1, 1);
        stock1.addPrice(date1, 100);
        stock1.addPrice(date2, 150);
        stock1.addPrice(lateDate, 600);
        stock2.addPrice(date1, 250);
        stock2.addPrice(date2, 100);
        stock2.addPrice(lateDate, 500);

        // El emptyDataDate no tiene datos, por lo tanto arroja un mensaje de no encontrado

        stock1.printStockValueByDate(date1);
        stock1.printStockValueByDate(date2);
        stock1.printStockValueByDate(emptyDataDate);

        // Test de portafolio

        Portfolio portfolio = new Portfolio("Portafolio 1");
        portfolio.addStock(stock1);
        portfolio.addStock(stock2);
        portfolio.printProfitBetweenDates(date1, date2);
        portfolio.printAnnualizedReturnBetweenDates(date1, date2);

        // Se coloca la ultima fecha en la cual el stock aumentó mucho su valor, el retorno analizado debería aumentar

        portfolio.printAnnualizedReturnBetweenDates(date1, lateDate);


    }
}