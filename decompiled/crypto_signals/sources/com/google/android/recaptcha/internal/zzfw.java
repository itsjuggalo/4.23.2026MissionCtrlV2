package com.google.android.recaptcha.internal;

import a5.A;
import a5.C;
import android.webkit.WebView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfw {
    private final WebView zza;
    private final A zzb;

    public zzfw(WebView webView, A a6) {
        this.zza = webView;
        this.zzb = a6;
    }

    public final void zzb(String str, String... strArr) {
        C.p(this.zzb, new zzfv((String[]) Arrays.copyOf(strArr, strArr.length), this, str, null));
    }
}
