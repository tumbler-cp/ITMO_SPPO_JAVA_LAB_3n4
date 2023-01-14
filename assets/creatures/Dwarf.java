package assets.creatures;
import assets.*;
import assets.creatures.Astronaut.Gender;
import assets.environment.Moon;

public class Dwarf extends Actor {
    public Gender gender;
    public Dwarf(String s, int m, Gender G){
        super(s, m);
        this.gender = G;
    }
    public void help(Astronaut goal){
        System.out.println(this+" помогает "+goal);
    }
    public String toString(){
        return this.name;
    }
    public void checkVisibility(Actor a){
        if(a.getCurrPlace()!=Moon.INNER_SURFACE){
            System.out.println(a+" не видно.");
        }
        else System.out.println(a + " видно.");
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
        Dwarf sec = (Dwarf) obj;
        if(this.hashCode()==sec.hashCode()){
            return this.mass==sec.mass&&this.gender==sec.gender;
        } else return false;
    }
}
