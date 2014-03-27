/* Copyright Ariel Mordoch 2014
This file is part of Chemistry Tools.

    Chemistry Tools is free software: you can redistribute it and/or modify
    it under the terms of the Lesser GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Chemistry Tools is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    Lesser GNU General Public License for more details.

    You should have received a copy of the Lesser GNU General Public License
    along with Chemistry Tools.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mordoch.chemtools.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mordoch.chemtools.Main;


/**
 * This class is used to store information about elements. 
 * There are three instance variables that contain Map objects. Upon creation these instance variables are either
 * filled with data or set to null by the constuctor.
 * @author Ariel Mordoch
 * @version 0.5
 * @see LookupTable#LookupTable(String)
 * @see LookupTable#LookupTable()
 * @see Main
 * @since 0.4
 */

public class LookupTable {
    // Create three Maps that hold element data. Empty until filled by the constructor
    private Map<String, Double> molarMass = new HashMap<String, Double>(118, 1.01f);
    private Map<String, Integer> atomicNumber = new HashMap<String, Integer>(118, 1.01f);
    private Map<String, String> name = new HashMap<String, String>(118, 1.01f);

    /**
     * This constructor fills the map corresponding to the desiredMap argument.
     * <p>Possible arguments:</p>
     * <ul>
     *     <body>
     *         <li>molarMass</li>
     *         <li>atomicNumber</li>
     *         <li>name</li>
     *     </body>
     * </ul>
     * @param desiredMap a String corresponding to the map to populate with data
     */

    public LookupTable(String desiredMap) {
        
        switch(desiredMap) {
            
            case "molarMass":
                molarMass();
                break;
            case "atomicNumber":
                atomicNumber();
                break;
            case "name":
                name();
                break;
            default:
                molarMass();
                atomicNumber();
                name();
            
        }
        
    }

    /**
     * If you want to fill all the Map objects with data, use this constructor.
     */

    public LookupTable() {
        molarMass();
        atomicNumber();
        name();
    }


    /**
     * Assembles a List<<x>Object> object containing all the Map objects in this class.
     * It is recommended to avoid using this method as it is an inefficient way of referencing element data, however,
     * it exists for some case where it may be useful.
     * @since 0.1
     */

    public List<Object> data() {
        // Create the list
        List<Object> data = new ArrayList<Object>();
        // Add the maps to the list
        data.add( name );
        data.add( molarMass );
        data.add( atomicNumber );
        // Return the list
        return data;
    }

    /**
     * Finds information about an element and then returns a list containing that information.
     * <p> Format: name, atomic number, atomic mass, molar mass </p> 
     * @param element a string containing the symbol for an element.
     * @return A List<<x>String> containing information about an element. See format above.
     * @since 0.1
     */

    public List<String> getElementInfo(String element) {
        // Create a new ArrayList that stores element info.
        List<String> elementInfo = new ArrayList<String>();

        /* Store element info */

        // Name
        elementInfo.add( name.get(element) );
        // Atomic number
        elementInfo.add( Integer.toString( atomicNumber.get(element), 10 ) );
        // Atomic mass
        elementInfo.add( Double.toString( molarMass.get(element) ) );
        // Molar mass
        elementInfo.add( Double.toString( molarMass.get(element) ) );
        // Return the list
        return elementInfo;
    }

    public double getMolarMass(String element) {
        return molarMass.get(element);
    }

    public int getAtomicNumber(String element) {
        return atomicNumber.get(element);
    }

    public double getAtomicMass(String element) {
        return molarMass.get(element);
    }

    public String getName(String element) {
        return name.get(element);
    }

    /**
     * Defines and returns a Map<<x>String, Double> containing the atomic/molar masses of every element on the periodic table.
     * Each element was added in order for the sake of convenience.
     * @return A Map<<x>String, Double> where the key is the atomic symbol, and the value is the atomic/molar mass. 
     * @since 0.1
     */

