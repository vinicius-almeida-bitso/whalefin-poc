package com.bitso.whalefinpoc;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WhalefinPocApplicationTests {

	@Test
	void contextLoads() {

		assertNotNull(System.getenv("WHALEFIN_ACCESS_KEY"));
		assertFalse(StringUtils.isBlank(System.getenv("WHALEFIN_ACCESS_KEY")));

		assertNotNull(System.getenv("WHALEFIN_ACCESS_SECRET"));
		assertFalse(StringUtils.isBlank(System.getenv("WHALEFIN_ACCESS_SECRET")));
	}

}
