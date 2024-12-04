import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StockItem {
    private final String name;
    private final double pricePerUnit;
    private final int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalValue() {
        return pricePerUnit * quantity;
    }
}

class Utils {
    public static List<StockItem> sort(List<StockItem> stockItems) {
        // your code here
        Comparator<StockItem> comparator = Comparator.comparing(StockItem::getTotalValue).reversed();
        stockItems.sort(comparator);
        return stockItems;
    }
}
/*
class Main {
    public static void main(String[] args) {
        List<StockItem> stockItems = new ArrayList<>();
        stockItems.add(new StockItem("nails", 0.01, 512));
        stockItems.add(new StockItem("hammers", 7.5, 24));
        stockItems.add(new StockItem("screws", 0.02, 318));
        for (StockItem item : Utils.sort(stockItems)) {
            System.out.println(item);
        }
    }
}

 */