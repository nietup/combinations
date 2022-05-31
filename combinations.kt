fun isValidSolution(state: , k: Int): Boolean {
    if (state.size < k)
    	return false
    
    for (i in 1 until state.size) {
        if (state(i) < state(i - 1)) {
            return false
        }
    }
    
    return true
}

fun getCandidates(state: List<Int>, n: Int, k: Int): Set<Int> {
    if (state.size >= k) {
        return emptySet()
    }
    
    return (state.getLast() until n).toSet()
}

fun findCombinations(n: Int, k: Int, state: List<Int>, solutions: Set<List<Int>>): Set<List<Int>> {
    if isValidSolution(state, k) {
        solutions.add(state.copyOf())
        return solutions
    }
    
    for (i in getCandidates(state, n, k)) {
        state.add(i)
        findCombinations(n, k, state, solutions)
        state.dropLast()
    }
}
 
fun main() {
    print(findCombinations(3, 2, emptyMutableList<Int>(), emptySet<List<Int>>()))
}