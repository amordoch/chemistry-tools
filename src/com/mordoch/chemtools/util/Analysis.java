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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mordoch.chemtools.Main;
import com.mordoch.chemtools.formulatools.Equation;
import com.mordoch.chemtools.formulatools.Formula;
import com.mordoch.chemtools.formulatools.FtHelper;
import com.mordoch.chemtools.util.elementinfo.ElementInfo;

/**
 * This class contains tools for analysis, i.e. finding empirical formula given percent composition.
 * 
 * @author Ariel Mordoch
 * @version 0.7
 * @see Main
 * @since 0.1
 */

public class Analysis {

  private static Map<String, Double> mass = ElementInfo.mass.unwrap();

  /**
   * This method takes 3 percents and 3 elements and finds the empirical formula for a compound
   * containing those elements (the molar masses of each element are found automatically. The user
   * must provide the element's symbol, i.e. "H").
   * <p>
   * <b> Note that this method does not check whether one of the normalized subscripts are decimals.
   * </b>
   * </p>
   * <em>An additional method of the same name can find the empirical formula of a compound with two elements rather than three.</em>
   * 
   * @param percent1 the percent of element 1 in compound X
   * @param percent2 the percent of a second element in compound X
   * @param percent3 the percent of a third element in compound X
   * @param element1 the symbol, i.e. "H", of the element corresponding to percent1
   * @param element2 the symbol, i.e. "H", of the element corresponding to percent2
   * @param element3 the symbol, i.e. "H", of the element corresponding to percent3
   * @return empirical formula <b>without correction for decimal subscripts</b>.
   * @since 0.1
   */

