class MyCircularDeque(val k: Int) {
    var arr: IntArray = IntArray(k)
    var frontIndex = k - 1
    var lastIndex = 0
    var size = 0

    /** Initialize your data structure here. Set the size of the deque to be k. */


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (size == k) return false
        arr[frontIndex] = value
        frontIndex = (--frontIndex + k) % k
        size++
        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (size == k) return false
        arr[lastIndex] = value
        lastIndex = ++lastIndex % k
        size++
        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (size == 0) return false
        frontIndex = ++frontIndex % k
        size--
        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (size == 0) return false
        lastIndex = (--lastIndex + k) % k
        size--
        return true
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        if (size == 0) return -1
        return arr[(frontIndex+1 ) % k]
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        if (size == 0) return -1
        return  arr[(lastIndex-1 +k )%k]
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return size==0
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return size==k
    }

}

fun main(){
    val circularDeque = MyCircularDeque(3) // set the size to be 3
    circularDeque.arr.forEach { print(it) }
    println()
    println(circularDeque.insertLast(1)   )
    circularDeque.arr.forEach { print(it) }
    println()// return true
    println(circularDeque.insertLast(2)    )
    circularDeque.arr.forEach { print(it) }
    println()// return true
    println(circularDeque.insertFront(3)  )
    circularDeque.arr.forEach { print(it) }
    println()// return true
    println(circularDeque.insertFront(4)   )
    circularDeque.arr.forEach { print(it) }
    println()// return false, the queue is full
    println(circularDeque.getRear()   )
    circularDeque.arr.forEach { print(it) }
    println()// return 2
    println(circularDeque.isFull()       )
    circularDeque.arr.forEach { print(it) }
    println()// return true
    println(circularDeque.deleteLast()      )
    circularDeque.arr.forEach { print(it) }
    println()// return true
    println(circularDeque.insertFront(4) )
    circularDeque.arr.forEach { print(it) }
    println()// return true
    println(circularDeque.getFront())
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
