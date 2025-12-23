import java.util.Scanner;

public  class Main {
     static void main() {
         int size = 0;
         int[] array;

        System.out.print("Введите размер массива: ");
        int newSize = getArrSize();
        if(newSize != 0){
            size = newSize;
        }

        System.out.print(size);
        System.out.println();




    }

    public static int getArrSize(){
        Scanner sc = new Scanner(System.in);
        int newSize = 0;
        if(sc.hasNextInt()){
            newSize =  sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не целое число");
        }
        return newSize;
    }
}