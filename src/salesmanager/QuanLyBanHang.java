package salesmanager;

import salesmanager.list.CommoditiesList;
import salesmanager.list.CustomersList;
import salesmanager.list.GoodsList;
import salesmanager.shppingcart.BuyerCart;
import salesmanager.shppingcart.Payment;
import salesmanager.shppingcart.ShoppingCartList;

import java.util.Scanner;

public class QuanLyBanHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optMain, optSub;

        CommoditiesList commoditiesData = new CommoditiesList().init();
        CustomersList customersData = new CustomersList().init();
        GoodsList goodsData = new GoodsList().init();

        ShoppingCartList shoppingCartList = new ShoppingCartList().init();

        do {
            System.out.println("Chương trình quản lý bán hàng");
            System.out.println("1. Quản lý danh sách các loại hàng");
            System.out.println("2. Quản lý danh sách các mặt hàng");
            System.out.println("3. Quản lý danh sách khách hàng");
            System.out.println("4. Giỏ hàng của khách");
            System.out.println("5. Quản lý danh sách các giỏ hàng");
            System.out.print("Nhập lựa chon: ");
            optMain = Integer.parseInt(scanner.nextLine());
            switch (optMain) {
                case 1:
                    do {
                        System.out.println("\n=================QUẢN LÝ DANH SÁCH CÁC LOẠI HÀNG=================");
                        System.out.println("1. Thêm");
                        System.out.println("2. Sửa");
                        System.out.println("3. Xóa");
                        System.out.println("4. Sắp xếp");
                        System.out.println("5. Xem danh sách");
                        System.out.println("6. Tìm kiếm");
                        System.out.println("0. Quay lại");
                        System.out.print("Nhập lựa chon: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                if (commoditiesData.add()) {
                                    System.out.println("Thêm loại hàng mới thành công");
                                } else {
                                    System.out.println("Thêm loại hàng mới không thành công");
                                }
                                break;
                            case 2:
                                if (commoditiesData.update(scanner)) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.out.println("Cập nhật không thành công");
                                }
                                break;
                            case 3:
                                if (commoditiesData.remove(scanner, goodsData)) {
                                    System.out.println("Xóa thành công");
                                } else {
                                    System.out.println("Xóa  không thành công");
                                }
                                break;
                            case 4:
                                commoditiesData.sort();
                                break;
                            case 5:
                                System.out.println(commoditiesData);
                                break;
                            case 6:
                                commoditiesData.search(scanner);
                                break;
                        }
                    } while (optSub != 0);
                    break;
                case 2:
                    do {
                        System.out.println("\n=================QUẢN LÝ DANH SÁCH CÁC MẶT HÀNG=================");
                        System.out.println("1. Thêm");
                        System.out.println("2. Sửa");
                        System.out.println("3. Xóa");
                        System.out.println("4. Sắp xếp");
                        System.out.println("5. Xem danh sách");
                        System.out.println("6. Tìm kiếm");
                        System.out.println("0. Quay lại");
                        System.out.print("Nhập lựa chon: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                if (goodsData.add(commoditiesData)) {
                                    System.out.println("Thêm mặt hàng mới thành công");
                                } else {
                                    System.out.println("Thêm mặt hàng không thành công");
                                }
                                break;
                            case 2:
                                if (goodsData.update(scanner, commoditiesData)) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.out.println("Cập nhật không thành công");
                                }
                                break;
                            case 3:
                                if (goodsData.remove(scanner, shoppingCartList)) {
                                    System.out.println("Xóa mặt hàng thành công");
                                } else {
                                    System.out.println("Xóa mặt hàng không thành công");
                                }
                                break;
                            case 4:
                                goodsData.sort();
                                break;
                            case 5:
                                System.out.println(goodsData.display(commoditiesData));
                                break;
                            case 6:
                                goodsData.search(scanner, commoditiesData);
                                break;
                        }
                    } while (optSub != 0);
                    break;
                case 3:
                    do {
                        System.out.println("\n=================QUẢN LÝ DANH SÁCH KHÁCH HÀNG=================");
                        System.out.println("1. Thêm");
                        System.out.println("2. Sửa");
                        System.out.println("3. Xóa");
                        System.out.println("4. Sắp xếp");
                        System.out.println("5. Xem danh sách");
                        System.out.println("6. Tìm kiếm");
                        System.out.println("0. Quay lại");
                        System.out.print("Nhập lựa chon: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                if (customersData.add()) {
                                    System.out.println("Thêm khách hàng mới thành công");
                                } else {
                                    System.out.println("Thêm khách hàng không thành công");
                                }
                                break;
                            case 2:
                                if (customersData.update(scanner)) {
                                    System.out.println("Cập nhật thành công");
                                } else {
                                    System.out.println("Cập nhật không thành công");
                                }
                                break;
                            case 3:
                                if (customersData.remove(scanner, shoppingCartList)) {
                                    System.out.println("Xóa khách hàng thành công");
                                } else {
                                    System.out.println("Xóa khách hàng không thành công");
                                }
                                break;
                            case 4:
                                customersData.sort();
                                break;
                            case 5:
                                System.out.println(customersData);
                                break;
                            case 6:
                                customersData.search(scanner);
                                break;
                        }
                    } while (optSub != 0);
                    break;
                case 4:
                    do {
                        System.out.println("\n=================GIỎ HÀNG CỦA KHÁCH=================");
                        System.out.println("1. Tạo giỏ hàng mới");
                        System.out.println("2. Chỉnh sửa giỏ hàng");
                        System.out.println("0. Quay lại");
                        System.out.print("Nhập lựa chon: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                BuyerCart newBuyerCart = new BuyerCart().create(scanner, customersData, goodsData);
                                if (newBuyerCart != null) {
                                    if (shoppingCartList.add(newBuyerCart)) {
                                        System.out.println("Tạo giỏ hàng thành công");
                                    } else {
                                        System.out.println("Giỏ hàng đã tồn tại");
                                    }
                                } else {
                                    System.out.println("Không tạo được giỏ hàng");
                                }
                                break;
                            case 2:
                                System.out.print("Nhập id giỏ hàng cần xem: ");
                                String id = scanner.nextLine();
                                int index = shoppingCartList.getIndex(id);
                                BuyerCart buyerCart  = shoppingCartList.getShoppingCartsList().get(index);
                                int optUser;
                                do {
                                    System.out.println("\n=================CHỈNH SỬA GIỎ HÀNG=================");
                                    System.out.println("1. Thêm");
                                    System.out.println("2. Sửa");
                                    System.out.println("3. Xóa");
                                    System.out.println("4. Xem");
                                    System.out.println("5. Thanh toán");
                                    System.out.println("0. Quay lại");
                                    System.out.print("Nhập lựa chon: ");
                                    optUser = Integer.parseInt(scanner.nextLine());
                                    switch (optUser) {
                                        case 1:
                                            if (buyerCart.add(scanner, goodsData)) {
                                                System.out.println("Thêm mặt hàng mới cho giỏ hàng thành công");
                                            } else {
                                                System.out.println("Không thêm được mặt hàng mới cho giỏ hàng");
                                            }
                                            break;
                                        case 2:
                                            if (buyerCart.update(scanner, goodsData)) {
                                                System.out.println("Cập nhật giỏ hàng thành công");
                                            } else {
                                                System.out.println("Cập nhật giỏ hàng thất bại");
                                            }
                                            break;
                                        case 3:
                                            if (buyerCart.remove(scanner)) {
                                                System.out.println("Xóa mặt hàng thành công");
                                            } else {
                                                System.out.println("Xóa mặt hàng không thành công");
                                            }
                                            break;
                                        case 4:
                                            System.out.println(buyerCart.display(customersData));
                                            break;
                                        case 5:
                                            Payment payment = new Payment();
                                            payment.completelyPayment(buyerCart, goodsData, shoppingCartList);
                                            System.out.println("Thanh toán hoàn tất");
                                            break;
                                    }
                                } while (optUser != 0);
                                break;
                        }
                    } while (optSub != 0);
                    break;
                case 5:
                    do {
                        System.out.println("=================QUẢN LÝ DANH SÁCH CÁC GIỎ HÀNG=================");
                        System.out.println("1. Thêm");
                        System.out.println("2. Sửa");
                        System.out.println("3. Xóa");
                        System.out.println("4. Tìm kiếm");
                        System.out.println("5. Xem danh sách");
                        System.out.println("0. Quay lại");
                        System.out.print("Nhập lựa chon: ");
                        optSub = Integer.parseInt(scanner.nextLine());
                        switch (optSub) {
                            case 1:
                                if (shoppingCartList.add(scanner, customersData, goodsData)) {
                                    System.out.println("Thêm giỏ hàng mới thành công");
                                } else {
                                    System.out.println("Không thêm được giỏ hàng mới");
                                }
                                break;
                            case 2:
                                if (shoppingCartList.update(scanner, customersData, goodsData)) {
                                    System.out.println("Cập nhật giỏ hàng thành công");
                                } else {
                                    System.out.println("Cập nhật giỏ hàng không thành công");
                                }
                                break;
                            case 3:
                                if (shoppingCartList.remove(scanner, goodsData)) {
                                    System.out.println("Xóa giỏ hàng thành công");
                                } else {
                                    System.out.println("Không xóa được giỏ hàng");
                                }
                                break;
                            case 4:
                                shoppingCartList.search(scanner, customersData, goodsData);
                                break;
                            case 5:
                                System.out.println(shoppingCartList.display(customersData));
                                break;
                        }
                    } while (optSub != 0);
                    break;
            }
        } while (optMain != 0);
    }
}
