package salesmanager.data;

import java.util.Scanner;

public class Customers {
    private String id;
    private String name;

    @Override
    public String toString() {
        String result = "";
        result += String.format("ID khách hàng : %s\n", id);
        result += String.format("Tên khách hàng: %s\n", name);
        return result;
    }

    public Customers create(Scanner scanner) {
        System.out.print("ID khách hàng: ");
        id = scanner.nextLine();
        System.out.print("Tên khách hàng: ");
        name = scanner.nextLine();
        if (id.equalsIgnoreCase("") || name.equalsIgnoreCase("")) {
            return null;
        }
        return this;
    }

    public Customers() {
    }

    public Customers(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
