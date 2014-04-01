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

import com.mordoch.chemtools.Main;
import com.mordoch.chemtools.formulatools.Formula;
import com.mordoch.chemtools.formulatools.FormulaHelper;

/**
 * This class contains tools for analysis, i.e. finding empirical formula given percent composition.
 * 
 * @author Ariel Mordoch
 * @version 0.6
 * @see Main
 * @since 0.1
 */

public class Analysis {

  private LookupTable lookup;
  private FormulaHelper formulaParser;
  
  public Analysis(LookupTable aLookupTable, FormulaHelper aFormulaHelper) {
    this.lookup = aLookupTable;
    this.formulaParser = aFormulaHelper;
  }
  
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

  public String empiricalFromPercentComposition(double percent1, double percent2, double percent3,
      String element1, String element2, String element3) {
    // First find the mols of each element then find which one is smallest.
    double element1Mols = percent1 / lookup.getMolarMass(element1);
    double element2Mols = percent2 / lookup.getMolarMass(element2);
    double element3Mols = percent3 / lookup.getMolarMass(element3);
    double normalize = Math.min(element1Mols, Math.min(element2Mols, element3Mols));
    // Now normalize the formula.
    double element1Normal = element1Mols / normalize;
    double element2Normal = element2Mols / normalize;
    double element3Normal = element3Mols / normalize;
    // Now return the completed formula.
    return element1 + "(" + element1Normal + ")" + element2 + "(" + element2Normal + ")" + element3
        + "(" + element3Normal + ")";
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

  public String empiricalFromPercentComposition(double percent1, double percent2, String element1,
      String element2) {
    // First find the mols of each element then find which one is smallest.
    double element1Mols = percent1 / lookup.getMolarMass(element1);
    double element2Mols = percent2 / lookup.getMolarMass(element2);
    double normalize = Math.min(element1Mols, element2Mols);
    // Now normalize the formula.
    double element1Normal = element1Mols / normalize;
    double element2Normal = element2Mols / normalize;
    // Now return the completed formula.
    return element1 + "(" + element1Normal + ")" + element2 + "(" + element2Normal + ")";
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

  public String empiricalFromMass(double mass1, double mass2, double mass3, String element1,
      String element2, String element3) {
    // First find the percent composition
    double element1Percent = mass1 / lookup.getMolarMass(element1);
    double element2Percent = mass2 / lookup.getMolarMass(element2);
    double element3Percent = mass3 / lookup.getMolarMass(element3);
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

  public String empiricalFromMass(double mass1, double mass2, String element1, String element2) {
    // First find the percent composition
    double element1Percent = mass1 / lookup.getMolarMass(element1);
    double element2Percent = mass2 / lookup.getMolarMass(element2);
    // Now find empirical formula
    return empiricalFromPercentComposition(element1Percent, element2Percent, element1, element2);
  }

  /**
   * This method takes a formula and the molar mass of a molecular formula and finds the subscripts of the molecular formula.
   * For example, molecularFromEmpirical("CH2O", 180.156) returns [6, 12, 6].
   * 
   * @param empiricalFormula a chemical formula  syntactically compatible with
   *        Parser#parseSimpleFormula
   * @param molarMassCompound the molar mass of a compound
   * @return an List of type Integer containing the molecular formula's subscripts
   * @since 0.3
   */

  public final String molecularFromEmpirical(String empiricalFormula,
      double molarMassCompound) {
    Formula parsedFormula = formulaParser.parseFormula(empiricalFormula);
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
    String molecularFormula = "";
    int indexOfSubscripts = 0;
    for (String element : elements ) {
      molecularFormula += element + roundedSubscripts.get(indexOfSubscripts);
      indexOfSubscripts++;
    }
    // Discard objects and return
    newSubscripts = null;
    subscripts = null;
    roundedSubscripts = null;
    parsedFormula = null;
    return molecularFormula;
  }

  public double[] computePercentComposition(String formula) {
    return null;
  }

  public double[] computeMassComposition(String formula, double mass) {
    return null;
  }

  /**
   * Computes the molar mass of a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @return the molar mass of the given formula
   */

  public double computeMolarMass(String formula) {
    Formula parsedFormula = formulaParser.parseFormula(formula);
    // First get the subscripts, elements, and coefficients from the forumula and declare a variable
    // that stores molar mass.
    List<Integer> subscripts = parsedFormula.getSubscripts();
    List<String> elements = parsedFormula.getElements();
    List<Double> coefficients = parsedFormula.getCoefficients();
    double molarMass = 0;
    // Now loop through the elements. Each iteration, multiply the subscript by the molar mass of
    // the element and its coefficient and add to molarMass.
    // Note that the given formula must be syntactically compatible with
    // Parser#parseFormula().
    for (int index = 0; index < elements.size(); index++) {
      molarMass +=
          subscripts.get(index) * lookup.getMolarMass(elements.get(index))
              * coefficients.get(index);
    }
    // Now discard all the objects and return.
    parsedFormula = null;
    subscripts = null;
    elements = null;
    coefficients = null;
    return molarMass;
  }

  /**
   * Computes the mass of a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @param moles the moles of the given formula
   * @return the mass of the given compound
   */

  public double computeMass(String formula, double moles) {
    // First get the molar mass of the formula.
    double molarMass = computeMolarMass(formula);
    // Now find mass.
    return Conversion.molsToMass(moles, molarMass);
  }

  /**
   * Computes the number of atoms in a formula.
   * 
   * @param formula a formula, such as "C6H12O6"
   * @return the number of atoms in the formula
   */

  public int numOfAtoms(String formula) {
    int numAtoms = 0;
    int index = 0;
    for (int subscript : formulaParser.parseFormula(formula).getSubscripts()) {
      numAtoms += subscript * formulaParser.parseFormula(formula).getCoefficients().get(index);
      index++;
    }
    return numAtoms;
  }
}