    private final void molarMass() {
        // Source: http://www.ptable.com
        molarMass.put("H", 1.008);
        molarMass.put("He", 4.002602);
        molarMass.put("Li", 6.94);
        molarMass.put("Be", 9.012182);
        molarMass.put("B", 10.81);
        molarMass.put("C", 12.011);
        molarMass.put("N", 14.007);
        molarMass.put("O", 15.999);
        molarMass.put("F", 18.9984032);
        molarMass.put("Ne", 20.1797);
        molarMass.put("Na", 22.98976928);
        molarMass.put("Mg", 24.305);
        molarMass.put("Al", 26.9815386);
        molarMass.put("Si", 28.085);
        molarMass.put("P", 30.973762); 
        molarMass.put("S", 32.06);
        molarMass.put("Cl", 32.45);
        molarMass.put("Ar", 39.948);
        molarMass.put("K", 39.0983);
        molarMass.put("Ca", 40.078);
        molarMass.put("Sc", 44.955912);
        molarMass.put("Ti", 47.867);
        molarMass.put("V", 50.9415);
        molarMass.put("Cr", 51.9961);
        molarMass.put("Mn", 54.938045);
        molarMass.put("Fe", 55.845);
        molarMass.put("Co", 58.933195);
        molarMass.put("Ni", 58.6934);
        molarMass.put("Cu", 63.536);
        molarMass.put("Zn", 65.38);
        molarMass.put("Ga", 69.723);
        molarMass.put("Ge", 72.63);
        molarMass.put("As", 74.92160);
        molarMass.put("Se", 78.96);
        molarMass.put("Br", 79.904);
        molarMass.put("Kr", 83.798);
        molarMass.put("Rb", 85.4678);
        molarMass.put("Sr", 87.62);
        molarMass.put("Y", 88.90585);
        molarMass.put("Zr", 91.224);
        molarMass.put("Nb", 92.90638);
        molarMass.put("Mo", 95.96);
        molarMass.put("Tc", 98.);
        molarMass.put("Ru", 101.07);
        molarMass.put("Rh", 102.90550);
        molarMass.put("Pd", 106.42);
        molarMass.put("Ag", 107.8682);
        molarMass.put("Cd", 112.411);
        molarMass.put("In", 114.818);
        molarMass.put("Sn", 118.710);
        molarMass.put("Sb", 121.760);
        molarMass.put("Te", 127.60);
        molarMass.put("I", 126.90447);
        molarMass.put("Xe", 131.293);
        molarMass.put("Cs", 132.9054519);
        molarMass.put("Ba", 137.327);
        molarMass.put("Hf", 178.49);
        molarMass.put("Ta", 180.94788);
        molarMass.put("W", 183.84);
        molarMass.put("Re", 186.207);
        molarMass.put("Os", 190.23);
        molarMass.put("Ir", 192.217);
        molarMass.put("Pt", 195.084);
        // I LOVE GOOOOOOOOOOOOLD
        molarMass.put("Au", 196.966569);
        molarMass.put("Hg", 200.59);
        molarMass.put("Tl", 204.38);
        molarMass.put("Pb", 207.2);
        molarMass.put("Bi", 208.98040);
        molarMass.put("Po", 209.);
        molarMass.put("At", 210.);
        molarMass.put("Rn", 222.);
        molarMass.put("Fr", 223.);
        molarMass.put("Ra", 226.);
        molarMass.put("Rf", 267.);
        molarMass.put("Db", 268.);
        molarMass.put("Sg", 271.);
        molarMass.put("Bh", 272.);
        molarMass.put("Hs", 270.);
        molarMass.put("Mt", 276.);
        molarMass.put("Ds", 281.);
        molarMass.put("Rg", 280.);
        molarMass.put("Cn", 285.);
        molarMass.put("Uut", 284.);
        molarMass.put("Fl", 289.);
        molarMass.put("Uup", 288.);
        molarMass.put("Lv", 293.);
        molarMass.put("Uus", 294.);
        molarMass.put("Uuo", 294.);
        molarMass.put("La", 138.90547);
        molarMass.put("Ce", 140.116);
        molarMass.put("Pr", 140.90765);
        molarMass.put("Nd", 144.242);
        molarMass.put("Pm", 145.);
        molarMass.put("Sm", 150.36);
        molarMass.put("Eu", 151.964);
        molarMass.put("Gd", 157.25);
        molarMass.put("Tb", 158.92535);
        molarMass.put("Dy", 162.500);
        molarMass.put("Ho", 164.93032);
        molarMass.put("Er", 167.259);
        molarMass.put("Tm", 168.93421);
        molarMass.put("Yb", 173.054);
        molarMass.put("Lu", 174.9668);
        molarMass.put("Ac", 227.);
        molarMass.put("Th", 232.03806);
        molarMass.put("Pa", 231.03586);
        molarMass.put("U", 238.02891);
        molarMass.put("Np", 237.);
        molarMass.put("Pu", 244.);
        molarMass.put("Am", 243.);
        molarMass.put("Cm", 247.);
        molarMass.put("Bk", 247.);
        molarMass.put("Cf", 251.);
        molarMass.put("Es", 252.);
        molarMass.put("Fm", 257.);
        molarMass.put("Md", 258.);
        molarMass.put("No", 259.);
        molarMass.put("Lr", 262.);
    }


