package assets.creatures.tech;

import assets.environment.Place;

public class IceBreaker extends Tech{
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        IceBreaker sec = (IceBreaker) obj;
        return this.hashCode()==sec.hashCode() && this.stat==sec.stat;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public void makeWay(Place a){
        a.availability = true;
        System.out.println("Теперь "+a+" доступна для передвижения.");
    }
    public IceBreaker(){
        this.name = "ледоруб";
        this.techType = Type.INSTRUMENT;
        this.stat = super.status();
    }
}
