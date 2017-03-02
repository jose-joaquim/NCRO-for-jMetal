package jmetal.metaheuristics.ncro;

import java.util.Random;
import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.problems.SPSP_2.SPSP_2;

/**
 *
 * @author jjaneto
 */
public class Mol extends Solution{
    
    private String typeOfVariation;
    public int id, auxID, numHit, minHit, rank, parents[], children[];
    public double molS[], t1[], t2[], ObjValues[], PE, KE, crowdingDistance, betterFitness;

    public Mol(Problem problem) throws ClassNotFoundException {
        super(problem);
        this.typeOfVariation = "";
        parents = new int[2];
        children = new int[2];
        this.numHit = 0;
        this.minHit = 0;
        this.betterFitness = Double.POSITIVE_INFINITY;
        if(problem.getName().equals("SPSP")){
            molS = new double[SPSP_2.L];
            for(int i = 0; i < SPSP_2.L; i++){
                //molS[i] = Prob.lBound[i] + (Prob.uBound[i] - Prob.lBound[i]) * Func.r.nextDouble();
                molS[i] = new Random().nextDouble();
            }
            t1 = new double[SPSP_2.L];
            t2 = new double[SPSP_2.L];
        }
        
    }
    
    public Mol(Mol mol, String typeOfVariation){
        
    }

    public String getTypeOfVariation() {
        return typeOfVariation;
    }

    public void setTypeOfVariation(String typeOfVariation) {
        this.typeOfVariation = typeOfVariation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuxID() {
        return auxID;
    }

    public void setAuxID(int auxID) {
        this.auxID = auxID;
    }

    public int getNumHit() {
        return numHit;
    }

    public void setNumHit(int numHit) {
        this.numHit = numHit;
    }

    public int getMinHit() {
        return minHit;
    }

    public void setMinHit(int minHit) {
        this.minHit = minHit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int[] getParents() {
        return parents;
    }

    public void setParents(int[] parents) {
        this.parents = parents;
    }

    public int[] getChildren() {
        return children;
    }

    public void setChildren(int[] children) {
        this.children = children;
    }

    public double[] getMolS() {
        return molS;
    }

    public void setMolS(double[] molS) {
        this.molS = molS;
    }

    public double[] getT1() {
        return t1;
    }

    public void setT1(double[] t1) {
        this.t1 = t1;
    }

    public double[] getT2() {
        return t2;
    }

    public void setT2(double[] t2) {
        this.t2 = t2;
    }

    public double[] getObjValues() {
        return ObjValues;
    }

    public void setObjValues(double[] ObjValues) {
        this.ObjValues = ObjValues;
    }

    public double getPE() {
        return PE;
    }

    public void setPE(double PE) {
        this.PE = PE;
    }

    public double getKE() {
        return KE;
    }

    public void setKE(double KE) {
        this.KE = KE;
    }

    public double getCrowdingDistance() {
        return crowdingDistance;
    }

    public void setCrowdingDistance(double crowdingDistance) {
        this.crowdingDistance = crowdingDistance;
    }

    public double getBetterFitness() {
        return betterFitness;
    }

    public void setBetterFitness(double betterFitness) {
        this.betterFitness = betterFitness;
    }
    
    
    
}
