package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import com.overone.cource.group47.lesson13.Str;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import static sample.Controller.getUrlContent;

public class Controller {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text anchorPaneWeather;

    @FXML
    private Button getData;

    @FXML
    private TextField textFieldCity;

    @FXML
    private Label informationLabel;

    @FXML
    private Text temperaturField;

    @FXML
    private Text feelsField;

    @FXML
    private Text maximumField;

    @FXML
    private Text minimumField;

    @FXML
    private Text pressureField;

    @FXML
    void gooooo(ActionEvent event) {
        temperaturField.setText("eeeeeee");
    }


    @FXML
    void initialize() {
        getData.setOnAction(event -> {
            java.awt.Label city;
            String getUserCity=city.getText().trim();
            String output=getUrlContent ("https://api.openweathermap.org/data/2.5/weather?id="+getUserCity +"&appid=fb459f996863a11527e50c1f86eed5f5&lang=ru\";")
            System.out.println(output);

        });

    }

    private static getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            wile((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Такой город был не найден!");
        }
        return content.toString();
    }

    private static void wile(boolean b) {
    }
}
