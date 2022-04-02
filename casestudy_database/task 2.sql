use furama;
select * from furama.nhan_vien
where (nhan_vien.ho_ten like 'h%' or nhan_vien.ho_ten like 't%' or nhan_vien.ho_ten like 'k%') and (char_length(nhan_vien.ho_ten) <=15)
