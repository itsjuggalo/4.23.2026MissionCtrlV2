package com.amazon.device.iap.internal;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f9149a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9150b = b.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f9151c;

    private b() {
    }

    public static b a() {
        return f9149a;
    }

    public e a(Context context) {
        if (f9151c == null) {
            synchronized (b.class) {
                try {
                    if (f9151c == null) {
                        if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                            f9151c = new com.amazon.device.iap.internal.c.e();
                        } else {
                            f9151c = new com.amazon.device.iap.internal.a.d();
                        }
                    }
                } finally {
                }
            }
        }
        return f9151c;
    }
}
