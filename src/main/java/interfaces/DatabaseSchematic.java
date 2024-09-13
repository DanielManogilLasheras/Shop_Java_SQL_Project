package interfaces;

public interface DatabaseSchematic  {
//DATABASE
    String DB_NAME="Shop_Java_SQL";
//CLIENT
    String CLIENT_TABLE="client";
    String COL_ID_CLIENT="id_client";
    String COL_NAME="name";
    String COL_SURNAME="surname";
    String COL_EMAIL="email";
    String COL_AGE="age";
    String COL_PASSWORD="password";

//ORDER
    String ORDER_TABLE="orders";
    String COL_ID_ORDER="id_order";
    String COL_ID_ORDER_CLIENT="id_order_client";
    String COL_DATE_ORDER="date_order";
    String COL_TOTAL_ORDER="total_order";

//ORDER DETAILS
    String ORDER_DETAILS_TABLE="order_details";
    String COL_ID_DETAILS="id_details";
    String COL_ID_ORDER_DETAILS="id_order_details";
    String COL_ID_PRODUCT_DETAILS="id_product_order";
    String COL_DETAILS_QUANTITY="quantity_units_order";
    String COL_PRICE_ORDER="price_unit_order";
    String COL_TOTAL_UNITS="subtotal_price_units";

//PRODUCT
    String PRODUCT_TABLE="product";
    String COL_NAME_PRODUCT="name_product";
    String COL_DESCRIPTION_PRODUCT="description_product";
    String COL_COST_PRODUCT="cost_product";
    String COL_STOCK_PRODUCT="stock_product";

//PAYMENT
    String PAYMENT_TABLE="payment";
    String COL_ID_INVOICE="id_invoice";
    String COL_ID_CLIENT_INVOICE="id_client_invoice";
    String COL_ID_ORDER_INVOICE="id_order_invoice";
    String COL_DATE_PAYMENT="date_payment";
    String COL_QUANTITY_PAID="quantity_paid";

//SHOPPING CART
    String SHOPPING_CART_TABLE="shopping_cart";
    String COL_ID_CLIENT_SHOP="id_client_shop";
    String COL_ID_PROD_SHOP="id_product_shop";
    String COL_QUANTITY_UNIT_CART="quantity_unit_cart";
    String COL_PRICE_UNIT_CART="price_unit_cart";
    String COL_SUBTOTAL_CART="subtotal_cart";
}
