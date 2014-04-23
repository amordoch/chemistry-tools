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
 * This class acts a container for Formula objects that represent a chemical equation. 
 * Theoretically, this class can hold as many Formula objects as there is address space, 
 * so I've set the limit to 10 reactants and products.
 * 
 * @author Ariel Mordoch
 * @version 1.0
 * @since 0.7-alpha
 */

public class Equation {

  private List<Formula> reactants;
  private List<Formula> products;
  private double ACTIVATION_ENERGY;
  

  /**
   * Default constructor, constructs and equation representing photosynthesis.
   */

  public Equation() {
    Equation eq = FtHelper.parseEquation("(6)C1O2 + (6) H2O1 ---> C6H12O6 + (6)O2");
    setReactants(eq.getReactants());
    setProducts(eq.getProducts());
    setActivationEnergy(eq.getActivationEnergy());
  }

  /**
   * This constructor should be used when creating a chemical equation via declaration. All Lists
   * should have type Formula.
   * 
   * @param listOfReactants a List representing the individual formulas contained in a chemical
   *        equation.
   * @param listOfProducts a List representing the individual products contains in a chemical
   *        equation.
   * @param activation_energy insiginificant for now
   */

  public Equation(List<Formula> listOfReactants, List<Formula> listOfProducts,
      double activation_energy) {
    setReactants(listOfReactants);
    setProducts(listOfProducts);
    setActivationEnergy(activation_energy);
  }

  /**
   * Gets the reactants of a chemical equation.
   * 
   * @return a List containing the reactants
   */

  public List<Formula> getReactants() {
    return reactants;
  }

  /**
   * Gets the products of a chemical equation.
   * 
   * @return a List containing the products
   */

  public List<Formula> getProducts() {
    return products;
  }

  public double getActivationEnergy() {
    return ACTIVATION_ENERGY;
  }

  /**
   * Sets the reactants of the current instance.
   * 
   * @param listOfReactants a List containing the reactants
   */

  public final void setReactants(List<Formula> listOfReactants) {
    reactants = listOfReactants;
  }

  /**
   * Sets the products of the current instance.
   * 
   * @param listOfProducts a List containing the products
   */

  public final void setProducts(List<Formula> listOfProducts) {
    products = listOfProducts;
    saveTheHeap();
  }


  public final void setActivationEnergy(double activation_energy) {
    ACTIVATION_ENERGY = activation_energy;
  }

  /**
   * Constructs and returns the string that was the original equation.
   * 
   * @return the string that was the original equation
   */

  public final String original() {
    String originalEq = "";
    for (Formula formula : reactants) {
      originalEq += formula.toString();
    }
    for (Formula formula : products) {
      originalEq += formula.toString();
    }
    return originalEq;
  }
  
  private final void saveTheHeap() throws UnsupportedOperationException {
    if ( reactants.size() + products.size() > 10 ) {
      throw new UnsupportedOperationException("Equation size exceeds limit");
    }
  }

}
