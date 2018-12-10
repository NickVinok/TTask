package sample.Model;

import java.util.ArrayList;

public interface ITransportTsk {
    int calculateOverallValueNW();
    int calculateOverallValueMinVal();
    ArrayList<ArrayList<Integer>> getNWResults();
    ArrayList<ArrayList<Integer>> getMinValResults();
    void setValues(ArrayList<Integer> values, ArrayList<Integer> stock, ArrayList<Integer> needs);
}
