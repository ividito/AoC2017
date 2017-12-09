fun main(args: Array<String>) {
	var score = 0;
    var level = 0;
    var garbageCount = 0
    var garbageFlag = false
    var discardFlag = false
    for (i in input.indices) {
        var c = input[i]
        if (!discardFlag){  //discard the character (state 1)
            if (c=='!'){ //check for state 1
                discardFlag = true 
            }
            else if (garbageFlag){ //state 2
                if (c=='>'){ //if c is ! then this will be false
                    garbageFlag = false //garbage closed
                }
                else{
                    garbageCount++
                }
            }
            else if (c=='<'){
                garbageFlag = true
            }
            else if (c=='{'){ //start group
                level++
            }
            else if (c=='}'){ //end group, increase score by level
                if(level>0){
                    score += level
                    level--
                }
            }
        }
        else {
            discardFlag = false //char skipped, reset ! flag
        }
    }
    println("Score is: "+score)
    println("Garbage count is: "+garbageCount)
}

