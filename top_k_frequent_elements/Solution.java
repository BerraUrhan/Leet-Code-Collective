import java.util.*;

class Pair implements Comparable<Pair> {
    int first, second;
    Pair (int first, int second){
        this.first = first;
        this.second = second;
    }
    @Override
    public int compareTo(Pair other){
        return Integer.compare(other.second, this.second);
    }

}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //Couning frequencies in O(n) time and space:
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums){
            Integer freq = frequencies.get(num);
            if (freq == null)
                frequencies.put(num, 1);
            else 
                frequencies.put(num, freq+1);
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> key_value : frequencies.entrySet()){
            priorityQueue.add(new Pair(key_value.getKey(), key_value.getValue()));
        }

        int[] answer = new int[k];

        for (int i = 0; i < k; i++)
            answer[i] = priorityQueue.poll().first;

        return answer;
    }
}