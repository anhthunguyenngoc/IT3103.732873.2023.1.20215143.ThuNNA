package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
  @FXML
  private Pane drawingAreaPane;
  private Color color = Color.BLACK;
  private int size = 4;
  @FXML
  void clearButtonPressed(ActionEvent event) {
	drawingAreaPane.getChildren().clear();
  }

  @FXML
  void drawingAreaMouseDragged(MouseEvent event) {
    Circle newCircle = new Circle(event.getX(), event.getY(), size, color);
    drawingAreaPane.getChildren().add(newCircle);
  }
  
  @FXML
  void eraseButtonPressed(ActionEvent event) {
    color = Color.WHITE;
    size = 10;
  }

  @FXML
  void penButtonPressed(ActionEvent event) {
	color = Color.BLACK;
	size = 4;
  }
}
