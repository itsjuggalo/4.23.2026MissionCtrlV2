package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends com.google.android.gms.common.api.n implements com.google.android.gms.common.api.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f10981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f10982f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k0 f10977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.api.h f10978b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10979c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Status f10980d = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10983g = false;

    public k0(WeakReference weakReference) {
        AbstractC1207s.l(weakReference, "GoogleApiClient reference must not be null");
        this.f10981e = weakReference;
        com.google.android.gms.common.api.f fVar = (com.google.android.gms.common.api.f) weakReference.get();
        this.f10982f = new i0(this, fVar != null ? fVar.f() : Looper.getMainLooper());
    }

    public static final void k(com.google.android.gms.common.api.k kVar) {
    }

    @Override // com.google.android.gms.common.api.l
    public final void a(com.google.android.gms.common.api.k kVar) {
        synchronized (this.f10979c) {
            try {
                if (!kVar.getStatus().F()) {
                    g(kVar.getStatus());
                    k(kVar);
                } else if (j()) {
                    android.support.v4.media.session.b.a(AbstractC1207s.k(null));
                    throw null;
                }
            } finally {
            }
        }
    }

    public final com.google.android.gms.common.api.n b(com.google.android.gms.common.api.m mVar) {
        k0 k0Var;
        synchronized (this.f10979c) {
            AbstractC1207s.o(true, "Cannot call then() twice.");
            AbstractC1207s.o(true, "Cannot call then() and andFinally() on the same TransformedResult.");
            k0Var = new k0(this.f10981e);
            this.f10977a = k0Var;
            h();
        }
        return k0Var;
    }

    public final void f(com.google.android.gms.common.api.h hVar) {
        synchronized (this.f10979c) {
            this.f10978b = hVar;
            h();
        }
    }

    public final void g(Status status) {
        synchronized (this.f10979c) {
            this.f10980d = status;
            i(status);
        }
    }

    public final void h() {
    }

    public final void i(Status status) {
        synchronized (this.f10979c) {
            try {
                if (j()) {
                    android.support.v4.media.session.b.a(AbstractC1207s.k(null));
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean j() {
        return false;
    }
}
