import java.time.LocalDate;
import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Stock> stockList;
    private String name;

    public Portfolio(String name) {
        this.name = name;
        this.stockList = new ArrayList<>();
    }

    public int calculateProfit(LocalDate startDate, LocalDate endDate) {
        int startDateValue = getSumOfStockValues(startDate);
        int endDateValue = getSumOfStockValues(endDate);
        return endDateValue - startDateValue;
    }


    public int getSumOfStockValues(LocalDate date) {
        int sum = 0;
        for (Stock stock : this.stockList) {
            sum += stock.getPrice(date);
        }
        return sum;
    }

    public void addStock(Stock stock) {
        this.stockList.add(stock);
    }

    public void printProfitBetweenDates(LocalDate startDate, LocalDate endDate) {
        System.out.println("----------------------------");
        System.out.println("Rango de fechas: " + startDate + " y " + endDate);
        System.out.println("Portafolio: " + this.name);
        int profit = calculateProfit(startDate, endDate);
        String msg = profit > 0 ? "Ganancia: " : "Pérdida: ";
        System.out.println(msg + profit);
    }

    // Para el rendimiento anualizado tuve que encontrar una fórmula que no comprendo del todo en https://www.businessinsider.com/personal-finance/investing/roi
    // A = (EV/BV) ** 1/n - 1

    public double calculateAnnualizedReturn(LocalDate startDate, LocalDate endDate) {
        int startDateValue = getSumOfStockValues(startDate);
        int endDateValue = getSumOfStockValues(endDate);
        // .25 para considerar años bisiestos
        double yearsBeetweenDates = (endDate.toEpochDay() - startDate.toEpochDay()) / 365.25;
        return Math.pow(((double) endDateValue / startDateValue), 1 / yearsBeetweenDates) - 1;
    }

    public void printAnnualizedReturnBetweenDates(LocalDate startDate, LocalDate endDate) {
        System.out.println("----------------------------");
        System.out.println("Rango de fechas: " + startDate + " y " + endDate);
        System.out.println("Portafolio: " + this.name);
        double annualizedReturn = calculateAnnualizedReturn(startDate, endDate);
        System.out.println("Retorno anualizado de: " + annualizedReturn + "%");
    }


}
