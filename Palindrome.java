import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Palindrome {

    // declaring and initalizing required static variables
    static int top = -1, size = 100;
    static char  stack[] = new char[size];

    protected static int rear = -1;			    // index for the rear of the queue
    protected static int capacity = 100; 		    // The actual capacity of the queue array
    protected static char Q[] = new char[capacity];	// array used to implement the queue

    //declaring varaibles and arrays for counting operation
    static int operation_counter1=0,operation_counter2=0,operation_counter3=0,operation_counter4=0;
    static int op_count1[] = new int[1000001];
    static int op_count2[]= new int[1000001];
    static int op_count3[] = new int[1000001];
    static int op_count4[] = new int[1000001];

    public static Scanner obj = new Scanner(System.in);

    public static void main(String args[]) throws IOException, WriteException {

        //initalizing required variables
        String input, binary;
        double  time_method1,time_method2, time_method3,time_method4;
        int countBoth_method1 = 0, count_method1 = 0,countBoth_method2 = 0, count_method2 = 0,
        countBoth_method3 = 0, count_method3 = 0,countBoth_method4 = 0, count_method4 = 0;

        Boolean palindrome, palindrome_binary;

        System.out.println("Method 1: ");

        //code for testing method 1
        // timer starts here
       time_method1 = System.currentTimeMillis();
        for ( int i = 0 ; i <= 1000000 ; i++ ) {

            //storing the number as string
            input = Integer.toString(i);
            // converting to binary using convertBinary() function
            binary = convertBinary(input);
            // palindrome variable stores true if the number is a palindrome else false
            palindrome = reverse_string(input);
            // palindrome_binary variable store true if the binary representation of the number is palindrome else false
            palindrome_binary = reverse_string(binary);

            // if both decimal and binary representation is palindrome for a number
            if (palindrome && palindrome_binary) {
                //counter for both increments by 1
                countBoth_method1++;
                count_method1++;
            }
            // either of the representation is a palindrome
            if (palindrome || palindrome_binary)
                // counter increases by 1
                count_method1++;

            //number of operations taken for checking is added to array
           op_count1[i] = operation_counter1;
           //operation counter is reset for the next run
            operation_counter1 = 0;

        }
        System.out.println("Number of palindromes: "+count_method1);
        System.out.println("Number of palindromes in both decimal and binary: "+countBoth_method1);
        // timer stops here
        time_method1 = System.currentTimeMillis() - time_method1; // calculating the time taken
        System.out.println("Time taken: "+time_method1 + " millisecond");
        System.out.println("");

        //code for testing method 2
        System.out.println("Method 2: ");
        // timer starts here
        time_method2 = System.currentTimeMillis();
        for ( int i = 0 ; i <= 1000000 ; i++ ) {

            //storing the number as string
            input = Integer.toString(i);
            // converting to binary using convertBinary() function
            binary = convertBinary(input);
            // palindrome variable stores true if the number is a palindrome else false
            palindrome = element_comparison(input);
            // palindrome_binary variable store true if the binary representation of the number is palindrome else false
            palindrome_binary = element_comparison(binary);


            // if both decimal and binary representation is palindrome for a number
            if (palindrome && palindrome_binary) {
                //counter for both increments by 1
                countBoth_method2++;
                count_method2++;
            }
            // either of the representation is a palindrome
            if (palindrome || palindrome_binary)
                // counter increases by 1
                count_method2++;

            //number of operations taken for checking is added to array
            op_count2[i] = operation_counter2;
            //operation counter is reset for the next run
            operation_counter2 = 0;
        }
        System.out.println("Number of palindromes: "+count_method2);
        System.out.println("Number of palindromes in both decimal and binary: "+countBoth_method2);
        time_method2 = System.currentTimeMillis() - time_method2; // calculating time taken
        System.out.println("Time taken: "+time_method2 + " millisecond");
        System.out.println("");

        //code for testing method 3
        System.out.println("Method 3: ");
        // timer starts here
        time_method3 = System.currentTimeMillis();
        for ( int i = 0 ; i <= 1000000 ; i++ ) {

            //storing the number as string
            input = Integer.toString(i);
            // converting to binary using convertBinary() function
            binary = convertBinary(input);
            // palindrome variable stores true if the number is a palindrome else false
            palindrome = stack_queue(input);
            // palindrome_binary variable store true if the binary representation of the number is palindrome else false
            palindrome_binary = stack_queue(binary);

            // if both decimal and binary representation is palindrome for a number
            if (palindrome && palindrome_binary) {
                //counter for both increments by 1
                countBoth_method3++;
                count_method3++;
            }
            // either of the representation is a palindrome
            if (palindrome || palindrome_binary)
                // counter increases by 1
                count_method3++;

            //resetting top and rear values for next run
            top = -1;
            rear = -1;

            //number of operations taken for checking is added to array
            op_count3[i] = operation_counter3;
            //operation counter is reset for the next run
            operation_counter3 = 0;

        }
        System.out.println("Number of palindromes: "+count_method3);
        System.out.println("Number of palindromes in both decimal and binary: "+countBoth_method3);
        time_method3 = System.currentTimeMillis() - time_method3; // calculating time taken
        System.out.println("Time taken: "+time_method3 + " millisecond");
        System.out.println("");

        //code for testing method 4
        System.out.println("Method 4: ");
        // timer starts here
        time_method4 = System.currentTimeMillis();
        for ( int i = 0 ; i <= 1000000 ; i++ ) {

            //storing the number as string
            input = Integer.toString(i);
            // converting to binary using convertBinary() function
            binary = convertBinary(input);
            // palindrome variable stores true if the number is a palindrome else false
            palindrome = using_recurssion(input);
            // palindrome_binary variable store true if the binary representation of the number is palindrome else false
            palindrome_binary = using_recurssion(binary);

            // if both decimal and binary representation is palindrome for a number
            if (palindrome && palindrome_binary) {
                //counter for both increments by 1
                countBoth_method4++;
                count_method4++;
            }
            // either of the representation is a palindrome
            if (palindrome || palindrome_binary)
                // counter increases by 1
                count_method4++;

            //number of operations taken for checking is added to array
            op_count4[i] = operation_counter4;
            //operation counter is reset for the next run
            operation_counter4 = 0;
        }
        System.out.println("Number of palindromes: "+count_method4);
        System.out.println("Number of palindromes in both decimal and binary: "+countBoth_method4);
        time_method4 = System.currentTimeMillis() - time_method4; // calculating time taken
        System.out.println("Time taken: "+time_method4 + " millisecond");

        //the number of operation store in the arrays is sent to createExcel() method to create and add datas in .xls file
        createExcel(op_count1,op_count2,op_count3,op_count4);

    }


    // reverse_string function implements the 1st method to check for palindrome
    public static boolean reverse_string(String input) {

        String reverse_input = "";
        int length = input.length();

        // running loop from length-1 to 0 to reverse the elements and store it in an array
        for (int i = length - 1; i >= 0; i--) {
            reverse_input += input.charAt(i);
            operation_counter1++;// increasing operation counter
        }
        // checking whether reversed string is equal to the original input
        if (input.equals(reverse_input))
            //returns true if equal(palindrome)
            return true;
        else return false;

    }

    // element_comparison() function implements the 2nd method to check for palindrome
    public static boolean element_comparison(String input) {
        int length = input.length();

        char c1, c2;
        int j = length - 1;

        //running loop from 0 to middle of the string
        for (int i = 0; i < length/2; i++) {

            c1 = input.charAt(i);
            operation_counter2++;

            c2 = input.charAt(j);
            operation_counter2++;

            operation_counter2++;
            // checking if character a position i and j are equal
            if (c1 != c2) {
                // if not equal the function returns false
               return false;
           }
            operation_counter2++;

            //j is decremented by 1
            j--;

        }
        //if the number is palindrome the function returns true
        return true;
    }

    // stack_queue function implements the 3rd method to check for palindrome
    public static boolean stack_queue(String input) {

        boolean flag = true;

        for (int i = 0 ; i < input.length() ; i++ ){
            operation_counter3++;
            // digit at poition i in the string is pushed into the stack
            push(input.charAt(i));
            operation_counter3++;
            // digit at poition i in the string is added to the queue
            enqueue(input.charAt(i));
        }

        // loop runs till the stack and queue is not empty
        while(!isEmpty() && !QisEmpty()){

            operation_counter3++;
            // checking the popped element with dequed element
            if (dequeue() != pop())
            {
                //if there arent same then returns false
                flag = false;

            }
        }
        // return true if they are all same
        return flag;
    }

    // using_recurssion() function implements the method 4 for checking palindrome
    public static boolean using_recurssion(String input){

        operation_counter4++;
        // return true if input is equal to the reverse string else false
        return input.equals(reverse(input))?true:false;

    }

    static String reversed_string = "";
    // reverse function is a recursive function used to reverse the digits in th estring
    public static String reverse(String input_string){



        // base condition when input string become empty return to the previous function
        if (input_string.isEmpty()){
            operation_counter4++;
            return input_string;
        }

        operation_counter4++;
        //calls itself by updating the value argument value to substring(1) of the input value and adding charAt(0) to the return
        return reverse(input_string.substring(1)) + input_string.charAt(0);
    }

// convertBinary() function converts decimal to binary
    public static String convertBinary(String decimal) {

        // string is converted to interger
        int n = Integer.parseInt(decimal);
        StringBuilder bin = new StringBuilder();

        //loop runs till the integer becomes 0
        while (n > 0) {
            // the modulus of the number by 2 is added to the string
            bin.append(n % 2);
            // the number is divided by 2
            n /= 2;
        }
        // string reversed and returned
        String binary = bin.reverse().toString();

        return binary;
    }


    // pop element remove and returns the top element of the stack array
    public static char pop() {

        char item;

        if (top < 0) {
            operation_counter3++;
            System.out.println("Stack underflow");
            return ' ';
        } else {

            item = stack[top];
            operation_counter3++;
            stack[top] = ' ';
            operation_counter3++;
            top--;
            operation_counter3++;
            return item;
        }
    }

    //push method pushes the element in the stack array
    public static void push(char item){

        if(top > size-1 )
            System.out.println("Stack Overflow");
        else {
            operation_counter3++;
            top++;
            operation_counter3++;
            stack[top] = item;
        }
    }

    // isEmpty checks whether the stack array is empty
    public static boolean isEmpty(){
        if (top==-1) {
            operation_counter3++;
            return true;
        }else{
            operation_counter3++;
            return false;
    }}

    public static void enqueue(char n)
    {
        if (isFull()) {
            operation_counter3++;
            System.out.println("Cannot enqueue object; queue is full.");
            return;
        }
        operation_counter3++;
        rear++;
        operation_counter3++;
        Q[rear] = n;
    }

    public static char dequeue()
    {
        // Can't do anything if it's empty
        if (QisEmpty())
            return ' ';

        char toReturn = Q[0];

        // shuffle all other objects towards 0
        int i = 1;
        while (i <= rear) {
            operation_counter3++;
            Q[i-1] = Q[i];
            operation_counter3++;
            i++;
        }
        operation_counter3++;
        rear--;
        return toReturn;
    }

    public static boolean QisEmpty()  {
        return (rear < 0);
    }

    public static boolean isFull() {
        return (rear == capacity-1);
    }


    public static void createExcel(int op_count1[],int op_count2[],int op_count3[],int op_count4[]) throws IOException,WriteException {

        int row = 1;

        // creating workbook
        WritableWorkbook workbook = Workbook.createWorkbook(new File("./palindrome.xls" +
                ""));

        //adding new worksheet
        WritableSheet excelSheet = workbook.createSheet("palindrome test", 0);

        // creating new coloum heading cells
        Label coloumn0 = new Label(0, 0, "Number Range");
        Label coloumn1 = new Label(1, 0, "Method  1");
        Label coloumn2 = new Label(2, 0, "Method  2");
        Label coloumn3 = new Label(3, 0, "Method  3");
        Label coloumn4 = new Label(4, 0, "Method  4");
        //adding heading cells to the worksheet
        excelSheet.addCell(coloumn0);
        excelSheet.addCell(coloumn1);
        excelSheet.addCell(coloumn2);
        excelSheet.addCell(coloumn3);
        excelSheet.addCell(coloumn4);

        // loop to add data from array to worksheet
        for (int i=0;i<= 1000000;i+=16){

            //creating cells with data from array
            jxl.write.Number range = new jxl.write.Number( 0, row,i);
            jxl.write.Number no_op1 = new jxl.write.Number( 1, row,op_count1[i]);
            jxl.write.Number no_op2 = new jxl.write.Number( 2, row,op_count2[i]);
            jxl.write.Number no_op3 = new jxl.write.Number( 3, row,op_count3[i]);
            jxl.write.Number no_op4 = new jxl.write.Number( 4, row,op_count4[i]);

            //adding cells containing data to worksheet
            excelSheet.addCell(range);
            excelSheet.addCell(no_op1);
            excelSheet.addCell(no_op2);
            excelSheet.addCell(no_op3);
            excelSheet.addCell(no_op4);

            row++;
        }
            workbook.write();
            workbook.close();

    }

}