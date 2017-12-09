import kotlin.math.*

fun main(args: Array<String>) {
    //PART1
	var side:Double = side_length(input)
    var xSteps = (side-1)/2
    //The most disgusting array initalization ever
    var range = DoubleArray(4, {i -> abs((side.pow(2.0) - ((side-1)*i)-floor(side/2))-input)})
    var ySteps = range.min()
    print(xSteps+ySteps!!)
    //PART2
    //No thanks, OEIS is bae (will consider coming back to this when I have time)
    // answer is 369601
    // https://oeis.org/A141481/b141481.txt
}

fun side_length(number: Double):Double {
    var side = ceil(sqrt(number)) //the grid is a series of odd squares
    if (side % 2 == 0.0){
        side++
    }
    return side
}
