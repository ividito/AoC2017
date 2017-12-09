fun main(args: Array<String>) {
    // PART 1
    var size = input.count()
    println("Size is "+size)
    var answer = 0 //init value
    var last = input[size-1] //init value, also covers last case
    for (c in input){
        if (c==last){
            answer = answer + valToInt(c)
        }
        last = c
    }
    println(answer) //Part 1 Answer
    
    //PART 2
    //create 2 substring halves
    answer = 0 //reset answer variable
    val halfSize = size/2
    val firstHalf = input.substring(0, halfSize) //second arg is exclusive, first arg is inclusive
    val secondHalf = input.substring(halfSize) //goes to end of string by default
    for (i in firstHalf.indices){
        if (firstHalf[i]==secondHalf[i]){
            answer = answer + (valToInt(firstHalf[i])*2)
        }
    }
    println("Part 2: "+answer) //Part 2 Answer
}

// Function to simplify the Char -> Int conversion
fun valToInt(c : Char): Int {
    val result = c.toInt()-'0'.toInt()
    return result
}