package com.xiang.oauth2.client;

/**
 * 封装OAuth Server端认证需要的参数
 */
public class ClientParams {

    public static final String CLIENT_ID = "c1ebe466-1cdc-4bd3-ab69-77c3561b9dee"; // 应用id CLIENT_ID

    public static final String CLIENT_SECRET = "d8346ea2-6017-43ed-ad68-19c0f971738b"; // 应用secret CLIENT_SECRET

    public static final String USERNAME = "admin"; // 用户名

    public static final String PASSWORD = "123456"; // 密码

    public static final String OAUTH_SERVER_URL = "http://localhost:8080/zetark-oauth2-server/authorize"; // 授权地址

    public static final String OAUTH_SERVER_TOKEN_URL = "http://localhost:8080/zetark-oauth2-server/accessToken"; // ACCESS_TOKEN换取地址

    public static final String OAUTH_SERVER_REDIRECT_URI = "http://notes.coding.me"; // 回调地址

    public static final String OAUTH_SERVICE_API = "http://localhost:8080/zetark-oauth2-server/v1/openapi/userInfo"; // 测试开放数据api

}
