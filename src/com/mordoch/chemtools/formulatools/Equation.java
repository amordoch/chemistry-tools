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
 * This class acts a container for Formula objects that represent a chemical equation. Currently
 * supports up to 2 reactants and 2 products (theoretically, it could support as many reactants and
 * products as the JVM can handle, but for now, 2 of each is fine).
 * 
 * @author Ariel Mordoch
 * @version 1.0
 * @since 0.7-alpha
 */

public class Equation {

  private Formula reactant1;
  private Formula reactant2;
  private Formula product1;
  private Formula product2;
  private double ACTIVATION_ENERGY;

  /**
   * This constuctor is used with {@link FormulaHelper#parseEquation(String)}.
   * 
   * @param activation_energy doesn't matter yet
   */

  public Equation(double activation_energy) {
    ACTIVATION_ENERGY = activation_energy;
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
    List<Formula> allReactants = new ArrayList<Formula>();
    allReactants.add(reactant1);
    allReactants.add(reactant2);
    return allReactants;
  }

  /**
   * Gets the products of a chemical equation.
   * 
   * @return a List containing the products
   */

  public List<Formula> getProducts() {
    List<Formula> allProducts = new ArrayList<Formula>();
    allProducts.add(product1);
    allProducts.add(product2);
    return allProducts;
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
    reactant1 = listOfReactants.get(0);
    reactant2 = listOfReactants.get(1);
  }

  /**
   * Sets the products of the current instance.
   * 
   * @param listOfProducts a List containing the products
   */

  public final void setProducts(List<Formula> listOfProducts) {
    if (listOfProducts.size() == 1) {
      product1 = listOfProducts.get(0);
    } else {
      product1 = listOfProducts.get(0);
      product2 = listOfProducts.get(1);
    }
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
    if (product2 == null) {
      originalEq +=
          reactant1.original() + " " + "+" + " " + reactant2.original() + " " + "--->" + " "
              + product1.original();
    } else {
      originalEq +=
          reactant1.original() + " " + "+" + " " + reactant2.original() + " " + "--->" + " "
              + product1.original() + " " + product2.original();
    }
    return originalEq;
  }

}
