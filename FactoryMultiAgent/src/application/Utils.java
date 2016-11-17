/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
/**
 *
 * @author dougl
 */
public class Utils {
    public static double map(double value, double currentRangeStart, double currentRangeStop, double targetRangeStart, double targetRangeStop) {
        return targetRangeStart + (targetRangeStop - targetRangeStart) * ((value - currentRangeStart) / (currentRangeStop - currentRangeStart));
    }

    /**
     * Create an imageview of a right facing arrow.
     * @param size The width. The height is calculated as width / 2.0.
     * @param height
     * @return
     */
    public static ImageView createArrowImageView( double size) {

        return createArrowImageView(size, size / 2.0, Color.BLUE, Color.BLUE.deriveColor(1, 1, 1, 0.3), 1);

    }

    /**
     * Create an imageview of a right facing arrow.
     * @param width
     * @param height
     * @return
     */
    public static ImageView createArrowImageView( double width, double height, Paint stroke, Paint fill, double strokeWidth) {

        return new ImageView( createArrowImage(width, height, stroke, fill, strokeWidth));

    }   

    /**
     * Create an image of a right facing arrow.
     * @param width
     * @param height
     * @return
     */
    public static Image createArrowImage( double width, double height, Paint stroke, Paint fill, double strokeWidth) {

        WritableImage wi;

        double arrowWidth = width - strokeWidth * 2;
        double arrowHeight = height - strokeWidth * 2;
        Canvas canvas = new Canvas(250,250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
         gc.fillRect(gc.getCanvas().getLayoutX(),      
                     gc.getCanvas().getLayoutY(), 
                     gc.getCanvas().getWidth(), 
                     gc.getCanvas().getHeight());
         gc.setFill(Color.GREEN);
         gc.setStroke(Color.BLUE);

         gc.setLineWidth(5);
         gc.strokeLine(40, 10, 10, 40);
         gc.fillOval(10, 60, 30, 30);
         gc.strokeOval(60, 60, 30, 30);
         gc.fillRoundRect(110, 60, 30, 30, 10, 10);
         gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
         gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
         gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
         gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT); 

        int imageWidth = (int) width;
        int imageHeight = (int) height;

        wi = new WritableImage( imageWidth, imageHeight);

        return gc.getCanvas().snapshot(parameters, wi);

    }
}
