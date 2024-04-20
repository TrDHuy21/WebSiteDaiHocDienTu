package nhom2.WebsiteDaiHocDienTu.dao;

import nhom2.WebsiteDaiHocDienTu.entity.User;

public interface AppDAO {
    void save(User user);
    User findUserById(int theId);
}
