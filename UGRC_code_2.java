import java.io.*;
import java.util.*;

class Demographics
{
    String city;
    int pincode;
    
    static HashMap<Integer, Demographics> map = new HashMap<>();
    // map is interned ocp
    
    private Demographics(String city,int pincode)
    {
        this.city=city;
        this.pincode=pincode;
    }
    
    public static Demographics create_object(String city, int pincode)
    {
        int hashvalue=Objects.hash(city, pincode);
        Demographics obj= map.get(hashvalue);
        
        if(obj==null || !(obj.city==city && obj.pincode==pincode))
        {
            Demographics new_obj=new Demographics(city, pincode);
            map.put(hashvalue,new_obj);
            return new_obj;
        }
        
        return obj;
    }

    @Override
    public boolean equals(Object o)
    {
        // We have a guarantee that if Objects have the same references then they are same and if Objects have different references then they are different. 
        if (this == o)
            return true;
        
        return false;    
    }

    @Override
    public String toString()
    {
        return ",City : "+this.city+" ,Pincode : "+this.pincode;
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(this.city,this.pincode);
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
        this.d=d;
    }

    @Override
    public String toString()
    {
        return "Userid : "+userid+" ,Name : "+name+" "+d.toString();
    }

    public void update(int pincode)
    {
     this.d=Demographics.create_object(this.d.city, pincode);
    }
    
    public void update(int pincode, String city)
    {
    this.d=Demographics.create_object(city, pincode);
    }
}

class UGRC_code_2
{  
        public static void main(String [] args) 
        {
          
        Demographics d1=Demographics.create_object("Bhopal",123456);
        Demographics d2=Demographics.create_object("Indore",123457);

        Userdetails u1= new Userdetails(1,"A",d1);
        Userdetails u2=new Userdetails(2,"B",d1);
        Userdetails u3=new Userdetails(3,"C",d2);
        Userdetails u4=new Userdetails(4,"D",d2);

     
        
        System.out.println(u1+"\n"+u2+"\n"+u3+"\n"+u4);

        u1.update(123466);
        u2.update(123458,"Indore");
        
        System.out.println("\n\n"+u1+"\n"+u2+"\n"+u3+"\n"+u4);
       
        }
     
}  
