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

package com.mordoch.chemtools.util;

import java.util.List;

import com.mordoch.chemtools.formulatools.Equation;
import com.mordoch.chemtools.formulatools.Formula;
import com.mordoch.chemtools.formulatools.FtHelper;

public class Stoichiometry {

  /*
   * Mol ratios
   */

  /**
   * Computes the mol ratio of a formula relative to a given reactant.
   * 
   * @param equation an equation, as a String
   * @param relativeToReactant the index (starting at 0) of the reactant relative to which the mol
   *        ratio will be found
   * @return the mol ratio relative to the given reactant
   */

  public static double findReactantRatio(String equation, int relativeToReactant) {

    Equation parsedEquation = FtHelper.parseEquation(equation);
    Formula remove = parsedEquation.getReactants().get(relativeToReactant);
    double ratio = remove.getCoefficient();
    parsedEquation.getReactants().remove(relativeToReactant);
    for (Formula formula : parsedEquation.getReactants()) {
      ratio /= formula.getCoefficient();
    }
    parsedEquation.getReactants().add(relativeToReactant, remove);
    return ratio;

  }

  /**
   * Computes the mol ratio of a formula relative to a given reactant.
   * 
   * @param equation an Equation object
   * @param relativeToReactant the index (starting at 0) of the reactant relative to which the mol
   *        ratio will be found
   * @return the mol ratio relative to the given reactant
   */

  public static double findReactantRatio(Equation equation, int relativeToReactant) {

    Formula remove = equation.getReactants().get(relativeToReactant);
    double ratio = remove.getCoefficient();
    equation.getReactants().remove(relativeToReactant);
    for (Formula formula : equation.getReactants()) {
      ratio /= formula.getCoefficient();
    }
    equation.getReactants().add(relativeToReactant, remove);
    return ratio;

  }

  /**
   * Computes the mol ratio of a formula relative to a given product.
   * 
   * @param equation an equation, as a String
   * @param relativeToProduct the index (starting at 0) of the product relative to which the mol
   *        ratio will be found
   * @return the mol ratio relative to the given product
   */

  public static double findProductRatio(String equation, int relativeToProduct) {

    Equation parsedEquation = FtHelper.parseEquation(equation);
    Formula remove = parsedEquation.getProducts().get(relativeToProduct);
    double ratio = remove.getCoefficient();
    parsedEquation.getProducts().remove(relativeToProduct);
    for (Formula formula : parsedEquation.getProducts()) {
      ratio /= formula.getCoefficient();
    }
    parsedEquation.getProducts().add(relativeToProduct, remove);
    return ratio;

  }

  /**
   * Computes the mol ratio of a formula relative to a given product.
   * 
   * @param equation an Equation object
   * @param relativeToProduct the index (starting at 0) of the product relative to which the mol
   *        ratio will be found
   * @return the mol ratio relative to the given product
   */

  public static double findProductRatio(Equation equation, int relativeToProduct) {

    Formula removed = equation.getProducts().get(relativeToProduct);
    double ratio = removed.getCoefficient();
    equation.getProducts().remove(relativeToProduct);
    for (Formula formula : equation.getProducts()) {
      ratio /= formula.getCoefficient();
    }
    equation.getProducts().add(relativeToProduct, removed);
    return ratio;

  }

  /*
   * % Yield
   */

  /**
   * Computes the percent yield of a reaction, first by finding theoretical yield, then by
   * determining percent yield.
   * 
   * @param baseEquation the equation to work with
   * @param actualYield actual yield of the reaction
   * @param gramsOfReactant amount of reactant available to react, in grams
   * @param indexOfReactant the number, beginning with 1, of the limiting reactant
   * @param indexOfProduct the number, beginning with 1, of the product to compute percent yield of
   * @return percent yield of the given product
   */

  public static double percentYield(String baseEquation, double actualYield,
      double gramsOfReactant, int indexOfReactant, int indexOfProduct) {
    double theoreticalYield =
        theoreticalYield(baseEquation, gramsOfReactant, indexOfReactant, indexOfProduct);
    return percentYield(actualYield, theoreticalYield);
  }

