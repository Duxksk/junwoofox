
package com.junwoofox.browser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var web: WebView
    lateinit var urlBox: EditText

    val bookmarks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web = findViewById(R.id.web)
        urlBox = findViewById(R.id.urlBox)

        val goBtn: Button = findViewById(R.id.goBtn)
        val backBtn: Button = findViewById(R.id.backBtn)
        val fwdBtn: Button = findViewById(R.id.forwardBtn)
        val bookmarkBtn: Button = findViewById(R.id.bookmarkBtn)
        val shareBtn: Button = findViewById(R.id.shareBtn)

        web.settings.javaScriptEnabled = true
        web.webViewClient = WebViewClient()

        goBtn.setOnClickListener {
            var url = urlBox.text.toString()
            if (!url.startsWith("http")) url = "https://$url"
            web.loadUrl(url)
        }

        backBtn.setOnClickListener {
            if (web.canGoBack()) web.goBack()
        }

        fwdBtn.setOnClickListener {
            if (web.canGoForward()) web.goForward()
        }

        bookmarkBtn.setOnClickListener {
            val current = web.url ?: return@setOnClickListener
            bookmarks.add(current)
        }

        shareBtn.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, web.url)
            startActivity(Intent.createChooser(shareIntent, "Share URL"))
        }
    }
}
