package salesmanager.shppingcart;

import salesmanager.data.Goods;
import salesmanager.list.CustomersList;
import salesmanager.list.GoodsList;

import java.util.Scanner;

public class BuyerCart {
    private String id;
    private String idCustomer;
    private GoodsList order = new GoodsList();

    public String display(CustomersList customerData) {
        String result = "================THÔNG TIN GIỎ HÀNG=====================\n";
        result += String.format("Tên khách hàng hàng: %s\n", customerData.getName(idCustomer));
        result += "Thông tin giỏ hàng hàng:\n";
        result += "STT    Tên mặt hàng                     Số lượng       Đơn giá        Thành tiền\n";
        for (int i = 0; i < order.getSize(); i++) {
            result += String.format("%3d    %-30s    %,11.2f    %,11d    %d\n", i + 1, order.getGoods(i).getName(),
                    order.getGoods(i).getAmount(), order.getGoods(i).getPrice(),
                    (long) (order.getGoods(i).getPrice() * order.getGoods(i).getAmount()));
        }
        result += String.format("Tổng hóa đơn:  %,d\n", this.totalMoney());
        return result;
    }

    public long totalMoney() {
        long result = 0;
        for (int i = 0; i < order.getSize(); i++) {
            int index = order.getIndex(order.getGoods(i).getId());
            result += (long) (order.getGoods(i).getPrice() * order.getGoods(i).getAmount());
        }
        return result;
    }

    public boolean add(Scanner scanner, GoodsList data) {
        System.out.print("ID mặt hàng: ");
        String idProduct = scanner.nextLine();
        int index = data.getIndex(idProduct);
        if (index >= 0) {
            System.out.print("Số lượng mua: ");
            Double amount = Double.parseDouble(scanner.nextLine());
            if (amount >= 0 && amount <= data.getGoods(index).getAmount()) {
                Goods goods = new Goods(idProduct, data.getGoods(index).getIdCommodities(),
                        data.getGoods(index).getName(), amount, data.getGoods(index).getPrice());
                order.add(goods);
                return true;
            } else {
                System.out.println("Số lượng mặt hàng trong kho không đủ");
            }
        } else {
            System.out.println("Mặt hàng không tồn tại");
        }
        return false;
    }

    public boolean update(Scanner scanner, GoodsList data) {
        System.out.print("Nhập ID mặt hàng cần sửa: ");
        String id = scanner.nextLine();
        int index = order.getIndex(id);
        if (index >= 0) {
            System.out.print("Số lượng mua: ");
            Double amount = Double.parseDouble(scanner.nextLine());
            if (amount >= 0 && amount <= data.getGoods(index).getAmount()) {
                Goods goods = new Goods(id, data.getGoods(index).getIdCommodities(),
                        data.getGoods(index).getName(), amount, data.getGoods(index).getPrice());
                order.add(goods);
                return true;
            } else {
                System.out.println("Số lượng mặt hàng trong kho không đủ");
            }
        } else {
            System.out.println("Mặt hàng không có trong giỏ hàng");
        }
        return false;
    }

    public boolean remove(Scanner scanner) {
        System.out.print("Nhập id mặt hàng cần xóa: ");
        String id = scanner.nextLine();
        int index = order.getIndex(id);
        if (index >= 0) {
            order.getGoodsList().remove(index);
            return true;
        }
        return false;
    }

    public boolean isExit(String id) {
        for (Goods goods :
                order.getGoodsList()) {
            if (id.equalsIgnoreCase(goods.getId())) {
                return true;
            }
        }
        return false;
    }

    public BuyerCart create(Scanner scanner, CustomersList customersData, GoodsList goodsData) {
        System.out.print("ID giỏ hàng: ");
        String id = scanner.nextLine();
        System.out.print("ID khách hàng: ");
        String idCustomer = scanner.nextLine();
        if (customersData.isExit(idCustomer)){
            System.out.print("Nhập số lượng mặt hàng cần mua: ");
            double quanity = Double.parseDouble(scanner.nextLine());
            for (int i = 0; i < quanity; i++) {
                System.out.println("Mặt hàng thứ " + (i + 1));
                System.out.print("ID mặt hàng: ");
                String idProduct = scanner.nextLine();
                int index = goodsData.getIndex(idProduct);
                if (index >= 0) {
                    System.out.print("Số lượng mua: ");
                    Double amount = Double.parseDouble(scanner.nextLine());
                    if (amount >= 0 && amount <= goodsData.getGoods(index).getAmount()) {
                        Goods goods = new Goods(idProduct, goodsData.getGoods(index).getIdCommodities(),
                                goodsData.getGoods(index).getName(), amount, goodsData.getGoods(index).getPrice());
                        order.add(goods);
                    } else {
                        System.out.println("Số lượng mặt hàng trong kho không đủ");
                    }
                } else {
                    System.out.println("Mặt hàng không tồn tại");
                }
            }
            return new BuyerCart(id, idCustomer, order);
        } else {
            System.out.println("Khách hàng chưa đăng ký");
        }
        return null;
    }

    public BuyerCart() {
    }

    public BuyerCart(String id, String idCustomer, GoodsList order) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public GoodsList getOrder() {
        return order;
    }

    public void setOrder(GoodsList order) {
        this.order = order;
    }
}
