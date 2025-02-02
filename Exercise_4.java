class MergeSort
{
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r)
    {
        //Your code here
        int leftLen = m-l+1;
        int rightLen = r-m;

        int leftArr[] = new int[leftLen];
        int rightArr[] = new int[rightLen];

        for(int i = 0; i < leftLen; i++){
            leftArr[i] = arr[l+i];
        }

        for(int i = 0; i < rightLen; i++){
            rightArr[i] = arr[m+i+1];
        }

        int i = 0, j = 0, k = l;

        while(i < leftLen && j < rightLen){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            }
            else{
                arr[k++] = rightArr[j++];
            }
        }

        while(i < leftLen){
            arr[k++] = leftArr[i++];
        }

        while(j < rightLen){
            arr[k++] = rightArr[j++];
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        //Write your code here
        //Call mergeSort from here
        if(l >= r) return;

        int m = l +(r-l)/2;

        sort(arr, l, m);
        sort(arr, m+1, r);

        merge(arr, l, m, r);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method 
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
} 