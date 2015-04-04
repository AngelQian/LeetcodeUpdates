class MinStack {
   Stack<Integer> sms = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    
    public void push(int x) { 
    	sms.push(x);
    	pushMin(x);
    }

    public void pop() {
    	popMin(sms.pop());
    }

    public int top() {
    	return sms.peek();
    }

    public int getMin() {
    	return mins.peek();
    }
    private void pushMin(int x){
    	if(mins.isEmpty() || x<=mins.peek()){
    		mins.push(x);
    	}
    }
    private void popMin(int x){
        if(x==mins.peek())
        mins.pop();
    }
}
