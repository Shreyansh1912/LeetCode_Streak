class MedianFinder {
PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<Integer> minheap = new PriorityQueue<>();    
    
    public MedianFinder() {}
    
    public void addNum(int num) {
        if(maxheap.isEmpty() || maxheap.peek() >= num){
            maxheap.add(num);
        } else{
            minheap.add(num);
        }
        
        //either both heap have equal number or maxheap will have one more element than minheap
        if(maxheap.size() > minheap.size()+1)
            minheap.add(maxheap.poll());
        else if(maxheap.size() < minheap.size())
            maxheap.add(minheap.poll());
    }
    
    public double findMedian() {
        if(maxheap.size() == minheap.size()){
            return maxheap.peek()/2.0 + minheap.peek()/2.0;
        }
        //becz maxheap have more element than minheap
        return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
