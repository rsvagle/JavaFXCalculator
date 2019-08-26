package calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    private double firstNumber;
    private double secondNumber;
    private String operator = "";

    @FXML
    private TextField output;

    @FXML
    private void processNumpad(ActionEvent event){
        String value = ((Button)event.getSource()).getText();

        if(!(value.equals("CE") || value.equals("C") || value.equals("Back") || value.equals("."))){
            // Simple numeric buttons
            output.setText(output.getText() + value);
        }
        else{
            // Non numeric buttons
            if(value.equals("C")){
                output.clear();
            }
            else if(value.equals("CE")){
                firstNumber = 0;
                output.clear();
            }
            else if(value.equals("Back")){
                String oneLess = output.getText(0, output.getLength()-1);
                output.setText(oneLess);
            }
            else if(value.equals(".")){
                if(output.getText().contains(".")){
                    // Do nothing
                }
                else{
                    output.setText(output.getText() + value);
                }
            }
        }
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if(!value.equals("=")){
            // If the button isn't the equals button, store the operator that was selected
            operator = value;

            // Try catch block to avoid a number format exception if the field is blank. Default to zero.
            try{
                firstNumber = Double.parseDouble(output.getText());
            }
            catch (NumberFormatException n){
                firstNumber = 0;
            }
            output.clear();
        }
        else{
            // If the button was the equals button, do the calculation with the stored operator

            // Try catch block to avoid a number format exception if the field is blank. Default to zero.
            try{
                secondNumber = Double.parseDouble(output.getText());
            }
            catch (NumberFormatException n){
                secondNumber = 0;
            }

            if(operator.equals("/")){
                double result = (firstNumber / secondNumber);
                setResult(result);
            }
            else if(operator.equals("*")){
                double result = (firstNumber * secondNumber);
                setResult(result);
            }
            else if(operator.equals("+")){
                double result = (firstNumber + secondNumber);
                setResult(result);
            }
            else if(operator.equals("-")){
                double result = (firstNumber - secondNumber);
                setResult(result);
            }
        }
    }

    public void setResult(double result){
        if(result % 1 == 0){
            output.setText("" + (int)result);
        }
        else{
            output.setText("" + result);
        }
    }

}
