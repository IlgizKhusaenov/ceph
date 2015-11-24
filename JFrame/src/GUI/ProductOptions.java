package GUI;

import ProductRepository.ProductRepository;
import entities.Product;
import exceptions.DBException;
import ProductRepository.ProductRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ProductOptions extends JFrame {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Products");

        JInternalFrame frame = new JInternalFrame("Products");
        JPanel panel = new JPanel(new GridLayout(12, 0));

        JButton sendButton = new JButton("Send");
        JButton getAllDataButton = new JButton("Get All Data");
        final JTextField field1 = new JTextField("", 20);
        JTextField field2 = new JTextField("", 20);
        final JTextField field3 = new JTextField("", 20);
        final JTextField field4 = new JTextField("", 20);

        JComboBox comboBox = new JComboBox();
        JLabel lb1 = new JLabel("Name: ");
        JLabel lb2 = new JLabel("Price: ");
        JLabel lb3 = new JLabel("Weight: ");
        JLabel lb4 = new JLabel("Manufacturer: ");
        JLabel lb5 = new JLabel("");
        JLabel lb6 = new JLabel("");

        panel.add(lb1);
        panel.add(field1);

        panel.add(lb2);
        panel.add(field2);

        panel.add(lb3);
        panel.add(field3);

        panel.add(lb4);
        panel.add(field4);

        panel.add(lb5);
        panel.add(sendButton);
        panel.add(getAllDataButton);
        panel.add(lb6);

        sendButton.addActionListener(e -> {
            String name = field1.getText();
            String price = field2.getText();
            String weight = field3.getText();
            String manufacturer = field4.getText();

            Product product = new Product(name, Integer.parseInt(price), Integer.parseInt(weight), manufacturer);
            try {
                ProductRepository.add(product);
                field1.setText("");
                field2.setText("");
                field3.setText("");
                field4.setText("");

                lb5.setText("The product was successfully added to the database.");
            } catch (DBException ex){
                System.out.println("Something wrong with database...");
            } catch (SQLException ex){
                System.out.println("SQLException");
            }
            });

        getAllDataButton.addActionListener(e -> {
            try {
                SwingUtilities.invokeLater(() -> {
                    try {
                        new ProductList().start();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });

            frame.add(panel);
            frame.setBounds(100, 100, 250, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            mainFrame.add(frame);
            mainFrame.setBounds(100, 150, 300, 400);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);

        }
    }
