package com.seongJIn.Robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seongJIn.Robot.Service.PollingService;
import com.seongJIn.Robot.Vo.FormatVo;

@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
		PollingService p = new PollingService();
		FormatVo formatVo = new FormatVo();
		p.getUpdate(formatVo);
		SpringApplication.run(RobotApplication.class, args);
	}
}
