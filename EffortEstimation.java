
import java.util.Scanner;
public class EffortEstimation {
	static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {      
        
        int aw,ucw,uucp;
        double count=0,tfac,tcf,efac,szuc,ef,ucp,er,mhour,adjmh,mHourEst,tMhour;
        double exp[]=new double [8];                
        
        System.out.println("\t\t\t==========================");
        System.out.println("\t\t\tSOFTWARE EFFORT ESTIMATION");
        System.out.println("\t\t\t==========================");	       
        
        aw = actorWeight();
        ucw = useCaseWeight();
        uucp = aw + ucw;
        tfac = techFactor();
        tcf = (0.01* tfac) + 0.6 ;
        szuc = uucp * tcf;
        count = expFactor(exp,count);
        efac = calExpFactor(exp);
        ef = (-0.03 * efac) + 1.4;
        ucp = szuc * ef;
        er = effRate(exp);
        mhour = er* ucp;
        adjmh = (1.0 +0.5)*mhour;
        mHourEst = mHourEst();
        tMhour = adjmh + mHourEst;
        report(aw,ucw,tcf,szuc,ef,mhour,adjmh,mHourEst,tMhour);
    }    

    public static int actorWeight(){
        int act1,act2,act3;
        System.out.println("1. ACTORS"
                + "\nEnter number of actors for:-");
        System.out.print("----------------------------------------------------------------------------------"
                + "\nActor Type \t Description \t\t\t\t\t Number of actors"
                + "\n----------------------------------------------------------------------------------"
                + "\nSimple \t\t Defined API \t\t\t\t\t ");
        act1 = scan.nextInt();                      
        System.out.print("Average \t Interactive or Protocol driven interface \t ");
        act2 = scan.nextInt();
        System.out.print("Complex \t Graphical User Interface \t\t\t ");
        act3 = scan.nextInt();        
        System.out.println("----------------------------------------------------------------------------------");
  
        return (1*act1) + (2*act2) + (3*act3);
    }
    
    public static int useCaseWeight(){
        int ucs1,ucs2,ucs3;
        System.out.println("\n2. USE-CASE"
                + "\nEnter number of use case for :-");
        System.out.print("--------------------------------------------------------------------"
                + "\nUse case type \t Number of transaction \t\t Number of use case"
                + "\n--------------------------------------------------------------------"
                + "\nSimple \t\t 3 or fewer \t\t\t ");
        ucs1 = scan.nextInt();
        System.out.print("Average \t 4 to 7 \t\t\t ");
        ucs2 = scan.nextInt();
        System.out.print("Complex \t More than 7 \t\t\t ");
        ucs3 = scan.nextInt(); 
        System.out.println("--------------------------------------------------------------------");
        
        return (5*ucs1)+(10*ucs2)+(15*ucs3);
    }
    
    public static double techFactor(){
       int t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
        System.out.println("\n3. TECHNICAL FACTORS"
                + "\nEnter rating (0-5) for :-");
        System.out.print("------------------------------------------------------------------------"
                + "\nFactor   Description \t\t\t\t\t\t Rating"
                + "\n------------------------------------------------------------------------"
                + "\nT1 \t Must have a distributed solution \t\t\t ");
        t1 = scan.nextInt();
        System.out.print("T2 \t Must respond to specific performance objectives \t ");
        t2 = scan.nextInt();
        System.out.print("T3 \t Must meet end-user efficiency desires \t\t\t ");
        t3 = scan.nextInt();
        System.out.print("T4 \t Complex internal processing \t\t\t\t ");
        t4 = scan.nextInt();
        System.out.print("T5 \t Code must be reusable \t\t\t\t\t ");
        t5 = scan.nextInt();
        System.out.print("T6 \t Must be easy to install \t\t\t\t ");
        t6 = scan.nextInt();
        System.out.print("T7 \t Must be easy to use \t\t\t\t\t ");
        t7 = scan.nextInt();
        System.out.print("T8 \t Must be portable \t\t\t\t\t ");
        t8 = scan.nextInt();
        System.out.print("T9 \t Must be easy to change \t\t\t\t ");
        t9 = scan.nextInt();
        System.out.print("T10 \t Must allow concurrent users \t\t\t\t ");
        t10 = scan.nextInt();
        System.out.print("T11 \t Includes special security features \t\t\t ");
        t11 = scan.nextInt();
        System.out.print("T12 \t Must provide direct access for 3rd parties \t\t ");
        t12 = scan.nextInt();
        System.out.print("T13 \t Requires special user training facilities \t\t ");
        t13 = scan.nextInt();
        
        return (2*t1)+t2+t3+t4+t5+(0.5*t6)+(0.5*t7)+(2*t8)+t9+t11+t13;
    }

