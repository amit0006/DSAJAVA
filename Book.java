import java.util.*;
public class Book{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of books");
		int n = sc.nextInt();
		System.out.println("Enter the number of students");
		int m = sc.nextInt();
		System.out.println("Enter the pages of the books");
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		Solution s = new Solution();
		int ans = s.solution(a,n,m);
		System.out.println("Answer: "+ans);
	}
}
class Solution{
	int solution(int a[],int n,int m){
		int s = 0;
		int e = 0,ans=0;
		for(int i=0;i<n;i++)
			e+=a[i];
		int mid = s+(e-s)/2;
		Solution sl = new Solution();
		while(s<=e){
			if(sl.isPossible(a,n,m,mid)){
				ans = mid;
				e=mid-1;
			}
			else{
				s = mid+1;
			}
			mid = (s+e)/2;
		}
		return ans;
	}
	boolean isPossible(int a[],int n,int m,int mid){
		int studentCount = 1;
		int pageSum = 0;
		for(int i=0;i<n;i++){
			if(pageSum+a[i]<=mid){
				pageSum+=a[i];
			}
			else{
				studentCount++;
				if(studentCount > m || a[i]>mid){
					return false;
				}
				pageSum = a[i];
			}
		}
		return true;
	}
}
