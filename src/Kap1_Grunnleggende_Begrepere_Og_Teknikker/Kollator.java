package Kap1_Grunnleggende_Begrepere_Og_Teknikker;


import java.text.*;

public class Kollator
{
    private Kollator(){}

    private static final String norsk =
            "< 0 < ¼ < ½ < ¾ < 1 < 2 < 3 < 4 < 5 < 6 < 7 < 8 < 9"
                    + "< a,A < b,B < c,C < d,D < e;é,E;É < f,F < g,G < h,H < i,I"
                    + " < j,J < k,K < l,L < m,M < n,N < o;ô,O;Ô < p,P < q,Q < r,R"
                    + " < s,S < t,T < u,U < v,V < w,W < x,X < ü = y,Y = Ü < z,Z"
                    + " < ä = æ,Æ = Ä < ö = ø,Ø = Ö < å = aa,Aa = Å";

    public static Collator norsk()
    {
        try
        {
            return new RuleBasedCollator(norsk);
        }
        catch(ParseException p)
        {
            return null;
        }
    }

} // Kollator