package com.google.android.play.core.integrity;

import F2.AbstractC0470h;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f11983a;

    public static synchronized s a(Context context) {
        try {
            if (f11983a == null) {
                q qVar = new q(null);
                qVar.a(AbstractC0470h.a(context));
                f11983a = qVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f11983a;
    }
}
