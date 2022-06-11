package salesmanager.list;

import salesmanager.data.Customers;
import salesmanager.shppingcart.ShoppingCartList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomersList {
    private LinkedList<Customers> customersList = new LinkedList<>();

    public boolean add() {
        Customers customers = new Customers().create(new Scanner(System.in));
        if (customers != null && !this.isExit(customers.getId())) {
            customersList.add(customers);
            return true;
        }
        return false;
    }

    public boolean update(Scanner scanner) {
        System.out.print("Nhập ID khách hàng cần sửa: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.print("Nhập tên khách hàng mới: ");
            customersList.get(index).setName(scanner.nextLine());
            return true;
        }
        return false;
    }

    public boolean remove(Scanner scanner, ShoppingCartList shoppingCartList) {
        System.out.print("Nhập ID khách hàng cần xóa: ");
        String id = scanner.nextLine();
        ;
        int indexCustomer = this.getIndex(id);
        if (indexCustomer >= 0) {
            int indexCart = shoppingCartList.getIndex(id, this);
            if (indexCart >= 0) {
                System.out.println("Giỏ hàng của " + customersList.get(indexCustomer).getName() + " đang tồn tại.\n" +
                        "Vui lòng xóa giỏ hàng của khách trước");
            } else {
                customersList.remove(indexCustomer);
                return true;
            }
        }
        return false;
    }

    public void search(Scanner scanner) {
        System.out.print("Nhập ID khách hàng cần tìm kiếm: ");
        String id = scanner.nextLine();
        int index = this.getIndex(id);
        if (index >= 0) {
            System.out.print("Thông tin khách hàng: \n" + customersList.get(index));
        } else {
            System.out.println("Không tìm thấy khách hàng");
        }
    }

    public void sort() {
        Collections.sort(customersList, (o1, o2) -> {
            return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
        });
        System.out.println("Sắp xếp thành công");
    }

    @Override
    public String toString() {
        String result = "\n===================DANH SACH KHÁCH HÀNG===================\n";
        result += "STT    ID      Tên khách hàng\n";
        for (int i = 0; i < customersList.size(); i++) {
            result += String.format("%3d    %-4s    %-30s\n", i + 1, customersList.get(i).getId(),
                    customersList.get(i).getName());
        }
        return result;
    }

    public String getName(String id) {
        for (Customers customers :
                customersList) {
            if (id.equalsIgnoreCase(customers.getId())) {
                return customers.getName();
            }
        }
        return "";
    }

    public  boolean isExit(String id) {
        for (Customers customers :
                customersList) {
            if (id.equalsIgnoreCase(customers.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(String id) {
        for (int i = 0; i < customersList.size(); i++) {
            if (id.equalsIgnoreCase(customersList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public CustomersList init() {
        customersList.add(new Customers("KH01", "Nguyễn Văn Sơn"));
        customersList.add(new Customers("KH02", "Nguyễn Văn Hải"));
        customersList.add(new Customers("KH03", "Trần Văn Mạnh"));
        customersList.add(new Customers("KH04", "Lê Thị Hằng"));
        customersList.add(new Customers("KH05", "Nguyễn Thanh Thúy"));
        customersList.add(new Customers("KH06", "Ngô Đình Huy"));
        return this;
    }

    public CustomersList() {
    }

    public CustomersList(LinkedList<Customers> customersList) {
        this.customersList = customersList;
    }

    public LinkedList<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(LinkedList<Customers> customersList) {
        this.customersList = customersList;
    }
}
