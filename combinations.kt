fun isValidSolution(state: MutableList<Int>, k: Int): Boolean =
    state.size == k

fun getCandidates(state: MutableList<Int>, n: Int): MutableSet<Int> =
    (((state.lastOrNull()?: (-1)) + 1) until n)
    .toMutableSet()

fun findCombinations(n: Int, k: Int, state: MutableList<Int>, solutions: MutableSet<MutableList<Int>>) {
    println("state with new candidate: $state")
    if (isValidSolution(state, k)) {
        println("state is a solution, adding to the list")
        solutions.add(state.toMutableList())
        return
    }
    
    println("state is not a solution yet, generating next step candidates: ${getCandidates(state, n)}")
    for (i in getCandidates(state, n)) {
        state.add(i)
        findCombinations(n, k, state, solutions)
        // todo why
        println("returned from recursion, removing last element from $state")
        state.removeLast()
    }
    println("all candidates processed, returning with state: $state")
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

// OUTPUT:
// state with new candidate: []
// state is not a solution yet, generating next step candidates: [0, 1, 2, 3, 4]
// state with new candidate: [0]
// state is not a solution yet, generating next step candidates: [1, 2, 3, 4]
// state with new candidate: [0, 1]
// state is not a solution yet, generating next step candidates: [2, 3, 4]
// state with new candidate: [0, 1, 2]
// state is a solution, adding to the list
// returned from recursion, removing last element from [0, 1, 2]
// state with new candidate: [0, 1, 3]
// state is a solution, adding to the list
// returned from recursion, removing last element from [0, 1, 3]
// state with new candidate: [0, 1, 4]
// state is a solution, adding to the list
// returned from recursion, removing last element from [0, 1, 4]
// all candidates processed, returning with state: [0, 1]
// returned from recursion, removing last element from [0, 1]
// state with new candidate: [0, 2]
// state is not a solution yet, generating next step candidates: [3, 4]
// state with new candidate: [0, 2, 3]
// state is a solution, adding to the list
// returned from recursion, removing last element from [0, 2, 3]
// state with new candidate: [0, 2, 4]
// state is a solution, adding to the list
// returned from recursion, removing last element from [0, 2, 4]
// all candidates processed, returning with state: [0, 2]
// returned from recursion, removing last element from [0, 2]
// state with new candidate: [0, 3]
// state is not a solution yet, generating next step candidates: [4]
// state with new candidate: [0, 3, 4]
// state is a solution, adding to the list
// returned from recursion, removing last element from [0, 3, 4]
// all candidates processed, returning with state: [0, 3]
// returned from recursion, removing last element from [0, 3]
// state with new candidate: [0, 4]
// state is not a solution yet, generating next step candidates: []
// all candidates processed, returning with state: [0, 4]
// returned from recursion, removing last element from [0, 4]
// all candidates processed, returning with state: [0]
// returned from recursion, removing last element from [0]
// state with new candidate: [1]
// state is not a solution yet, generating next step candidates: [2, 3, 4]
// state with new candidate: [1, 2]
// state is not a solution yet, generating next step candidates: [3, 4]
// state with new candidate: [1, 2, 3]
// state is a solution, adding to the list
// returned from recursion, removing last element from [1, 2, 3]
// state with new candidate: [1, 2, 4]
// state is a solution, adding to the list
// returned from recursion, removing last element from [1, 2, 4]
// all candidates processed, returning with state: [1, 2]
// returned from recursion, removing last element from [1, 2]
// state with new candidate: [1, 3]
// state is not a solution yet, generating next step candidates: [4]
// state with new candidate: [1, 3, 4]
// state is a solution, adding to the list
// returned from recursion, removing last element from [1, 3, 4]
// all candidates processed, returning with state: [1, 3]
// returned from recursion, removing last element from [1, 3]
// state with new candidate: [1, 4]
// state is not a solution yet, generating next step candidates: []
// all candidates processed, returning with state: [1, 4]
// returned from recursion, removing last element from [1, 4]
// all candidates processed, returning with state: [1]
// returned from recursion, removing last element from [1]
// state with new candidate: [2]
// state is not a solution yet, generating next step candidates: [3, 4]
// state with new candidate: [2, 3]
// state is not a solution yet, generating next step candidates: [4]
// state with new candidate: [2, 3, 4]
// state is a solution, adding to the list
// returned from recursion, removing last element from [2, 3, 4]
// all candidates processed, returning with state: [2, 3]
// returned from recursion, removing last element from [2, 3]
// state with new candidate: [2, 4]
// state is not a solution yet, generating next step candidates: []
// all candidates processed, returning with state: [2, 4]
// returned from recursion, removing last element from [2, 4]
// all candidates processed, returning with state: [2]
// returned from recursion, removing last element from [2]
// state with new candidate: [3]
// state is not a solution yet, generating next step candidates: [4]
// state with new candidate: [3, 4]
// state is not a solution yet, generating next step candidates: []
// all candidates processed, returning with state: [3, 4]
// returned from recursion, removing last element from [3, 4]
// all candidates processed, returning with state: [3]
// returned from recursion, removing last element from [3]
// state with new candidate: [4]
// state is not a solution yet, generating next step candidates: []
// all candidates processed, returning with state: [4]
// returned from recursion, removing last element from [4]
// all candidates processed, returning with state: []
// [[0, 1, 2], [0, 1, 3], [0, 1, 4], [0, 2, 3], [0, 2, 4], [0, 3, 4], [1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4]]
