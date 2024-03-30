import java.util.Scanner;

public class App {
    public int i, n;
    public int array[], l[], r[];
    Scanner sc = new Scanner(System.in);

    public void mergesort() {
        System.out.println("Enter the number of elements you want to sort");
        n = sc.nextInt();
        array = new int[n];

        System.out.println("Enter the elements now");
        insertvalues();
        
        sortArray(array, 0, array.length - 1);
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void insertvalues() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element for position " + i);
            array[i] = sc.nextInt();
        }
    }

    public void sortArray(int array[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortArray(array, l, m);
            sortArray(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    public void merge(int array[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int leftarr[] = new int[n1];
        int rightarr[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftarr[i] = array[l + i];
        }
        for (int j = 0; j < n2; j++) {
            rightarr[j] = array[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (leftarr[i] <= rightarr[j]) {
                array[k] = leftarr[i];
                i++;
            } else {
                array[k] = rightarr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftarr[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightarr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        App s = new App();
        s.mergesort();
    }
}
