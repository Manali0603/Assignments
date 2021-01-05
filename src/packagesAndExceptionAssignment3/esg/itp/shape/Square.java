package packagesAndExceptionAssignment3.esg.itp.shape;

public class Square implements Polygon{

    float side;
    public Square(float s)
    {
        side=s;
    }

    @Override
    public void calcArea() {
        float area=side*side;
        System.out.println("Area of the square is : "+area);
    }

    @Override
    public void calcPeri() {
        float perimeter=4*side;
        System.out.println("Perimeter of the square is : "+perimeter);
    }

    @Override
    public void display() {
        calcArea();
        calcPeri();

    }
}
