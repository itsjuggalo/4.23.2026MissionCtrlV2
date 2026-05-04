package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f6015a;

    public static synchronized s a(Context context) {
        try {
            if (f6015a == null) {
                q qVar = new q(null);
                qVar.a(n6.h.a(context));
                f6015a = qVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6015a;
    }
}
