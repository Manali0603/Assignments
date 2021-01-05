package packagesAndExceptionAssignment3;

public class UserTrail {
    int val1, val2;

    public UserTrail(int val1, int val2) {
        if (val1 < 0 || val2 < 0) {
            try {
                throw new IllegalValueException();
            } catch (IllegalValueException e) {
                System.out.println(e);
            }
        }

        this.val1 = val1;
        this.val2 = val2;
    }

    void display() {
        System.out.println("First number is " + val1 + "\nSecond number is " + val2);
    }

    public static void main(String[] args) {
        UserTrail user = new UserTrail(1, 25);
        user.display();
    }
}
