package salesmanager.list;

import salesmanager.data.Goods;
import salesmanager.shppingcart.BuyerCart;
import salesmanager.shppingcart.ShoppingCartList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GoodsList {
    private LinkedList<Goods> goodsList = new LinkedList<>();

    public int getSize() {
        return goodsList.size();
    }

    public Goods getGoods(int index) {
        for (int i = 0; i < goodsList.size(); i++) {
            if (index == i) {
                return goodsList.get(i);
            }
        }
        return null;
    }

    public boolean add(Goods goods) {
        return goodsList.add(goods);
    }

    public boolean add(CommoditiesList data) {
        Goods goods = new Goods().create(new Scanner(System.in), data);
        if (goods != null && !this.isExit(goods.getId())) {
            goodsList.add(goods);
            return true;
        }
        return false;
    }

    public boolean update(Scanner scanner, CommoditiesList data) {
        System.out.print("Nhập ID mặt hàng cần sửa: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.print("Nhập ID loại hàng mới: ");
            String productID = scanner.nextLine();
            if (data.isExit(productID)) {
                goodsList.get(index).setIdCommodities(productID);
                System.out.print("Tên hàng mới: ");
                goodsList.get(index).setName(scanner.nextLine());
                System.out.print("Số lượng mới: ");
                goodsList.get(index).setAmount(Double.parseDouble(scanner.nextLine()));
                System.out.print("Đơn giá mới: ");
                goodsList.get(index).setPrice(Long.parseLong(scanner.nextLine()));
                return true;
            }
        }
        return false;
    }

    public boolean remove(Scanner scanner, ShoppingCartList data) {
        boolean flag = false;
        System.out.print("Nhập ID mặt hàng cần xóa: ");
        String id = scanner.nextLine();;
        int index = this.getIndex(id);
        if (index >= 0) {
            for (BuyerCart buyerCart :
                    data.getShoppingCartsList()) {
                if (buyerCart.isExit(id)) {
                    System.out.println("Mặt hàng " + goodsList.get(index).getName() + " đang nằm trong giỏ hàng " +
                            buyerCart.getId() + "\nVui lòng xóa mặt hàng khỏi giỏ trước");
                    return false;
                }
            }
            goodsList.remove(index);
            return true;
        }
        return false;
    }

    public void search(Scanner scanner, CommoditiesList data) {
        System.out.print("Nhập ID mặt hàng cần tìm kiếm: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.print("Thông tin mặt hàng: \n" + goodsList.get(index).display(data));
        } else {
            System.out.println("Không tìm thấy mặt hàng");
        }
    }

    public void sort() {
        Collections.sort(goodsList, (o1, o2) -> {
            return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
        });
        System.out.println("Sắp xếp thành công");
    }

    public String display(CommoditiesList data) {
        String result = "\n===================DANH SACH MẶT HÀNG===================\n";
        result += "STT    ID      Tên hàng                          Loại hàng                         Số lượng    Đơn giá\n";
        for (int i = 0; i < goodsList.size(); i++) {
            result += String.format("%3d    %-4s    %-30s    %-30s    %,8.2f    %,11d\n", i + 1, goodsList.get(i).getId(),
                    goodsList.get(i).getName(), data.getName(goodsList.get(i).getIdCommodities()),
                    goodsList.get(i).getAmount(), goodsList.get(i).getPrice());
        }
        return result;
    }

    public boolean isCommodities(String idCommodities) {
        for (Goods goods :
                goodsList) {
            if (idCommodities.equalsIgnoreCase(goods.getIdCommodities())) {
                if (goods.getAmount() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public  boolean isExit(String id) {
        for (Goods goods :
                goodsList) {
            if (id.equalsIgnoreCase(goods.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(String id) {
        for (int i = 0; i < goodsList.size(); i++) {
            if (id.equalsIgnoreCase(goodsList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public GoodsList init() {
        goodsList.add(new Goods("H01", "LH02", "Máy giặt", 10, 7000000));
        goodsList.add(new Goods("H02", "LH03", "Iphone", 50, 15000000));
        goodsList.add(new Goods("H03", "LH04", "Mì tôm", 100, 100000));
        goodsList.add(new Goods("H04", "LH05", "Kệ tủ gỗ", 5, 20000000));
        goodsList.add(new Goods("H05", "LH01", "Dao nhà bếp", 50, 50000));
        goodsList.add(new Goods("H06", "LH02", "Tủ lạnh", 15, 10000000));
        return this;
    }

    public GoodsList() {
    }

    public GoodsList(LinkedList<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public LinkedList<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(LinkedList<Goods> initGoods) {
        this.goodsList = initGoods;
    }
}
