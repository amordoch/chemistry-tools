/*
 * Copyright Ariel Mordoch 2014 This file is part of Chemistry Tools.
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

package com.mordoch.chemtools.util;

import java.util.ArrayList;
import java.util.List;

/**
 * This class parses certain data, such as formulas, and contains getters relevant to that parsed
 * data.
 * 
 * @author Ariel Mordoch
 * @version 1.0
 * @since 0.6.5-alpha
 */

public class Parser {

  private LookupTable lookup = new LookupTable();

  /* FORMULAE THAT CONTAIN ONE ATOM OF AN ELEMENT MUST EXPLICITLY CONTAIN A 1 AFTER THE ELEMENT. */

  /**
   * This method takes a string such as "C6H12O6" and separates the formula into a List. This makes
   * it much easier to get relevant data like the elements in the formula and their subscripts
   * later. There are a number of rules to follow:
   * <ol>
   * <li>If a formula contains only 1 atom of a given element and multiple atoms of another element,
   * it must be explicitly stated, e.g. carbon dioxide become "C1O2".</li>
   * <li>If a formula contains a coefficient, it must be written within parenthesis, e.g. "(.5)O2"</li>
   * <li>Fractional coefficients must be input as decimals.</li>
   * <li>If you have multiple moles of a particular molecule, you must distribute the two across
   * each element. For example, if you had 2 moles of Glucose, the input would be
   * "(2)C6(2)H12(2)O6".</li>
   * </ol>
   * 
   * @param formula a string such as "C6H12O6" to parse
   * @return a List<<x>Object> containing the coefficients first (as a List<<x>Double>) subscripts
   *         first (as ints), then the elements (as Strings).
   */

  private List<Object> parseSimpleFormula(String formula) {

    // First create a list of Objects that hold formula data
    List<Object> parsedFormula = new ArrayList<Object>();
    // Convert the string to an array of chars
    char[] asCharArray = formula.toCharArray();

    /************** COEFFICIENTS **************/

    // Starting character for coefficient search '(', ending character ')'
    List<Double> coefficients = new ArrayList<Double>();
    // Loop through the array
    for (int index = 0; index < asCharArray.length; index++) {
      // Is the element '('? If so, loop through until we find ')'
      if (asCharArray[index] == '(') {
        // Set the '(' to '/'
        asCharArray[index] = '/';
        // A string that holds the final value of the integer
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
        // Now that we've constructed a number, add it to finalValue.
        coefficients.add(Double.parseDouble(finalValue));
      }
    }
    // Add coefficients to parsedFormula
    parsedFormula.add(coefficients);

    /************** SUBSCRIPTS **************/

    // Now loop to find the integers that are subscripts
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
        // Final value is constructed, so add finalValue to parsedFormula
        parsedFormula.add(Integer.parseInt(finalValue));
      }

    }

    /************** ELEMENTS **************/

    // Now loop to find elements
    for (int index = 0; index < asCharArray.length; index++) {
      // If this is the last index, skip the two-letter symbol check
      if (index == asCharArray.length - 1) {
        if (asCharArray[index] != '/') {
          // Concatenate the two characters then add to parsedFormula
          parsedFormula.add(Character.toString(asCharArray[index]));
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
            lookup.getMolarMass(Character.toString(asCharArray[index])
                + Character.toString(asCharArray[index + 1]));
          } catch (NullPointerException e) {
            parsedFormula.add(Character.toString(asCharArray[index]));
            isSingleElement = true;
          }
          // If we have a single element, don't run this code
          if (!isSingleElement) {
            // Concatenate the two characters then add to parsedFormula
            parsedFormula.add(Character.toString(asCharArray[index])
                + Character.toString(asCharArray[index + 1]));
            // Discard the elements
            asCharArray[index] = '/';
            asCharArray[index + 1] = '/';
          }
        } // If element is a single-letter symbol
        else if (asCharArray[index] != '/') {
          // Add to to parsedFormula
          parsedFormula.add(Character.toString(asCharArray[index]));
          // Discard element
          asCharArray[index] = '/';
        }

      }
    }

    /************** RETURN **************/

    // No need for asCharArray anymore, so scrap it
    asCharArray = null;
    // Return parsed formula
    return parsedFormula;
  }

  /**
   * Gets the elements of a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @return the elements of a formula (in the above example, it would return ["C", "H", "O"])
   */

  public List<String> getElements(String formula) {
    List<Object> parsedFormula = parseSimpleFormula(formula);
    List<String> elements = new ArrayList<String>();
    for (Object element : parsedFormula) {
      if (element.getClass().equals(String.class)) {
        elements.add((String) element);
      }
    }
    if (elements.isEmpty()) {
      elements = null;
    }
    return elements;
  }

  /**
   * Gets the subscripts of each element in a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @return the subscripts of each element in that formula (in the above case, it would return [6,
   *         12, 6])
   */

  public List<Integer> getSubscripts(String formula) {
    List<Object> parsedFormula = parseSimpleFormula(formula);
    List<Integer> subscripts = new ArrayList<Integer>();
    for (Object subscript : parsedFormula) {
      if (subscript.getClass().equals(Integer.class)) {
        subscripts.add((Integer) subscript);
      }
    }
    // If subscripts is empty, add 1's corresponding to the amount of elements in the formula
    if (subscripts.isEmpty()) {
      for (Object element : parsedFormula) {
        if (element.getClass().equals(String.class)) {
          subscripts.add(1);
        }
      }
    }
    return subscripts;
  }

  /**
   * Gets the coefficients of a given formula, provided they are contained within parentheses.
   * 
   * @param formula a formula represented by a string, for example (2)Na(2)Cl
   * @return a List of type Double containing the coefficients of the given formula
   */

  @SuppressWarnings("unchecked")
  public List<Double> getCoefficients(String formula) {
    List<Double> coefficients = (List<Double>) parseSimpleFormula(formula).get(0);
    // If there were no coefficients, add 1.0 to coefficients corresponding to the amount of
    // elements in a formula.
    if (coefficients.isEmpty()) {
      for (Object element : parseSimpleFormula(formula)) {
        if (element.getClass().equals(String.class)) {
          coefficients.add(1.0);
        }
      }
    }
    return coefficients;
  }
}
