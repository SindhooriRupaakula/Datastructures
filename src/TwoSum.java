import java.util.Arrays;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;
        int[] nums2= nums.clone();
        Arrays.sort(nums2);
        System.out.println(nums[0]+" "+nums2[0]);
        int beg=0, end;
        end = nums2.length-1;
        //System.out.println()
        while(beg<end){
           int n1= nums2[beg];
           int n2= nums2[end];
           if((n1 + n2) == target)
            {	
                int[] ret= new int[]{-1,-1};
                for(int i=0;i<(nums.length);i++){
                    if(n1 == nums[i]) 
                    	{
                    		ret[0]=i;
                    	
                    	}
                    if(n2 == nums[i]) 
                    {
                    	ret[1]=i;
                    }
                }
                return ret;
            }
            else if((n1+n2) >target){
                end--;
                
            }
            else if((n1+n2) <target){
                beg++;
                
            }
        }
        int[] ret= new int[]{-1,-1};
        return ret;
        
    }
    
    public static void main(String args[]){
    	int[] n = new int[]{3,2,4};
    	TwoSum t = new TwoSum();
    	System.out.println("===="+t.twoSum(n,6)[0]);
    	System.out.println("========"+t.twoSum(n,6)[1]);
    }
}