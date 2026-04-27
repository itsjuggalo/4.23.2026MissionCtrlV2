package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import b6.AbstractC1077k;
import b6.L;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfw {
    private final WebView zza;
    private final L zzb;

    public zzfw(WebView webView, L l7) {
        this.zza = webView;
        this.zzb = l7;
    }

    public final void zzb(String str, String... strArr) {
        AbstractC1077k.d(this.zzb, null, null, new zzfv((String[]) Arrays.copyOf(strArr, strArr.length), this, str, null), 3, null);
    }
}
