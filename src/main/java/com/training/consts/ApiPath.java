package com.training.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

<<<<<<< Updated upstream
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

    //account
    String ACCOUNT_GET_ALL = API + "/accounts";
=======
    //user
    String USER_GET_ALL = API + "/users";
    String USER_CREATE = API + "/user/create";
    String USER_DELETE = API + "/user/delete";
    String USER_UPDATE = API + "/user/update";
    String USER_BY_ID = API + "/user/{id}";

 // Order API
    String ORDER_GET_ALL = API + "/order";
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
>>>>>>> Stashed changes
    String ACCOUNT_CREATE = API + "/account/create";
    String ACCOUNT_DELETE = API + "/account/delete";
    String ACCOUNT_UPDATE = API + "/account/update";
    String ACCOUNT_BY_ID = API + "/account/{id}";

<<<<<<< Updated upstream
    //report
    String REPORT_GET_ALL = API + "/reports";
=======
    //Report API
    String REPORT_GET_ALL = API + "/report";
>>>>>>> Stashed changes
    String REPORT_CREATE = API + "/report/create";
    String REPORT_DELETE = API + "/report/delete";
    String REPORT_UPDATE = API + "/report/update";
    String REPORT_BY_ID = API + "/report/{id}";
<<<<<<< Updated upstream

    //role
    String ROLE_GET_ALL = API + "/roles";
    String ROLE_CREATE = API + "/role/create";
    String ROLE_DELETE = API + "/role/delete";
    String ROLE_UPDATE = API + "/role/update";
    String ROLE_BY_ID = API + "/role/{id}";
=======
>>>>>>> Stashed changes
}
