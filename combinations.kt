fun isValidSolution(state: MutableList<Int>, k: Int): Boolean = state.size == k

fun getCandidates(state: MutableList<Int>, n: Int, k: Int): MutableSet<Int> {
    if (state.size >= k) {
        return mutableSetOf()
    }

    return if (state.isEmpty())
        	(0 until n).toMutableSet()
    	else
    		((state.last() + 1) until n).toMutableSet()
}

fun findCombinations(n: Int, k: Int, state: MutableList<Int>, solutions: MutableSet<MutableList<Int>>) {
    if (isValidSolution(state, k)) {
        solutions.add(state.toMutableList())
    }
    
    for (i in getCandidates(state, n, k)) {
        state.add(i)
        findCombinations(n, k, state, solutions)
        // todo why
        state.dropLast(1)
    }
}

fun solve(n: Int, k: Int): MutableSet<MutableList<Int>> {
    val state = mutableListOf<Int>()
    val solutions = mutableSetOf<MutableList<Int>>()
    findCombinations(n, k, state, solutions)
    return solutions
}

fun main() {
    print(solve(3, 2))
}
