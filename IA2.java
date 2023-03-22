import java.util.*;

public class IA2 {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        for(int i=1;;i++)
        {
            System.out.println("---------------------------------");
            System.out.println("MONTH NO."+i);
            System.out.println("---------------------------------");
            System.out.println("COMMERCIAL CENTER");
            System.out.println("---------------------------------");
            int ch=0;
            while(ch<4 || ch==5)
            {
                System.out.println("\n1.Electronics Store \n2.Sports Store \n3.Food Court \n4.Next Month \n5.Admin");
                ch=scan.nextInt();
                switch(ch)
                {
                    case 1: Electronics elec=new Electronics();
                            elec.store();
                            break;
                    
                    case 2: Sports sport=new Sports();
                            sport.store();
                            break; 
                    
                    case 3: FoodCourt food=new FoodCourt();
                            food.store();
                            break;
                    
                    case 4: break;

                    case 5: System.out.println("Statement from Gada Electronics till month no."+i+"= Rs."+Electronics.ElecRev);
                            System.out.println("Statement from Sportstronics till month no."+i+"= Rs."+Sports.SportsRev);
                            System.out.println("Statement from Panvel Food Court till month no."+i+"= Rs."+FoodCourt.FoodRev);
                            System.out.println("Statement from the Mall till month no."+i+"= Rs."+Mall.total_rev);
                            break;
                }

            }
        }

        

        
        
    }
}

abstract class Mall{
    //Mall revenue calculated 
    static int total_rev=0;
    int checkout(String items[], int price[], int order[][]){
        int bill=0;
        System.out.println("---------------------------------");
        System.out.println("ITEM NAME --> TOTAL PRICE");
        for(int i=0;i<order.length;i++)
        {
            for(int j=0;j<items.length;j++)
            {
                if(order[i][0]==(j+1))
                {
                    bill+=price[j]*order[i][1];
                    System.out.println(items[j]+" --> Rs."+(price[j]*order[i][1]));
                }
            }
        }
        System.out.println("---------------------------------");
        total_rev+=bill;
        return bill;   
    }

    public int operations()
    {
        int expenditure=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount spent on rent & electricity");
        expenditure+=sc.nextInt();
        System.out.println("Enter the cost of goods");
        expenditure+=sc.nextInt();
        System.out.println("Enter the total salary given");
        expenditure+=sc.nextInt();
        total_rev-=expenditure;
        return expenditure;   
    }
}

class Electronics extends Mall{
    //5 items, bill generation 
    //Call mall and edit total rev
    static int ElecRev;
    public void store(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nGADA ELECTRONICS ITEMS: \n1. Apple \n2. Oneplus \n3.Samsung ");
        int ElecPrices[]=new int[3];
        ElecPrices[0]=79900;
        ElecPrices[1]=60000;
        ElecPrices[2]=100000;
        String ElecItems[]=new String[3];
        ElecItems[0]="Apple";
        ElecItems[1]="OnePlus";
        ElecItems[2]="Samsung";
        int ElecArr[][]=new int[3][2];
        for(int i=0;i<3;i++)
        {
            System.out.println("Enter item no.");
            int k=sc.nextInt();
            ElecArr[i][0]=k;
            System.out.println("Enter quantity of the item sold:");
            ElecArr[i][1]=sc.nextInt();
        }
        int ElecBill=checkout(ElecItems, ElecPrices, ElecArr);
        ElecRev+=ElecBill;
        System.out.println("Total Revenue from Electronics Store: "+ElecBill);
        System.out.println("---------------------------------");
        int ElecExpense=operations();
        ElecRev-=ElecExpense;
        System.out.println("---------------------------------");
        System.out.println("Total Expenditure by Electronics Store: "+ElecExpense);   
        System.out.println("---------------------------------"); 
    }
}

class Sports extends Mall{
    //5 items, bill generation 
    //Call mall and edit total rev
    static int SportsRev;
    public void store(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSPORTSTRONICS ITEMS: \n1. Football \n2. Cricket Bat \n3. Jersey ");
        int SportsPrices[]=new int[3];
        SportsPrices[0]=1500;
        SportsPrices[1]=3500;
        SportsPrices[2]=4000;
        String SportsItems[]=new String[3];
        SportsItems[0]="Football";
        SportsItems[1]="Cricket Bat";
        SportsItems[2]="Jersey";
        int SportsArr[][]=new int[3][2];
        for(int i=0;i<3;i++)
        {
            System.out.println("Enter item no.");
            int k=sc.nextInt();
            SportsArr[i][0]=k;
            System.out.println("Enter quantity of the item sold:");
            SportsArr[i][1]=sc.nextInt();
        }
        
        int SportsBill=checkout(SportsItems, SportsPrices, SportsArr);
        SportsRev+=SportsBill;
        System.out.println("Total Revenue from Sports Store: "+SportsBill);
        System.out.println("---------------------------------");
        int SportsExpense=operations();
        SportsRev-=SportsExpense;
        System.out.println("---------------------------------");
        System.out.println("Total Expenditure by Sports Store: "+SportsExpense);
        System.out.println("---------------------------------");
        
    }
}

class FoodCourt extends Mall{
    static int FoodRev;
    public void store(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPANVEL FOOD COURT ITEMS: \n1. Pizza \n2. Pasta \n3. Tacos ");
        int foodPrices[]=new int[3];
        foodPrices[0]=350;
        foodPrices[1]=400;
        foodPrices[2]=300;
        String foodItems[]=new String[3];
        foodItems[0]="Pizza";
        foodItems[1]="Pasta";
        foodItems[2]="Tacos";
        int foodArr[][]=new int[3][2];
        for(int i=0;i<3;i++)
        {
            System.out.println("Enter item no.");
            int k=sc.nextInt();
            foodArr[i][0]=k;
            System.out.println("Enter quantity of the item sold:");
            foodArr[i][1]=sc.nextInt();
        }
        
        int FoodBill=checkout(foodItems, foodPrices, foodArr);
        FoodRev+=FoodBill;
        System.out.println("Total Revenue from Food Court: "+FoodBill);
        System.out.println("---------------------------------");
        int FoodExpense=operations();
        FoodRev-=FoodExpense;
        System.out.println("---------------------------------");
        System.out.println("Total Expenditure by Sports Store: "+FoodExpense);
        System.out.println("---------------------------------");
        
    }

}

