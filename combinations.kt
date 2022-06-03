fun isValidSolution(state: MutableList<Int>, k: Int): Boolean = state.size == k

fun getCandidates(state: MutableList<Int>, n: Int, k: Int): MutableSet<Int> {
    return if (state.isEmpty()) {
        (0 until n).toMutableSet()
    } else {
    	((state.last() + 1) until n).toMutableSet()
    }
}

fun findCombinations(n: Int, k: Int, state: MutableList<Int>, solutions: MutableSet<MutableList<Int>>) {
    if (isValidSolution(state, k)) {
        solutions.add(state.toMutableList())
        return
    }
    
    for (i in getCandidates(state, n, k)) {
        state.add(i)
        findCombinations(n, k, state, solutions)
        // todo why
        state.removeLast()
    }
}

fun solve(n: Int, k: Int): MutableSet<MutableList<Int>> {
    val state = mutableListOf<Int>()
    val solutions = mutableSetOf<MutableList<Int>>()
    findCombinations(n, k, state, solutions)
    return solutions
}

fun main() {
    print(solve(5, 3))
}
