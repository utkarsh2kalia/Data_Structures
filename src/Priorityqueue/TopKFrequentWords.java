package Priorityqueue;

import java.util.*;


//Given a non-empty list of words, return the k most frequent elements.
//
//        Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
//        Example 1:
//        Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//        Output: ["i", "love"]
//        Explanation: "i" and "love" are the two most frequent words.
//        Note that "i" comes before "love" due to a lower alphabetical order.
//        Example 2:
//        Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//        Output: ["the", "is", "sunny", "day"]
//        Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//        with the number of occurrence being 4, 3, 2 and 1 respectively.



class Pair{
    String key; int value;

    Pair(String key, int value)
    {
        this.key = key; this.value = value;
    }

}

public class TopKFrequentWords {




        public List<String> topKFrequent(String[] words, int k) {

            // if the frequency is equal, return the word with lower alphabetical order
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.value==b.value?a.key.compareTo(b.key):b.value-a.value);
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i<words.length; i++){

                if(!map.containsKey(words[i]))
                    map.put(words[i], 1);

                else
                    map.put(words[i], map.get(words[i])+1);



            }

            map.forEach((key,value)-> pq.add(new Pair(key,value)));

            List<String> list = new ArrayList<>();


            while(!pq.isEmpty() && k!=0){

                list.add(pq.poll().key);
                k--;

            }
            return list;


        }


    public static void main(String[] args) {


            String words[] ={"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
            TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(words, 4));


    }
    }

