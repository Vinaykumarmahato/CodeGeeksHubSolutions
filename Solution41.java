
/*

Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item here. 

Example 1:

Input:
N = 3, W = 50
value[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.000000
Explanation:
Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total weight becomes 60+100+80.0=240.0
Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 
Example 2:

Input:
N = 2, W = 50
value[] = {60,100}
weight[] = {10,20}
Output:
160.000000
Explanation:
Take both the items completely, without breaking.
Total maximum value of item we can have is 160.00 from the given capacity of sack.
Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size N and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= W <= 109
1 <= valuei, weighti <= 104




*/


import java.util.Arrays;
import java.util.Comparator;

// Comparator to compare items based on value-to-weight ratio
class ItemComparator implements Comparator<Item> {
    // Comparison function to sort items according to value/weight ratio
    @Override
    public int compare(Item a, Item b) {
        double ratioA = (double) a.value / a.weight;
        double ratioB = (double) b.value / b.weight;

        if (ratioA > ratioB) {
            return -1;
        } else if (ratioA < ratioB) {
            return 1;
        }
        return 0;
    }
}

// Class representing an item with a value and weight
class Item {
    int value;
    int weight;

    // Constructor for Item
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

// Class to solve the fractional knapsack problem
class FractionalKnapsackSolver {
    // Function to get the maximum total value in the knapsack
    double fractionalKnapsack(int W, Item arr[]) {
        // Sorting items based on value/weight ratio
        Arrays.sort(arr, new ItemComparator());

        // Variable to keep track of current weight in the knapsack
        int curWeight = 0;
        double finalValue = 0.0;

        // Iterating over all the items
        for (Item item : arr) {
            // If current weight + item's weight is less than or equal to W,
            // then add the entire item's value to the final value
            if (curWeight + item.weight <= W) {
                curWeight += item.weight;
                finalValue += item.value;
            }
            // Else take a fraction of the item's value based on the remaining weight in knapsack
            else {
                int remain = W - curWeight;
                finalValue += item.value * ((double) remain / item.weight);
                break;
            }
        }

        // Returning the final value
        return finalValue;
    }
}

// Class containing the main method for example usage
public class Solution {
    public static void main(String[] args) {
        // Example usage
        int knapsackCapacity = 50;
        Item[] items = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};

        FractionalKnapsackSolver solver = new FractionalKnapsackSolver();
        double result = solver.fractionalKnapsack(knapsackCapacity, items);

        System.out.println("Maximum value in the knapsack: " + result);
    }
}
