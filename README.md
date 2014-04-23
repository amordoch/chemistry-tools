###### Chemistry Tools Copyright © 2014 Ariel Mordoch

Chemistry Tools is meant to be used as a command line program that contains conversions and analyses useful to chemistry.
In future versions it will be possible to use the program as a library.

Currently, I am focusing on the backend code, and as such, some program functions may not be accessible to users for some time.

Package Summary

| Package Name | Description |
| ------------ | ----------- |
| com.mordoch.chemtools | Main package |
| com.mordoch.chemtools.interaction | Human-interface package |
| com.mordoch.chemtools.util | Utility classes |
| com.mordoch.chemtools.util.lists | Element information system |
| com.mordoch.chemtools.formulatools | Tools for representing chemical formulas and equations as Java objects |

Class Summary

| Class Name | Class Use |
| ---------- | --------- |
| Main | Main class |
| Conversions | Conversions |
| Analysis | Finding empirical formula, etc. |
| Menu | Command-line interface |
| Formula | An object representing a chemical formula |
| FtHelper | Reduce unnecessary method load from Formula |
| Equation | A container for Formula objects that represent a chemical equation |
| ElementInfoWrapper | A wrapper for Map&lt;K, V&gt; objects that store element information |
| Subclasses of ElementInfoWrapper | Implementation of ElementInfoWrapper |