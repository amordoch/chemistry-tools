/*
 * Copyright Ariel Mordoch 2014 
 * This file is part of Chemistry Tools.
 * 
 * Chemistry Tools is free software: you can redistribute it and/or modify it under the terms of the
 * Lesser GNU General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 * 
 * Chemistry Tools is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Lesser GNU General Public License for more details.
 * 
 * You should have received a copy of the Lesser GNU General Public License along with Chemistry
 * Tools. If not, see <http://www.gnu.org/licenses/>.
 */

package com.mordoch.chemtools.formulatools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mordoch.chemtools.util.elementinfo.ElementInfo;

/**
 * The sole purpose of this class is to offload excess methods from Formula.
 * 
 * @author Ariel Mordoch
 * @version 1.5
 * @since 0.6.8-alpha
 */

public class FtHelper {

  private static Map<String, Double> massList = ElementInfo.mass.unwrap();
  private static Map<String, String> typeList = ElementInfo.type.unwrap();


  /**
   * This method takes a string such as "C6H12O6" and adds the elements, subscripts, and
   * coefficients into a Formula object. This makes it much easier to get relevant data like the
   * elements in the formula and their subscripts later. There are a number of rules to follow:
   * <ol>
   * <li>If a formula contains only 1 atom of a given element and multiple atoms of another element,
   * it must be explicitly stated, e.g. carbon dioxide becomes "C1O2".</li>
   * <li>If a formula contains a coefficient, it must be written within parenthesis, e.g. "(.5)O2"</li>
   * <li>Fractional coefficients must be input as decimals.</li>
   * </ol>
   * 
   * @param formulaToParse a string such as "C6H12O6" to parse
   * @return a Formula object representing formulaToParse
   */

  public static Formula parseFormula(String formulaToParse) {
    // Convert the string to an array of chars
    char[] asCharArray = formulaToParse.toCharArray();

    /************** COEFFICIENT **************/
    // Starting character for search is '(', ending character is ')'
    double coefficient = 1;

    for (int index = 0; index < asCharArray.length; index++) {
      // Is the element '('? If so, loop through until we find ')'
      if (asCharArray[index] == '(') {
        // Set the '(' to '/'
        asCharArray[index] = '/';
        String finalValue = "";
        // Loop until we find ')'
        int indexForWhile = index + 1;
        while (asCharArray[indexForWhile] != ')') {
          finalValue += Character.toString(asCharArray[indexForWhile]);
          // Set the character to '/'
          asCharArray[indexForWhile] = '/';
          indexForWhile++;
        }
        // Since the current char is ')', set it to '/'
        asCharArray[indexForWhile] = '/';
        // Now that we've constructed a number, that's the coefficient.
        coefficient = Double.parseDouble(finalValue);
      }
    }

    /************** SUBSCRIPTS **************/

    List<Integer> listOfSubscripts = new ArrayList<Integer>();

    for (int index = 0; index < asCharArray.length; index++) {
      // A pattern to compare the current char to.
      String possibleDigits = "0123456789";
      // The string that holds what will be an integer.
      String finalValue = "";
      // If the current character is an integer, then continue, otherwise, start the next iteration.
      if (possibleDigits.indexOf(asCharArray[index]) != -1) {
        // Since we are going to loop until we find a character that isn't an integer, the while
        // loop requires is own index value.
        int indexForWhile = index;
        // This test is used so many times that I'll just test out here.
        boolean currentCharIsAnInt = possibleDigits.indexOf(asCharArray[indexForWhile]) != -1;
        // As long as the char on the current iteration is an integer, loop.
        while (currentCharIsAnInt) {
          // If this is the last index, add the int value to finalValue and then stop looping.
          if (indexForWhile == asCharArray.length - 1) {
            finalValue += asCharArray[indexForWhile];
            asCharArray[indexForWhile] = '/';
            break;
          } else {
            finalValue += Character.toString(asCharArray[indexForWhile]);
            asCharArray[indexForWhile] = '/';
            indexForWhile++;
            // Since we just advanced the index, check if current char is an int again.
            currentCharIsAnInt = possibleDigits.indexOf(asCharArray[indexForWhile]) != -1;
          }
        }
        listOfSubscripts.add(Integer.parseInt(finalValue));
      }
    }

    /************** ELEMENTS **************/

    List<String> listOfElements = new ArrayList<String>();

    for (int index = 0; index < asCharArray.length; index++) {
      // If this is the last index, skip the two-letter symbol check
      if (index == asCharArray.length - 1) {
        if (asCharArray[index] != '/') {
          // Concatenate the two characters then add to elements
          listOfElements.add(Character.toString(asCharArray[index]));
          // Discard element
          asCharArray[index] = '/';
        }
      } else {
        // If element has a two-letter symbol
        if (asCharArray[index] != '/' && asCharArray[index + 1] != '/') {
          // An input like CO will test true, so start a try/catch
          boolean isSingleElement = false;
          // Try getting the molar mass. If it doesn't exist, we know we have a single element, so
          // set isSingleElement to true.
          try {
            String molarMassToGet = Character.toString(asCharArray[index]) + Character.toString(asCharArray[index + 1]); 
            massList.get(molarMassToGet);
          } catch (NullPointerException e) {
            listOfElements.add(Character.toString(asCharArray[index]));
            isSingleElement = true;
          }
          // If we have a single element, don't run this code
          if (!isSingleElement) {
            // Concatenate the two characters then add to parsedFormula
            listOfElements.add(Character.toString(asCharArray[index])
                + Character.toString(asCharArray[index + 1]));
            // Discard the elements
            asCharArray[index] = '/';
            asCharArray[index + 1] = '/';
          }
        } else if (asCharArray[index] != '/') {
          // Add to to parsedFormula
          listOfElements.add(Character.toString(asCharArray[index]));
          // Discard element
          asCharArray[index] = '/';
        }

      }
    }

    /************** RETURN **************/

    Formula parsedFormula = new Formula(listOfElements, listOfSubscripts, coefficient);
    // Return the Formula object
    return parsedFormula;
  }

