CREATE TABLE `shopping_cart_goods` (
    id bigint NOT NULL AUTO_INCREMENT,
    shopping_cart_id bigint NOT NULL,
    goods_id bigint NOT NULL,
    count int NOT NULL,
    PRIMARY KEY (id)
);