  /**
   * Computes the percent yield of a reaction, first by finding theoretical yield, then by
   * determining percent yield.
   * 
   * @param equation the equation to work with
   * @param actualYield actual yield of the reaction
   * @param gramsOfReactant amount of reactant available to react, in grams
   * @param indexOfReactant the number, beginning with 1, of the limiting reactant
   * @param indexOfProduct the number, beginning with 1, of the product to compute percent yield of
   * @return percent yield of the given product
   */

  public static double percentYield(Equation equation, double actualYield, double gramsOfReactant,
      int indexOfReactant, int indexOfProduct) {
    double theoreticalYield =
        theoreticalYield(equation, gramsOfReactant, indexOfReactant, indexOfProduct);
    return percentYield(actualYield, theoreticalYield);
  }

  /**
   * Computes percent yield.
   * 
   * @param actualYield actual yield
   * @param theoreticalYield theoretical yield
   * @return percent yield
   */

  public static double percentYield(double actualYield, double theoreticalYield) {
    return actualYield / theoreticalYield;
  }

  /*
   * Theoretical yield
   */

  /**
   * Computes the theoretical yield of a product in a reaction.
   * 
   * @param baseEquation the equation to work with
   * @param gramsOfReactant amount of reactant available to react, in grams
   * @param indexOfReactant the number, beginning with 1, of the limiting reactant
   * @param indexOfProduct the number, beginning with 1, of the product to compute percent yield of
   * @return theoretical yield of the given product
   */

  public static double theoreticalYield(String baseEquation, double gramsOfReactant,
      int indexOfReactant, int indexOfProduct) {
    // indexOfReactant and indexOfProduct are expected to be a natural numbers, so subtract 1 for
    // the actual index.
    indexOfReactant -= 1;
    indexOfProduct -= 1;
    Equation parsedEquation = FtHelper.parseEquation(baseEquation);
    List<Formula> reactants = parsedEquation.getReactants();
    List<Formula> products = parsedEquation.getProducts();
    // First find the mol ratio relative to the reactant given
    double ratio = findProductRatio(parsedEquation, indexOfProduct);
    // Find the moles of reactant
    String reactant = reactants.get(indexOfReactant).toString();
    double reactantMolarMass = Analysis.computeMolarMass(reactant);
    double molesOfReactant = Conversions.massToMols(gramsOfReactant, reactantMolarMass);
    // Get the molar mass of the product and use the formula to find theoretical yield.
    String product = products.get(indexOfProduct).toString();
    double productMolarMass = Analysis.computeMolarMass(product);
    double molesOfProduct = molesOfReactant * ratio;
    double theoreticalYield = Conversions.molsToMass(molesOfProduct, productMolarMass);
    return theoreticalYield;

  }

  /**
   * Computes the theoretical yield of a product in a reaction.
   * 
   * @param equation the equation to work with
   * @param gramsOfReactant amount of reactant available to react, in grams
   * @param indexOfReactant the number, beginning with 1, of the limiting reactant
   * @param indexOfProduct the number, beginning with 1, of the product to compute percent yield of
   * @return theoretical yield of the given product
   */

  public static double theoreticalYield(Equation equation, double gramsOfReactant,
      int indexOfReactant, int indexOfProduct) {
    // indexOfReactant and indexOfProduct are expected to be a natural numbers, so subtract 1 for
    // the actual index.
    indexOfReactant -= 1;
    indexOfProduct -= 1;
    List<Formula> reactants = equation.getReactants();
    List<Formula> products = equation.getProducts();
    // First find the mol ratio relative to the reactant given
    double ratio = findProductRatio(equation, indexOfProduct);
    // Find the moles of reactant
    String reactant = reactants.get(indexOfReactant).toString();
    double reactantMolarMass = Analysis.computeMolarMass(reactant);
    double molesOfReactant = Conversions.massToMols(gramsOfReactant, reactantMolarMass);
    // Get the molar mass of the product and use the formula to find theoretical yield.
    String product = products.get(indexOfProduct).toString();
    double productMolarMass = Analysis.computeMolarMass(product);
    double molesOfProduct = molesOfReactant * ratio;
    double theoreticalYield = Conversions.molsToMass(molesOfProduct, productMolarMass);
    return theoreticalYield;

  }

}
