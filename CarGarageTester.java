/*
Test Class for Garage.java and Car.java
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CarGarageTester
{
    public static void main(String[] args) throws IOException
    {
        // Create new Garage object
        Garage theGarage = new Garage() ;
        
        // Number of lines to be counted in original input
        int lines = 0 ;
        
        // Scand the input file
        Scanner lineCounter = new Scanner( new File("garage.txt") ) ;
        
        // Counts the number of lines in input file
        while ( lineCounter.hasNextLine() )
        {
            lineCounter.nextLine() ;
            lines++ ;
        }
        
        // Create array the size of the number of lines in the input file
        Car[] temp = new Car[lines] ;
        
        // Scans the input file
        Scanner inFile = new Scanner( new File("garage.txt") ) ;
        
        // Counter used to count the number of unique Car objects from input
        int last = 0 ;
        
        // Loops through input, locates each unique Car object by license plate
        // and fill the temp Array with the Cars
        while ( inFile.hasNext() )
        {
            String license = inFile.next() ;
            inFile.next() ;
            
            // For each line in the input
            for (int i = 0; i < lines; i++) 
            {
                // If temp array is null, add the Car object to the array
                if (temp[i] == null)
                {
                    temp[i] = new Car(license) ;

                    last = i ;   // The last counter will get the i'th index  

                    break ;
                } 
                // If the Car object has already been added to the temp array,
                // skip over and do not add this Car
                else if ( temp[i].getLicense().equals(license) )
                {
                    break ;
                }
            }   
        }
        
        // New array equal to the size of the number of unique Car objects
        Car[] cars = new Car[last + 1] ;
        
        // Populate the car Array with the Cars from the temp array
        // The cars array will be full, and each index will contain a unique 
        // Car object
        for (int i = 0; i <= last; i++)
        {
            cars[i] = temp[i] ;
        }
        
        // Scans the input file
        Scanner inFileAgain = new Scanner( new File("garage.txt") ) ;
          
        // Echos output to an output file
        PrintWriter outFile = new PrintWriter("Garage_Output.txt") ;
           
        // For each line in the input, scan the Car objects and deterine if the
        // Car is arriving or departing the garage
        while ( inFileAgain.hasNext() )
        {
            String license = inFileAgain.next() ;
            String action = inFileAgain.next() ;
            
            // If Car is arriving, add to cars array
            if (action.equals("ARRIVE"))
            {
                for (int i = 0; i < cars.length; i++)
                {
                    if ( cars[i].getLicense().equals(license) )
                    {
                       // Echo to output file
                       outFile.println( theGarage.arrive(cars[i]) ) ;
                    }
                }
            }
            // If car is departing, remove car from cars array
            else if (action.equals("DEPART"))
            {
                for (int i = 0; i < cars.length; i++)
                {
                    if ( cars[i].getLicense().equals(license) )
                    {
                       //Echo to output file
                       outFile.println( theGarage.depart(cars[i]) ) ;
                    }
                }
            }
        }
    
        outFile.close() ; // Close and save output file
    }
}