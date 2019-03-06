package me.maxcostadev.mhwcrowns

import me.maxcostadev.mhwcrowns.model.Monster
import me.maxcostadev.mhwcrowns.repo.FileLoader
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FileLoaderTest {
    var json:List<Monster>? = null

    @Before
    fun init(){
        json = FileLoader.getFileData()
    }

    @Test
    fun fileLoads() {
        assertNotNull(json)
    }

    @Test
    fun loadsValidList(){
        assertThat(json, instanceOf(List::class.java))
    }

    @Test
    fun listIsNotEmpty(){
        assertThat(json?.size, not(0))
        assertThat(json!![0] , instanceOf(Monster::class.java))
    }
}
