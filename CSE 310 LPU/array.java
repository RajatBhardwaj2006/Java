import java.util.Scanner;
public class array{
    // enum
    enum Day{
            MONDAY, TUESDAY, WEDNESDAY
    }

    enum traffic{
        RED, YELLOW, GREEN
    }

    enum day{
        MONDAY, TUESDAY, WEDNESDAY, THURESDAY, FRIDAY, SATURDAY, SUNDAY
    }
    /* 
    varargs
    It must be last parameter
    only one varargs is allowed
    */
    // sum of n number 
        static int sum(int ... nums){
            int s = 0;
            for(int x : nums){
                s += x;
            }
            return s;
        }
    // find the largest value in an array 

    static int largest_values(int ... arr){
        int largest = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] arr = {10, 20, 30, 40};

        System.out.print(arr[0]);// 20 because we access it using index

        int size = 5;
        int [] marks = new int[size];
        System.out.println("Length of Array: "+marks.length);
        for(int i=0; i<marks.length; i++){
            int value = sc.nextInt();
            marks[i] = value;
        }
        System.out.println("Array values: ");
        for(int i=0; i<marks.length; i++){
        System.out.print(marks[i]+" ");
        }

        // for each loop  in array 
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};

        for (int x : arr1){
            // System.out.println(x+" ");
        }


        //  multi dimensional array 

        int [][] mat_arr; // declare array

        int [][] mat_arr = new int[1][2]; // creating 2D array (2 rows and three columns)

        int [][] mat_arr = { // initializing 2D array
        //   0   1   2 Columns 
            {1,  2,  3}, // 0 Rows 
            {4,  5,  6}, // 1 Rows
            {7,  8,  9}  // 2 Rows
        }; 
        // First rows then columns will execute
        System.out.print(mat_arr[2][0]); // 7
        System.out.print(mat_arr[0][2]); // 3
        System.out.print(mat_arr[2][1]); // 8


        //print 2D array

        int [][]mat_arr2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for(int i=0; i<mat_arr2.length; i++){
            for(int j=0; j<mat_arr2.length; j++){
                System.out.print(mat_arr2[i][j]+" ");
            }
            System.out.println();
        }

        // varargs 
        System.out.println("Sum of numbers: "+sum(1,2,3,4,5,6,7,8,9,10));
        System.out.println("Largest in an Array: "+largest_values(100,2,3,4,5,6,7,8,9,10));

        // Enumerations (ENUM)
        // Enum is a special data type that represents a fixed set of constant values.

        // Day de = Day.TUESDAY;
        // System.out.println(de);

        traffic t = traffic.RED;

        switch(t){
            case RED:
                System.out.println("Stop");
                break;
            case YELLOW:
                System.out.println("Ready to Go OR Slow down");
                break;
            case GREEN:
                System.out.println("GO.");
                break;
        }

        for (day d : day.values()){
            System.out.println(d);
        }
    }
}