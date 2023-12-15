package com.example.uf1_proyecto.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class TripViewModel(private val tripDao: TripDao) : ViewModel() {

    private val _trips: MutableStateFlow<List<Trip>> = MutableStateFlow(emptyList())
    val trips: StateFlow<List<Trip>> get() = _trips

    init {
        // Observar el Flow y actualizar el estado cuando cambia
        viewModelScope.launch {
            tripDao.getTrips().collect { trips ->
                _trips.value = trips
            }
        }
    }

    fun getSizeTrips(): Int {
        return trips.value.size
    }
}
class TripViewModelFactory(private val tripDao: TripDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TripViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TripViewModel(tripDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}