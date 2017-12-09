fun main(args: Array<String>) {
    val registers = HashMap<String, Int>()
    val instructions = input.map { it.split(" ") }
    var max = 0
    loop@ for (it in instructions) {
        val register = it[0]
        val op = it[1]
        val value = it[2].toInt()
        val conditionRegister = it[4]
        val condition = it[5]
        val compareValue = it[6].toInt()
        val registerValue = registers.getOrDefault(register, 0)
        val conditionRegisterValue = registers.getOrDefault(conditionRegister, 0)
        when (condition) {
            "==" -> if (conditionRegisterValue != compareValue) continue@loop
            "!=" -> if (conditionRegisterValue == compareValue) continue@loop
            "<=" -> if (conditionRegisterValue > compareValue) continue@loop
            "<" -> if (conditionRegisterValue >= compareValue) continue@loop
            ">=" -> if (conditionRegisterValue < compareValue) continue@loop
            ">" -> if (conditionRegisterValue <= compareValue) continue@loop
        }
        when (op) {
            "inc" -> registers.put(register, registerValue + value)
            "dec" -> registers.put(register, registerValue - value)
        }
        val newRegisterValue = registers.getOrDefault(register, 0)
        if (newRegisterValue > max) max = newRegisterValue
    }
    println("Heard You Like Registers A: ${registers.values.max()}")
    println("Heard You Like Registers B: $max")
}