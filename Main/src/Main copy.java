import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;

import javax.swing.plaf.synth.SynthTextAreaUI;

class Main {
    public static void printHelp(){
        System.out.println("Usage: Java [options] Main [-m average|median] | -h");
        System.out.println("This program is an example of processing" + "command line arguments.");
    }
    public static void main(String[] args) {
        String mode = "";

        //Array of the valid command line options
        LongOpt[] longOptions = {
               new LongOpt("mode", LongOpt.REQUIRED_ARGUMENT, null, 'm'),
                new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h')
        };

        //Make a Getopt object that can process our args array
        Getopt g = new Getopt("Lab1", args, "hm:", longOptions);
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
                        System.err.println("Error: invalid mode " + mode);
                        System.exit(1);

                    }
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

        System.out.println("you have selected " +mode + "mode.");

    }
}