    /**
     * Defines and returns a Map containing elements and their corresponding atomic numbers.
     * @return A Map containing elements and their atomic numbers.
     * @since 0.1
     */

    private final void atomicNumber() {
        atomicNumber.put("H",  1);
        atomicNumber.put("He", 2);
        atomicNumber.put("Li", 3);
        atomicNumber.put("Be", 4);
        atomicNumber.put("B",  5);
        atomicNumber.put("C",  6);
        atomicNumber.put("N",  7);
        atomicNumber.put("O",  8);
        atomicNumber.put("F",  9);
        atomicNumber.put("Ne", 10);
        atomicNumber.put("Na", 11);
        atomicNumber.put("Mg", 12);
        atomicNumber.put("Al", 13);
        atomicNumber.put("Si", 14);
        atomicNumber.put("P",  15); 
        atomicNumber.put("S",  16);
        atomicNumber.put("Cl", 17);
        atomicNumber.put("Ar", 18);
        atomicNumber.put("K",  19);
        atomicNumber.put("Ca", 20);
        atomicNumber.put("Sc", 21);
        atomicNumber.put("Ti", 22);
        atomicNumber.put("V",  23);
        atomicNumber.put("Cr", 24);
        atomicNumber.put("Mn", 25);
        atomicNumber.put("Fe", 26);
        atomicNumber.put("Co", 27);
        atomicNumber.put("Ni", 28);
        atomicNumber.put("Cu", 29);
        atomicNumber.put("Zn", 30);
        atomicNumber.put("Ga", 31);
        atomicNumber.put("Ge", 32);
        atomicNumber.put("As", 33);
        atomicNumber.put("Se", 34);
        atomicNumber.put("Br", 35);
        atomicNumber.put("Kr", 36);
        atomicNumber.put("Rb", 37);
        atomicNumber.put("Sr", 38);
        atomicNumber.put("Y",  39);
        atomicNumber.put("Zr", 40);
        atomicNumber.put("Nb", 41);
        atomicNumber.put("Mo", 42);
        atomicNumber.put("Tc", 43);
        atomicNumber.put("Ru", 44);
        atomicNumber.put("Rh", 45);
        atomicNumber.put("Pd", 46);
        atomicNumber.put("Ag", 47);
        atomicNumber.put("Cd", 48);
        atomicNumber.put("In", 49);
        atomicNumber.put("Sn", 50);
        atomicNumber.put("Sb", 51);
        atomicNumber.put("Te", 52);
        atomicNumber.put("I",  53);
        atomicNumber.put("Xe", 54);
        atomicNumber.put("Cs", 55);
        atomicNumber.put("Ba", 56);
        atomicNumber.put("Hf", 72);
        atomicNumber.put("Ta", 73);
        atomicNumber.put("W",  74);
        atomicNumber.put("Re", 75);
        atomicNumber.put("Os", 76);
        atomicNumber.put("Ir", 77);
        atomicNumber.put("Pt", 78);
        // I LOVE GOOOOOOOOOOOOLD
        atomicNumber.put("Au", 79);
        atomicNumber.put("Hg", 80);
        atomicNumber.put("Tl", 81);
        atomicNumber.put("Pb", 82);
        atomicNumber.put("Bi", 83);
        atomicNumber.put("Po", 84);
        atomicNumber.put("At", 85);
        atomicNumber.put("Rn", 86);
        atomicNumber.put("Fr", 87);
        atomicNumber.put("Ra", 88);
        atomicNumber.put("Rf", 104);
        atomicNumber.put("Db", 105);
        atomicNumber.put("Sg", 106);
        atomicNumber.put("Bh", 107);
        atomicNumber.put("Hs", 108);
        atomicNumber.put("Mt", 109);
        atomicNumber.put("Ds", 110);
        atomicNumber.put("Rg", 111);
        atomicNumber.put("Cn", 112);
        atomicNumber.put("Uut", 113);
        atomicNumber.put("Fl", 114);
        atomicNumber.put("Uup", 115);
        atomicNumber.put("Lv", 116);
        atomicNumber.put("Uus", 117);
        atomicNumber.put("Uuo", 118);
        atomicNumber.put("La", 57);
        atomicNumber.put("Ce", 58);
        atomicNumber.put("Pr", 59);
        atomicNumber.put("Nd", 60);
        atomicNumber.put("Pm", 61);
        atomicNumber.put("Sm", 62);
        atomicNumber.put("Eu", 63);
        atomicNumber.put("Gd", 64);
        atomicNumber.put("Tb", 65);
        atomicNumber.put("Dy", 66);
        atomicNumber.put("Ho", 67);
        atomicNumber.put("Er", 68);
        atomicNumber.put("Tm", 69);
        atomicNumber.put("Yb", 70);
        atomicNumber.put("Lu", 71);
        atomicNumber.put("Ac", 89);
        atomicNumber.put("Th", 90);
        atomicNumber.put("Pa", 91);
        atomicNumber.put("U",  92);
        atomicNumber.put("Np", 93);
        atomicNumber.put("Pu", 94);
        atomicNumber.put("Am", 95);
        atomicNumber.put("Cm", 96);
        atomicNumber.put("Bk", 97);
        atomicNumber.put("Cf", 98);
        atomicNumber.put("Es", 99);
        atomicNumber.put("Fm", 100);
        atomicNumber.put("Md", 101);
        atomicNumber.put("No", 102);
        atomicNumber.put("Lr", 103);
    }

