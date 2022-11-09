import java.util.ArrayList;
import java.util.List;

public class Util {

    public boolean valid(String line1, String line2,String joinAttributeStr) {

        String[] attributes = joinAttributeStr.split(",");

        ArrayList<String> line1Attributes = new ArrayList<String>(List.of(line1.split(",")));
        ArrayList<String> line2Attributes = new ArrayList<String>(List.of(line2.split(",")));

        for (String attribute : attributes) {
            if (!line1Attributes.contains(attribute) || !line2Attributes.contains(attribute)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getIndexes(String line1, String line2,String joinAttributeStr){
        if(!valid(line1,line2,joinAttributeStr)){
            return null;
        }
        else {
            String[] attributes = joinAttributeStr.split(",");
            ArrayList<String> line1Attributes = new ArrayList<String>(List.of(line1.split(",")));
            ArrayList<String> line2Attributes = new ArrayList<String>(List.of(line2.split(",")));
            ArrayList<Integer> indexes = new ArrayList<Integer>();
            for (String attribute : attributes) {
                indexes.add(line1Attributes.indexOf(attribute));
            }
            for (String attribute : attributes) {
                indexes.add(line2Attributes.indexOf(attribute));

            }
            return indexes;
        }
    }

    public String generateRow(String head1, String head2, ArrayList<Integer> indexes){
        String toWrite="";


        ArrayList<String> head1Attr = new ArrayList<String>(List.of(head1.split(",")));
        ArrayList<String> head2Attr = new ArrayList<String>(List.of(head2.split(",")));


        for(int i=0;i<head2Attr.size();i++){
            if(!head1Attr.contains(head2Attr.get(i))){
                toWrite+=head2Attr.get(i);
                if(i!=head2Attr.size()-1){
                    toWrite+=",";
                }
            }
        }
        return head1+","+toWrite;
    }

}
