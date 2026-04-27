package com.google.android.recaptcha.internal;

import Y4.d;
import Y4.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class zzeg {
    private zzeg() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int zzc(String str) {
        String strS = l.S("18.6.1", ".", "");
        int iY = d.Y(strS, "-", 0, 6);
        if (iY != -1) {
            strS = strS.substring(0, iY);
            j.d(strS, "substring(...)");
        }
        return Integer.parseInt(strS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzd(String str) {
        return "cesdb".concat(d.c0("18.6.1", "-", ""));
    }

    public /* synthetic */ zzeg(f fVar) {
    }
}
