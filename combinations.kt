fun isValidSolution(state: MutableList<Int>, k: Int): Boolean {
    if (state.size > k)
    	return false
    
    for (i in 1 until state.size) {
        if (state[i] <= state[i - 1]) {
            return false
        }
    }
    
    return true
}

fun getCandidates(state: MutableList<Int>, n: Int, k: Int): MutableSet<Int> {
    if (state.size >= k) {
        return mutableSetOf()
    }
    
    return if (state.isEmpty())
        	(0 until n).toMutableSet()
    	else
    		((state.last()) until n).toMutableSet()
}

fun findCombinations(n: Int, k: Int, state: MutableList<Int>, solutions: MutableSet<MutableList<Int>>): MutableSet<MutableList<Int>> {
    if (isValidSolution(state, k)) {
        solutions.add(state.toMutableList())
        return solutions
    }
    
    for (i in getCandidates(state, n, k)) {
        state.add(i)
        findCombinations(n, k, state, solutions)
        state.dropLast(1)
    }
    
    return mutableSetOf()
}
 
fun main() {
    print(findCombinations(3, 2, mutableListOf(), mutableSetOf()))
}
