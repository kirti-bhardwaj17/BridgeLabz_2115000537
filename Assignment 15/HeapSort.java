import java.util.*;
class HeapSort{
public static void heapSort(int a[], int n){
for(int i=n/2-1; i>=0; i--){
heapify(a, n, i);
}
for(int i=n-1; i>0; i--){
int temp = a[0];
a[0] = a[i];
a[i] = temp;
heapify(a, i, 0);
}
}
public static void heapify(int a[], int n, int i){
int largest = i;
int left = 2*i + 1;
int right = 2*i + 2;
if(left < n && a[left] > a[largest]){
largest = left;
}
if(right < n && a[right] > a[largest]){
largest = right;
}
if(largest != i){
int swap = a[i];
a[i] = a[largest];
a[largest] = swap;
heapify(a, n, largest);
}
}
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int a[]=new int[n];
for(int i=0;i<n;i++){
a[i]=sc.nextInt();
}
heapSort(a, n);
for(int i=0;i<n;i++){
System.out.print(a[i]+" ");
}
System.out.println();
}
}

