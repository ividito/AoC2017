import java.util.Arrays

fun main(args: Array<String>) {
    
    println(day06(input))
    
}


fun day06(thing: MutableList<Int>) : Int {
    val knownConfigurations = mutableSetOf<List<Int>>()
    var counter = 0
    while (!knownConfigurations.contains(thing)) {
        knownConfigurations.add(List(thing.size) {i-> thing[i] + 0} )
        counter++
        var biggestIndex = 0

        var biggestNum = 0
        thing.forEachIndexed {index, num ->
            if (num > biggestNum) {
                biggestNum = num
                biggestIndex = index
            }
        }
        thing[biggestIndex] = 0
        while (biggestNum > 0) {
            biggestNum--
            biggestIndex = (biggestIndex + 1) % thing.size
            thing[biggestIndex]++
        }
    }
    //part2
    return knownConfigurations.size - knownConfigurations.indexOf(thing)
    //return  counter
}

    //I was getting memory errors running the below solution. Oops. TODO fix this

    /*
    var memory = mutableListOf<Array<Int>>()
    var count = 0
    memory.add(0, input)
    for (element in memory){
        println(Arrays.toString(element))
    }
    while(true){
        var lastStep = memory.get(count) //should be input to start
        var nextStep = redist(lastStep)
        count++
        if(memory.contains(nextStep)){ //check next iteration vs memory
            println("Breaking")
            break
        }
        println("Adding new step")
        println(Arrays.toString(nextStep))
        memory.add(count, nextStep)
    }
    for (element in memory){
        println(Arrays.toString(element))
    }
    println(memory.size)
}

//confirmed works
fun redist(startData : Array<Int>):Array<Int>{
    var startBlock = startData.indexOf(startData.max())
    var dataPool = startData[startBlock]
    startData[startBlock] = 0
    while(dataPool>0){
        if(startBlock<startData.size-1){
            startBlock++
        }
        else startBlock=0
        startData[startBlock]++
        dataPool--
    }
    return startData
}

*/