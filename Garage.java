/*
A class that creates a 10 element empty array of Car objects, used 
to store and manipulate Car objects. The methods will populate the array with 
Car objects, move Car objects, and remove Car objects, and keep track of how 
many Car objects are in the array at a given time.
*/

/**
 * A class that creates a Garage object that stores Car objects in an empty 10
 * element array.
 */
public class Garage
{
    private Car[] garage ;   // Array of Cars
    private int carsParked ; // Current number of Car objects in array
    
    /**
     * Creates a Garage object of an array with 10 elements able to hold Car
     * objects.
     */
    public Garage()
    {
        garage = new Car[10];   // Array gets lenth of 10
        this.carsParked = 0;    // Initially zero Car objects in the array
    }
    
    /**
     * Inserts a Car object into the array at specified index.
     * @param car the Car inserted in the array
     */
    public void park(Car car)
    {
        garage[ getCarsParked() ] = car ;  // Takes the Car object and adds it
                                    // the the array in lowest unoccupied index
        carsParked++ ;   // Increments counter to signify an additional Car
                        // object is in the array
    }
    
    /**
     * Return the number of Car objects currently in the array.
     * @return the number of Car objects currently in the array
     */
    public int getCarsParked()
    {
        return carsParked ;  // The current number of Car objects in the array
    }
    
    /**
     * Adds a Car object to the array, if the array is not full.
     * @param car the Car object to add to the array
     * @return String notifying user if the Car object was successfully added
     * to the array, or if the Car object cannot be added if the array is full
     */
    public String arrive(Car car)
    {
        // If array is full with 10 Car object 
        if ( getCarsParked() == 10 )  
            return "Garage Full, Cannot Park Here" ; // Cannot add Car
        // Else add car to array
        else
            park(car) ;
        
        // If Car object added to array, echo this to output file
        return car.getLicense() + " has been parked." ;
    }
    
    /**
     * Removes Car object from the array, if the array contains this Car object.
     * @param car the Car object to be removed
     * @return String notifying user if the Car object was successfully removed
     * from the array, or if the Car object was not found in the array
     */
    public String depart(Car car)
    {
        // For indices 0 through 9 in the array
        for (int i = 0; i < 10; i++)
        {
            // If the Car object is located in the array
            if (garage[i] == car)
            {
                garage[i] = null ; // That index is cleared

                // For each car Object in array at a higher index than the Car
                // object that was removed
                for (int j = i + 1; j < 10; j++)
                {
                    // The the index contains a Car object
                    if (garage[j] != null)
                    {
                        garage[j - 1] = garage[j] ; // Move Car object from
                                                // index + 1 down to this index
                        garage[j] = null ; // Clears the index + 1
                    }
                }
                
                // Incrememnt the move counter fgor all Car objects in a lower 
                // index than the Car that was removed 
                for (int k = i - 1; k >= 0; k--)
                {
                    garage[k].addMove() ;
                }

                carsParked-- ; // One less Object in the array

                // Return the Car object that was removed from the array, and
                // the amount of times it was moved during its stay
                return car.getLicense() + " has departed. It had been moved " 
                        + car.getCount() + " times." ;
            }
        }
        
        // If Car object is not in the array, inform the user of this
        return car.getLicense() + " is not located in the garage." ;
    }
}
