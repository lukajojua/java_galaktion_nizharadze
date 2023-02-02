package com.example.java_galaktion_nizharadze;
import connection.ProductUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;




public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {

        ProductUtil.createTable();
        Label label1 = new Label("name");
        Label label2 = new Label("brand");
        Label label3 = new Label("price");
        Label label4 = new Label("expiration");

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();

        Button button = new Button("chamateba");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = textField1.getText();
                String brand = textField2.getText();
                int price = Integer.parseInt(textField3.getText());
                int expiration = Integer.parseInt(textField4.getText());
                Product product = new Product(name, brand, price, expiration);
                try {
                    ProductUtil.insertProduct(product);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        PieChart pieChart = new PieChart();
        pieChart.setData(ProductUtil.getData());
        pieChart.setTranslateX(100);
        pieChart.setTranslateY(200);

        GridPane root = new GridPane();
        root.addRow(0, label1, textField1);
        root.addRow(1, label2, textField2);
        root.addRow(2, label3, textField3);
        root.addRow(3, label4, textField4);
        root.addRow(5, button);
        root.addRow(10, pieChart);

        Scene scene = new Scene(root, 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        Product product_121 = new Product();
        System.out.println(product_121);
        Product product = new Product(1L,"name1", "brand", 20, 2019);
        Product product1 = new Product(1L,"name1", "brand", 20, 2019);
        System.out.println(product);
        System.out.println(product.equals(product1));
        product.setName("name2");
        System.out.println(product.getName());
        System.out.println(product);
        System.out.println(product.hashCode());
        System.out.println(product.equals(product1));
    }
}