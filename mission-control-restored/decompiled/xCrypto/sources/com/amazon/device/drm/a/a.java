package com.amazon.device.drm.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f9051a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f9052b;

    private a() {
    }

    public static a a() {
        return f9051a;
    }

    public c a(Context context) {
        if (f9052b == null) {
            synchronized (a.class) {
                try {
                    if (f9052b == null) {
                        if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                            f9052b = new com.amazon.device.drm.a.d.c();
                        } else {
                            f9052b = new com.amazon.device.drm.a.b.c();
                        }
                    }
                } finally {
                }
            }
        }
        return f9052b;
    }
}
