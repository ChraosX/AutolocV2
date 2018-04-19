package fr.eni.autoloc.autoloc.DAL;

import java.util.ArrayList;
import java.util.List;

import fr.eni.autoloc.autoloc.DAL.Room.Entity.ParsableToBo;

public class ParserList<P> {
    public List<P> ParsToBo(List<? extends ParsableToBo<P>> p){
        List<P>  result = new ArrayList<P>();

        for (ParsableToBo parse : p){
            P  nP =(P) parse.toBo();
            result.add(nP);
        }

        return result;
    }
}
