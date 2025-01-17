import java.util.*;
import java.io.*;
class Solution{

  public static void main(String args[]){
      BufferredReader br = new BufferredReader(new InputStreamReader());
      String date = br.readLine();
      StringBuilder year = new StringBuilder();
      StringBuilder month = new StringBuilder();
      StringBuilder day = new StringBuilder();
      for(int i=0;i<4;i++){
        year.append(date.charAt(i));
      }
      for(int i=5;i<7;i++){
        month.append(date.charAt(i));
      }
      for(int i=8;i<10;i++){
        day.append(date.charAt(i));
      }

    
  }
}
