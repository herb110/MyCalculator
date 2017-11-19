import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable
{
    
 //   private Label label;
    @FXML
    private TextField txtDisplay;
    private int decimalClick = 0;
    private double firstDouble;
    private double secondDouble;
    private double  result = 0;
    private String generalOprend;

    @FXML
    private void handlerGeneralAction(ActionEvent event)
    {
        generalOprend = ((Button)event.getSource()).getText();
        switch(generalOprend)
        {
            case "AC":
                    txtDisplay.setText("");
                    decimalClick = 0;
                    break;
            case "+/-":
                    double plusMinus = Double.parseDouble(txtDisplay.getText());
                    plusMinus = plusMinus * (-1);
                    txtDisplay.setText(String.valueOf(plusMinus));
                    break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                     String currentText = txtDisplay.getText();
                     firstDouble = Double.parseDouble(currentText);
                     txtDisplay.setText("");
                     decimalClick = 0;
                     break;
            default: 
                break;
        }
    }

    @FXML
    private void handlerDigitAction(ActionEvent event)
    {
           String digitObject = ((Button) event.getSource()).getText();
           String oldText = txtDisplay.getText();
           String newText = oldText + digitObject;
           txtDisplay.setText(newText);
    }

    @FXML
    private void handlerDecimalAction(ActionEvent event)
    {
        if(decimalClick == 0)
        {
            String decimalObject = ((Button) event.getSource()).getText();
            String oldText = txtDisplay.getText();
            String newText = oldText + decimalObject;
            txtDisplay.setText(newText);
            decimalClick = 1;
        }
    }

    @FXML
    private void handlerEqualAction(ActionEvent event)
    {
        String secondText = txtDisplay.getText();
        secondDouble = Double.parseDouble(secondText);
        result = 0;
        switch(generalOprend)
        {
            case "+" :
                result = firstDouble + secondDouble;
                break;
           case "-" :
                result = firstDouble - secondDouble;
                break;
           case "*" :
                result = firstDouble * secondDouble;
                break;
           case "/" :
               try
               {
                   result = firstDouble / secondDouble;
               } catch (Exception e)
               {
                   e.printStackTrace();
               }
                finally
               {
                   break;
               }
           case "%" :
               try
               {
                    result = firstDouble % secondDouble;
               } catch (Exception e)
               {
                   e.printStackTrace();
               }    
               finally
               {
                    break;
               }              
           default:
                break;
        }
        String resultString =Double.valueOf(result).toString();
        txtDisplay.setText(resultString);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
    }
    
}
