package com.amazon.device.simplesignin.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5029a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f5030b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f5031c;

    private a() {
    }

    public static a a() {
        return f5030b;
    }

    public boolean b(Context context) {
        return com.amazon.a.a.a((Application) context.getApplicationContext());
    }

    public b a(Context context) {
        if (f5031c == null) {
            synchronized (a.class) {
                try {
                    if (f5031c == null) {
                        if (b(context)) {
                            f5031c = new com.amazon.device.simplesignin.a.c.b();
                            com.amazon.device.simplesignin.a.d.a.a(f5029a, "SDK initialized in Sandbox mode.");
                        } else {
                            f5031c = new com.amazon.device.simplesignin.a.a.b();
                            com.amazon.device.simplesignin.a.d.a.a(f5029a, "SDK initialized in Production mode.");
                        }
                    }
                } finally {
                }
            }
        }
        return f5031c;
    }
}
