package com.example.assignment2.ui.recyclerview

import com.example.assignment2.data.RepClass
import com.example.assignment2.network.DashboardResponse
import com.example.assignment2.network.ResponseItem
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*


@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var repository: RepClass
    private val exampleResponseItem =
        ResponseItem(artist_name = "abc", album_title = "def", release_year = "123",
            genre ="ghi", track_count = "456", description ="jkl", popular_track = "mno")

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        // Mock the repository
        repository = mockk()

        // Set the dispatcher for the ViewModel's scope
        Dispatchers.setMain(testDispatcher)

        // Mock the repository response
        coEvery { repository.getDashboard("mocked_keypass") } returns DashboardResponse(
            entities = listOf(
                exampleResponseItem.copy(artist_name = "asd"),
                exampleResponseItem.copy(artist_name = "fgh")
            ), entity_total = 2
        )

        // Initialize the ViewModel
        viewModel = DashboardViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the Main dispatcher to the original one
    }

    @Test
    fun `test ViewModel calls API and updates StateFlow on init`() = runTest(testDispatcher) {
        // The ViewModel's init() method is called during setup @Before when after viewmodel is created

        // Advance time to allow the ViewModel's coroutine to execute
        advanceUntilIdle()

        // Verify that the apiResponseObjects is updated with the mocked data
        val apiResponse = viewModel.apiResponseObjects.value
        assertEquals(2, apiResponse.size)
        assertEquals("asd", apiResponse[0].artist_name)
        assertEquals("fgh", apiResponse[1].artist_name)
    }

}