package com.rarnu.tools.neo.activity

import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebSettings
import com.rarnu.kt.android.resStr
import com.rarnu.kt.android.showActionBack
import com.rarnu.tools.neo.R
import com.rarnu.tools.neo.RootApplication
import com.rarnu.tools.neo.api.API
import kotlinx.android.synthetic.main.fragment_manual.*

/**
 * Created by rarnu on 12/13/16.
 */
class ManualActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_manual)
        actionBar?.title = resStr(R.string.view_usage_manual)
        showActionBack()

        with(wvManual) {
            with(settings) {
                javaScriptEnabled = false
                layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
                displayZoomControls = false
                builtInZoomControls = false
            }
            loadUrl(API.API_BASE + if (RootApplication.isZh) "manual.html" else "manual_en.html")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}