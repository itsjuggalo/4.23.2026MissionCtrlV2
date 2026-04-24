package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import u1.C1200b;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0441t implements InterfaceC0426d, InterfaceC0424b, InterfaceC0425c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static C0441t f5279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0442u f5280c = new C0442u(0, false, false, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f5281a;

    public /* synthetic */ C0441t(Object obj) {
        this.f5281a = obj;
    }

    public static synchronized C0441t e() {
        try {
            if (f5279b == null) {
                f5279b = new C0441t();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5279b;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0424b
    public void a(int i) {
        ((InterfaceC0403f) this.f5281a).a(i);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0425c
    public void b(C1200b c1200b) {
        ((InterfaceC0413p) this.f5281a).b(c1200b);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0426d
    public void c(C1200b c1200b) {
        boolean zM = c1200b.m();
        AbstractC0428f abstractC0428f = (AbstractC0428f) this.f5281a;
        if (zM) {
            abstractC0428f.getRemoteService(null, abstractC0428f.getScopes());
        } else if (abstractC0428f.zzx != null) {
            abstractC0428f.zzx.b(c1200b);
        }
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0424b
    public void d(Bundle bundle) {
        ((InterfaceC0403f) this.f5281a).i();
    }
}
