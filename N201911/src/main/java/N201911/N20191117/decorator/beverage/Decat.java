package N201911.N20191117.decorator.beverage;

public class Decat extends Beverage {

    public Decat(){
        description = "Decat";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
