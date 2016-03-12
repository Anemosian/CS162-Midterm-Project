
package scheduler;

import java.util.*;


public class Scheduler {
        int current_process_index;
        int time_elapsed=0;
        int time_counter=0;
        int same_CPU_time_counter;
        int[] tempAT=new int[AT.length];
        for(int i=0; i<AT.length; i++)
            tempAT[i]=99999999;
        int[] tempBT=new int[BT.length];
        for(int i=0; i<AT.length; i++)
            tempBT[i]=99999999;
        int stop_counter=0;
        int temp_minBT;
        
        while(true){
            same_CPU_time_counter=0;
            
            if(time_counter==AT.length)
                time_elapsed=getMinValue(AT);
            time_counter=0;
            
        for(int i=0; i<AT.length; i++)
            if(AT[i]<=time_elapsed){    
                tempBT[i]=BT[i];  
            }
            else
                time_counter++;
        
        temp_minBT=getMinValue(tempBT);
        for(int i=0; i<AT.length; i++)
            if(tempBT[i]==temp_minBT&&tempBT[i]!=99999999){
                same_CPU_time_counter++;
                tempAT[i]=AT[i];
            }
        
        for(int i=0; i<AT.length; i++)
            if(tempBT[i]==getMinValue(tempBT)&&tempBT[i]!=99999999){
                if(same_CPU_time_counter>1){
                       
                    for(int j=0; j<AT.length; j++){
                        if(tempAT[j]==getMinValue(tempAT)){
                            current_process_index=j;
                            AT[j]=99999999;
                            tempAT[j]=99999999;
                            tempBT[j]=99999999;
                            System.out.println(""+time_elapsed+" "+current_process_index+" "+BT[current_process_index]+"X");
                            break;
                        }
                    
                    }
                }
                else{
                    current_process_index=i;
                    AT[i]=99999999;
                    tempBT[i]=99999999;
                    tempAT[i]=99999999;
                    System.out.println(""+time_elapsed+" "+current_process_index+" "+BT[current_process_index]+"X");
                }
                time_elapsed+=BT[i];
                break;
            }
                
        stop_counter=0;
        
        for(int i=0; i<AT.length; i++)
            if(AT[i]==99999999)
                stop_counter++;
       
        if(stop_counter==AT.length)
                break;        
        }        
    } 

// getting the miniumum value
public static int getMinValue(int[] array){  
     int minValue = array[0];  
     for(int i=1;i<array.length;i++){  
     if(array[i] < minValue){  
     minValue = array[i];  
        }  
     }  
    return minValue;  
}  


    public static void main(String[] args) {
        int[] A={20,30,50};
        int[] B={50,10,10};
        int[] C={2,1,1,1};
        Scheduler.SJF(A,B,C);
    }
    
}
