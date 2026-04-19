package com.realestate.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realestate.app.domain.RealEstateUseCase
import com.realestate.app.domain.models.RealEstateDomain
import com.realestate.app.utils.Defaults.DEBOUNCE_TIME
import com.realestate.app.utils.Defaults.REPLAY_COUNT
import com.realestate.app.utils.Defaults.STOP_TIMEOUT
import com.realestate.app.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val realEstateUseCase: RealEstateUseCase) :
    ViewModel() {
    private val refreshTrigger = MutableSharedFlow<Unit>(replay = REPLAY_COUNT).apply {
        tryEmit(Unit)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val realEstateState: StateFlow<Resource<List<RealEstateDomain>>> =
        refreshTrigger.flatMapLatest {
            realEstateUseCase.fetchRealEstate()
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT),
            initialValue = Resource.Loading()
        )

    fun refreshData() {
        refreshTrigger.tryEmit(Unit)
    }

    @OptIn(FlowPreview::class)
    fun bookmarkRealEstate(id: Long, isBookmarked: Boolean) {
        viewModelScope.launch {
            realEstateUseCase.bookmarkRealEstate(id = id, isBookmarked = isBookmarked)
                .debounce(DEBOUNCE_TIME).collect {
                    refreshData()
                }
        }
    }
}
