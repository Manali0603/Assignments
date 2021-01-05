package coreJavaAssignment1;

import java.util.Scanner;

class Term {
     int coefficient;
     int exponent;

    public Term() {
        coefficient = 0;
        exponent = 0;
    }


}

class Polynomial {
    Term terms[];
    int top=0;

    Polynomial(int n)
    {
        terms = new Term[n];
        for(int i=0; i<n; i++)
            terms[i] = new Term();
    }

    public void setTerm(int exp, int coefficient,int size) {
        for(int i=0; i<top; i++) {
            if(exp == terms[i].exponent) {
                System.out.println("Same Exponent cannot be input twice!");
                return;
            }
        }
        if(top == size) {
            System.out.println("Polynomial size exceeded!");
            return;
        }
        if(exp < 0) {
            System.out.println("Exponent can't be negative!");
            return;
        }
        terms[top].coefficient = coefficient;
        terms[top].exponent = exp;
        top++;
    }

    public void sort() {
        Term temp= new Term();
        for(int i=0; i<top-1; i++) {
            for(int j=i+1; j<top; j++ ) {
                if(terms[i].exponent > terms[j].exponent) {
                    temp= terms[i];
                    terms[i]=terms[j];
                    terms[j]=temp;
                }
            }
        }
    }

    public void print() {
        System.out.printf(" %dx^%d", terms[0].coefficient, terms[0].exponent);
        for(int i=1; i<top; i++)
            System.out.printf(" + %dx^%d", terms[i].coefficient, terms[i].exponent);
    }

}

public class q10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of terms: ");
        int n = in.nextInt();

        Polynomial polynomial = new Polynomial(n);
        System.out.println("Enter number of terms where data to be filled : ");
        int t = in.nextInt();

        for(int i=0; i<t; i++) {
            System.out.println("Enter co-efficient : ");
            int coeff= in.nextInt();
            System.out.println("Enter exponent : ");
            int exp= in.nextInt();
            polynomial.setTerm(exp, coeff,n);
        }
        polynomial.sort();
        polynomial.print();

    }

}
