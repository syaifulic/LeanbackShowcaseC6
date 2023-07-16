package androidx.leanback.leanbackshowcase.app;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class QWebViewClient extends WebViewClient {

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
    }

    public void onPageFinished(WebView view, String url) {
    }

    @SuppressWarnings("deprecation")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;

    }
}
