CREATE TABLE `t_order` (
  `id`            INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `good_id`       INTEGER NOT NULL,
  `good_number`   INTEGER NOT NULL,
  `status`   VARCHAR(50) NOT NULL DEFAULT 'created',
  `total_price`   DECIMAL(10, 2) NOT NULL DEFAULT 0
);