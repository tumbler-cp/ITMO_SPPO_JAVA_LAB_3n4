package assets.creatures.tech;

import assets.Actor;

public abstract class Tech extends Actor {
    public enum Type{
        INSTRUMENT,
        TRANSPORT
    }
    protected Type techType;
    protected boolean status(){return Math.random()>= 0.01;}
    protected techHealth health = techHealth.NORMAL;

    public techHealth getHealth() {
        return health;
    }

    public Type getTechType() {
        return techType;
    }

    public boolean stat;
    public Tech(){
        this.stat = status();
    }
    public Tech(String Name){
        this();
        this.name = Name;
        this.stat = status();
        if(!stat){
            this.health = techHealth.BROKEN;
        }
    }
    public Tech(String Name, Type type){
        this(Name);
        this.techType = type;
    }
}