    /**
     * Defines and returns a Map containing elements and their corresponding names.
     * @return A Map containing elements and their names.
     * @since 0.1
     */

    private final void name() {
        name.put("H",  "Hydrogen");
        name.put("He", "Helium");
        name.put("Li", "Lithuim");
        name.put("Be", "Beryllium");
        name.put("B",  "Boron");
        name.put("C",  "Carbon");
        name.put("N",  "Nitrogren");
        name.put("O",  "Oxygen");
        name.put("F",  "Flourine");
        name.put("Ne", "Neon");
        name.put("Na", "Sodium");
        name.put("Mg", "Magnesium");
        name.put("Al", "Aluminium");
        name.put("Si", "Silicon");
        name.put("P",  "Phosphorus"); 
        name.put("S",  "Sulfur");
        name.put("Cl", "Chlorine");
        name.put("Ar", "Argon");
        name.put("K",  "Potassium");
        name.put("Ca", "Calcium");
        name.put("Sc", "Scandium");
        name.put("Ti", "Titanium");
        name.put("V",  "Vanadium");
        name.put("Cr", "Chromium");
        name.put("Mn", "Manganese");
        name.put("Fe", "Iron");
        name.put("Co", "Cobalt");
        name.put("Ni", "Nickel");
        name.put("Cu", "Copper");
        name.put("Zn", "Zinc");
        name.put("Ga", "Gallium");
        name.put("Ge", "Germanium");
        name.put("As", "Arsenic");
        name.put("Se", "Selinium");
        name.put("Br", "Bromine");
        name.put("Kr", "Krypton");
        name.put("Rb", "Rubidium");
        name.put("Sr", "Strontium");
        name.put("Y",  "Yttrium");
        name.put("Zr", "Zirconium");
        name.put("Nb", "Niobium");
        name.put("Mo", "Molybdenum");
        name.put("Tc", "Technetium");
        name.put("Ru", "Ruthenium");
        name.put("Rh", "Rhodium");
        name.put("Pd", "Palladium");
        name.put("Ag", "Silver");
        name.put("Cd", "Cadmium");
        name.put("In", "Indium");
        name.put("Sn", "Tin");
        name.put("Sb", "Antimony");
        name.put("Te", "Tellurium");
        name.put("I",  "Iodine");
        name.put("Xe", "Xenon");
        name.put("Cs", "Ceaseium");
        name.put("Ba", "Barium");
        name.put("Hf", "Hafnium");
        name.put("Ta", "Tantalum");
        name.put("W",  "Tungsten");
        name.put("Re", "Rhenium");
        name.put("Os", "Osmium");
        name.put("Ir", "Iridium");
        name.put("Pt", "Platinum");
        // I LOVE GOOOOOOOOOOOOLD
        name.put("Au", "Gold");
        name.put("Hg", "Mercury");
        name.put("Tl", "Thallium");
        name.put("Pb", "Lead");
        name.put("Bi", "Bismuth");
        name.put("Po", "Polonium");
        name.put("At", "Astaline");
        name.put("Rn", "Radon");
        name.put("Fr", "Francium");
        name.put("Ra", "Radium");
        name.put("Rf", "Rutherfordium");
        name.put("Db", "Dubnium");
        name.put("Sg", "Seaborgium");
        name.put("Bh", "Bohrium");
        name.put("Hs", "Hassium");
        name.put("Mt", "Meitnerium");
        name.put("Ds", "Darmstadtium");
        name.put("Rg", "Roentgenium");
        name.put("Cn", "Copernicium");
        name.put("Uut", "Unutrium");
        name.put("Fl", "Flevroium");
        name.put("Uup", "Unupentium");
        name.put("Lv", "Livermorium");
        name.put("Uus", "Unuseptium");
        name.put("Uuo", "Ununoctium");
        name.put("La", "Lanthanum");
        name.put("Ce", "Cerium");
        name.put("Pr", "Praseodymium");
        name.put("Nd", "Neodymium");
        name.put("Pm", "Promethium");
        name.put("Sm", "Samarium");
        name.put("Eu", "Europium");
        name.put("Gd", "Gadolinium");
        name.put("Tb", "Terbium");
        name.put("Dy", "Dysprosium");
        name.put("Ho", "Holmium");
        name.put("Er", "Erbium");
        name.put("Tm", "Thulium");
        name.put("Yb", "Yttrbium");
        name.put("Lu", "Lutetium");
        name.put("Ac", "Actinium");
        name.put("Th", "Thorium");
        name.put("Pa", "Protactinium");
        name.put("U",  "Uranium");
        name.put("Np", "Neptunium");
        name.put("Pu", "Plutonium");
        name.put("Am", "Americium");
        name.put("Cm", "Curium");
        name.put("Bk", "Berkelium");
        name.put("Cf", "Califonium");
        name.put("Es", "Einsteinium");
        name.put("Fm", "Fermium");
        name.put("Md", "Mendelvium");
        name.put("No", "Nobelium");
        name.put("Lr", "Lawrenium");
    }

}

