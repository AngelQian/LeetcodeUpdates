class MinStack {
    int size = 10;
    int[] sarr = new int[size];
    int index = -1;
    
    public void push(int x) {        
        if(index>size/2)
           balanceSize(size*2);   
        
        sarr[++index] = x;
    }

    public void pop() {
        index --;
        if(index < -1)
          index=-1;
        
        if(index > 0 && index<size/2)
            balanceSize(size/2);
    }

    public int top() {
        return sarr[index];
    }

    public int getMin() {
        if(index<0)
           return 0;
        int min = sarr[0];
        for(int i=1; i<=index; i++){
        	if(sarr[i]<min)
        		min = sarr[i];
        }
        return min;
    }
    
    private void balanceSize(int s){
        size = s;
        int[] tmp = new int[s];
        for(int i = 0; i<= index; i++)
        {
            tmp[i] = sarr[i];
        }
        sarr = tmp;
    }
}
