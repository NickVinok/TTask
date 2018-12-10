package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Model.ITransportTsk;
import sample.Model.TransportModel;

import java.util.ArrayList;

public class Controller {
    private ITransportTsk transportModel;
    @FXML
    private Button sb;
    @FXML
    private Label p1;
    @FXML
    private Label p2;
    @FXML
    private Label p3;
    @FXML
    private Label p4;
    @FXML
    private Label p5;
    @FXML
    private Label p6;
    @FXML
    private Label p7;
    @FXML
    private Label p8;
    @FXML
    private Label p9;
    @FXML
    private Label p10;
    @FXML
    private Label p11;
    @FXML
    private Label p12;
    @FXML
    private Label t1;
    @FXML
    private Label t2;
    @FXML
    private Label t3;
    @FXML
    private Label t4;
    @FXML
    private Label s1;
    @FXML
    private Label s2;
    @FXML
    private Label s3;
    @FXML
    private Label overall;

    @FXML
    private TextField v1;
    @FXML
    private TextField v2;
    @FXML
    private TextField v3;
    @FXML
    private TextField v4;
    @FXML
    private TextField v5;
    @FXML
    private TextField v6;
    @FXML
    private TextField v7;
    @FXML
    private TextField v8;
    @FXML
    private TextField v9;
    @FXML
    private TextField v10;
    @FXML
    private TextField v11;
    @FXML
    private TextField v12;
    @FXML
    private TextField sv1;
    @FXML
    private TextField sv2;
    @FXML
    private TextField sv3;
    @FXML
    private TextField tv1;
    @FXML
    private TextField tv2;
    @FXML
    private TextField tv3;
    @FXML
    private TextField tv4;
    @FXML
    private ComboBox methodPicker;

    @FXML
    private Label lab;

    public void setMOdel(TransportModel m){
        this.transportModel = m;
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Метод северо-западного угла",
                        "Метод наименьшего элемента"
                );
        methodPicker.setItems(options);
    }

    @FXML
    public void sbOnAction(ActionEvent actionEvent) {
        if(!methodPicker.getSelectionModel().isEmpty()) {
            ArrayList<Integer> values = new ArrayList<>();
            ArrayList<Integer> needs = new ArrayList<>();
            ArrayList<Integer> stock = new ArrayList<>();
            try {
                Integer tmp = Integer.parseInt(v1.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v2.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v3.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v4.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v5.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v6.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v7.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v8.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v9.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v10.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v11.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(v12.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                values.add(tmp);
                tmp = Integer.parseInt(tv1.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                needs.add(tmp);
                tmp = Integer.parseInt(tv2.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                needs.add(tmp);
                tmp = Integer.parseInt(tv3.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                needs.add(tmp);
                tmp = Integer.parseInt(tv4.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                needs.add(tmp);
                tmp = Integer.parseInt(sv1.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                stock.add(tmp);
                tmp = Integer.parseInt(sv2.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                stock.add(tmp);
                tmp = Integer.parseInt(sv3.getText());
                if (tmp < 0) {
                    throw new NumberFormatException();
                }
                stock.add(tmp);

            } catch (NumberFormatException e) {
                values.clear();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Должны быть введены числа\nПри том положительные");
                alert.show();
            }
            int result = -1;
            ArrayList<ArrayList<Integer>> resultingPrices = new ArrayList<>();
            System.out.println(stock.size());
            if(Integer.sum(Integer.sum(stock.get(0),stock.get(1)),stock.get(2)) !=
                    Integer.sum(Integer.sum(needs.get(0),needs.get(1)),Integer.sum(needs.get(2), needs.get(3)))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Сумма требуемых единиц товара должна быть равна сумме имеющихся");
                alert.show();
                values.clear();
            }

            if(values.isEmpty()){    }
            else {
                if (!values.isEmpty() && methodPicker.getValue() == "Метод северо-западного угла") {
                    transportModel.setValues(values, stock, needs);
                    result = transportModel.calculateOverallValueNW();
                    resultingPrices = transportModel.getNWResults();
                } else if (!values.isEmpty() && methodPicker.getValue() == "Метод наименьшего элемента") {
                    transportModel.setValues(values, stock, needs);
                    result = transportModel.calculateOverallValueMinVal();
                    resultingPrices = transportModel.getMinValResults();
                }
                overall.setText(String.valueOf(result));
                s1.setText(sv1.getText());
                s2.setText(sv2.getText());
                s3.setText(sv3.getText());
                t1.setText(tv1.getText());
                t2.setText(tv2.getText());
                t3.setText(tv3.getText());
                t4.setText(tv4.getText());

                p1.setText(Integer.toString(resultingPrices.get(0).get(0)));
                p2.setText(Integer.toString(resultingPrices.get(0).get(1)));
                p3.setText(Integer.toString(resultingPrices.get(0).get(2)));
                p4.setText(Integer.toString(resultingPrices.get(1).get(0)));
                p5.setText(Integer.toString(resultingPrices.get(1).get(1)));
                p6.setText(Integer.toString(resultingPrices.get(1).get(2)));
                p7.setText(Integer.toString(resultingPrices.get(2).get(0)));
                p8.setText(Integer.toString(resultingPrices.get(2).get(1)));
                p9.setText(Integer.toString(resultingPrices.get(2).get(2)));
                p10.setText(Integer.toString(resultingPrices.get(3).get(0)));
                p11.setText(Integer.toString(resultingPrices.get(3).get(1)));
                p12.setText(Integer.toString(resultingPrices.get(3).get(2)));
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Необходимо выбрать тип составления опорного плана");
            alert.show();
        }
    }
}
