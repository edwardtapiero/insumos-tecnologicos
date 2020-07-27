-- the order of values is related to the name of field.
-- Updating is necessary, if the name is changed



INSERT INTO "PUBLIC"."PEDIDO" VALUES (2147483643, 'Calle 33 F 14B-51', 'cliente2@email.com', 'cliente2', '2343456', '2020-03-15 12:52:20.439', 100, 0, '2020-03-15 12:52:20.439');
INSERT INTO "PUBLIC"."PEDIDO" VALUES (2147483641, 'Calle 33 F 14B-51', 'cliente2@email.com', 'cliente2', '2343456', '2020-03-15 12:52:07.428', 180, 2, '2020-03-15 12:52:53.664');
INSERT INTO "PUBLIC"."PEDIDO" VALUES (2147483648, 'Calle 33 F 14B-48', 'cliente1@email.com', 'cliente1', '123456789', '2020-03-15 13:01:06.943', 134, 1, '2020-03-15 13:02:56.498');

-- ----------------------------
-- Table structure for PRODUCT_CATEGORY

-- ----------------------------
-- Records of PRODUCT_CATEGORY
-- ----------------------------
INSERT INTO "PUBLIC"."CATEGORIA_PRODUCTO" VALUES (2147483641, 'Computadores', 0, '2020-03-09 23:03:26', '2020-03-10 00:15:27');
INSERT INTO "PUBLIC"."CATEGORIA_PRODUCTO" VALUES (2147483642, 'Mouse', 1, '2020-03-10 00:15:02', '2020-03-10 00:15:21');
INSERT INTO "PUBLIC"."CATEGORIA_PRODUCTO" VALUES (2147483644, 'Teclados', 2, '2020-03-10 01:01:09', '2020-03-10 01:01:09');
INSERT INTO "PUBLIC"."CATEGORIA_PRODUCTO" VALUES (2147483645, 'Otros', 3, '2020-03-10 00:26:05', '2020-03-10 00:26:05');


-- ----------------------------
-- Records of PRODUCT_IN_ORDER
-- ----------------------------
INSERT INTO "PUBLIC"."PRODUCTO_EN_PEDIDO" VALUES (2147483642, 0,1,'Procesador: AMD Ryzen 5 3500U Processor 2.1 GHz (4M Cache, up to 3.7Hz), Sistema Operativo: Windows 10 Home - 64bit, Memoria RAM: 8 GB, Disco Sólido: 256GB, Pantalla: 14" Pulgadas', 'https://i.imgur.com/hLavDyb.jpg', 'B0001', 'ASUS M409DA-BV455T', 3400000,30,NULL, 2147483641);
INSERT INTO "PUBLIC"."PRODUCTO_EN_PEDIDO" VALUES (2147483644, 1,1,'Mouse HP', 'https://i.imgur.com/6w4b2sq.jpg', '0002', 'HP Inalámbrico Z3700', 47900,100,NULL, 2147483643);
INSERT INTO "PUBLIC"."PRODUCTO_EN_PEDIDO" VALUES (2147483643, 2,1,'Teclado LOGITECH Touch Inalámbrico Alfanumérico', 'https://i.imgur.com/7G8ubMg.jpg', 'B0001', 'LOGITECH K400 Plus', 129900,100,NULL, 2147483648);


