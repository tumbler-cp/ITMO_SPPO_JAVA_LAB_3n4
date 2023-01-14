package assets.creatures.tech;
import assets.creatures.Astronaut;
import assets.creatures.Group;
import assets.environment.Moon;
import assets.environment.Place;
import assets.exceptions.WrongParameterException;
import storytell.Story;
import java.util.ArrayList;
import java.util.List;


public class Propeller extends Tech implements TransportIF{
    private int angle;
    private float diameter;
    private int rpm;

    private List<Astronaut> Passengers;
    private final List<Place> bannedPlaces = new ArrayList<>();

    public void setAngle(int angle) throws WrongParameterException {
        if(Math.abs(angle)>360) throw new WrongParameterException("Angle is out of range");
        this.angle = angle;
    }

    public void setDiameter(float diameter) throws WrongParameterException {
        if(diameter<0)throw new WrongParameterException("Negative diameter!");
        this.diameter = diameter;
    }

    public void setRpm(int rpm) throws WrongParameterException {
        if(rpm < 0){
            this.health = techHealth.BROKEN;
            throw new WrongParameterException("Negative RPM!");}
        this.rpm = rpm;
    }

    @Override
    public void addPassengers(Astronaut... astronauts) {
        Place mainPlace = this.currPlace;
        for (Astronaut astronaut: astronauts){
            if(astronaut.inTransport) {
                System.out.println(astronaut + " уже в другом ТС.");
                continue;
            }
            if(astronaut.getCurrPlace()!=mainPlace) astronaut.move(mainPlace);
            astronaut.inTransport = true;
            Passengers.add(astronaut);
            this.mass+=astronaut.getMass();
            System.out.println(astronaut+" теперь в "+this.name);
        }
    }

    @Override
    public void delPassengers(Astronaut... astronauts) {
        for(Astronaut astronaut: astronauts){
            Passengers.remove(astronaut);
            this.mass-=astronaut.getMass();
        }
    }

    @Override
    public void addPassengers(Group astronauts) {
        Place mainPlace = this.currPlace;
        for (Astronaut astronaut: astronauts.members){
            if(astronaut.inTransport) {
                System.out.println(astronaut + " уже в другом ТС.");
                continue;
            }
            if(astronaut.getCurrPlace()!=mainPlace) astronaut.move(mainPlace);
            astronaut.inTransport = true;
            Passengers.add(astronaut);
            this.mass+=astronaut.getMass();
            System.out.println(astronaut+" теперь в "+this.name);
        }
    }

    @Override
    public void delPassengers(Group astronauts) {
        for(Astronaut astronaut: astronauts.members){
            Passengers.remove(astronaut);
            this.mass-=astronaut.getMass();
        }
    }

    @Override
    public void carry(Place goal)
    {
        if(this.health == techHealth.BROKEN){
            System.out.println("Пропеллер сломан");
        } else {
            if (bannedPlaces.contains(goal)) {
                System.out.println("В " + goal + " нельзя переместится на " + this.name);
                return;
            }
            float f = Math.abs((float) angle) * Moon.defaultAirPressure * (float) Math.pow(rpm, 2) * (float) Math.pow(diameter, 4);
            if(f<=0){
                System.out.println("Тяга отрицательная или равна нулю");
                return;
            }
            float P = this.mass * Moon.defaultGravitation;
            if (f - P <= 1000) {
                System.out.println(this.name + " создаёт слабую тягу.");
                System.out.print("Причина: ");
                if (Moon.defaultAirPressure <= 0.1f) System.out.println("Воздух крайне разрежен");
                else if (this.diameter < 0.5f) System.out.println("Пропеллер слишком маленький");
                else if (this.rpm <= 500) System.out.println("Малое кол-во об/мин.");
                else if (Math.abs(this.angle) <= 5) System.out.println("Форма пропеллера.");
            }
            for (Astronaut passenger : Passengers) {
                passenger.setCurrPlace(goal);
            }
            System.out.println(this.name + " с " + Passengers + " переместился в " + goal);
        }
    }

    @Override
    public String toString() {
        String buff = new String();
        buff = this.name + " с пассажирами:\n";
        for (Astronaut passenger: Passengers){
            buff+=passenger + "\n";
        }
        return buff;
    }

    @Override
    public int hashCode() {
        return this.angle*(int)this.diameter*this.rpm*this.mass;
    }

    @Override
    public boolean equals(Object obj) {
        Propeller sec = (Propeller) obj;
        if(this.hashCode()==obj.hashCode()){
            return (this.angle==sec.angle)&&(this.diameter==sec.diameter)&&(this.rpm==sec.rpm)&&this.stat==sec.stat;
        } else return false;
    }

    public Propeller(int Angle, float Diameter, int RPM){
        super("Пропеллер", Type.TRANSPORT);
        this.stat = super.status();
        try {
            this.setAngle(Angle);
            this.setRpm(RPM);
            this.setDiameter(Diameter);
            this.setMass(30);
        }
        catch (WrongParameterException a){
            a.printStackTrace();
        }
        bannedPlaces.add(Moon.GROTTO);
        bannedPlaces.add(Moon.CAVE);
        Passengers = new ArrayList<>();
    }
    public class nylonCord{
        public void Attach(Astronaut ... astronauts){
            for (Astronaut astronaut: astronauts) System.out.println(astronaut + "привязался к капроновому шнуру");
            Propeller.this.addPassengers(astronauts);
        }
        public void Attach(Group group){
            for (Astronaut astronaut: group.members) System.out.println(astronaut + "привязался к капроновому шнуру");
            Propeller.this.addPassengers(group);
        }
    }
}
