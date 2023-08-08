using namespace std;

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // initialize map
        map<int,int> myMap;
        // iterate nums vector and add to map -- O(n)
        for (int i = 0; i < nums.size(); i++) 
        {
            myMap[nums.at(i)]++;
        }
        // initialize priority queue
        priority_queue<pair<int,int>> pq;
        for (auto i : myMap)
        {
            pq.push(make_pair(i.second, i.first));
        }
        vector<int> repeated;
        for (int i = 0; i < k; i++)
        {
            repeated.push_back(pq.top().second);
            pq.pop();
        }
        return repeated;
    }
};
