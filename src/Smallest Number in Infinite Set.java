class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    int smallest;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        smallest = 1;
    }

    public int popSmallest() {
        // System.out.println("popping smallest");
        if (pq.isEmpty()) {
            // System.out.println("pq empty");
            return smallest++;
        }
        // System.out.println("pq not empty peek: "+pq.peek());
        set.remove(pq.peek());
        return pq.poll();

    }

    public void addBack(int num) {
        // System.out.println("num is "+num+" smallest is "+smallest);
        if (smallest > num) {
            // System.out.println("inside if");
            int sizeprev = set.size();
            set.add(num);
            if (sizeprev < set.size()) {
                pq.add(num);
            }
        }

    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
