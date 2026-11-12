/**
 * Driver class to test the multivariate polynomial.
 */
public class Main {


    public static void main(String[] args) {


        Polynomial poly = new Polynomial();


        // Term 1 : 3x²y⁴
        TermNode term1 = poly.insertTerm(3);
        poly.insertVariable(term1, 'x', 2);
        poly.insertVariable(term1, 'y', 4);


        // Term 2 : -5z²
        TermNode term2 = poly.insertTerm(-5);
        poly.insertVariable(term2, 'z', 2);


        // Term 3 : x
        TermNode term3 = poly.insertTerm(1);
        poly.insertVariable(term3, 'x', 1);


        // Term 4 : -y
        TermNode term4 = poly.insertTerm(-1);
        poly.insertVariable(term4, 'y', 1);


        // Term 5 : 20
        poly.insertTerm(20);


        System.out.println("Polynomial :");
        poly.displayPolynomial();


        System.out.println("Degree of Polynomial : " + poly.findDegree());
    }
}