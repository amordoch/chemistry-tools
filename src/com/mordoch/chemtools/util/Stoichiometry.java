package com.mordoch.chemtools.util;

import com.mordoch.chemtools.formulatools.Equation;
import com.mordoch.chemtools.formulatools.Formula;
import com.mordoch.chemtools.formulatools.FtHelper;

public class Stoichiometry {
  
  public static double findRatio(String equation) {  
    
    Equation parsedEquation = FtHelper.parseEquation(equation);
    double ratio = parsedEquation.getReactants().get(0).getCoefficient();
    parsedEquation.getReactants().remove(0);
    for (Formula formula : parsedEquation.getReactants()) {
      ratio /= formula.getCoefficient();
    }
    return ratio;
  }  
  
}