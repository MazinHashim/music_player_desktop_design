package application;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class musicController {

    @FXML
    private Button setting;
    @FXML
    private Button close;
    @FXML
    private AnchorPane pane_setting;
    @FXML
    private Button close_setting;

	private double x = 0;
	private double y = 0;
    private FadeTransition fadeIn = new FadeTransition();
    private FadeTransition fadeOut = new FadeTransition();

    @FXML
    public void clickAction(MouseEvent event) {
    	if(event.getSource() == close) {
    		System.exit(0);
    	}
    	if(event.getSource() == setting) {
    		fadeIn.setNode(pane_setting);
    		fadeIn.setAutoReverse(false);
    		//fadeIn.setByValue(2.2);
    		fadeIn.setDuration(Duration.millis(1000));
    		fadeIn.setFromValue(0.0);
    		fadeIn.setToValue(1.0);
    		pane_setting.setVisible(true);
    		fadeIn.play();
    	}
    	if(event.getSource() == close_setting) {
    		fadeOut.setNode(pane_setting);
    		fadeOut.setDuration(Duration.millis(1000));
    		fadeOut.setFromValue(1.0);
    		fadeOut.setToValue(0.0);
    		pane_setting.setVisible(false);
    		fadeOut.play();
    	}
    }
    public void dragged(MouseEvent e) {
		Node node = (Node) e.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setX(e.getScreenX()-x);
		stage.setY(e.getScreenY()-y);
	}
	public void pressed(MouseEvent e) {
		x = e.getSceneX();
		y = e.getSceneY();
	}
}
