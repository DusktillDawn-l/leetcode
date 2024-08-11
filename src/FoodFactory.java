public class FoodFactory {

    public Food createFood(String type) {
        switch (type) {
            case "hamburger":
                return new Hamburger();
            case "hotpot":
                return new Hotpot();
            default:
                throw new IllegalArgumentException("Unknown food type");
        }
    }

    public static void main(String[] args) {
        FoodFactory foodFactory = new FoodFactory();
        Food myHamburger = foodFactory.createFood("hamburger");
        myHamburger.prepare();
        Food myHotpot = foodFactory.createFood("hotpot");
        myHotpot.prepare();
    }

//    public static void main(String[] args) {
//        Hamburger myHamburger = new Hamburger();
//        myHamburger.prepare();
//
//        Hotpot myHotpot = new Hotpot();
//        myHotpot.prepare();
//        Food mySushi = new Sushi();
//        mySushi.prepare();
//
//        Food myPizza = new Pizza();
//        myPizza.prepare();
//
//        Food mySalad = new Salad();
//        mySalad.prepare();
//
//        Food mySteak = new Steak();
//        mySteak.prepare();
//
//        Food mySoup = new Soup();
//        mySoup.prepare();
//
//        Food mySandwich = new Sandwich();
//        mySandwich.prepare();
//    }
}
