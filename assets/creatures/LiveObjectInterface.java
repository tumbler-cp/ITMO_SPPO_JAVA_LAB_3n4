package assets.creatures;

import assets.creatures.tech.Tech;
import assets.environment.Crystals;
import assets.environment.Place;

interface LiveObjectInterface {
    void printPlace();
    void mine(Crystals crystals);
    void move(Place place);
    void use(Tech tech, Object a);
    default void check(Tech tech, Object obj){
        System.out.println(obj + " проверяет "+ tech+ ". "+tech+" "+tech.getHealth());
    }
}
