public class ControlFlow {
    public static void main(String[] args) {
        int visaCard = 100; // this visaCard variable represents the 100$ you got for your birthday
        int burgerCost = 45; // this burgerCost variable represents the 45$ charge for the nice burger you
                             // want to get

        if (visaCard >= burgerCost) {
            System.out.println("Congrats on buying a burger! Gordon Ramsay is pleased to serve you today");
        }

        if (100 >= 45) {
            System.out.println("Congrats on buying a burger! Gordon Ramsay is pleased to serve you today");
        }

        if (true) {
            System.out.println("Congrats on buying a burger! Gordon Ramsay is pleased to serve you today");
        }

        int lowCard = 40; // you've used your card a couple of times now, so there is less money on it

        if (lowCard >= burgerCost) {
            System.out.println("Congrats on buying a burger! Gordan Ramsay is pleased to serve you today");
        }

        if (40 >= 45) {
            System.out.println("Congrats on buying a burger! Gordon Ramsay is pleased to serve you today");
        }

        if (false) {
            System.out.println("Congrants on buying a burger! Gordan Ramsay is pleased to serve you today");
        }
        /*
         * So far we have just looked at the >= operator, but there are many other
         * options we can use:
         * > greater than
         * < less than
         * >= greater or equal
         * <= less or equal
         * == equal
         */

        int numOne = 10;
        int numTwo = 32;

        if (numOne < numTwo) {
            System.out.println("Will this phrase show?");
        }
    }    
}