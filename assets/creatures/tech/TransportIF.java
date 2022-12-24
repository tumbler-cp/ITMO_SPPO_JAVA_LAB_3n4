package assets.creatures.tech;

import assets.creatures.Astronaut;
import assets.creatures.Group;
import assets.environment.Place;

public interface TransportIF {
    void carry(Place goal);
    void addPassengers(Astronaut ... astronauts);
    void delPassengers(Astronaut ... astronauts);
    void addPassengers(Group astronauts);
    void delPassengers(Group astronauts);
}
