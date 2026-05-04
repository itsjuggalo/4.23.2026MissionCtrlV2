package com.amazon.device.iap.internal;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f4943a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4944b = b.class.getName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile e f4945c;

    private b() {
    }

    public static b a() {
        return f4943a;
    }

    public e a(Context context) {
        if (f4945c == null) {
            synchronized (b.class) {
                try {
                    if (f4945c == null) {
                        if (com.amazon.a.a.a((Application) context.getApplicationContext())) {
                            f4945c = new com.amazon.device.iap.internal.c.e();
                        } else {
                            f4945c = new com.amazon.device.iap.internal.a.d();
                        }
                    }
                } finally {
                }
            }
        }
        return f4945c;
    }
}
