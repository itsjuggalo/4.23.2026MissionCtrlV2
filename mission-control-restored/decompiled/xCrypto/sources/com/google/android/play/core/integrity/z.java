package com.google.android.play.core.integrity;

import X1.AbstractC0747h;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f10200a;

    public static synchronized s a(Context context) {
        try {
            if (f10200a == null) {
                q qVar = new q(null);
                qVar.a(AbstractC0747h.a(context));
                f10200a = qVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10200a;
    }
}
