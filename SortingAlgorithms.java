class SortingAlgorithms 
{
	public static void main( String[] args ) 
	{
		int[] a = new int[7];
		a[0]=89;
		a[1]=11;
		a[2]=76;
		a[3]=22;
		a[4]=33;
		a[5]=98;
		a[6]=18;
		quickSort(a);
		printAll(a);
	}

	//Median Method
	public static int median3(int[] a, int left, int right){
		int mid = (right+left)/2;
		if(a[left]>a[mid]){
			swapValues(a, left, mid);
		}
		if(a[left]>a[right]){
			swapValues(a, left, right);
		}
		if(a[right]<a[mid]){
			swapValues(a, right, mid);
		}
		return mid;
	}
	// FOR EXERCISE 2b. Median3s' algorithmic complexity is of O(1) since the inputs are constants and the algorithm works directly on constants

	//Helper Method to print the array
	public static void printAll(int[] a){
		for (int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
	
	}

	public static void insertionSort( int [] theArray )
	{
		insertionSort( theArray , theArray.length );
	}
	
	public static void selectionSort( int [] theArray )
	{
		selectionSort( theArray , theArray.length );
	}

	public static void quickSort( int [] theArray )
	{
		quickSort( theArray , 0 , theArray.length - 1 );
	}

	private static void insertionSort( int [] theArray , int n )
	{
		for ( int i = 1; i < n; i++ )
		{
			int temp = theArray[ i ];
			int loc = i;

			while ( ( loc > 0 ) && ( theArray[ loc-1 ] > temp ) )
			{
				theArray[ loc ] = theArray[ loc-1 ];
				loc = loc - 1;
			}
			theArray[ loc ] = temp;
		}
	}
	
	private static void selectionSort( int [] theArray , int n )
	{
		int i , minIndex;

		for ( i = 0; i < n-1; i++ )
		{
			minIndex = indexOfMinimum( theArray , i , n );
			swapValues( theArray , i , minIndex );
		}
	}

	private static int indexOfMinimum( int [] theArray , int i , int n )
	{
		int minIndex = i;

		for ( int j = i; j < n; j++ )
			if ( theArray[ j ] < theArray[ minIndex ] )
				minIndex = j;

		return minIndex;
	}
	
	private static final void swapValues( int [ ] a, int index1, int index2 )
	{
		int tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}

	private static void quickSort( int [] theArray , int low , int high )
	{
		int pivot_index;
		if ( low < high ) 
		{
			//pivot_index = partition ( theArray , low , high );
			pivot_index = median3(theArray, low, high);
			quickSort( theArray , low , pivot_index - 1 );
			quickSort( theArray , pivot_index + 1 , high );
		}
	}

	private static int partition( int [] theArray , int low , int high )
	{
		int left = low;
		int right = high;
		int pivot = theArray[ low ];

		while ( left < right )
		{
			while ( ( left < high ) && ( theArray[ left ] <= pivot ) )
				left++;

			while ( theArray[ right ] > pivot )
				right--;

			if ( left < right ) 
				swapValues( theArray , left , right );
		}

		swapValues( theArray , low , right );
		return right;
	}
}
