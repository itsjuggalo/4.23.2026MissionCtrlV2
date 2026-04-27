package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f10236a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f10237b;

    private a() {
    }

    public static a a() {
        return f10236a;
    }

    public c a(Context context) {
        if (f10237b == null) {
            synchronized (a.class) {
                try {
                    if (f10237b == null) {
                        if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                            f10237b = new com.amazon.device.drm.a.d.c();
                        } else {
                            f10237b = new com.amazon.device.drm.a.b.c();
                        }
                    }
                } finally {
                }
            }
        }
        return f10237b;
    }
}
