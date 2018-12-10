package sample.Model;

import java.util.ArrayList;

public class TransportModel implements ITransportTsk{

    private  ArrayList<ArrayList<Integer>> NWResults;
    private  ArrayList<ArrayList<Integer>> MinValResults;
    private ArrayList<ArrayList<Integer>> originalValues;
    private ArrayList<Integer> stock;
    private ArrayList<Integer> needs;

    public int calculateOverallValueNW(){
        int sum = 0;
        int firstBuyerIndex = 0;
        for(int i = 0;i<needs.size();i++){
            for(int j = firstBuyerIndex;j<stock.size();j++){
                if(stock.get(j) < needs.get(i)){
                    int tmp = stock.get(j)*originalValues.get(i).get(j);
                    needs.set(i, needs.get(i) - stock.get(j));
                    sum+=tmp;
                    NWResults.get(i).set(j, tmp);
                }else{
                    int tmp = needs.get(i) * originalValues.get(i).get(j);
                    sum+=tmp;
                    stock.set(j, stock.get(j) - needs.get(i));
                    firstBuyerIndex = j;
                    NWResults.get(i).set(j, tmp);
                    break;
                }
            }
        }
        return sum;
    }

    public int calculateOverallValueMinVal(){
        int sum = 0;
        
        return sum;
    }

    public  ArrayList<ArrayList<Integer>> getNWResults(){return NWResults;}
    public  ArrayList<ArrayList<Integer>> getMinValResults(){return MinValResults;}

    public void setValues(ArrayList<Integer> values, ArrayList<Integer> stock, ArrayList<Integer> needs){
        this.stock = stock;
        this.needs = needs;
        NWResults = new ArrayList<>();
        MinValResults = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        int k =0;
        for(int i = 0;i<needs.size();i++){
            tmp.add(new ArrayList<>());
            NWResults.add(new ArrayList<>());
            MinValResults.add(new ArrayList<>());
            for(int j = 0; j<stock.size();j++){
                tmp.get(i).add(values.get(k));
                k++;
                NWResults.get(i).add(0);
                MinValResults.get(i).add(0);
            }
        }
        originalValues = tmp;
    }
}
