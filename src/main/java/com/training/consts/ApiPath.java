package com.training.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

    //notification
    String NOTIFICATION_GET_ALL = API + "/notifications";
    String NOTIFICATION_CREATE = API + "/notification/create";
    String NOTIFICATION_DELETE = API + "/notification/delete";
    String NOTIFICATION_UPDATE = API + "/notification/update";
    String NOTIFICATION_BY_ID = API + "/notification/{id}";

    //news
    String NEWS_GET_ALL = API + "/news";
    String NEWS_CREATE = API + "/news/create";
    String NEWS_DELETE = API + "/news/delete";
    String NEWS_UPDATE = API + "/news/update";
    String NEWS_BY_ID = API + "/news/{id}";

    //post
    String POST_GET_ALL = API + "/posts";
    String POST_CREATE = API + "/post/create";
    String POST_DELETE = API + "/post/delete";
    String POST_UPDATE = API + "/post/update";
    String POST_BY_ID = API + "/post/{id}";

    //product
    String PRODUCT_GET_ALL = API + "/products";
    String PRODUCT_CREATE = API + "/product/create";
    String PRODUCT_DELETE = API + "/product/delete";
    String PRODUCT_UPDATE = API + "/product/update";
    String PRODUCT_BY_ID = API + "/product/{id}";
    String PRODUCT_BY_CATEGORY = API + "/product/find-by-category";
    String PRODUCT_BY_CATEGORY_ID = API + "/product/find-by-category/{id}";

    //price
    String PRICE_GET_ALL = API + "/prices";
    String PRICE_CREATE = API + "/price/create";
    String PRICE_DELETE = API + "/price/delete";
    String PRICE_UPDATE = API + "/price/update";
    String PRICE_BY_ID = API + "/price/{id}";

    //category
    String CATEGORY_GET_ALL = API + "/categories";
    String CATEGORY_CREATE = API + "/category/create";
    String CATEGORY_DELETE = API + "/category/delete";
    String CATEGORY_UPDATE = API + "/category/update";
    String CATEGORY_BY_ID = API + "/category/{id}";

    //import
    String IMPORT_GET_ALL = API + "/imports";
    String IMPORT_CREATE = API + "/import/create";
    String IMPORT_DELETE = API + "/import/delete";
    String IMPORT_UPDATE = API + "/import/update";
    String IMPORT_BY_ID = API + "/import/{id}";

    //user
    String USER_GET_ALL = API + "/users";
    String USER_CREATE = API + "/user/create";
    String USER_DELETE = API + "/user/delete";
    String USER_UPDATE = API + "/user/update";
    String USER_BY_ID = API + "/user/{id}";


    // Delivery detail
    String DELIVERY_DETAIL_GET_ALL = API + "/delivery-details";
    String DELIVERY_DETAIL_CREATE = API + "/delivery-detail/create";
    String DELIVERY_DETAIL_DELETE = API + "/delivery-detail/delete";
    String DELIVERY_DETAIL_UPDATE = API + "/delivery-detail/update";
    String DELIVERY_DETAIL_BY_ID = API + "/delivery-detail/{id}";

    // Order
    String ORDER_GET_ALL = API + "/orders";
    String ORDER_CREATE = API + "/order/create";
    String ORDER_DELETE = API + "/order/delete";
    String ORDER_UPDATE = API + "/order/update";
    String ORDER_BY_ID = API + "/order/{id}";

    //Role API
    String ROLE_GET_ALL = API + "/role";
    String ROLE_CREATE = API + "/role/create";
    String ROLE_DELETE = API + "/role/delete";
    String ROLE_UPDATE = API + "/role/update";
    String ROLE_BY_ID = API + "/role/{id}";

    //Account API
    String ACCOUNT_GET_ALL = API + "/account";
    String ACCOUNT_CREATE = API + "/account/create";
    String ACCOUNT_DELETE = API + "/account/delete";
    String ACCOUNT_UPDATE = API + "/account/update";
    String ACCOUNT_BY_ID = API + "/account/{id}";

    //Report API
    String REPORT_GET_ALL = API + "/report";
    String REPORT_CREATE = API + "/report/create";
    String REPORT_DELETE = API + "/report/delete";
    String REPORT_UPDATE = API + "/report/update";
    String REPORT_BY_ID = API + "/report/{id}";


    // Feedback
    String FEEDBACK_GET_ALL = API + "/feedbacks";
    String FEEDBACK_CREATE = API + "/feedback/create";
    String FEEDBACK_DELETE = API + "/feedback/delete";
    String FEEDBACK_UPDATE = API + "/feedback/update";
    String FEEDBACK_BY_ID = API + "/feedback/{id}";

    // Order status
    String ORDER_STATUS_GET_ALL = API + "/order-status";
    String ORDER_STATUS_CREATE = API + "/order-status/create";
    String ORDER_STATUS_DELETE = API + "/order-status/delete";
    String ORDER_STATUS_UPDATE = API + "/order-status/update";
    String ORDER_STATUS_BY_ID = API + "/order-status/{id}";

    // Customer
    String CUSTOMER_GET_ALL = API + "/customers";
    String CUSTOMER_CREATE = API + "/customer/create";
    String CUSTOMER_DELETE = API + "/customer/delete";
    String CUSTOMER_UPDATE = API + "/customer/update";
    String CUSTOMER_BY_ID = API + "/customer/{id}";

    // Item
    String ITEM_GET_ALL = API + "/items";
    String ITEM_CREATE = API + "/item/create";
    String ITEM_DELETE = API + "/item/delete";
    String ITEM_UPDATE = API + "/item/update";
    String ITEM_BY_ID = API + "/item/{id}";

}
