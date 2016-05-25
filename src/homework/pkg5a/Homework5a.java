
package homework.pkg5a;

import java.util.Scanner;

/** Accept words on input and indicate whether or not the word is a Nohl 
 * palindrome. If it is a Nohl palindrome, you will further output the
 * palindromic substring and its order. You must locate and output the Nohl
 * palindrome with the largest order 
 * @author Ryan Hilsabeck
 */
public class Homework5a 
{


    public static void main(String[] args) 
    {
     String userWord;
     String largestPal; //stores largest palindrome that is returned from method
     int order;         
      
     Scanner keyboard = new Scanner(System.in);
       
     System.out.print("Type in any word in lowercase. Press *** to exit " +
                      "the program: ");
     userWord = keyboard.nextLine();
      
     //While the user doesn't enter ***, the program will cycle through the
     //program by calling a method that will go through a user entered word
     //that will determine if it is a Nohl palindrome and then send back
     //the largest one. If it is equal to largest palindrome returned is equal
     //to the user's word or if it is less then 3 characters in length then it
     //will output NO and will have user enter in another word. Otherwise, it
     //will output the largest Nohl palindrome and its order.
     while(!userWord.equals("***")) 
     {
      largestPal = largestPalindrome(userWord);
      if(largestPal.length() == userWord.length() || largestPal.length() < 3)
        System.out.println("NO");
      else
      {
       order = largestPal.length();
       System.out.println("Yes: " + largestPal + ": Order " + order);
      }
       
      System.out.print("Type in any word. Press *** to exit program: "); 
      userWord = keyboard.nextLine();
     }
    }
    
    //This method will determine the largest palindrome located in the word and
    //will return it back to the main method. It will cycle through every
    //possible iteration.
    public static String largestPalindrome(String currentWord)
    {
     int startSub;  //start of substring
     int endSub;    //end of substring
     String currentPalindrome = "";
     String largestPalindrome = "";
        
     for(startSub = 0; startSub < currentWord.length() - 1; startSub++)
     {
     for(endSub = startSub + 1 ; endSub <= currentWord.length(); endSub++)
     {
      String currentSubString = currentWord.substring(startSub, endSub);
               
      if(isPalindrome(currentSubString) == true)
        currentPalindrome = currentSubString;
      if(currentPalindrome.length() > largestPalindrome.length())
        largestPalindrome = currentPalindrome;
      }
     }
     return largestPalindrome;
    }
    //This method will take the current substring and check to see if it is a
    //palindrome of any kind. If it is, it will return true, if not, false.
    public static boolean isPalindrome(String word)
    {
     int left = 0;
     int right = word.length() - 1;
        
     while(left < right)
     {
      if(word.charAt(left) != word.charAt(right))
      {
       return false;
      }
      left++;
      right--;
     }
     return true;
    }
}
