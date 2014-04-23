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

import java.util.List;

/**
 * This class acts as a means of representing chemical formulas as Java objects.
 * 
 * @author Ariel Mordoch
 * @version 1.5.5
 * @since 0.6.5-alpha
 */

public class Formula {

  // Formula data
  private List<String> elements;
  private List<Integer> subscripts;
  private double coefficient;
  private String bondType;

  /**
   * Default constructor, creates a Formula representing oxygen in its natural state.
   */

  public Formula() {
    Formula formula = FtHelper.parseFormula("O2");
    setElements(formula.getElements());
    setSubscripts(formula.getSubscripts());
    setCoefficient(formula.getCoefficient());
    setBondType("covalent");
  }

  /**
   * This constructor should be used when creating a Formula object by declaration.
   * 
   * @param listOfElements a List of bondType string that contains the elements of the formula
   * @param listOfSubscripts a List of bondType Integer that contains the subscripts of each element
   * @param coeff the coefficient of the formula
   * @param bondType ignore for now
   */

  public Formula(List<String> listOfElements, List<Integer> listOfSubscripts, double coeff) {
    this.elements = listOfElements;
    this.subscripts = listOfSubscripts;
    this.coefficient = coeff;
    setBondType(FtHelper.determineBondType(this));
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
   * @return a List of bondType Double containing the coefficients of the given formula
   */

  public final double getCoefficient() {
    // If there was no given coefficient, the coefficient is 1.
    return coefficient;
  }

  /**
   * Sets the elements of a formula.
   * 
   * @param listOfElements a List of bondType String containing the elements of a formula
   */

  public final void setElements(List<String> listOfElements) {
      elements = listOfElements;
  }

  /**
   * Sets the subscripts of a formula.
   * 
   * @param listOfSubscripts a List of bondType Integer containing the subscripts of a formula
   */

  public final void setSubscripts(List<Integer> listOfSubscripts) {
      subscripts = listOfSubscripts;
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

  public final String getBondType() {
    return bondType;
  }
  
  public final void setBondType(String validBondType) {
    validBondType.toLowerCase();
    if (validBondType == "covalent" || validBondType == "ionic" || validBondType == "metallic" || validBondType == "hydrogen") {
      bondType = validBondType;
    }
  }
  
  /**
   * Returns the string representation of the represented formula.
   * For example, this method would return "C6H12O6" for a Formula object that
   * represents glucose.
   */
  @Override
  public final String toString() {
    String originalFormula;
    if (coefficient == 1) {
      originalFormula = "";
    } else {
      originalFormula = "(" + coefficient + ")";
    }
    int indexOfSubscripts = 0;
    for (String element : elements) {
      originalFormula += element + subscripts.get(indexOfSubscripts);
      indexOfSubscripts++;
    }
    return originalFormula;
  }
}
