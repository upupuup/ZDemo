package com.enumDemo;

public class Const {
    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";

    public static final String USERNAME = "username";

    public interface ProductListOrderBy {
        // price_desc price指的是使用价格排序，desc指的是排序方式
        // Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");

    }

    public interface Cart {
        int CHECKED = 1; // 购物车选中状态
        int UN_CHECKED = 0; // 购物车未选择状态

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    public interface Role{
        int ROLE_CUSTOMER = 0; // 普通用户
        int ROLE_ADMIN = 1; // 管理员
    }

    public enum ProductStatusEnum {
        ON_SALE(1, "在线");
        private String value;
        private int code;

        ProductStatusEnum (int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum OrderStatusEnum {
        CANCEL(0, "取消", "quxiao"),
        NO_PAY(10, "未支付", "weizhifu"),
        PAID(20, "已付款", "yifukuan"),
        SHIPPED(40, "已发货", "yifahuo"),
        ORDER_SUCCESS(50, "订单完成", "dingdanwancheng"),
        ORDER_CLOSE(60, "订单关闭", "dingdanguanbi")
        ;

        OrderStatusEnum(int code, String value, String desc) {
            this.code = code;
            this.value = value;
            this.desc = desc;
        }

        private String value;
        private int code;
        private String desc;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public String getDesc() {return desc;}

        public static OrderStatusEnum codeOf(int code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                // 判断是否有和这个枚举常量相等的
                return orderStatusEnum;
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

    public interface AlipayCallback {
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    public enum PayPlatformEnum {
        ALIPAY(1, "支付宝")
        ;

        PayPlatformEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum PaymentTypeEnum{
        ONLINE_PAY(1, "在线")
        ;

        PaymentTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        public static PaymentTypeEnum codeOf(int code) {
            for (PaymentTypeEnum paymentTypeEnum : values()) {
                // 判断是否有和这个枚举常量相等的
                return paymentTypeEnum;
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

}

