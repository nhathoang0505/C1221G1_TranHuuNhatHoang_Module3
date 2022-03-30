drop database if exists ss2_design_and_create_database_bai_tap_1;
create database ss2_design_and_create_database_bai_tap_1;
use ss2_design_and_create_database_bai_tap_1;
create TABLE phieuxuat(
so_px int AUTO_INCREMENT PRIMARY key,
ngay_xuat DATE
);
create table vattu(
ma_vtu int AUTO_INCREMENT PRIMARY key,
ten_vtu varchar(50)
);
CREATE table chi_tiet_phieu_xuat(
so_px int,
ma_vtu int,
FOREIGN KEY (so_px) REFERENCES phieuxuat(so_px),
FOREIGN KEY (ma_vtu) REFERENCES vattu(ma_vtu),
dg_xuat double,
sl_xuat int
);
create table phieu_nhap(
so_pn int AUTO_INCREMENT PRIMARY key,
ngay_nhap DATE
);
create TABLE chi_tiet_phieu_nhap(
ma_vtu int,
so_pn int,
FOREIGN KEY (ma_vtu) REFERENCES vattu(ma_vtu),
FOREIGN KEY (so_pn) REFERENCES phieu_nhap(so_pn),
dg_nhap double,
sl_nhap int
);
create table nha_cc(
ma_ncc int AUTO_INCREMENT PRIMARY key,
ten_ncc varchar(50),
dia_chi varchar(50),
sdt varchar (20) 
);
create table so_dien_thoai(
sdt varchar(20) PRIMARY key ,
ma_ncc int,
FOREIGN KEY (ma_ncc) REFERENCES nha_cc(ma_ncc) 
);
create table don_dh(
so_dh int AUTO_INCREMENT PRIMARY KEY,
ngay_dh DATE,
ma_ncc int,
FOREIGN KEY (ma_ncc) REFERENCES nha_cc(ma_ncc)
);
create table chi_tiet_don_dat_hang(
ma_vtu int,
so_dh int,
FOREIGN KEY (ma_vtu) REFERENCES vattu(ma_vtu),
FOREIGN KEY (so_dh) REFERENCES don_dh(so_dh)
);


