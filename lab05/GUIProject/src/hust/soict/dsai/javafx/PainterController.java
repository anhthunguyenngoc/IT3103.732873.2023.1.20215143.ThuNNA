//Nguyễn Ngọc Anh Thư - 20215143
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
  @FXML //Event khi chọn clear: xóa bảng vẽ
  void clearButtonPressed(ActionEvent event) {
	drawingAreaPane.getChildren().clear(); 
  }

  @FXML
  void drawingAreaMouseDragged(MouseEvent event) {
    Circle newCircle = new Circle(event.getX(), event.getY(), size, color);
    drawingAreaPane.getChildren().add(newCircle);
  }
  
  @FXML	//Event khi chọn erase
  void eraseButtonPressed(ActionEvent event) {
    color = Color.WHITE; //Đổi màu bút thành màu trắng
    size = 10;			 
  }

  @FXML //Event khi chọn pen
  void penButtonPressed(ActionEvent event) {
	color = Color.BLACK; //Đổi màu bút thành màu đen
	size = 4;
  }
}
