# LeetCode

// SOme important concepts of Java
// priority queue

PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator< ListNode >() { <br>
            @Override <br>
            public int compare(ListNode a,ListNode b)<br>
            {<br>
                if(a.val < b.val)<br>
                {<br>
                    return -1;<br>
                }<br>
                else if(a.val > b.val)<br>
                    return 1;<br>
                else<br>
                    return 0;<br>
            }<br>
        });<br>

import static is used when we want to import static variables from other classes 
for eg :  import static java.lang.Math.PI; and we can use PI directly in the java file else we need to use Math.PI everytime

An interface can extend another interface

Marker interface is something which doesnt have any methods but used to force some functionality , for eg : Serializable 

Composition is always preferred over inheritance

to run a jar file through cmd we need to added the main class in the manifest file 

A string can be used in switch statement from java 7 onwards

Externalizable and Serializable - 

Serializable is a marker interface and no need to override , where as Externalizable needs to override readExternal and writeExternal

Functional interface is something which has only one abstract method and it can have more than one default or static method

private and static, default methods in interface should have a body

Lambda expressions basically express instances of functional interfaces , they implement the only abstract method


Lambda as an expression -> it can have return types as well

lambda as an object ->

lambda variable capture -> it can access all the variables i.e local , object and class(static)

method references as lambdas -> 

If a class implements another interface , the interface obj can only access methods which are declared in the interface .

static and default methods in an interface should have a body.

Method references -> 1. reference to a static method 
					 2. reference to a non static or instance method
					 3. reference to a constructor.
					 

Streams is one of the most important operation in Java --> we can have many intermediate operations but only one terminal operation

Arrays.stream(arrayname) || Stream.of(values i.e 1,2,4,5,7)

to find max of an array , we can do --> Arrays.stream(arrname).max().getAsInt();

we can have a callback function in c using void (*func)(int)  = &add; -- this means func is a function pointer to the function add which takes int as an argument 

similarly we can have void (*func)()  = &add;-- this means func is a function pointer to the function add which doesnt have an arugment

but void *func(int) -- if we dont have braces around func this means func is a function with argument as int and which returns void * 

void vs void * - void as the return type. Then your second method would read "a method that returns an untyped pointer." void* is a memory address without a type.

Callback in C vs Java :

Callbacks in C , we can pass a function pointer to a function so that (the start of the code represented by function pointer) can be called inside this function and will it be known as callback).

In java , we can only pass primitive types and objects as arguments to function and cannot pass another func ( as in C) , because we dont have pointers in java , we overcome this by using interfaces . we declare a method in the interface which needs to be overridden in the derived class and call that method through this function , so that it acts as a function pointer . Sample example written in githubcode


Memory layout of C program :

Initialized data segment : contains the global and static variables which are initialized
Uinitialized data segment : contains the global and static variables which are un  initialized
Text segment : this contains the executable instructions and are typically read only 
stack: this contains the local variables and program stack and the values passed to functions
heap : this contains the dynamic area of the program i.e ptrs and stuff
