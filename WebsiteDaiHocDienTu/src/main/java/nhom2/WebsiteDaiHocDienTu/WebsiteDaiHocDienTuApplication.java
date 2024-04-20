package nhom2.WebsiteDaiHocDienTu;

import nhom2.WebsiteDaiHocDienTu.dao.AppDAO;
import nhom2.WebsiteDaiHocDienTu.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsiteDaiHocDienTuApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteDaiHocDienTuApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return args -> {
			User user = new User("1", "1234", "Huy");
			appDAO.save(user);
			System.out.println("Da luu");
			System.out.println("Bat dau lay user");

			User user1 = appDAO.findUserById(1);
			System.out.println(user1);

			System.out.println("Done");

		};
	}


}
