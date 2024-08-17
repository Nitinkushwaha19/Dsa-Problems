public class CreationSt {
    static int[] tree;
    public static void buildTree(int[] arr, int i, int start, int end){
        if( start == end){
            tree[i] = arr[start];
            return;
        }

        int mid = start + (end - start)/2;
        buildTree(arr, 2*i+1, start, mid); // leftHalf
        buildTree(arr, 2*i+2, mid+1, end); // rightHalf 

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }


    // get sum 
    public static int getSumUtil(int i, int si, int sj, int qi, int qj){
        if(qj < si || qi > sj) {
            return 0;

        }else if (si >= qi && sj <= qj){
            return tree[i];
        }else {
            int mid = (si + sj)/2;
            int left = getSumUtil(2*i+1,si , mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }
    
    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUtil(0,0,n-1,qi,qj);
    }



    // update on segment tree
    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx < si || idx > sj){
            return;
        }

        tree[i] += diff;

        if(si != sj){
            int mid = (si + sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void update(int[] arr, int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0, 0, n-1, idx, diff);

    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        tree = new int[4 * n];
        buildTree(nums, 0, 0, n - 1);

        int count = 0;
        for (int i = 0; i < tree.length; i++) {
            if (lower <= tree[i] && tree[i] <= upper) {
                System.out.println(tree[i]);;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {0,-3,-3,1,1,2};
        int n = arr.length;

        tree = new int[4 * n];
        buildTree(arr, 0, 0, n-1);

        for(int num : tree) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println(countRangeSum(arr, -2, 2));


        // System.out.println(getSum(arr, 2, 5));
        // update(arr, 2, 4);
        // System.out.println(getSum(arr, 2, 5));



    }
}