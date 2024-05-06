	delete from ttcn_nhom2.sinh_vien;
	delete from ttcn_nhom2.quan_ly_khoa;
	delete from ttcn_nhom2.giang_vien;
	delete from ttcn_nhom2.sv_seq;
	delete from ttcn_nhom2.gv_seq;
	delete from ttcn_nhom2.qlk_seq;
    delete from ttcn_nhom2.role_user;
    delete from ttcn_nhom2.user;
    delete from ttcn_nhom2.role;
-- create role
insert into ttcn_nhom2.role (id, state, ten)
values 
	(1, 1, "SV"),
	(2, 1, "SV"),
	(3, 1, "SV"),
	(4, 1, "SV");

-- tạo người dùng
	
    

-- tạo sinh viên, user, add role add foreignkey
	insert into ttcn_nhom2.sinh_vien (id)
	values 
		("SV_00001");
	insert into ttcn_nhom2.user (id, user_name, password, ho, ten, state)
	values 
		(1, "SV_00001", '{bcrypt}$2a$10$2H4UW3xv15qNfleaSMnIbe5xpT7XMYKMwt27jCsiiFBPeZyBW0Iqm', 'Duc', 'Huy', 1);
	update ttcn_nhom2.sinh_vien
	set user_id=1
	where id='SV_00001';

	insert into ttcn_nhom2.sv_seq (next_val) values (1);
    
    insert into ttcn_nhom2.role_user (role_id,user_id)
    values
		(1,1);
    
  
-- create giang vien
insert into ttcn_nhom2.giang_vien (id)
	values 
		("GV_00001");
	insert into ttcn_nhom2.user (id, user_name, password, ho, ten, state)
	values 
		(2, "GV_00001", '{bcrypt}$2a$10$c6t1IRZCm4EqwYfxlzWDweL64ORncDLyH/IpZGemFAkCNb1GUFZ8C', 'Thien', 'Lam', 1);
		
	update ttcn_nhom2.giang_vien
	set user_id=2
	where id='GV_00001';

	insert into ttcn_nhom2.gv_seq (next_val) values (1);
    
    insert into ttcn_nhom2.role_user (role_id,user_id)
    values
        (2,2);
-- create quan ly khoa
	insert into ttcn_nhom2.quan_ly_khoa (id)
	values 
		("QLK_00001");
	insert into ttcn_nhom2.user (id, user_name, password, ho, ten, state)
	values 
		(3, "QLK_00001", '{bcrypt}$2a$10$c6t1IRZCm4EqwYfxlzWDweL64ORncDLyH/IpZGemFAkCNb1GUFZ8C', 'Minh', 'Tien', 1);
		
	update ttcn_nhom2.quan_ly_khoa
	set user_id=3
	where id='QLK_00001';

	insert into ttcn_nhom2.qlk_seq (next_val) values (1);
    
    insert into ttcn_nhom2.role_user (role_id,user_id)
    values
        (3,3);

-- create user admin
	insert into ttcn_nhom2.user (id, user_name, password, ho, ten, state)
	values 
		(4, "admin", '{bcrypt}$2a$10$c6t1IRZCm4EqwYfxlzWDweL64ORncDLyH/IpZGemFAkCNb1GUFZ8C', 'Quang', 'Minh', 1);
    
    insert into ttcn_nhom2.role_user (role_id,user_id)
    values
        (3,4),
        (4,4);

