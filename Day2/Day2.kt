fun main(args: Array<String>) {
    val mapToInt = {str : String -> str.toInt()} //lambda for converting strings to ints
    
    // PART 1
    
    var checksum : Int? = 0 //init
    for (str in input.iterator()){
        var rowlist = str.split("\\s+".toRegex()) //split on any whitespace
        var numlist = rowlist.map(mapToInt) //this is why we need lambdas
        var min = numlist.min()
        var max = numlist.max()
        checksum = checksum!! + max!! - min!! //null safety is weird
    }
    println(checksum)
    
    // PART 2
    // This runs in O(N^3) time and I feel dirty
    checksum = 0 //reset
    for (str in input.iterator()){
        var rowlist = str.split("\\s+".toRegex()) //split on any whitespace
        var numlist = rowlist.map(mapToInt) //this is why we need lambdas
        var result = false
        for (i in numlist){
            for (j in numlist){
                if(i!=j && (i%j)==0){
                	checksum = checksum!! + (i/j)
                	break
            	}
            }
            if (result){
            	result = false
            }
        }
    }
    println(checksum)
    
}