  public static Formula empiricalFromPercentComposition(double percent1, double percent2,
      double percent3, String element1, String element2, String element3) {
    // First find the mols of each element then find which one is smallest.
    double element1Mols = percent1 / mass.get(element1);
    double element2Mols = percent2 / mass.get(element2);
    double element3Mols = percent3 / mass.get(element3);
    double normalize = Math.min(element1Mols, Math.min(element2Mols, element3Mols));
    // Now normalize the formula.
    double element1Normal = element1Mols / normalize;
    double element2Normal = element2Mols / normalize;
    double element3Normal = element3Mols / normalize;
    // Now construct and return the completed formula.
    List<String> elements = new ArrayList<String>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);
    List<Integer> subscripts = new ArrayList<Integer>();
    subscripts.add((int) Math.round(element1Normal));
    subscripts.add((int) Math.round(element2Normal));
    subscripts.add((int) Math.round(element3Normal));
    Formula empiricalFormula = new Formula(elements, subscripts, 1);
    return empiricalFormula;
  }

  /**
   * This method takes 2 percents and 2 elements and finds the empirical formula for a compound
   * containing those elements (the molar masses of each element are found automatically. The user
   * must provide the element's symbol, i.e. "H").
   * <p>
   * <b> Note that this method does not check whether one of the normalized subscripts are decimals.
   * </b>
   * </p>
   * <em>An additional method of the same name can find the empirical formula of a compound with three elements rather than two.</em>
   * 
   * @param percent1 the percent of element 1 in compound X
   * @param percent2 the percent of a second element in compound X
   * @param element1 the symbol, i.e. "H", of the element corresponding to percent1
   * @param element2 the symbol, i.e. "H", of the element corresponding to percent2
   * @return empirical formula <b>without correction for decimal subscripts</b>.
   * @since 0.2
   */

  public static Formula empiricalFromPercentComposition(double percent1, double percent2,
      String element1, String element2) {
    // First find the mols of each element then find which one is smallest.
    double element1Mols = percent1 / mass.get(element1);
    double element2Mols = percent2 / mass.get(element2);
    double normalize = Math.min(element1Mols, element2Mols);
    // Now normalize the formula.
    final double element1Normal = element1Mols / normalize;
    final double element2Normal = element2Mols / normalize;
    // Now construct the formula and return.
    List<Integer> subscripts = new ArrayList<Integer>();
    subscripts.add((int) Math.round(element1Normal));
    subscripts.add((int) Math.round(element2Normal));
    List<String> elements = new ArrayList<String>();
    elements.add(element1);
    elements.add(element2);
    Formula empiricalFormula = new Formula(elements, subscripts, 1.0);
    return empiricalFormula;
  }

  /**
   * This method takes the total mass of a compound and its three elements and determines the
   * empirical formula of that compound. Employs the empiricalFromPercentComposition method to work.
   * <p>
   * <b> Note that this method does not check whether one of the normalized subscripts are decimals.
   * </b>
   * </p>
   * <em>An additional method of the same name can find the empirical formula of a compound with two elements rather than three.</em>
   * 
   * @param mass1 the mass of an element in compound X
   * @param mass2 the mass of a second element in compound X
   * @param mass3 the mass of a third element in compound X
   * @param element1 the element that corresponds to mass1
   * @param element2 the element that corresponds to mass2
   * @param element3 the element that corresponds to mass3
   * @return empirical formula, <b>without correcting for decimal subscripts</b>
   * @see Analysis#empiricalFromPercentComposition(double, double, double, String, String, String)
   * @since 0.2
   */

  public static Formula empiricalFromMass(double mass1, double mass2, double mass3,
      String element1, String element2, String element3) {
    // First find the percent composition
    double element1Percent = mass1 / mass.get(element1);
    double element2Percent = mass2 / mass.get(element2);
    double element3Percent = mass3 / mass.get(element3);
    // Now find empirical formula (there's already a method for this, so why not use it?).
    return empiricalFromPercentComposition(element1Percent, element2Percent, element3Percent,
        element1, element2, element3);
  }

  /**
   * This method takes the total mass of a compound and its two elements and determines the
   * empirical formula of that compound. Employs the empiricalFromPercentComposition method to work.
   * <p>
   * <b> Note that this method does not check whether one of the normalized subscripts are decimals.
   * </b>
   * </p>
   * <em>An additional method of the same name can find the empirical formula of a compound with three elements rather than two.</em>
   * 
   * @param mass1 the mass of an element in compound X
   * @param mass2 the mass of a second element in compound X
   * @param element1 the element that corresponds to mass1
   * @param element2 the element that corresponds to mass2
   * @return empirical formula, <b>without correcting for decimal subscripts</b>
   * @see Analysis#empiricalFromPercentComposition(double, double, String, String)
   * @since 0.2
   */

  public static Formula empiricalFromMass(double mass1, double mass2, String element1,
      String element2) {
    // First find the percent composition
    double element1Percent = mass1 / mass.get(element1);
    double element2Percent = mass2 / mass.get(element2);
    // Now find empirical formula
    return empiricalFromPercentComposition(element1Percent, element2Percent, element1, element2);
  }

  /**
   * This method takes a formula and the molar mass of a molecular formula and finds the subscripts
   * of the molecular formula. For example, molecularFromEmpirical("CH2O", 180.156) returns [6, 12,
   * 6].
   * 
   * @param empiricalFormula a chemical formula syntactically compatible with
   *        Parser#parseSimpleFormula
   * @param molarMassCompound the molar mass of a compound
   * @return a Formula representing the molecular formula
   * @since 0.3
   */

  public static final Formula molecularFromEmpirical(String empiricalFormula,
      double molarMassCompound) {
    Formula parsedFormula = FtHelper.parseFormula(empiricalFormula);
    // Get the molar mass and subscripts of the empirical formula
    double molarMassEmpirical = computeMolarMass(empiricalFormula);
    List<Integer> subscripts = parsedFormula.getSubscripts();
    // First, find the factor of the molecular formula
    double multiplier = molarMassCompound / molarMassEmpirical;
    // Create a new ArrayList of doubles to store the multiplied subscripts
    List<Double> newSubscripts = new ArrayList<Double>();
    // Create an array of ints to store the correct, rounded subscripts
    List<Integer> roundedSubscripts = new ArrayList<Integer>();
    // Loop through the original subscripts
    for (int index = 0; index < subscripts.size(); index++) {
      // Multiply the subscript by the multiplier and store it in newSubscripts
      newSubscripts.add(subscripts.get(index) * multiplier);
      // Round that off so it's proper
      roundedSubscripts.add((int) Math.round(newSubscripts.get(index)));
    }
    List<String> elements = parsedFormula.getElements();
    // Construct the molecular formula
    Formula molecularFormula =
        new Formula(elements, roundedSubscripts, parsedFormula.getCoefficient());
    return molecularFormula;
  }

  /**
   * This method finds the empirical formula from a given molecular formula, using GCD. <strong>Note
   * that the method used to find GCD, which is based off Euclid's algorithm, can err.</strong>
   * 
   * @param formula a molecular formula
   * @return the empirical formula, in the form of a Formula object
   */

  public static final Formula empiricalFromMolecular(String formula) {
    int gcd = Integer.MAX_VALUE;
    Formula empiricalFormula = FtHelper.parseFormula(formula);
    List<Integer> subscripts = empiricalFormula.getSubscripts();
    // We'll find GCDs in pairs and store them in tryGCD
    int[] tryGcd = new int[10];
    for (int x = 0; x < subscripts.size() - 1; x++) {
      // First find the initial min and max of the pair.
      int min = Math.min(subscripts.get(x), subscripts.get(x + 1));
      int max = Math.max(subscripts.get(x), subscripts.get(x + 1));
      // Now loop and use the algorithm.
      for (int y = 0; y < 1000; y++) {
        max -= min;
        min = Math.min(max, min);
        max = Math.max(max, min);
        if (max == min) {
          tryGcd[x] = min;
          break;
        }
      }
    }
    // Loop through tryGCD, find the smallest GCD that isn't 0, and set GCD to it.
    for (int candidateGcd : tryGcd) {
      if (candidateGcd != 0) {
        if (candidateGcd < gcd) {
          gcd = candidateGcd;
        }
      }
    }
    // Now that we finally have the GCD, divide the subscripts by it
    // and return the empirical formula.
    List<Integer> newSubscripts = new ArrayList<Integer>();
    for (int subscript : subscripts) {
      newSubscripts.add(subscript / gcd);
    }
    empiricalFormula.setSubscripts(newSubscripts);
    return empiricalFormula;
  }

  /**
   * Computes the percent composition of a formula.
   * 
   * @param formula
   * @return
   */

  public static double[] computePercentComposition(String formula) {

    Formula parsedFormula = FtHelper.parseFormula(formula);
    List<Integer> subscripts = parsedFormula.getSubscripts();
    List<String> elements = parsedFormula.getElements();
    double[] percents = new double[elements.size()];
    double molarMass = computeMolarMass(formula);
    for (int index = 0; index < elements.size(); index++) {
      percents[index] = subscripts.get(index) * mass.get(elements.get(index)) / molarMass * 100;
    }
    return percents;
  }

  /**
   * Computes the mass composition of a formula.
   * 
   * @param formula a formula, such as "H2O1"
   * @return a double[] containing the mass composition of each element in the formula
   */

  public static double[] computeMassComposition(String formula, double massOfFormula) {

    double[] percentComposition = computePercentComposition(formula);
    double[] masses = new double[percentComposition.length];

    int c = 0;
    for (double percent : percentComposition) {
      masses[c] = (percent / 100) * massOfFormula;
      c++;
    }
    return masses;

  }

  /**
   * Computes the molar mass of a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @return the molar mass of the given formula
   */

  public static double computeMolarMass(String formula) {
    Formula parsedFormula = FtHelper.parseFormula(formula);
    // First get the subscripts, elements, and coefficients from the forumula and declare a variable
    // that stores molar mass.
    List<Integer> subscripts = parsedFormula.getSubscripts();
    List<String> elements = parsedFormula.getElements();
    double molarMass = 0;
    // Now loop through the elements. Each iteration, multiply the subscript by the molar mass of
    // the element and its coefficient and add to molarMass.
    // Note that the given formula must be syntactically compatible with
    // Parser#parseFormula().
    for (int index = 0; index < elements.size(); index++) {
      molarMass += subscripts.get(index) * mass.get(elements.get(index));
    }
    // Now discard all the objects and return.
    parsedFormula = null;
    subscripts = null;
    elements = null;
    return molarMass;
  }

  /**
   * Computes the mass of a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @param moles the moles of the given formula
   * @return the mass of the given compound
   */

  public static double computeMass(String formula, double moles) {
    // First get the molar mass of the formula.
    double molarMass = computeMolarMass(formula);
    // Now find mass.
    return Conversions.molsToMass(moles, molarMass);
  }

  /**
   * Computes the number of atoms in a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @return the number of atoms in the formula
   */

  public static int numOfAtoms(String formula) {
    int numAtoms = 0;
    Formula parsedFormula = FtHelper.parseFormula(formula);
    for (int subscript : parsedFormula.getSubscripts()) {
      numAtoms += subscript * parsedFormula.getCoefficient();
    }
    parsedFormula = null;
    return numAtoms;
  }

  /**
   * Computes the number of atoms on the reactants side of a chemical equation.
   * 
   * @param equation a valid chemical equation
   * @return the number of atoms contained on the reactants side of the equation (the side is
   *         insignificant if the equation is balanced)
   */

  public static int numOfAtomsReactants(String equation) {
    int numAtoms = 0;
    Equation parsedEquation = FtHelper.parseEquation(equation);
    List<Formula> reactants = parsedEquation.getReactants();
    for (Formula reactant : reactants) {
      numAtoms += numOfAtoms(reactant.toString());
    }
    parsedEquation = null;
    reactants = null;
    return numAtoms;
  }

  /**
   * Computes the number of atoms on the products side of a chemical equation.
   * 
   * @param equation a valid chemical equation
   * @return the number of atoms contained on the products side of the equation (the side is
   *         insignificant if the equation is balanced)
   */

  public static int numOfAtomsProducts(String equation) {
    int numAtoms = 0;
    Equation parsedEquation = FtHelper.parseEquation(equation);
    List<Formula> products = parsedEquation.getProducts();
    for (Formula product : products) {
      numAtoms += numOfAtoms(product.toString());
    }
    parsedEquation = null;
    products = null;
    return numAtoms;
  }
}
