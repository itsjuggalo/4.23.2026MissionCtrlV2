package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import java.util.Arrays;
import t3.AbstractC1822k;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
public final class zzfw {
    private final WebView zza;
    private final L zzb;

    public zzfw(WebView webView, L l4) {
        this.zza = webView;
        this.zzb = l4;
    }

    public final void zzb(String str, String... strArr) {
        AbstractC1822k.d(this.zzb, null, null, new zzfv((String[]) Arrays.copyOf(strArr, strArr.length), this, str, null), 3, null);
    }
}
