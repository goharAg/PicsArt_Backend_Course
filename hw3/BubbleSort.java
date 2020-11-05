package hw3;

public class BubbleSort {

    public static void main(String[] args) {
        int[] myArray = {1,3,4,6,2,8,1,9,8};
        bubbleSort(myArray);

        for(int k = 0; k < myArray.length; k++){
            System.out.print(myArray[k] + " " );
        }

    }

    public static void bubbleSort(int[] array){
        int len = array.length;
        for(int i = 0; i < len-1; i++ ){
            boolean swapped = false;
            for(int j = 0; j < len-i-1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }

            }
            if(!swapped){
                break;
            }

        }
    }
}
