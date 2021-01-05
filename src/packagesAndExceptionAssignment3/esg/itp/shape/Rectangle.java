package packagesAndExceptionAssignment3.esg.itp.shape;

public class Rectangle implements Polygon{
    float length;
    float breadth;
    public Rectangle(float l,float b)
    {
        length=l;
        breadth=b;
    }
    @Override
    public void calcArea() {
        float area=length*breadth;
        System.out.println("Area of the rectangle is : "+area);

    }

    @Override
    public void calcPeri() {
        float perimeter=2*(length+breadth);
        System.out.println("Perimeter of the rectangle is : "+perimeter);
    }

    @Override
    public void display() {
        calcArea();
        calcPeri();

    }
}
