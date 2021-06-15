package business.services;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

public class CalculateOrderItems {
    int carportLength;
    int pricePrItem;
    //TODO: Lav en beregner som beregner antallet af spær ud fra den ønskede længde

    public CalculateOrderItems(int carportLength, int pricePrItem) {
        this.carportLength = carportLength;
        this.pricePrItem = pricePrItem;
    }

    public int calculatePrice(){
        int price = ((carportLength/55)*2)*pricePrItem;

        return price;
    }

    public HashMap<String, Integer> CarportItems(int Length, int Width){
        HashMap<String, Integer> items = new HashMap<>();
        boolean CarportL = Width > 600;

        int numBeams = (int) (Math.ceil(Length/60f)+1);
        if(CarportL){
            numBeams = numBeams*2;
            items.put("Beams 600cm", numBeams);
        }else{
            items.put("Beams 480cm", numBeams);
        }

        int posts = 0;
        if(Length < 600 && Width < 600){
            posts = 4;
        }else if((Length > 600 && Width < 600) || (Length < 600 && Width > 600)){
            posts = 6;
        }
        items.put("Posts 300cm", posts);

        items.put("Universal 190mm Left", numBeams);
        items.put("Universal 190mm Right", numBeams);

        int screws = (int) Math.ceil(((numBeams*2)*9)/250f);
        items.put("4,0x50mm screws 250 pack", screws);

        int bolts = 8;
        if(posts == 6){
            bolts = 16;
        }
         items.put("Bolt 10x120mm", bolts);
         items.put("Nut 40x40x11mm", bolts);

         int plastmo;
         float tilt = calcTri(Length);
         if(tilt > 6){
             plastmo = (int) Math.ceil(Width/102f);
         }else{
             plastmo = (int) Math.ceil(Width/95f);
         }
         items.put("Plastmo 600mm", plastmo);

         return items;
    }

    public float calcTri(int length){
        float result;
        float C = (float) Math.sqrt(Math.pow(length, 2)-100);
        result = (float) Math.acos(Math.pow(length, 2)+Math.pow(C,2)-100/(2*length*C));
        return result*10;
    }

}
