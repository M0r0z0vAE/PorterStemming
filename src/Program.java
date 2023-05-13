import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    private char[] b;
    private int i, i_end, j, k;
    private static final int INC = 50;
    public Program(String string, int i_w)
    {
        b = string.toCharArray();
        i = i_w;
        i_end = 0;
    }
    private final boolean consonant(int i)
    {
        switch (b[i])
        {
            case 'a': case 'e': case 'i': case 'o': case 'u': return false;
            case 'y': return (i == 0) ? true : !consonant(i-1);
            default: return true;
        }
    }
    private final int m()
    {
        int n = 0;
        int i = 0;
        while(true)
        {
            if (i > j) return n;
            if (! consonant(i)) break; i++;
        }
        i++;
        while(true)
        {
            while(true)
            {
                if (i > j) return n;
                if (consonant(i)) break;
                i++;
            }
            i++;
            n++;
            while(true)
            {
                if (i > j) return n;
                if (! consonant(i)) break;
                i++;
            }
            i++;
        }
    }
    private final boolean vowelTrue()
    {
        int i; for (i = 0; i <= j; i++) if (! consonant(i)) return true;
        return false;
    }
    private final boolean doubleC(int j)
    {  if (j < 1) return false;
        if (b[j] != b[j-1]) return false;
        return consonant(j);
    }
    private final boolean cvc(int i)
    {  if (i < 2 || !consonant(i) || consonant(i-1) || !consonant(i-2)) return false;
        {  int ch = b[i];
            if (ch == 'w' || ch == 'x' || ch == 'y') return false;
        }
        return true;
    }
    private final boolean getW(String s)
    {
        int l = s.length();
        int o = k-l+1;
        if (o < 0) return false;
        for (int i = 0; i < l; i++) if (b[o+i] != s.charAt(i)) return false;
        j = k-l;
        return true;
    }
    private final void setW(String s)
    {
        int l = s.length();
        int o = j+1;
        for (int i = 0; i < l; i++) b[o+i] = s.charAt(i);
        k = j+l;
    }
    private final void setW_M(String s) { if (m() > 0) setW(s); }
    private final void step1a()
    {
        if (b[k] == 's')
        {
            if (getW("sses")) k -= 2; else
            if (getW("ies")) setW("i"); else
            if (b[k-1] != 's') k--;
        }
    }
    private final void step1b()
    {
        if (getW("eed")) { if (m() > 0) k--; } else
        if ((getW("ed") || getW("ing")) && vowelTrue())
        {  k = j;
            if (getW("at")) setW("ate"); else
            if (getW("bl")) setW("ble"); else
            if (getW("iz")) setW("ize"); else
            if (doubleC(k))
            {  k--;
                {
                    int ch = b[k];
                    if (ch == 'l' || ch == 's' || ch == 'z') k++;
                }
            }
            else if (m() == 1 && cvc(k)) setW("e");
        }
    }
    private final void step1c()
    {
        if (getW("y") && vowelTrue()) b[k] = 'i';
    }

    private final void step2()
    {
        if (k == 0) return;
        switch (b[k-1])
        {
            case 'a': if (getW("ational")) { setW_M("ate"); break; }
                if (getW("tional")) { setW_M("tion"); break; }
                break;
            case 'c': if (getW("enci")) { setW_M("ence"); break; }
                if (getW("anci")) { setW_M("ance"); break; }
                break;
            case 'e': if (getW("izer")) { setW_M("ize"); break; }
                break;
            case 'l': if (getW("bli")) { setW_M("ble"); break; }
                if (getW("alli")) { setW_M("al"); break; }
                if (getW("entli")) { setW_M("ent"); break; }
                if (getW("eli")) { setW_M("e"); break; }
                if (getW("ousli")) { setW_M("ous"); break; }
                break;
            case 'o': if (getW("ization")) { setW_M("ize"); break; }
                if (getW("ation")) { setW_M("ate"); break; }
                if (getW("ator")) { setW_M("ate"); break; }
                break;
            case 's': if (getW("alism")) { setW_M("al"); break; }
                if (getW("iveness")) { setW_M("ive"); break; }
                if (getW("fulness")) { setW_M("ful"); break; }
                if (getW("ousness")) { setW_M("ous"); break; }
                break;
            case 't': if (getW("aliti")) { setW_M("al"); break; }
                if (getW("iviti")) { setW_M("ive"); break; }
                if (getW("biliti")) { setW_M("ble"); break; }
                break;
            case 'g': if (getW("logi")) { setW_M("log"); break; }
        }
    }
    private final void step3()
    {
        switch (b[k])
        {
            case 'e': if (getW("icate")) { setW_M("ic"); break; }
                if (getW("ative")) { setW_M(""); break; }
                if (getW("alize")) { setW_M("al"); break; }
                break;
            case 'i': if (getW("iciti")) { setW_M("ic"); break; }
                break;
            case 'l': if (getW("ical")) { setW_M("ic"); break; }
                if (getW("ful")) { setW_M(""); break; }
                break;
            case 's': if (getW("ness")) { setW_M(""); break; }
                break;
        }
    }
    private final void step4()
    {
        if (k == 0) return;
        switch (b[k-1])
        {
            case 'a': if (getW("al")) break; return;
            case 'c': if (getW("ance")) break;
                if (getW("ence")) break; return;
            case 'e': if (getW("er")) break; return;
            case 'i': if (getW("ic")) break; return;
            case 'l': if (getW("able")) break;
                if (getW("ible")) break; return;
            case 'n': if (getW("ant")) break;
                if (getW("ement")) break;
                if (getW("ment")) break;
                if (getW("ent")) break; return;
            case 'o': if (getW("ion") && j >= 0 && (b[j] == 's' || b[j] == 't')) break;
                if (getW("ou")) break; return;
            case 's': if (getW("ism")) break; return;
            case 't': if (getW("ate")) break;
                if (getW("iti")) break; return;
            case 'u': if (getW("ous")) break; return;
            case 'v': if (getW("ive")) break; return;
            case 'z': if (getW("ize")) break; return;
            default: return;
        }
        if (m() > 1) k = j;
    }
    private final void step5a()
    {
        j = k;
        if (b[k] == 'e')
        {  int a = m();
            if (a > 1 || a == 1 && !cvc(k-1)) k--;
        }
    }
    private final void step5b()
    {
        if (b[k] == 'l' && doubleC(k) && m() > 1) k--;
    }
    public void steps()
    {
        k = i - 1;
        if (k > 1) { step1a(); step1b(); step1c(); step2(); step3(); step4(); step5a(); step5b();}
        i_end = k+1; i = 0;
    }

    public String toString() { return new String(b,0,i_end); }

    public static void main(String[] args) {
        Scanner scannerName = new Scanner(System.in);
        String w = scannerName.next();
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(w);

        if (m.matches()){
            Program program = new Program(w, w.length());
            program.steps();
            {  String u;
                u = program.toString();
                System.out.print(u);
            }
        }
        else {
            System.out.println("Error");
        }
    }
}