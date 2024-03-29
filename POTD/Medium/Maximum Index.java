


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int A[], int N) { 
        
        //using sliding window
        //the approcah is to find the min from the left 
        //the maximums from the right so that i can keep the index diff large
        //why because take the example of 2
        //as 34 is less than 80 i can slide up to 80 so that index
        //diff can be large
        
        int left_min[] = new int[N];
        int right_max[] = new int[N];
        
        left_min[0] = A[0];
        right_max[N-1] = A[N-1];
        
        for(int i=1 ; i<N ; i++){
            left_min[i] = Math.min(left_min[i-1],A[i]);
        }
        for(int i=N-2 ; i>=0 ; i--){
            right_max[i] = Math.max(A[i],right_max[i+1]);
        }
        
        //for a sliding window we have to use two pointers
        int left_ptr = 0 , right_ptr = 0 ;
        int maxDiff = 0;
        while(left_ptr<=right_ptr && right_ptr<N){
            if(left_min[left_ptr]<=right_max[right_ptr]){
                right_ptr++;
            }
            else{
                maxDiff = Math.max(right_ptr-left_ptr-1,maxDiff);
                left_ptr++;
            }
            
        }
        right_ptr--;
        if(left_ptr<=right_ptr){
        maxDiff = Math.max(right_ptr-left_ptr,maxDiff);
        }
        return maxDiff;
        
    }
}
