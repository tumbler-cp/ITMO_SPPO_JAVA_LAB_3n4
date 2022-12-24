package assets;

import assets.environment.Moon;
import assets.environment.Place;

public abstract class Actor {
    protected String name;
    protected int mass;
    protected Place currPlace = Moon.TUNNEL;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setCurrPlace(Place currPlace) {
        this.currPlace = currPlace;
    }

    public Place getCurrPlace() {
        return currPlace;
    }

    public String toString(){
        return this.name;
    }
    public Actor(){
        this.name = "Безымянный";
    }
    public Actor(String N){
        this.name = N;
    }
    public Actor(String N, int M){
        this(N);
        if(M<=0){
            throw new IllegalArgumentException("Масса объекта должна быть положительной и не равна нулю.");
        }
        this.mass = M;
    }
    public Actor(String N, int M, Place P){
        this(N, M);
        this.currPlace = P;
    }
}
