package com.amazon.device.simplesignin.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9253a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f9254b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f9255c;

    private a() {
    }

    public static a a() {
        return f9254b;
    }

    public boolean b(Context context) {
        return com.amazon.a.a.a((Application) context.getApplicationContext());
    }

    public b a(Context context) {
        if (f9255c == null) {
            synchronized (a.class) {
                try {
                    if (f9255c == null) {
                        if (b(context)) {
                            f9255c = new com.amazon.device.simplesignin.a.c.b();
                            com.amazon.device.simplesignin.a.d.a.a(f9253a, "SDK initialized in Sandbox mode.");
                        } else {
                            f9255c = new com.amazon.device.simplesignin.a.a.b();
                            com.amazon.device.simplesignin.a.d.a.a(f9253a, "SDK initialized in Production mode.");
                        }
                    }
                } finally {
                }
            }
        }
        return f9255c;
    }
}
