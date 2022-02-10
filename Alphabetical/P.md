## P~
![[PandaAdmireHat.png]]
### Parallel processing - Things to know before
I watched one of the presentations of Brian Goetz (Java Language Architect & specification lead for Lambda Expressions). He explains in detail the following 4 points to consider before going for parallelization:

* Splitting / decomposition costs  
Sometimes splitting is more expensive than just doing the work!
* Task dispatch / management costs  
Can do a lot of work in the time it takes to hand work to another thread.  
* Result combination costs  
Sometimes combination involves copying lots of data. For example, adding numbers is cheap whereas merging sets is expensive.  
* Locality  
The elephant in the room. This is an important point which everyone may miss. You should consider cache misses, if a CPU waits for data because of cache misses then you wouldn't gain anything by parallelization. That's why array-based sources parallelize the best as the next indices (near the current index) are cached and there are fewer chances that CPU would experience a cache miss.

He also mentions a relatively simple formula to determine a chance of parallel speedup.

NQ Model:
```
N x Q > 10000
```

where,  
N = number of data items  
Q = amount of work per item   

[stackoverflow - should-i-always-use-a-parallel-stream-when-possible](https://stackoverflow.com/questions/20375176/should-i-always-use-a-parallel-stream-when-possible)  
[Brian Goetz - Stream parallel processing](https://www.infoq.com/presentations/parallel-java-se-8/)

### User centric parallel Stream impl
```
public long getMaxPrice() { return priceStream().max(); }

private Stream priceStream() {
    return (prices.size() < MIN_PAR) ? 
    prices.stream() : prices.parallelStream();
}
```
[Java - StreamParallelGuidance] (http://gee.cs.oswego.edu/dl/html/StreamParallelGuidance.html)