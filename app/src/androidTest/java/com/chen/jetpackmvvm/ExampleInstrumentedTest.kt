package com.chen.jetpackmvvm

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

typealias aaa = String
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.chen.jetpackmvvm", appContext.packageName)


    }



    @Target(AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.SOURCE)
    @Repeatable
    @MustBeDocumented
    internal annotation class a(val value: String = "value")

    fun a(){}


    @a("aaa")
    @a("aaa")
    class b(a : String){
        private var strin = ""
    }
}
