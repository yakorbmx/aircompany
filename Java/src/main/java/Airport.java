import Planes.experimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019
// modified by Yaroslav Gavrilenko
// 20-Dec-2019

public class Airport {
  private List<? extends Plane> planes;

  public List<PassengerPlane> getListOfPassengerPlanes() {
    List<PassengerPlane> listOfPassengerPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof PassengerPlane) listOfPassengerPlanes.add((PassengerPlane) plane);
    }
    return listOfPassengerPlanes;
  }

  public List<MilitaryPlane> getListOfMilitaryPlanes() {
    List<MilitaryPlane> listOfMilitaryPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof MilitaryPlane) listOfMilitaryPlanes.add((MilitaryPlane) plane);
    }
    return listOfMilitaryPlanes;
  }

  public PassengerPlane getPassengerPlaneWithMaximalPassengersCapacity() {
    List<PassengerPlane> listOfPassengerPlanes = getListOfPassengerPlanes();
    PassengerPlane passengerPlaneWithMaximalCapacity = listOfPassengerPlanes.get(0);
    for (int i = 0; i < listOfPassengerPlanes.size(); i++) {
      if (listOfPassengerPlanes.get(i).getPassengersCapacity()
          > passengerPlaneWithMaximalCapacity.getPassengersCapacity())
        passengerPlaneWithMaximalCapacity = listOfPassengerPlanes.get(i);
    }
    return passengerPlaneWithMaximalCapacity;
  }

  public List<MilitaryPlane> getListOfTransportMilitaryPlanes() {
    List<MilitaryPlane> listOfTransportMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getListOfMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {
      MilitaryPlane plane = militaryPlanes.get(i);
      if (plane.getType() == MilitaryType.TRANSPORT) listOfTransportMilitaryPlanes.add(plane);
    }
    return listOfTransportMilitaryPlanes;
  }

  public List<MilitaryPlane> getBomberMilitaryPlanes() {
    List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getListOfMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {
      MilitaryPlane plane = militaryPlanes.get(i);
      if (plane.getType() == MilitaryType.BOMBER) bomberMilitaryPlanes.add(plane);
    }
    return bomberMilitaryPlanes;
  }

  public List<experimentalPlane> getExperimentalPlanes() {
    List<experimentalPlane> experimentalPlanes = new ArrayList<>();
    for (Plane plane : planes) {
      if (plane instanceof experimentalPlane) experimentalPlanes.add((experimentalPlane) plane);
    }
    return experimentalPlanes;
  }

  public Airport sortByMaxDistance() {
    Collections.sort(
        planes,
        new Comparator<Plane>() {
          public int compare(Plane o1, Plane o2) {
            return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
          }
        });
    return this;
  }

  public Airport sortByMaxSpeed() {
    Collections.sort(
        planes,
        new Comparator<Plane>() {
          public int compare(Plane o1, Plane o2) {
            return o1.getMS() - o2.getMS();
          }
        });
    return this;
  }

  public Airport sortByMaxLoadCapacity() {
    Collections.sort(
        planes,
        new Comparator<Plane>() {
          public int compare(Plane o1, Plane o2) {
            return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
          }
        });
    return this;
  }

  public List<? extends Plane> getPlanes() {
    return planes;
  }

  private void print(Collection<? extends Plane> collection) {
    Iterator<? extends Plane> iterator = collection.iterator();
    while (iterator.hasNext()) {
      Plane plane = iterator.next();
      System.out.println(plane);
    }
  }

  @Override
  public String toString() {
    return "Airport{" + "Planes=" + planes.toString() + '}';
  }

  public Airport(List<? extends Plane> planes) {
    this.planes = planes;
  }
}
