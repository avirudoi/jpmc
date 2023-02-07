package com.example.jpmc

import com.example.jpmc.Interactor.GetSchoolsFromDBInteractor
import com.example.jpmc.data.School
import com.example.jpmc.db.SchoolRoomProvider
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSchoolsFromDBInteractorTest {

    @Mock
    private lateinit var schoolRoomProvider: SchoolRoomProvider

    private lateinit var getSchoolsFromDBInteractor: GetSchoolsFromDBInteractor


    @Before
    fun setUp() {
        getSchoolsFromDBInteractor = GetSchoolsFromDBInteractor(schoolRoomProvider)
    }

    @Test
    fun verifySchoolRoomProviderCalled() {
        getSchoolsFromDBInteractor.execute()
        verify(schoolRoomProvider).getSchoolInfo()
    }

    @Test
    fun verifyLocalSchoolsFetched() {
        val fakeListOfSchools = listOf(fakeSchool)
        Mockito.`when`(schoolRoomProvider.getSchoolInfo()).thenReturn(fakeListOfSchools)

        val result = getSchoolsFromDBInteractor.execute()

        assertEquals(result, fakeListOfSchools)
    }

    companion object {
        val fakeSchool = School("1", "name", "333-333-3333", "test@test.com","test location","www.test.com")
    }
}