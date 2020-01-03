package pl.dawid.web.dao;

import pl.dawid.web.Client;

import java.util.List;
import javax.sql.DataSource;

public interface ClientDataDAO {
	
	void saveClientData(Client client, DataSource dataSource) throws Exception;
	List readClientsData(DataSource dataSource) throws Exception;
	void removeClient(String name, String surname, DataSource dataSource) throws Exception;
	void removeClient(int id, DataSource dataSource) throws Exception;
}
