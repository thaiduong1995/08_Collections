package salesmanager.shppingcart;

import salesmanager.data.Goods;
import salesmanager.list.GoodsList;

public class Payment {

    public void completelyPayment(BuyerCart buyerCart, GoodsList data, ShoppingCartList shoppingCartList) {
        for (Goods goods :
                buyerCart.getOrder().getGoodsList()) {
            String idGoods = goods.getId();
            int index = data.getIndex(idGoods);
            data.getGoods(index).setAmount(data.getGoods(index).getAmount() - goods.getAmount());
        }
        shoppingCartList.remove(buyerCart);
    }

}
