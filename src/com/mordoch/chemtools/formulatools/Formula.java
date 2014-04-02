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
 * This class acts as a means of representing chemical formulas as Java objects.
 * 
 * @author Ariel Mordoch
 * @version 1.5.1
 * @since 0.6.5-alpha
 */

public class Formula {

  // Formula data
  private List<String> elements = new ArrayList<String>();
  private List<Integer> subscripts = new ArrayList<Integer>();
  private double coefficient;
  private String type;

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
   * @param coeff the coefficient of the formula
   * @param type ignore for now
   */

  public Formula(List<String> listOfElements, List<Integer> listOfSubscripts, double coeff,
      String type) {
    this.type = type;
    this.elements = listOfElements;
    this.subscripts = listOfSubscripts;
    this.coefficient = coeff;
  }

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

  public final double getCoefficient() {
    // If there was no given coefficient, the coefficient is 1.
    return coefficient;
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
   * @param aCoefficient the coefficient of the formula
   */

  public final void setCoefficient(double aCoefficient) {
    if (aCoefficient == 0) {
      coefficient = 1;
    } else {
      coefficient = aCoefficient;
    }
  }

  public final String getType() {
    return type;
  }

  public final String original() {
    String originalFormula = "(" + coefficient + ")";
    int indexOfSubscripts = 0;
    for (String element : elements) {
      originalFormula += element + subscripts.get(indexOfSubscripts);
      indexOfSubscripts++;
    }
    return originalFormula;
  }
}
