import java.io.*;
import java.util.*;


class Demographics
{
    String city;
    int pincode;
    
    Demographics(String city,int pincode)
    {
        this.city=city;
        this.pincode=pincode;
    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;

        if (this.getClass() != o.getClass()) return false; 

        Demographics other = (Demographics)o;
        return other.pincode==this.pincode && other.city.equals(this.city);
    }
    
    @Override
    public String toString()
    {
        return ",City : "+this.city+" ,Pincode : "+this.pincode;
    }
  
}

class Userdetails
{
    String name;
    int userid;
    Demographics d;
    
    Userdetails( int userid,String name,Demographics d)
    {
        this.name=name;
        this.userid=userid;
        this.d=new Demographics(d.city, d.pincode);
    }

    @Override
    public String toString()
    {
        return "Userid : "+userid+" ,Name : "+name+" "+d.toString();
    }
}

class UGRC_code_1
{  
        public static void main(String [] args) 
        {
            
            Demographics d1=new Demographics("Bhopal",123456);
            Demographics d2=new Demographics("Indore",123457);
            
            Userdetails u1= new Userdetails(1,"A",d1);
            Userdetails u2=new Userdetails(2,"B",d1);
            Userdetails u3=new Userdetails(3,"C",d2);
            Userdetails u4=new Userdetails(4,"D",d2);

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);
        }
     
}  