    public static double expFactor(double exp[],double count){

        System.out.println("------------------------------------------------------------------------");
        System.out.println("\n4. EXPERIENCE FACTORS"
                + "\nEnter rating (0-5) for :-");
        System.out.println("----------------------------------------------------------------");
        System.out.print("Factor   Description \t\t\t\t\t Rating"
                + "\n----------------------------------------------------------------"
                + "\nE1 \t Familiar with FPT software process \t\t ");
        exp[0] = scan.nextInt();                
        System.out.print("E2 \t Application experience \t\t\t ");
        exp[1] = scan.nextInt();
        System.out.print("E3 \t Paradigm experience (OO) \t\t\t ");
        exp[2] = scan.nextInt();
        System.out.print("E4 \t Lead analyst capability \t\t\t ");
        exp[3] = scan.nextInt();
        System.out.print("E5 \t Motivation \t\t\t\t\t ");
        exp[4] = scan.nextInt();
        System.out.print("E6 \t Stable Requirements \t\t\t\t ");
        exp[5] = scan.nextInt();
        System.out.print("E7 \t Part-time workers \t\t\t\t ");
        exp[6] = scan.nextInt();
        System.out.print("E8 \t Difficulty of programming language \t\t ");
        exp[7] = scan.nextInt();
        System.out.println("----------------------------------------------------------------");               
        
        return count;
    }
    
    public static double calExpFactor(double exp[]){        
        return exp[0]+(0.5*exp[1])+exp[2]+(0.5*exp[3])+(2*exp[5])+(-1*exp[6])+(-1*exp[7]);
    }
    
    public static double effRate(double exp[]){
        int index=0, hour=0;
        for(int a=0;a<6;a++){
            if(exp[a]<3){
                ++index;
            }
            }
        for(int a=6;a<8;a++){
            if(exp[a]>3){
                ++index;
            }
        }        
        
        if(index > 0 && index <= 2){
            hour=20;
        }else if(index >=3 && index <= 4){
            hour=28;
        }else{
            System.out.println("Please reconstruct the project team.");
        }
    return hour;
    }
          
    public static double mHourEst(){
        double a1,a2,a3;
        System.out.println("\n5. MAN HOUR ESTIMATE"
                + "\nEnter average man-hours for :-");
        System.out.print("----------------------------------"
                + "\nActor type \t Average Man-Hours"
                + "\n----------------------------------"
                + "\nSimple \t\t ");
        a1 = scan.nextInt();
        System.out.print("Average \t ");
        a2 = scan.nextInt();
        System.out.print("Complex \t ");
        a3 = scan.nextInt(); 
        System.out.println("----------------------------------");
        
        return (20*a1)+(15*a2)+(10*a3);
    }
    
    public static void report(int aw,int ucw,double tcf,double szuc,double ef,double mhour,double adjmh,double mHourEst,double tMhour){
        System.out.println("=============================================="
                + "\n\t\tREPORT"
                + "\n==============================================");
        System.out.printf("Total actor weight  \t\t\t %d",aw);
        System.out.printf("\nTotal use case weight \t\t\t %d",ucw);
        System.out.printf("\nTechnical Complexity Factor weight \t %.2f",tcf);
        System.out.printf("\nSize of the software project \t\t %.2f",szuc);
        System.out.printf("\nEnvironmental Factor weight \t\t %.2f",ef);
        System.out.printf("\nUnadjusted Man-Hours \t\t\t %.2f",mhour);
        System.out.printf("\nAdjusted Man-Hours by 5 percent \t %.2f",adjmh);
        System.out.printf("\nTotal report Man-Hours Estimate \t %.2f",mHourEst);
        System.out.printf("\nTOTAL MAN-HOURS \t\t\t %.2f",tMhour);
        System.out.println("\n==============================================");               
    }
}
	
	    
