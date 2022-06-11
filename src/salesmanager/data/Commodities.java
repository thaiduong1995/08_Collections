package salesmanager.data;

import java.util.Scanner;

public class Commodities {
    private String id;
    private String name;

    @Override
    public String toString() {
        String result = "";
        result += String.format("ID loại hàng : %s\n", id);
        result += String.format("Tên loại hàng: %s\n", name);
        return result;
    }

    public Commodities create(Scanner scanner) {
        System.out.print("ID loại hàng: ");
        id = scanner.nextLine();
        System.out.print("Tên loại hàng: ");
        name = scanner.nextLine();
        if (id.equalsIgnoreCase("") || name.equalsIgnoreCase("")) {
            return null;
        }
        return this;
    }

    public Commodities() {
    }

    public Commodities(String id, String name) {
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
