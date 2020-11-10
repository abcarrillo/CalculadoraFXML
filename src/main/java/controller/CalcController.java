package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Calculadora;

public class CalcController implements Initializable {

	private Calculadora calculadora = new Calculadora();

	@FXML
	private AnchorPane view;
	
	@FXML
	private TextField txtResultado;

	@FXML
	private Button btn7;

	@FXML
	private Button btn5;

	@FXML
	private Button btn9;

	@FXML
	private Button btn8;

	@FXML
	private Button btn4;

	@FXML
	private Button btn1;

	@FXML
	private Button btn0;

	@FXML
	private Button btn2;

	@FXML
	private Button btn6;

	@FXML
	private Button btn3;

	@FXML
	private Button btnComa;

	@FXML
	private Button btnCE;

	@FXML
	private Button btnMultiplicacion;

	@FXML
	private Button btnResta;

	@FXML
	private Button btnSuma;

	@FXML
	private Button btnC;

	@FXML
	private Button btnDivision;

	@FXML
	private Button btnIgual;

	public CalcController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Vista.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public AnchorPane getView() {
		return view;
	}

	@FXML
	private void escribirNumero(ActionEvent event) {
		Button boton = (Button) event.getSource();
		char res = boton.getText().toCharArray()[0];
		calculadora.insertar(res);
		
		txtResultado.setText(calculadora.getPantalla());
	}
	
	@FXML
    private void determinarOperacion(ActionEvent event) {
		Button boton = (Button) event.getSource();
		String operacion = boton.getText();
		
		switch (operacion) {
			case "+": {
				calculadora.operar(Calculadora.SUMAR);
				break;
			}
			case "-":{
				calculadora.operar(Calculadora.RESTAR);
				break;
			}
			case "*":{
				calculadora.operar(Calculadora.MULTIPLICAR);
				break;
			}
			case "/":{
				calculadora.operar(Calculadora.DIVIDIR);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + operacion);
				
			}
    }
	
	@FXML
    private void insertarComa(ActionEvent event) {
		calculadora.insertarComa();
		txtResultado.setText(calculadora.getPantalla());
    }
	
	@FXML
    void realizarOperacion(ActionEvent event) {
		calculadora.operar(Calculadora.IGUAL);
		txtResultado.setText(calculadora.getPantalla());
    }
	
	@FXML
    void borrarInput(ActionEvent event) {
		calculadora.borrar();
		txtResultado.setText(calculadora.getPantalla());
    }

    @FXML
    void borrarTodo(ActionEvent event) {
    	calculadora.borrarTodo();
    	txtResultado.setText(calculadora.getPantalla());
    }
}
