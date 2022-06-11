package salesmanager.data;

import salesmanager.list.CommoditiesList;

import java.util.Scanner;

public class Goods {
    private String id;
    private String idCommodities;
    private String name;
    private double amount;
    private long price;

    public String display(CommoditiesList data) {
        String result = "";
        result += String.format("ID mặt hàng: %s\n", id);
        result += String.format("Loại hàng  : %s\n", data.getName(idCommodities));
        result += String.format("Tên hàng   : %s\n", name);
        result += String.format("Số lượng   : %.2f\n", amount);
        result += String.format("Đơn giá    : %,d\n", price);
        return result;
    }

    public Goods create(Scanner scanner, CommoditiesList data) {
        System.out.print("ID mặt hàng: ");
        id = scanner.nextLine();
        System.out.print("ID loại hàng: ");
        String productID = scanner.nextLine();
        int index = data.getIndex(productID);
        if (index >= 0) {
            idCommodities = productID;
            System.out.print("Tên mặt hàng: ");
            name = scanner.nextLine();
            System.out.print("Số lượng: ");
            amount = Double.parseDouble(scanner.nextLine());
            System.out.print("Đơn giá: ");
            price = Long.parseLong(scanner.nextLine());
            return this;
        }
        return null;
    }

    public Goods() {
    }

    public Goods(String id, String idCommodities, String name, double amount, long price) {
        this.id = id;
        this.idCommodities = idCommodities;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCommodities() {
        return idCommodities;
    }

    public void setIdCommodities(String idCommodities) {
        this.idCommodities = idCommodities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
