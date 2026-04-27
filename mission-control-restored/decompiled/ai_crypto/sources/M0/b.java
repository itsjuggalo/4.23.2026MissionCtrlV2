package M0;

import android.webkit.WebResourceError;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static CharSequence a(WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static int b(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }
}
