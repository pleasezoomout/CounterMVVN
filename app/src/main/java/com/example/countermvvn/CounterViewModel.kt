package com.example.countermvvn

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel(): ViewModel() {
    // Initialize the repository
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)

    // Expose the count as a read-only state
    val count: MutableState<Int> = _count

    fun increment(){
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement(){
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}