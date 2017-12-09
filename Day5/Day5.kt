fun main(args: Array<String>) {
	var i=0
    var count=0
    while(i<input.size){
        if(input[i]>2){
            input[i] = input[i]-1
            i = i+input[i]+1
        }
        else{
        	input[i]= input[i]+1
            i = i+input[i]-1
        }
        count++
    }
    println(count)
}