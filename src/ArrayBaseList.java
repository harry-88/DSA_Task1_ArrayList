import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayBaseList {
    int arrayList[];
    int size;
    int noOfElement;
    public ArrayBaseList()
    {
        arrayList = new int[5];
        size = 5;
        noOfElement = 0;
    }

    public int[] getArrayList() {
        return arrayList;
    }

    public void setArrayList(int[] arrayList) {
        this.arrayList = arrayList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNoOfElement() {
        return noOfElement;
    }

    public void setNoOfElement(int noOfElement) {
        this.noOfElement = noOfElement;
    }

    public void insertAtEnd(int value)//the purpose of this method is to add data at the end of the array
    {
        if (noOfElement == arrayList.length)
        {
            int arr[] = new int[arrayList.length*2];
            for (int i = 0;i<noOfElement;i++)
                arr[i] = arrayList[i];

            arrayList = arr;
        }
        arrayList[noOfElement] = value;
        noOfElement++;
    }

    public void insertAtIndex(int value,int index)//the purpose of this method is to insert the data at the required index
    {
        if (index < 0 || index > noOfElement)
            throw new IllegalAccessError("you entered an illegal index");
        else {
            if (noOfElement == arrayList.length) {
                int arr[] = new int[arrayList.length * 2];
                for (int i = 0; i < noOfElement; i++)
                    arr[i] = arrayList[i];

                arrayList = arr;
            }
            noOfElement++;
            for (int i = noOfElement - 1; i > index; i--)
                arrayList[i] = arrayList[i - 1];
            arrayList[index] = value;


        }
    }

    public void removeFromEnd()
    {
        noOfElement--;
    }//the purpose of this method is to remove the last data

    public void removeFromIndex(int index)//the purpose of this method is to remove the data from required index
    {
        if (index < 0 || index > noOfElement)
            throw new IllegalAccessError("you entered an illegal index");
        else
        {
            for (int i = index;i<noOfElement;i++)
               arrayList[i] = arrayList[i+1];

            noOfElement--;

        }
    }
    public void print()//the purpose of this method is to print the data of the array
    {
        System.out.println("arrays data are :");
        for (int i = 0;i<noOfElement;i++)
            System.out.println(arrayList[i]);
    }
    public int linearSearch(int value)//the purpose of this method is to search the data by linear search
    {
        for (int i = 0;i<noOfElement;i++)
            if (arrayList[i] == value)
                return i;

            return -1;
    }

    public int binarySearch(int value)//the purpose of this method is to search the data by binary search
    {
        int left = 0;
        int right = noOfElement;
        int mid = 0;
        int arr[] = new int[noOfElement];
        System.out.println("the array is :");
        for (int i = 0;i<noOfElement;i++) {
            arr[i] = arrayList[i];
        }

        Arrays.sort(arr);

        while (left<=right)
        {
            mid = (left + right)/2;
            if (arr[mid] == value)
                return mid;
            else if(arr[mid] < value)
                left += 1;
            else
                right  -= 1;
        }
        return -1;
    }

    public void removeDuplicate()//the purpose of this method is to remove the duplicate data
    {
        for (int outter  = 0; outter < noOfElement;outter++)
        {
            for (int inner = outter + 1;inner < noOfElement;inner++)
            {
                if (arrayList[outter] == arrayList[inner])
                {
                    for (int i = inner;i<noOfElement - 1;i++)
                    {
                        arrayList[i] = arrayList[i+1];
                    }
                    noOfElement--;
                }
            }
        }
    }

    public void copyList(int arr[],int size)//the purpose of this method is to copy the  array at the end of the same array
    {
        if (size>= 0)
            for (int i = 0;i<size;i++)
                insertAtEnd(arr[i]);
    }

    public void mergeTwoLists(int arr[],int size)// the purpose of this method is to merge the array of the arrayList.
    {
        int len = arrayList.length;
        if (size < 0 || size > (len-noOfElement)) {

            int arr1[] = new int[len * 2];
            for (int i = 0; i < noOfElement; i++)
                arr1[i] = arrayList[i];

            arrayList = arr1;

        }

        int l = noOfElement;
        for (int i = noOfElement;i<l+size;i++)
        {
            this.arrayList[noOfElement] = arr[i];
            noOfElement++;
        }
    }

    public void addMultipleElement()
    {
        Scanner scanner = new Scanner(System.in);
        char ch = 'y';
        do{
            System.out.print("enter a number ");
            int num = scanner.nextInt();
            System.out.println("enter the index in which you want to add the number ");
            int index = scanner.nextInt();
            insertAtIndex(num, index);
            System.out.println("do you want to enter data again(y-yes/n-no) ? ");
            ch = scanner.next().charAt(0);
        }while (ch == 'y' || ch == 'Y');

    }

    public static void main(String[] args) {
        ArrayBaseList arrayBaseList = new ArrayBaseList();

        int i[] = {23,36,2,0,12,34};
        arrayBaseList.copyList(i,i.length);//this statement store the copy of the data in the array of arrayBaseList
        arrayBaseList.print();//it display all the element of the array
        arrayBaseList.addMultipleElement();//it take the data from the user as the user need
        arrayBaseList.print();// it display the array after adding same new data members
    }


}