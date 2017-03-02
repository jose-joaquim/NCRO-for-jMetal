package jmetal.metaheuristics.ncro;

import java.util.ArrayList;
import jmetal.core.Algorithm;
import jmetal.core.Operator;
import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.SolutionSet;
import jmetal.qualityIndicator.QualityIndicator;
import jmetal.util.JMException;

/**
 *
 * @author jjaneto
 */
public class NCRO extends Algorithm{
    

    public NCRO(Problem problem) {
        super(problem);
    }

    @Override
    public SolutionSet execute() throws JMException, ClassNotFoundException {
        int populationSize;
        int maxEvaluations;
        int evaluations;
        double iniKE;
        
        Operator synthesis;
        Operator onwall;
        Operator inef;
        Operator dec;
        
        QualityIndicator indicators; // QualityIndicator object
        int requiredEvaluations; // Use in the example of use of the
        // indicators object (see below)

        SolutionSet population;
        SolutionSet offspringPopulation;
        SolutionSet union;

        populationSize = ((Integer) getInputParameter("populationSize")).intValue();
        maxEvaluations = ((Integer) getInputParameter("maxEvaluations")).intValue();
        iniKE = ((Double) getInputParameter("iniKE")).doubleValue();
        indicators = (QualityIndicator) getInputParameter("indicators");
        
        population = new SolutionSet(populationSize);
        evaluations = 0;

        requiredEvaluations = 0;

        //Read the operators
        synthesis = operators_.get("synthesis");
        onwall = operators_.get("onwall");
        inef = operators_.get("ineff");
        dec = operators_.get("dec");
        
        
        Mol newMol;
        for(int i = 0; i < populationSize; i++){
            newMol = new Mol(problem_);
            newMol.setId(i);
            newMol.setKE(iniKE);
            
            problem_.evaluate(newMol);
            problem_.evaluateConstraints(newMol);
            evaluations++;
            population.add(newMol);
        }
        //UPDATEPOP() AQUI
        
        SolutionSet population_p_t = newPopulation(population);
        while(evaluations < maxEvaluations){
            //
            population.clear();
            for(int i = 0; i < populationSize; i++){
                Mol m = new Mol((Mol) population_p_t.get(i), "");
                m.setId(i);
                population.add(m);
            }
            //
        }
        
        return null;
    }
    
    public SolutionSet newPopulation(SolutionSet population){
        SolutionSet ret = new SolutionSet(population.size());
        for(int i = 0; i < population.size(); i++){
            ret.add(population.get(i));
        }
        return ret;
    }
    
}
