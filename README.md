###### Chemistry Tools Copyright 2014 Ariel Mordoch

Chemistry Tools is meant to be used as a command line program that contains conversions and analyses useful to chemistry.
In future versions it will be possible to use the program as a library.

Currently, all methods are static and both classes are abstract, as neither need or use object properties.
This means you need not create any Conversion or Analysis objects when implementing the classes yourself, rather, simply access them like so:

'''java
Class.method(args)
'''

Lastly, in the main class, I've added two shortcut methods, one for using System.out.println(), the other for printing "Enter and amount: " to the console.

| To do list  |
| :----------- |
| Chemical equation balancer |
| Formula validation |
| Formula correction | 