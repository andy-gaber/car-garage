# car-garage

Simulates a single lane parking garage that can hold up to 10 cars. Cars enter from the rear and exit from the front, and when a car arrives it is parked in the spot closest towards the front. If a car needs to exit the garage and it is not the car nearest the exit, all cars in front of the exiting car need to move out of the way while the car exits, and are then moved back in place to their original spaces. Any cars behind the exiting car will move up one space.

An input file contains a list of cars with their respective license plate numbers as a string, and the cars actions (either ARRIVE or DEPART). The file will be read, each car will be parked, moved, or be departed depending on the action specified. Each action will be written to an output file revealing all the cars actions: parked, moved (and how many times), departed, and also if the car is not in the garage, or the car cannot be parked because the garage is full.
