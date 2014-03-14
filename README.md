###### Chemistry Tools Copyright 2014 Ariel Mordoch

Chemistry Tools is meant to be used as a command line program that contains conversions and analyses useful to chemistry.
In future versions it will be possible to use the program as a library.

Most of the methods behave like normal objects, but the Conversion class does not (it is abstract and its methods are static), as it does not need object properties.
This means you need not create any Conversion objects when implementing the classes yourself, rather, simply access them like so:

```java
Conversion.method(args)
```

Lastly, in the main class, I've added two shortcut methods, one for using System.out.println(), the other for printing "Enter and amount: " to the console.

| Class Name | Class Use |
| :--------: | :-------: |
| Run | Main class |
| Conversion | Conversions |
| Analysis | Finding empirical formula, etc. |
| LookupTable | Finding and using element data |
| ---------- | --------- | 


TODO:
- Chemical equation balancer
- Formula validation
- Formula correction  

