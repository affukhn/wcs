import com.opencsv.CSVReader;
import com.opencsv.bean.OpencsvUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class WcsMain
{
    private static Map<String,Product> m= new HashMap<>();
    private  static Map<String,Integer> cart=new HashMap<>();
    private static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) throws Exception {

        CSVReader r =new CSVReader(new FileReader("C:\\Users\\Admin\\Desktop\\data structure and algorithem\\wcs\\src\\main\\resources\\product.csv"));
        List<String[]> l=r.readAll();
        for(int i=1;i<l.size();i++)
        {
            Double d=Double.valueOf(l.get(i)[2]);
             m.put(l.get(i)[0],new Product(l.get(i)[0],l.get(i)[1],d));
        }

        while(true)
        {
            System.out.println("Enter the number to process the request");
            System.out.println("Enter 1 to add to cart");
            System.out.println("Enter 2 to checkout from the cart");
            int str=scan.nextInt();

            switch (str){
                case 1:
                    addtoCart();
                    break;
                case 2:
                    checkout();
                    break;
                default:
                    System.out.println("wrong choice");
                    break;

            }
            System.out.println("enter the value 1 to continue and 2 for Exit");
            int itr=scan.nextInt();
            if(itr==2)
            {
                break;
            }
        }

    }

    private static void checkout()
    {
        List<Product> checkOut=new ArrayList<>();

        for(Map.Entry map:cart.entrySet())
        {
             Product p=m.get(map.getKey());
             int sr= (int) map.getValue();
            double b=new Double(sr);
            checkOut.add(new Product(p.getId(),p.getName(),p.getPrice()*b));


        }
        for(Product ptr:checkOut)
        {
            System.out.print("NameProduct = "+ ptr.getName() +" " );
            System.out.println("pice= "+ ptr.getPrice() +" " );
        }

    }

    private static void addtoCart()
    {
        System.out.println("enter the Id");
       for(Map.Entry map:m.entrySet())
       {
           System.out.println(map.getValue());
       }

        String str=scan.next();
       cart.put(str,cart.getOrDefault(str,0)+1);
    }
}
