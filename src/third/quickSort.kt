package main.third

fun main(args: Array<String>) {
    val testList1: List<Int> = (0..100000).shuffled()
    val testList2: IntArray = (0..100000).shuffled().toIntArray()

    val startTime1 = System.currentTimeMillis()
    println(testList1.sorted())
    val endTime1 = System.currentTimeMillis()

    val startTime2 = System.currentTimeMillis()
    println(quickSort(testList2))
    val endTime2 = System.currentTimeMillis()

    println("${endTime1 - startTime1}")
    println("${endTime2 - startTime2}")
}

fun quickSort(array: IntArray, left: Int = 0, right: Int = array.size - 1) {
    val index = partition(array, left, right)

    if(left < index-1) { // 2) Sorting left half
        quickSort(array, left, index-1)
    }
    if(index < right) { // 3) Sorting right half
        quickSort(array, index, right)
    }
}

fun partition(array: IntArray, l: Int, r: Int): Int {
    var left = l
    var right = r
    val pivot = array[(left + right) / 2] // 4) Pivot Point

    while (left <= right) {
        while (array[left] < pivot) left++ // 5) Find the elements on left that should be on right

        while (array[right] > pivot) right-- // 6) Find the elements on right that should be on left

        // 7) Swap elements, and move left and right indices
        if (left <= right) {
            swapArray(array, left, right)

            left++
            right--
        }
    }
    return left
}

fun swapArray(a: IntArray, b: Int, c: Int) {
    val temp = a[b]
    a[b] = a[c]
    a[c] = temp
}
