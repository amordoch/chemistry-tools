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

/**
 * This class parses certain data, such as formulas, and contains getters relevant to that parsed
 * data.
 * 
 * @author Ariel Mordoch
 * @version 1.5
 * @since 0.6.5-alpha
 */

public class Formula {

  /**
   * This constructor is used when passing a formula through
   * {@link FormulaHelper#parseFormula(String)}. Type serves no purpose yet.
   * 
   * @param aType the type of a formula ("Ionic", "Covalent", or "Metallic")
   */

  public Formula(String aType) {
    this.type = aType;
  }

  /**
   * This constructor should be used when creating a Formula object by declaration.
   * 
   * @param listOfElements a List of type string that contains the elements of the formula
   * @param listOfSubscripts a List of type Integer that contains the subscripts of each element
   * @param listOfCoefficients a List of type Double that contains the coefficients of each element
   *        (an empty list is fine)
   * @param type ignore for now
   */

  public Formula(List<String> listOfElements, List<Integer> listOfSubscripts,
      List<Double> listOfCoefficients, String type) {
    this.type = type;
    this.elements = listOfElements;
    this.subscripts = listOfSubscripts;
    this.coefficients = listOfCoefficients;
  }

  // Formula data
  private List<String> elements = new ArrayList<String>();
  private List<Integer> subscripts = new ArrayList<Integer>();
  private List<Double> coefficients = new ArrayList<Double>();
  private String type;
  
  /**
   * Gets the elements of a formula.
   * 
   * @return the elements of a formula (in the above example, it would return ["C", "H", "O"])
   */

  public final List<String> getElements() {
    if (elements.isEmpty()) {
      elements = null;
    }
    return elements;
  }

  /**
   * Gets the subscripts of each element in a formula.
   * 
   * @return the subscripts of each element in that formula (in the above case, it would return [6,
   *         12, 6])
   */

  @SuppressWarnings("unused")
  public final List<Integer> getSubscripts() {
    // If subscripts is empty, add 1's corresponding to the amount of elements in the formula
    if (subscripts.isEmpty()) {
      for (String element : elements) {
        subscripts.add(1);
      }
    }
    return subscripts;
  }

  /**
   * Gets the coefficients of a given formula, provided they are contained within parentheses.
   * 
   * @return a List of type Double containing the coefficients of the given formula
   */

  @SuppressWarnings("unused")
  public final List<Double> getCoefficients() {
    // If there were no coefficients, add 1.0 to coefficients corresponding to the amount of
    // elements in a formula.
    if (coefficients.isEmpty()) {
      for (String element : elements) {
        coefficients.add(1.0);
      }
    }
    return coefficients;
  }

  /**
   * Sets the elements of a formula.
   * 
   * @param listOfElements a List of type String containing the elements of a formula
   */

  public final void setElements(List<String> listOfElements) {
    if (elements.isEmpty()) {
      for (String element : listOfElements) {
        elements.add(element);
      }
    }
  }

  /**
   * Sets the subscripts of a formula.
   * 
   * @param listOfSubscripts a List of type Integer containing the subscripts of a formula
   */

  public final void setSubscripts(List<Integer> listOfSubscripts) {
    if (subscripts.isEmpty()) {
      for (int subscript : listOfSubscripts) {
        subscripts.add(subscript);
      }
    }
  }

  /**
   * Sets the coefficients of a formula. If a formula contains no subscripts, an array of a length
   * corresponding to the amount of elements and filled with 1's is fine.
   * 
   * @param listOfCoefficients a List of type Double containing the coefficients of a formula
   */

  public final void setCoefficients(List<Double> listOfCoefficients) {
    if (coefficients.isEmpty()) {
      for (double coefficient : listOfCoefficients) {
        coefficients.add(coefficient);
      }
    }
  }

  public final String getType() {
    return type;
  }

}
