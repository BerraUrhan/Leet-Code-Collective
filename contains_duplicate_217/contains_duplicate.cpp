class Solution {
public:
    bool containsDuplicate(vector<int>& nums)
    {
        // first create a hash set
        unordered_set<int> mySet;
        // add elements to set
        for (int i = 0;i < nums.size(); i++)
        {
            if (mySet.count(nums.at(i)) > 0)
            {
                return true;
            }
            mySet.insert(nums.at(i));
        }
        return false;
    }

};