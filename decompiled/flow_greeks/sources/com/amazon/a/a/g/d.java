package com.amazon.a.a.g;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f4271a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f4272b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f4273c = true;

    @Override // com.amazon.a.a.g.c
    public boolean a() {
        return true;
    }

    @Override // com.amazon.a.a.g.c
    public boolean b() {
        return true;
    }

    @Override // com.amazon.a.a.g.c
    public boolean c() {
        return true;
    }

    @Override // com.amazon.a.a.g.c
    public void a(String str, String str2) {
        Log.d(str, a(str2));
    }

    @Override // com.amazon.a.a.g.c
    public void b(String str, String str2) {
        Log.e(str, a(str2));
    }

    @Override // com.amazon.a.a.g.c
    public void c(String str, String str2) {
        Log.v(str, a(str2));
    }

    private static String a(String str) {
        return "Appstore SDK - Sandbox Mode: " + str;
    }
}
