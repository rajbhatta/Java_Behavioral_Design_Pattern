package example.one;

public class StrategyDemo {
    public static void main(String[] args){
        CreditCard amexCard=new CreditCard(new AmexStrategy());
        amexCard.setNumber("379185883464283");
        amexCard.setDate("04/2020");
        amexCard.setCvv("123");

        System.out.println("Is Amex valid:"+amexCard.isValid());


        CreditCard amexCard2=new CreditCard(new AmexStrategy());
        amexCard.setNumber("379185883464282");
        amexCard.setDate("04/2017");
        amexCard.setCvv("234");

        System.out.println("Is Amex valid:"+amexCard.isValid());

    }
}
