-- Chemistry Tools v1.0 Readme --

Chemistry Tools is meant to be used as a command line program that contains conversions and analyses useful to chemistry.
In future versions it will be possible to use the program as a library.

As of version 1.0, all methods are static in order to save resources when creating a new object and to avoid code clutter.
This means you need not create any Conversion or Analysis objects when implementing the classes yourself, rather, simply access them like so:
Class.method(args)

Lastly, in the main class, I've added two shortcut methods, one for using System.out.println(), the other for printing "Enter and amount: " to the console.