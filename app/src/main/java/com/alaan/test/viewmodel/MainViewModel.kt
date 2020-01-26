package com.alaan.test.viewmodel
import androidx.lifecycle.ViewModel
import com.alaan.test.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    internal val name: String
        get() = repository.name
}
