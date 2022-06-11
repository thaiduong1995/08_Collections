package salesmanager.list;

import salesmanager.data.Commodities;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CommoditiesList {
    private LinkedList<Commodities> commoditiesList = new LinkedList<>();

    public boolean add() {
        Commodities commodities = new Commodities().create(new Scanner(System.in));
        if (commodities != null && !this.isExit(commodities.getId())) {
            commoditiesList.add(commodities);
            return true;
        }
        return false;
    }

    public boolean update(Scanner scanner) {
        System.out.print("Nhập ID loại hàng cần sửa: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.print("Nhập tên loại hàng mới: ");
            commoditiesList.get(index).setName(scanner.nextLine());
            return true;
        }
        return false;
    }

    public boolean remove(Scanner scanner, GoodsList data) {
        System.out.print("Nhập ID loại hàng cần xóa: ");
        String id = scanner.nextLine();;
        int index = this.getIndex(id);
        if (index >= 0 && data.isCommodities(id) == false) {
            commoditiesList.remove(index);
            return true;
        }
        return false;
    }

    public void search(Scanner scanner) {
        System.out.print("Nhập ID loại hàng cần tìm kiếm: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.print("Thông tin loại hàng: \n" + commoditiesList.get(index));
        } else {
            System.out.println("Không tìm thấy loại hàng");
        }
    }

    public void sort() {
        Collections.sort(commoditiesList, (o1, o2) -> {
            return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
        });
        System.out.println("Sắp xếp thành công");
    }
    @Override
    public String toString() {
        String result = "\n===================DANH SACH LOẠI HÀNG===================\n";
        result += "STT    ID      Tên loại hàng\n";
        for (int i = 0; i < commoditiesList.size(); i++) {
            result += String.format("%3d    %-4s    %-30s\n", i + 1, commoditiesList.get(i).getId(),
                    commoditiesList.get(i).getName());
        }
        return result;
    }


    public String getName(String id) {
        for (Commodities commodities :
                commoditiesList) {
            if (id.equalsIgnoreCase(commodities.getId())) {
                return commodities.getName();
            }
        }
        return "";
    }

    public  boolean isExit(String id) {
        for (Commodities commodities :
                commoditiesList) {
            if (id.equalsIgnoreCase(commodities.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(String id) {
        for (int i = 0; i < commoditiesList.size(); i++) {
            if (id.equalsIgnoreCase(commoditiesList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public CommoditiesList init() {
        commoditiesList.add(new Commodities("LH01", "Gia dụng"));
        commoditiesList.add(new Commodities("LH02", "Thiết bị điện tử"));
        commoditiesList.add(new Commodities("LH03", "Điện thoại"));
        commoditiesList.add(new Commodities("LH04", "Đồ ăn"));
        commoditiesList.add(new Commodities("LH05", "Bàn ghế"));
        commoditiesList.add(new Commodities("LH06", "Máy tính"));
        return this;
    }

    public CommoditiesList() {
    }

    public CommoditiesList(LinkedList<Commodities> commoditiesList) {
        this.commoditiesList = commoditiesList;
    }

    public LinkedList<Commodities> getCommoditiesList() {
        return commoditiesList;
    }

    public void setCommoditiesList(LinkedList<Commodities> commoditiesList) {
        this.commoditiesList = commoditiesList;
    }
}
