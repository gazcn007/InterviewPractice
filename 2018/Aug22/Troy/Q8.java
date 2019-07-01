class RandomizedSet {
    HashSet<Integer> hashSet;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashSet = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = !hashSet.contains(val);
        if (result) hashSet.add(val);
        return result;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean result = hashSet.contains(val);
        if (result) hashSet.remove(val);
        return result;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = (int)(Math.random() * hashSet.size()) + 0;
        List<Integer> valuesList = new ArrayList<Integer>(hashSet);
        int randomIndex = new Random().nextInt(valuesList.size());
        return valuesList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
