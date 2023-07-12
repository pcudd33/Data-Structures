import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void printHelp(){
        System.out.println("Usage: Java [options] Main [-m average|median] | -h");
        System.out.println("This program is an example of processing" + "command line arguments.");
    }
    public static void main(String[] args) {
        String mode = "";
        boolean verbose = false;

        //Array of the valid command line options
        LongOpt[] longOptions = {
               new LongOpt("mode", LongOpt.REQUIRED_ARGUMENT, null, 'm'),
                new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h'),
                new LongOpt("verbose", LongOpt.NO_ARGUMENT, null, 'v')
        };

        //Make a Getopt object that can process our args array
        Getopt g = new Getopt("Lab1", args, "hvm:", longOptions);
        g.setOpterr(true);

        int choice; // what Getopt processed most recently

        // process the command line arguments
        //g.getopt() return the int representing the short flag
        //or -1 if we are done
        while((choice = g.getopt())!= -1) {
            //choice stores a command line argument in the process
            //figure out which option we are processing
            switch (choice) {
                case 'h':
                    printHelp();
                    System.exit(0);
                    break;
                case 'm':
                    mode = g.getOptarg();
                    if (!mode.equals("average") && !mode.equals("median")){
                        System.err.println("this is an invalid method");
                        System.exit(1);

                    }
                    break;
                case 'v':
                    verbose = true;
                    break;
                default:
                    System.err.println("Error: invalid option");
                    System.exit(1);
            }
        }//while

        //Check that we got all required options
        //for us, that is the mode flag
        if (mode.equals("")){
            //mode never got set
            System.err.println("specify the mode ");
            System.exit(1);
        }

        System.out.println("you have selected " + mode + " mode.");

        Scanner in = new Scanner(System.in);
        int AmountInt = in.nextInt();
        //System.out.println("Enter your amount of integers: ");


        if (AmountInt == 0){
            System.out.println("No data => no Statistics!");
            System.exit(0);
        }
        if (AmountInt < 0){
            System.err.println("Input numbers out of bounds");
            System.exit(1);
        }
        if (verbose){
            System.out.println("reading " + AmountInt + " numbers.");
            System.out.println("read "+AmountInt+" numbers");
        }

        float[] data = new float[AmountInt];
        for (int i = 0;i < AmountInt; i++){
            data[i] = in.nextFloat();
        }

        if (mode.equals("average")){
            MyAverage(data);
        }

        if (mode.equals("median")){
           MyMedian(data);
        }

    }
    public static void MyAverage(float[] data){
        int length = data.length;
        float sum = 0;
        for (int i2 = 0; i2 < length; i2++){
            sum += data[i2];
        }
        float average = sum / length;
        System.out.println("The average of the array: "+ Math.round(average * 100)/100.0);
    }
    //https://stackoverflow.com/questions/11955728/how-to-calculate-the-median-of-an-array
    //how to find the median of an array
    private static void MyMedian(float[] data) {
        Arrays.sort(data);
        float median;
        if (data.length % 2 == 0){
            median = ((float)data[data.length/2] + (float)data[data.length/2 -1])/2;
        }else{
            median = (float) data[data.length/2];
        }
        System.out.println("The median of the array is: "+ Math.round(median *100)/100.0);
    }

}
