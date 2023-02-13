package com.br.atos.APIUsers;

import org.eclipse.jgit.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class ApiUsersApplicationTests {

	@Test
	void contextLoads() {

		System.out.println(Base64.decode("e05f86cc-c68e-45cf-b490-2d449e3771d5"));
	}

}
