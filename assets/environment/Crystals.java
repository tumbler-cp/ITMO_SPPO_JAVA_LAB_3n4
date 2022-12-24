package assets.environment;

import assets.Actor;

public class Crystals extends Actor {
    public String toString(){
        return this.name;
    }

    @Override
    public int hashCode() {
        return 66 * this.name.length();
    }

    @Override
    public boolean equals(Object obj) {
        Crystals sec = (Crystals) obj;
        if(this.hashCode()==sec.hashCode()) return this.name.equals(sec.name);
        else return false;
    }

    public Crystals(String Ore){
        this.name = Ore;
        this.currPlace = Moon.CAVE;
    }
}

