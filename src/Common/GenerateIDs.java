/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;


import java.util.StringTokenizer;

/**
 *
 * @author HiM
 */
public class GenerateIDs {

    public int findNum(String code) {
        String str = code;
        StringTokenizer st = new StringTokenizer(str, "_");
        st.nextElement();
        String element = (String) st.nextElement();
        int no = Integer.parseInt(element);
        
        return no;
        
    }
    
    public int findNum2(String code) {
        String str = code;
        StringTokenizer st = new StringTokenizer(str, "_");
        st.nextElement();
        String element = (String) st.nextElement();
        int no = Integer.parseInt(element);
        
        return no;
        
    }
}
