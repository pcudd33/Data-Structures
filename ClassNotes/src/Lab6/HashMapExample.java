package Lab6;

import java.util.HashMap;
import java.util.Objects;

public class HashMapExample {

    public static void main(String[] args) {
        HashMap<Person, String> colors = new HashMap<Person, String>();

        colors.put(new Person("Drew", "M"), "orange");
        colors.put(new Person("Ruoting", "C"), "black");
        colors.put(new Person("Sam", "R"), "red-black");
        colors.put(new Person("Ben", "D"), "green");
        colors.put(new Person("Cam", "B"), "purple");
        colors.put(new Person("Glen", "M"), "orange");
        colors.put(new Person("Robert", "F"), "blue");
        colors.put(new Person("Ayanda", "M"), "purple");
        colors.put(new Person("Cassie", "R"), "grey");
        colors.put(new Person("Matt", "A"), "blue");
        colors.put(new Person("Adam", "Q"), "green");
        colors.put(new Person("Jane", "B"), "blue");
        colors.put(new Person("Parker", "C"), "green");
        colors.put(new Person("Grace", "C"), "blue");
        colors.put(new Person("Jason", "A"), "lavender");

        System.out.println(colors.get(new Person("Grace", "C")));


        //to loop over all the values in the map
        for (String color : colors.values()){
            //get the color from new map and increment the count
        }
    }

    private static class Person {
        String firstName, lastName;

        public Person (String first, String last){
            firstName = first;
            lastName = last;
        }
        //you need these two methods in order to have your hashtable return
        //values that are what we want
        //hashcode hashes the person object
        @Override
        public int hashCode(){
            return Objects.hash(firstName, lastName);
        }
// Equals, makes it so instead of returning the bucket value we return the actual
        //value stored within it
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(firstName, person.firstName) &&
                    Objects.equals(lastName, person.lastName);
        }
    }
}
