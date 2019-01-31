
import BLL.Service;
import Model.Value;
import java.util.Map;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Maxime
 */
public class Main_Controller {

    Service service = new Service();
    static int parabolaCounter = 1;

    @FXML
    private Text equation;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private Button findSolution;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    void onActionFindSolution(ActionEvent event) {
        showEquation();
        if (!this.textField1.getText().isEmpty() && !this.textField2.getText().isEmpty() && !this.textField3.getText().isEmpty()) {
            Value value = new Value(
                    Integer.parseInt(this.textField1.getText()),
                    Integer.parseInt(this.textField1.getText()),
                    Integer.parseInt(this.textField1.getText())
            );
            Map<Integer, Double> coordinateTab = new TreeMap<Integer, Double>();

            coordinateTab = service.drawingParabola(value, 10);

            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Parabola #" + parabolaCounter++);

            for (Map.Entry<Integer, Double> entry : coordinateTab.entrySet()) {
                series1.getData().add(new XYChart.Data(entry.getKey().toString(), entry.getValue()));
                System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
            }
            lineChart.getData().addAll(series1);
        } else {
            System.out.println("Please fill all text field beside !");
        }//if
    }//onActionFindSolution
    
    private void showEquation(){
        String a = this.textField1.getText();
        String b = this.textField2.getText();
        String c = this.textField3.getText();

        if ((Double.parseDouble(b) >= 0) && (Double.parseDouble(c) >= 0))  {
            this.equation.setText("y = " + a + "x²" + "+" + b + "x" + "+" + c);
        } else if ((Double.parseDouble(b) >= 0) && (Double.parseDouble(c) < 0)){
            this.equation.setText("y = " + a + "x²" + "+" + b + "x" + c);
        } else if ((Double.parseDouble(b) < 0) && (Double.parseDouble(c) >= 0)){
            this.equation.setText("y = " + a + "x²" + b + "x" + "+" + c);
        }
    }
    
}//Main_Controller