-- ----------------------------
-- Records of PRODUCT_INFO
-- ----------------------------
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('B0001', 0, '2020-03-10 10:37:39', 'Procesador: AMD Ryzen 5 3500U Processor 2.1 GHz (4M Cache, up to 3.7Hz), Sistema Operativo: Windows 10 Home - 64bit, Memoria RAM: 8 GB, Disco Sólido: 256GB, Pantalla: 14" Pulgadas', 'https://i.imgur.com/hLavDyb.jpg', 'ASUS M409DA-BV455T', 3400000, 0, 30, '2020-03-10 19:42:02');
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('B0002', 0, '2020-03-10 12:12:46', 'Procesador: AMD Ryzen 5 3500U Processor 2.1 GHz (4M Cache, up to 3.7Hz), Sistema Operativo: Windows 10 Home - 64bit, Memoria RAM: 8 GB, Disco Sólido: 256GB, Pantalla: 14" Pulgadas', 'https://i.imgur.com/0E1fsqu.png', 'HP Envy 13-aq1001la', 3400000, 1, 0, '2020-03-10 12:12:46');
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('C0001', 1, '2020-03-10 06:51:03', 'Mouse HP', 'https://i.imgur.com/6w4b2sq.jpg', 'HP Inalámbrico Z3700', 47900, 0, 100, '2020-03-10 12:04:13');
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('C0002', 1, '2020-03-10 10:35:43', 'Mouse HP', 'https://i.imgur.com/LCpR3wQ.jpg', 'HP Inalámbrico Optico 200', 49900, 0, 100, '2020-03-10 10:35:43');
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('D0001', 2, '2020-03-10 12:09:41', 'Teclado LOGITECH Touch Inalámbrico Alfanumérico', 'https://i.imgur.com/7G8ubMg.jpg', 'LOGITECH K400 Plus', 129900, 0, 100, '2020-03-10 12:09:41');
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('D0002', 2, '2020-03-10 12:11:51', 'El GXT 830-RW cuenta con tecnología anti-fantasma para garantizar que puedas jugar de forma rápida y precisa', 'https://i.imgur.com/0KYKmVP.png', 'TRUST Alambrico Ilum GXT830', 139000, 0, 100, '2020-03-10 12:11:51');
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('E0001', 3, '2020-03-10 06:44:25', 'Router TP-LINK TL-WR941HP Inalámbrico 3 Antenas Rompe Muros 450Mbp', 'https://i.imgur.com/xcUBRnN.jpg', 'Router TP-LINK TL-WR941HP', 259000, 0, 100, '2020-03-10 06:44:25');
INSERT INTO "PUBLIC"."PRODUCTO_INFO" VALUES ('E0002', 3, '2020-03-10 06:44:25', 'Adaptador TP-LINK Power N300 2 Antenas', 'https://i.imgur.com/0K2Auuq.jpg', 'Adaptador TP-LINK Power N300', 109900, 0, 100, '2020-03-10 06:44:25');


-- ----------------------------
-- Records of USERS
-- ----------------------------
INSERT INTO "PUBLIC"."USUARIOS" VALUES (2147483641, 't', 'Calle 33 F 14B-48', 'cliente1@email.com', 'cliente1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '123456789', 'ROLE_CUSTOMER');
INSERT INTO "PUBLIC"."USUARIOS" VALUES (2147483642, 't', 'Calle 33 F 14B-49', 'administrador1@email.com', 'administrador1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '987654321', 'ROLE_MANAGER');
INSERT INTO "PUBLIC"."USUARIOS" VALUES (2147483643, 't', 'Calle 33 F 14B-50', 'administrador2@email.com', 'administrador2', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '123123122', 'ROLE_MANAGER');
INSERT INTO "PUBLIC"."USUARIOS" VALUES (2147483645, 't', 'Calle 33 F 14B-51', 'cliente2@email.com', 'cliente2', '$2a$10$0oho5eUbDqKrLH026A2YXuCGnpq07xJpuG/Qu.PYb1VCvi2VMXWNi', '2343456', 'ROLE_CUSTOMER');

-- ----------------------------
-- Records of CART
-- ----------------------------
INSERT INTO "PUBLIC"."CARRITO" VALUES (2147483641);
INSERT INTO "PUBLIC"."CARRITO" VALUES (2147483642);
INSERT INTO "PUBLIC"."CARRITO" VALUES (2147483643);
INSERT INTO "PUBLIC"."CARRITO" VALUES (2147483645);


