package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import java.util.Arrays;
import ng.k;
import ng.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfw {
    private final WebView zza;
    private final n0 zzb;

    public zzfw(WebView webView, n0 n0Var) {
        this.zza = webView;
        this.zzb = n0Var;
    }

    public final void zzb(String str, String... strArr) {
        k.d(this.zzb, null, null, new zzfv((String[]) Arrays.copyOf(strArr, strArr.length), this, str, null), 3, null);
    }
}
