package packagesAndExceptionAssignment3;

import packagesAndExceptionAssignment3.esg.itp.shape.Rectangle;
import packagesAndExceptionAssignment3.esg.itp.shape.Square;

public class TestPolygon {
    public static void main(String[] args) {
        Square square=new Square(5.0f);
        Rectangle recatngle=new Rectangle(2.0f,3.0f);
        square.display();
        recatngle.display();
    }

}
