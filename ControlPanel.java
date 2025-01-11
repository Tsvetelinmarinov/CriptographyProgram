 /**
 * Cryptography program
 */

package appdata;



import java.util.Random;
import java.util.Scanner;





/**
 *
 */
public class ControlPanel {


    /**
     * The keys for the scripting process
     */
    private static final char[] keys = {
            '!','@','#','$','%',
            '^','&','*','(',')',
            '_','-','=','+','|',
            ';','.','>','<',',',
            '`','~','?','{',']',
            '}','[','§','№','€'
    };


    /**
     * Scanner to scan for user input
     */
    private static Scanner scan = new Scanner(System.in);


    /**
     * Random number for the keys array indexing
     */
    private static Random rand;










    /**
     *
     * @param args
     */
    public static void main(String[] args){ load_screen(); }









    /**
     * Load the game start menu
     */
    private static void load_screen(){

        //Print the "Welcome" text and the main menu
        System.out.println(
          "\n\n\n>>>>>>>>>>>>>>>>>>> Encrypting program <<<<<<<<<<<<<<<<<<<\n\n\n\n"+
          "  >   Choose option   <\n\n"+"  > 1. Encrypt text\n  > 2. Decrypt text\n  > 3. exit\n\n\n   "
        );

        System.out.print("  > ");

        //Get the user input
        int input = Integer.parseInt(scan.nextLine());

        System.out.println();


        switch(input){
            case 1:
                _ENCRYPT_();
                break;
            default: System.out.println("\n\n\n Invalid choose!\n Please select from allowed options.");
        }

    }







    /**
     * Encrypt a text to a key
     */
    private static void _ENCRYPT_(){

        System.out.print(" Type the text > ");

        //Holds the text that will be encrypted
        String txt = scan.nextLine();

        String rspn = new _SYSTEM_().rplc(txt,keys);

        System.out.println("\n\n Encrypted text >  " + rspn + "\n\n\n");

    }







    /**
     * Inner class to hold all the manin logic
     */
    private static final class _SYSTEM_{




        /**
         * Replace symbols
         */
        private String rplc(String text,char[] arrayOfKeys){

            //initialize the random number
            rand = new Random();

            char[] text_c = text.toCharArray();

            int text_length = text_c.length;

            //loop the text and replace the symbols
            for (int i = 0; i < text_length; i++) {
                text_c[i] = arrayOfKeys[rand.nextInt(30)];
                arrayOfKeys[i] = text_c[i];
            }


            return text_c.toString();

        }




    }





}