  /**
   * Takes an equation in string form, such as "H2 + (.5)O2 ---&gt; H2O1", and returns an Equation
   * object representing that equation. This method splits the reactants and products into
   * individual formulas using {@link FtHelper#parseFormula(String)}, so keep in mind that the
   * equation's parts must be syntactically compatible with it. <strong>In order for this method
   * function, the reactants and products must be separated by the sequence '---&gt;' exactly.</strong>
   * 
   * @param equationToParse a string containing the equation to parse
   * @return an Equation object representing the given equation
   */

  public static Equation parseEquation(String equationToParse) {
    //Equation parsedEquation = new Equation(Double.NaN);
    // Sample: H2 + (.5)O2 ---> H2O1
    // Split the 2 sides of the equation
    String[] splitEquation = equationToParse.split("--->");
    // Now split into individual formulas (remove spaces so as not to confuse parseFormula)
    String allReactants = splitEquation[0].replaceAll("\\s", "");
    String allProducts = splitEquation[1].replaceAll("\\s", "");
    String[] individualReactants = allReactants.split("\\+");
    String[] individualProducts = allProducts.split("\\+");
    // Now parse each reactant & product and put them into their respective list
    List<Formula> reactants = new ArrayList<Formula>();
    List<Formula> products = new ArrayList<Formula>();
    for (String reactant : individualReactants) {
      reactants.add(parseFormula(reactant));
    }
    for (String product : individualProducts) {
      products.add(parseFormula(product));
    }
    // Build the Equation object and return
    Equation parsedEquation = new Equation(reactants, products, Double.NaN);
    return parsedEquation;
  }
  
  /**
   * Determines the bond type of a formula by evaluating what types of elements
   * make up that formula. This following the logic employed:
   * <ul>
   *    <li>If the formula contains hydrogen and is only composed of 2 elements, the bond is a hydrogen bond.</li>
   *    <li>If the formula contains metals and nonmetals, the bond is covalent.</li>
   *    <li>If the formula contains only metals, the bond is metallic.</li>
   *    <li>If the formula contains only nonmetals, the bond is covalent.</li>
   * </ul>
   * 
   * @param formula the formula for which to determine the bond type
   * @return the bond type, as a String
   */
  
  public static String determineBondType(Formula formula) {
    
    List<String> elements = formula.getElements();
    List<String> elementTypes = new ArrayList<String>();
    for (String element : elements) {
      elementTypes.add(typeList.get(element));
    }
    String bondType = null;
    if (elementTypes.contains("Hydrogen") && elements.size() <= 2) {
      bondType = "hydrogen";
      return bondType;
    }
    if (elementTypes.contains("Metal") && elementTypes.contains("Nonmetal")) {
      bondType = "ionic";
    } else if(elementTypes.contains("Metal") && !elementTypes.contains("Nonmetal")) {
      bondType = "metallic";
    } else if(elementTypes.contains("Nonmetal")&& !elementTypes.contains("Metal")) {
      bondType = "covalent";
    }
    return bondType;

  }

}
