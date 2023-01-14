package assets.creatures;

import assets.Actor;
import assets.creatures.tech.IceBreaker;
import assets.creatures.tech.Tech;
import assets.environment.Crystals;
import assets.environment.Place;
import assets.environment.Moon;

public class Astronaut extends Actor implements LiveObjectInterface {
    public enum Gender {
        MALE, FEMALE
    }//Гендер космонавта нужен только для сравнение его с другим экземляром класса Astronaut.
    protected Gender gender;
    public boolean inTransport;
    @Override
    public void move(Place place) {
        if(!place.availability){
            System.out.println("К "+place+" нет доступа");
            return;
        }
        this.currPlace = place;
        System.out.println(this.name + " переместился в " + place);
    }
    @Override
    public void use(Tech tech, Object a) {
        String buf = "";
        if(tech.stat) buf = "использует "+tech + " на "+ a;
        else buf = tech + " сломан(-а)!";
        System.out.println(this.name+" "+buf);
        if(tech.getTechType() == Tech.Type.TRANSPORT){
            System.out.println("На транспорте можно только ехать.");
            return;
        } else if (tech.getTechType() == Tech.Type.INSTRUMENT) {
            if(tech instanceof IceBreaker){
                ((IceBreaker) tech).makeWay((Place) a);
            }
        }


    }

    @Override
    public void mine(Crystals crystals) {
        if(currPlace!=Moon.CAVE){
            System.out.println("Кристаллы можно добывать только в пещере.");
            return;
        }
        System.out.println(this.name + " добывает "+ crystals);
    }

    public void printPlace(){
        System.out.println(this.name + " находится в " + this.currPlace);
    }
    public void splitGroup(Group parent, Group child, Astronaut ... toMove){
        parent.delMembers(toMove);
        child.addMembers(toMove);
        String text = "";
        for(Astronaut unit: toMove){ text += unit + " ";}
        System.out.println(this.name + " делит группу " + parent.getName() + ". Из него уходят "+ text + " в группу " + child.getName());
    }

    public String toString(){
        return this.name;
    }

    @Override
    public int hashCode() {
        int k =0;
        switch (this.gender){
            case FEMALE -> k =2;
            case MALE -> k=4;
        }
        return 777*k*mass;
    }

    @Override
    public boolean equals(Object obj) {
        Astronaut sec = (Astronaut) obj;
        if(this.hashCode()==sec.hashCode()){
            return this.mass==sec.mass&&this.gender==sec.gender;
        } else return false;
    }

    public Astronaut(String Name, int Mass, Gender Gend){
        super(Name, Mass);
        this.gender = Gend;
        inTransport = false;
    }
    public Astronaut(String Name, int Mass, Gender Gend, Place place){
        super(Name, Mass, place);
        this.gender = Gend;
    }

    public class Spacesuit{
        public enum Status {
            PUT_ON ("надет"),
            PUT_OFF ("снят");
            String text;
            Status(String s){
                text = s;
            }

            @Override
            public String toString() {
                return this.text;
            }
        }
        Status status = Status.PUT_OFF;
        public void putOn(){
            this.status = Status.PUT_ON;
            System.out.println(Astronaut.this + ": " + "скафандр" + this.status);
        }
        public void putOff(){
            this.status = Status.PUT_OFF;
            System.out.println(Astronaut.this + ": " + "скафандр" + this.status);
        }
    }
}
