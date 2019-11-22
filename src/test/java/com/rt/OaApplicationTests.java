package com.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rt.modules.pub.dto.req.CrtUptUserReq;
import com.rt.modules.pub.service.CrtUptUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {

	@Autowired
	private CrtUptUserService crtUptUserService;
	
	@Test
	public void test() {
		for (int i = 0; i < 50; i++) {
			CrtUptUserReq req = new CrtUptUserReq();
			req.setName("user"+i);
			crtUptUserService.crtUser(req);
		}
	}
}
