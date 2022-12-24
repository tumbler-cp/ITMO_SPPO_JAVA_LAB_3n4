package assets.creatures;

import assets.creatures.tech.Tech;
import assets.environment.Crystals;
import assets.environment.Place;

interface LiveObjectInterface {
    void printPlace();
    void mine(Crystals crystals);
    void move(Place place);
    void use(Tech tech, Object a);
    default void check(Tech tech){
        String buff = "";
        switch (tech.getHealth()){
            case BROKEN -> buff = "сломан(-а)";
            case NORMAL -> buff = "в порядке";
        }
        System.out.println("Производится проверка "+ tech+ ". "+tech+" "+buff);
    }
}
