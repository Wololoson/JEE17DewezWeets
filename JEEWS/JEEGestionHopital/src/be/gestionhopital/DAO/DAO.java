package be.gestionhopital.DAO;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.sun.jersey.api.client.WebResource;

public abstract class DAO<T> {
	protected WebResource connect = null;
	
	public DAO(WebResource conn) {
		this.connect = conn;
	}
	
	public abstract boolean create(T obj) throws SAXException, IOException;
	
	public abstract boolean delete(T obj) throws SAXException, IOException;
	
	public abstract boolean update(T obj) throws SAXException, IOException;
	
	public abstract T find(int id) throws SAXException, IOException;
}
