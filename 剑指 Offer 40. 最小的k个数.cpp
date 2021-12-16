class Solution {
public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        sort(arr.begin(),arr.end());
        vector<int> ans(arr.begin(), arr.begin()+k);
        return ans;
    }
};

class Solution {
public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        quickSort(arr,0,arr.size()-1);
        vector<int> ans(arr.begin(), arr.begin()+k);
        return ans;
    }
    void quickSort(vector<int>& arr, int l, int r)
    {
        if(l >= r) return ;
        int i = l, j = r;
        while(i < j)
        {
            while(arr[j]>=arr[l] && i < j) j--;
            while(arr[i]<=arr[l] && i < j) i++;
            swap(arr[i],arr[j]);
        }
        swap(arr[l],arr[i]);
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }
};