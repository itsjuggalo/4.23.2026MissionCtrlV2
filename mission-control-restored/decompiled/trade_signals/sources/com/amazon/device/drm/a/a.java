package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f14347a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f14348b;

    private a() {
    }

    public static a a() {
        return f14347a;
    }

    public c a(Context context) {
        if (f14348b == null) {
            synchronized (a.class) {
                try {
                    if (f14348b == null) {
                        f14348b = com.amazon.a.a.a((Application) context.getApplicationContext()) ? new com.amazon.device.drm.a.d.c() : new com.amazon.device.drm.a.b.c();
                    }
                } finally {
                }
            }
        }
        return f14348b;
    }
}
