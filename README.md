###### Chemistry Tools Copyright © 2014 Ariel Mordoch

Chemistry Tools is meant to be used as a command line program that contains conversions and analyses useful to chemistry.
In future versions it will be possible to use the program as a library.

Most of the methods behave like normal objects, but the Conversion class does not (it is abstract and its methods are static), as it does not need object properties.
This means you need not create any Conversion objects when implementing the classes yourself, rather, simply access them like so:

```java
Conversion.method(args)
```

Package Summary
| Package Name | Description |
| ------------ | ----------- |
| com.mordoch.chemtools | Main package |
| com.mordoch.chemtools.interaction | Human-interface package |
| com.mordoch.chemtools.util | Utility classes |

Class Summary
| Class Name | Class Use |
| ---------- | --------- |
| Main | Main class |
| Conversion | Conversions |
| Analysis | Finding empirical formula, etc. |
| LookupTable | Finding and using element data |
| Menu | Command-line interface |


TODO:
- Chemical equation balancer
- Formula validation
- Formula correction  

