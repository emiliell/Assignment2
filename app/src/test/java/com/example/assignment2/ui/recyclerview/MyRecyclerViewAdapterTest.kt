package com.example.assignment2.ui.recyclerview


import com.example.assignment2.network.ResponseItem
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test


class MyRecyclerViewAdapterTest {

    private lateinit var adapter: MyRecyclerViewAdapter
    private val mockNavigationFunction: (ResponseItem) -> Unit = {}
    private val exampleResponseItem = ResponseItem(artist_name = "abc", album_title = "def", release_year = "123",
        genre ="ghi", track_count = "456", description ="jkl", popular_track = "mno")

    @Before
    fun setUp() {
        adapter = spyk(MyRecyclerViewAdapter(navigationFunction = mockNavigationFunction))
        every { adapter.notifyDataSetChanged() } returns Unit
    }

    @Test
    fun `getItemCount returns correct size`() {
        // Given
        val dataList = mutableListOf(
            exampleResponseItem,
            exampleResponseItem.copy(artist_name = "xyz"),
            exampleResponseItem.copy(artist_name = "uvw")
        )
        adapter.setData(dataList)

        // When
        val itemCount = adapter.getItemCount()

        // Then
        assertEquals(3, itemCount)
    }

    @Test
    fun `setData updates dataList and calls notifyDataSetChanged`() {
        // Given
        val newDataList = listOf(
            exampleResponseItem.copy(artist_name = "qwe"),
            exampleResponseItem.copy(artist_name = "rty")
        )

        // When
        adapter.setData(newDataList)

        // Then
        assertEquals(2, adapter.getItemCount()) // Verify dataList size is updated
        verify { adapter.notifyDataSetChanged() } // Verify notifyDataSetChanged is called
    }
}