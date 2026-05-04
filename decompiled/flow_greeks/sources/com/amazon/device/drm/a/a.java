package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f4845a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f4846b;

    private a() {
    }

    public static a a() {
        return f4845a;
    }

    public c a(Context context) {
        if (f4846b == null) {
            synchronized (a.class) {
                try {
                    if (f4846b == null) {
                        if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                            f4846b = new com.amazon.device.drm.a.d.c();
                        } else {
                            f4846b = new com.amazon.device.drm.a.b.c();
                        }
                    }
                } finally {
                }
            }
        }
        return f4846b;
    }
}
