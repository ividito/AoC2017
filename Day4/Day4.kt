fun main(args: Array<String>) {
    //PART1
    var count = 0
    for (str in input){
        var rowlist = str.split("\\s+".toRegex()) //split on any whitespace
        if(rowlist.count() == rowlist.distinct().count()){
            count++
        }
    }
    println(count)
    //PART2
    val pt2 = partTwo(input)
    println(pt2)
}

//super ugly function definition, but it works really well
fun partTwo(input: List<String>): Int = input.map { it.split(" ")
                                                      .map { it.sort() } }
                                             .count { it.size == it.toSet().size }

fun String.sort(): String {
  val carr = this.toCharArray(); carr.sort(); return String(carr)
}    