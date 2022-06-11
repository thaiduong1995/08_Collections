package salesmanager.shppingcart;

import salesmanager.data.Goods;
import salesmanager.list.CustomersList;
import salesmanager.list.GoodsList;

import java.util.LinkedList;
import java.util.Scanner;

public class ShoppingCartList {
    private LinkedList<BuyerCart> shoppingCartsList = new LinkedList<>();

    public boolean add(Scanner scanner, CustomersList customerData, GoodsList goodsData) {
        BuyerCart shoppingCart = new BuyerCart();
        shoppingCart.create(scanner, customerData, goodsData);
        if (shoppingCart != null && !this.isExit(shoppingCart.getId())) {
            shoppingCartsList.add(shoppingCart);
            return true;
        }
        return false;
    }

    public boolean add(BuyerCart buyerCart) {
        if (this.isExit(buyerCart.getId())) {
            return false;
        } else {
            shoppingCartsList.add(buyerCart);
            return true;
        }
    }

    public boolean update(Scanner scanner, CustomersList customerData, GoodsList goodsData) {
        System.out.print("Nhập ID giỏ hàng cần sửa: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.println("Nhập ID khách hàng mới: ");
            String customerID = scanner.nextLine();
            if (customerData.isExit(customerID)) {
                shoppingCartsList.get(index).setIdCustomer(customerID);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Scanner scanner, GoodsList data) {
        System.out.print("Nhập ID giỏ hàng cần xóa: ");
        String id = scanner.nextLine();;
        int index = this.getIndex(id);
        if (index >= 0) {
            shoppingCartsList.remove(index);
            return true;
        }
        return false;
    }

    public boolean remove(BuyerCart buyerCart) {
        if (buyerCart != null) {
            return shoppingCartsList.remove(buyerCart);
        }
        return false;
    }

    public void search(Scanner scanner, CustomersList customerData, GoodsList goodsData) {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.print("Thông tin giỏ hàng: \n" + shoppingCartsList.get(index).display(customerData));
        } else {
            System.out.println("Không tìm giỏ mặt hàng");
        }
    }

    public String display(CustomersList customerData) {
        String result = "\n===================DANH SACH CÁC GIỎ HÀNG===================\n";
        for (int i = 0; i < shoppingCartsList.size(); i++) {
            result += "\n=======================Giỏ hàng thứ " + (i + 1) + " :\n";
            result += shoppingCartsList.get(i).display(customerData) + "\n";
        }
        return result;
    }

    public boolean isExit(String id) {
        for (BuyerCart shoppingCart :
                shoppingCartsList) {
            if (id.equalsIgnoreCase(shoppingCart.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(String id) {
        for (int i = 0; i < shoppingCartsList.size(); i++) {
            if (id.equalsIgnoreCase(shoppingCartsList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public int getIndex(String id, CustomersList data) {
        boolean flag = false;
        for (int i = 0; i < shoppingCartsList.size(); i++) {
            if (id.equalsIgnoreCase(shoppingCartsList.get(i).getIdCustomer())) {
                flag = true;
                if (data.isExit(id)) {
                    return i;
                } else {
                    System.out.println("Khách hàng chưa được đăng ký");
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("Khách hàng chưa mua hàng");
        }
        return -1;
    }

    public ShoppingCartList init() {
        LinkedList<Goods> goodsList1 = new LinkedList<>();
        goodsList1.add(new Goods("H01", "LH02", "Máy giặt", 1, 7000000));
        goodsList1.add(new Goods("H02", "LH03", "Iphone", 2, 15000000));
        goodsList1.add(new Goods("H03", "LH04", "Mì tôm", 10, 100000));
        shoppingCartsList.add(new BuyerCart("GH01", "KH01", new GoodsList(goodsList1)));

        LinkedList<Goods> goodsList2 = new LinkedList<>();
        goodsList2.add(new Goods("H02", "LH03", "Iphone", 2, 15000000));
        goodsList2.add(new Goods("H06", "LH02", "Tủ lạnh", 1, 10000000));
        shoppingCartsList.add(new BuyerCart("GH02", "KH03", new GoodsList(goodsList2)));

        LinkedList<Goods> goodsList3 = new LinkedList<>();
        goodsList3.add(new Goods("H02", "LH03", "Iphone", 1, 15000000));
        goodsList3.add(new Goods("H05", "LH01", "Dao nhà bếp", 10, 50000));
        shoppingCartsList.add(new BuyerCart("GH03", "KH02", new GoodsList(goodsList3)));

        return this;
    }

    public ShoppingCartList() {
    }

    public ShoppingCartList(LinkedList<BuyerCart> shoppingCartsList) {
        this.shoppingCartsList = shoppingCartsList;
    }

    public LinkedList<BuyerCart> getShoppingCartsList() {
        return shoppingCartsList;
    }

    public void setShoppingCartsList(LinkedList<BuyerCart> shoppingCartsList) {
        this.shoppingCartsList = shoppingCartsList;
    }
}
