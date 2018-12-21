/*
Purpose: A class that creates a Car object to be used in a Garage class and 
stored in an array. Each car is identified by a license plate String that is 
comprised of six letters and numbers, and each car can be stored and manipulated 
in an array in the Garage class.
*/

/**
 * A class that creates a Car object to be stored in an array.
 */
public class Car
{
    private String licensePlate ;    // The six character identifier of a car
    private int moveCount ;          // amount of times a car temporarily moves 
                                 // out of the garage to let another car depart
                
    /**
     * Creates a car object with a license identifier, and a move counter 
     * initialized to zero.
     * @param licensePlate the cars identifier
     */
    public Car(String licensePlate)
    {
        this.licensePlate = licensePlate ;
        moveCount = 0 ;
    }
    
    /**
     * Returns the specific cars six character identifier.
     * @return the six character identifier
     */
    public String getLicense()
    {
        return licensePlate ;
    }
    
    /**
     * Returns the number of times a car was temporarily moved out of the garage 
     * to make room for a car that is departing.
     * @return the number of times a car is temporarily moved for another 
     * departing car
     */
    public int getCount()
    {
        return moveCount ;
    }
    
    /**
     * Increments the moveCount by 1.
     */
    public void addMove()
    {
        moveCount += 1 ;
    }
    
}