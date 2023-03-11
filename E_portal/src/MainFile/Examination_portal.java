package MainFile;
import Login_page.Login_page;
import java.util.*;
public class Examination_portal
{
    public static HashMap<String,String> hashMap = new HashMap<String,String>();
    public static void main(String... args)
    {
        hashMap.put("John Price", "16010121199");
        hashMap.put("Naruto","160101220");
        hashMap.put("Simon Rilley Ghost","160101188");
        hashMap.put("Gary Kyles","160102110");
        hashMap.put("Laswell","1601012112");
       Login_page.MakeLoginPage();
        
    }
}