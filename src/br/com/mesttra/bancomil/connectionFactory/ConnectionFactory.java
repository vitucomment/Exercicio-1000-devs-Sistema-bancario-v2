package br.com.mesttra.bancomil.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection getConnection() {
		try {
			
			return DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/mildevs", "root", ""
				);
			
		} catch(SQLException  e) {
			System.out.println("Erro ao estabelecer conexão");
			return null;
		}
	}
	
}
