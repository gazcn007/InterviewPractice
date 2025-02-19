class Logger {

    private HashMap<String, Integer> logs;
    /** Initialize your data structure here. */
    public Logger() {
        logs = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!logs.containsKey(message)) {
            logs.put(message, timestamp);
            return true;
        } else {
            if (timestamp - logs.get(message) < 10) {
                return false;
            }
             logs.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
