package com.training.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

    //user
    String USER_GET_ALL = API + "/users";
    String USER_CREATE = API + "/user/create";
    String USER_DELETE = API + "/user/delete";
    String USER_UPDATE = API + "/user/update";
    String USER_BY_ID = API + "/user/{id}";

    //notification
    String NOTIFICATION_GET_ALL = API + "/notifications";
    String NOTIFICATION_CREATE = API + "/notification/create";
    String NOTIFICATION_DELETE = API + "/notification/delete";
    String NOTIFICATION_UPDATE = API + "/notification/update";
    String NOTIFICATION_BY_ID = API + "/notification/{id}";
}
