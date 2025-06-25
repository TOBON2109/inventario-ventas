package com.empresa.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);

		try {
			Thread.sleep(3000);
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://localhost:8080/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
