###### Chemistry Tools Copyright © 2014 Ariel Mordoch

Chemistry Tools is meant to be used as a command line program that contains conversions and analyses useful to chemistry.
In future versions it will be possible to use the program as a library.

Most of the methods behave like normal objects, but the Conversion class does not (it is abstract and its methods are static).

Package Summary

| Package Name | Description |
| ------------ | ----------- |
| com.mordoch.chemtools | Main package |
| com.mordoch.chemtools.interaction | Human-interface package |
| com.mordoch.chemtools.util | Utility classes |
| com.mordoch.chemtools.formulatools | Tools for representing chemical formulas and equations as Java objects |

Class Summary

| Class Name | Class Use |
| ---------- | --------- |
| Main | Main class |
| Conversion | Conversions |
| Analysis | Finding empirical formula, etc. |
| LookupTable | Finding and using element data |
| Menu | Command-line interface |
| Formula | An object representing a chemical formula |
| FormulaHelper | Reduce unnecessary method load from Formula |
| Equation | A container for Formula objects that represent a chemical equation |


TODO:
- Chemical equation balancer
- Formula validation
- Formula correction  

