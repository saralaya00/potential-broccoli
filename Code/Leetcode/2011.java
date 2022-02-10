// 2011. Final Value of Variable After Performing Operations 
// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

// Easy enough problem for stream practice
// https://www.baeldung.com/java-stream-sum

// https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#stream-int:A-
// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#mapToInt-java.util.function.ToIntFunction-
// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
class Solution {
    //Streams Reduce Integer::sum
    public int fvaoReduceIntegerSum(String[] operations) {
        return Arrays.stream(operations)
            .map(x -> x.contains("++") ?  1 : x.contains("--") ? -1 : 0)
            .reduce(0, Integer::sum);
    }
    
    // Streams Vanilla reduce
    public int fvaoVanillaReduce(String[] operations) {
        return Arrays.stream(operations)
            .map(x -> x.contains("++") ?  1 : x.contains("--") ? -1 : 0)
            .reduce(0, (accumulated, current) -> {
                // System.out.println(accumulated);
                return accumulated + current;
            }
        );
    }
    
    // Streams Reduce mapToInt
    public int fvaoReduceMapToInt(String[] operations) {
        return Arrays.stream(operations)
            .map(x -> x.contains("++") ?  1 : x.contains("--") ? -1 : 0)
            .mapToInt(Integer::intValue)
            .sum();
    }

        
    // Streams Collector sum
    public int fvaoCollectorSum(String[] operations) {
        return Arrays.stream(operations)
            .map(x -> x.contains("++") ?  1 : x.contains("--") ? -1 : 0)
            .collect(Collectors.summingInt(Integer::intValue));
    }
    
    // String contains
    public int finalValueAfterOperations(String[] operations) {
        int sum = 0;
        for(String item: operations) {
            if (item.contains("++")) {
                sum++;
            } 
            else sum--;
        }
        return sum;
    }
}