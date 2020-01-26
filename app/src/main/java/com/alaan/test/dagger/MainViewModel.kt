package com.alaan.test.dagger
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: Repository) : ViewModel() {

    internal val name: String
        get() = repository.name
}
