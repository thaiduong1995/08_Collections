package salesmanager;

public class test {
    public static void main(String[] args) {
        String result = "STT    Tên mặt hàng                      Số lượng    Đơn giá        Thành tiền\n";
        result += String.format("%3d    %-30s    %,8.2f    %,11d    %,10d\n", 1, "Kệ tủ gỗ", 5d, 20000000, 100000000);
        result += String.format("%3d    %-30s    %,8.2f    %,11d    %,10d\n", 2, "Máy giặt", 10d, 7000000, 70000000);
        result += String.format("%3d    %-30s    %,8.2f    %,11d    %,10d\n", 3, "Mì tôm", 2d, 100000, 200000);
        result += String.format("Tổng thành tiền: %,65d", 1000000000000L);
        System.out.println(result);
    }
}
