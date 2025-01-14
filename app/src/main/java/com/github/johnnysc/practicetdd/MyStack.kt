package com.github.johnnysc.practicetdd

interface MyStack<T> {

    fun pop(): T

    fun push(item: T)

    //Stack
    class LIFO<T>(private val maxCount: Int) : MyStack<T> {
        private val stack: Array<Any?>
        private var lastIndex = -1

        init {
            if (maxCount <= 0) throw IllegalStateException("MaxCount should be positive")
            stack = Array<Any?>(maxCount) { null }
        }

        override fun pop(): T {
            if (lastIndex == -1) throw IllegalStateException("")
            val item = stack[lastIndex] as T
            stack[lastIndex] = null
            lastIndex--
            return item
        }

        override fun push(item: T) {
            if (lastIndex >= maxCount - 1) throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            lastIndex++
            stack[lastIndex] = item
        }
    }

    //Queue
    class FIFO<T>(private val maxCount: Int) : MyStack<T> {
        private val stack: Array<Any?>
        private var lastIndex = -1

        init {
            if (maxCount <= 0) throw IllegalStateException("")
            stack = Array<Any?>(maxCount) { null }
        }

        override fun pop(): T {
            if (lastIndex == -1) throw IllegalStateException("Stack is empty")
            val item = stack[0] as T
            for (i in 0 until lastIndex) {
                stack[i] = stack[i + 1]
            }
            stack[lastIndex] = null
            lastIndex -= 1
            return item
        }

        override fun push(item: T) {
            if (lastIndex == maxCount - 1) throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            lastIndex++
            stack[lastIndex] = item
        }
    }
}