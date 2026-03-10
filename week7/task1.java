Overview
The problem is to design a parking system.

A design problem is a problem where we have to implement a class or a data structure. This class usually has multiple functions that we have to implement. This falls under the category of Object Oriented Programming

In this problem, we have to implement the ParkingSystem class. It will have the following components:

ParkingSystem constructor. Whenever any user or test case wants to create a new parking system, they will call this constructor. They need to specify the number of parking slots available for each type of car (small, medium, or large).

We have to write code to store this information in the class. This information will perhaps be used in other functions.

Different languages have different ways to implement constructors.

In Python, we use __init__ function to implement the constructor.
In C++ and Java, the name of the constructor is the same as the name of the class.
addCar function. Whenever any user or test case wants to add a car to the parking system, they will call this function. They need to specify the type of the car, carType using an integer.

if they want to add a big car, they will pass 1 as the argument.
if they want to add a medium car, they will pass 2 as the argument.
if they want to add a small car, they will pass 3 as the argument.

We have to write code to check if there is a parking slot available for the given type of car.

If there is a parking slot available, we have to add the car to the parking system and return true.
Otherwise, we have to return false.
In these problems, users often faces difficulty in understanding the input and output formats. Let's pick one example and understand its input and output structure. If you are not familiar with design problems, it is advisable to expand the section by clicking here.
↓ 
Section below structure
​
 

There are tons of similar Design Problems on LeetCode. A few of them are listed below:

LRU Cache
Implement Trie (Prefix Tree)
Implement Stack using Queues
Implement Queue using Stacks
Design Browser History
Design Linked List
Approach: Array for Parking Slots
Intuition
We want to initialize our object given slots for each type of car.

What exactly do we need to store in our object?
It depends on the desired function of the object. The required function is addCar and we should check if there is a parking space for carType. If so, then we should add the car to the parking system and return true. Otherwise, we should return false.

Thus, while creating an object, we perhaps need to store the

Parking limit for big cars
Parking limit for medium cars
Parking limit for small cars
Do we need anything else in the constructor?
We know the limits for each type of car. But we don't know the number of cars parked in the parking system. We need to store this information as well.

Therefore, it may also be necessary to store the following three pieces of information in the object:

Count of big cars parked in the parking system.
Count of medium cars parked in the parking system.
Count of small cars parked in the parking system.
All of them will be initialized to 0.

Initially, constructor in pseudo-code will look like this:

ParkingSystem(int big, int medium, int small) {

    // Store the parking limit for each type of car
    this.bigLimit = big
    this.mediumLimit = medium
    this.smallLimit = small

    // Store the count of cars parked in the parking system
    this.bigCount = 0
    this.mediumCount = 0
    this.smallCount = 0
}
The this keyword is used to access the current object's attributes and methods. Different languages have different ways to access the current object's attributes and methods. For example, in Python, we can use the self keyword to access the current object's attributes and methods.

We are currently storing the count and limits of cars for each type in six variables. However, what if we have hundreds of types of cars? Is it a good idea to have two variables for each type of car?

It turns out that if data represents the same type of thing (or data is homogeneous), then we can use an array to store them.

An Array is a data structure that stores a collection of elements. It is a linear data structure, which means that elements are stored sequentially. Each element in an array is identified by an index. Readers can learn more about Array from Leetcode Explore Card.

Thus, we can club the three variables bigCount, mediumCount, and smallCount into one array count. Also, we can club the three variables bigLimit, mediumLimit, and smallLimit into one array limit.

Hence, so far, we are planning to use two arrays, count and limit. Can we brainstorm a way to use only one array?

The condition to check if we can addCar or not will be

⇝ count[i] < limit[i]

⇝ limit[i] > count[i]

⇝ limit[i] - count[i] > 0

What exactly does limit[i] - count[i] represent? It represents the number of empty slots available for a particular type of car. Hence, we can use this value to store the empty slots for each type of car in one array, empty.

Initially, all available slots will be empty. Hence, we can initialize empty with the parking limit of each type of car provided as arguments to the constructor.

Now, does the order of these variables matter, or can we gain any advantage if they are stored in one specific order instead of another?
For answering this, let's re-read the following portion of the problem statement

carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.

This hints that if we store

big cars at index 1,
medium cars at index 2,
and small cars at index 3,
then we can directly access the count of cars of a particular type by using carType as the index.

What about index-0, then?

Arrays in most programming languages are 0-indexed. This means that the first element of the array is stored at index 0.

There are two ways to handle this.

We can allocate an array of size 4, and store the number of empty slots of cars at index 1, 2, and 3. On Index 0, we can store some dummy value.

The carType here will directly act as an index.

We can allocate an array of size 3, and store the number of empty slots of cars at index 0, 1, and 2.

The carType here will act as an index after subtracting 1 from it.

Readers can choose any of the two ways. We will proceed with the second way.

Thus, now our constructor in pseudo-code will look like this

ParkingSystem(int big, int medium, int small) {

    // Store the empty slots for each type of car
    this.empty = [big, medium, small]
}
Readers can appreciate the compactness obtained by using an array. We have reduced the number of variables from six to one.

Interview Tip: Reading the problem statement multiple times helps to formulate solutions elegantly.

In the addCar function, we check if the number of empty slots is greater than 0. If it is, we add the car and decrement the number of empty slots by 1. In this case, we return true. Otherwise, we return false.

boolean addCar(int carType) {

    // Depending on carType, decide
    if empty[carType - 1] > 0 {
        empty[carType - 1] -= 1
        return true
    }
    else {
        return false
    }
}
Thus using this approach we can solve the problem. Once solved, readers are advised to see codes in other languages and compare how classes and objects are implemented in different languages. Also, it's worth noting that we can also use a Hash map to solve this problem. Readers can try to solve the problem using a Hash map as well.

Algorithm
In the constructor, create one array of size 3. Let's call it empty.

empty will store the number of empty slots available for each type of car. Index 0 will be used for big cars, index 1 will be used for medium cars, and index 2 will be used for small cars. These limits will be passed as big, medium, and small respectively as parameters to the constructor. Initially, all the empty slots will be equal to the parking limit of each type of car.

In the addCar function, if the number of empty slots for carType is greater than 0, then decrement the number of empty slots by 1 and return true. Else, return false.

The if condition will be similar to if empty[carType - 1] > 0.

