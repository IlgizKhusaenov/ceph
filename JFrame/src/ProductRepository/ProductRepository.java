package ProductRepository;

import entities.Product;
import exceptions.DBException;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Utilites.DBConnection.getDBConnection;

public class ProductRepository {

    public static void add(Product product)throws DBException, SQLException{

        Connection connection = (Connection) getDBConnection();
        assert connection != null;

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products(name, price, weight, manufacturer) VALUES (?,?,?,?)");
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setInt(3, product.getWeight());
        preparedStatement.setString(4, product.getManufacturer());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public static List<Product> getAllData() throws Exception{
        List<Product> products = new ArrayList<Product>();

        Connection connection = (Connection) getDBConnection();
        assert connection != null;
        PreparedStatement statement = (PreparedStatement) connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM products;");

        while(set.next()){
            products.add(new Product(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4), set.getString(5)));
        }
        return products;
    }

}
