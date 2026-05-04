package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends com.google.android.gms.common.api.n implements com.google.android.gms.common.api.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f5536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c1 f5537f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d1 f5532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.api.h f5533b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5534c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Status f5535d = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5538g = false;

    public d1(WeakReference weakReference) {
        com.google.android.gms.common.internal.s.l(weakReference, "GoogleApiClient reference must not be null");
        this.f5536e = weakReference;
        com.google.android.gms.common.api.g gVar = (com.google.android.gms.common.api.g) weakReference.get();
        this.f5537f = new c1(this, gVar != null ? gVar.f() : Looper.getMainLooper());
    }

    @Override // com.google.android.gms.common.api.l
    public final void a(com.google.android.gms.common.api.k kVar) {
        synchronized (this.f5534c) {
            try {
                if (!kVar.getStatus().V()) {
                    d(kVar.getStatus());
                    k(kVar);
                } else if (j()) {
                    android.support.v4.media.session.b.a(com.google.android.gms.common.internal.s.k(null));
                    throw null;
                }
            } finally {
            }
        }
    }

    public final com.google.android.gms.common.api.n b(com.google.android.gms.common.api.m mVar) {
        d1 d1Var;
        synchronized (this.f5534c) {
            com.google.android.gms.common.internal.s.o(true, "Cannot call then() twice.");
            com.google.android.gms.common.internal.s.o(true, "Cannot call then() and andFinally() on the same TransformedResult.");
            d1Var = new d1(this.f5536e);
            this.f5532a = d1Var;
            g();
        }
        return d1Var;
    }

    public final void c(com.google.android.gms.common.api.h hVar) {
        synchronized (this.f5534c) {
            this.f5533b = hVar;
            g();
        }
    }

    public final /* synthetic */ d1 e() {
        return this.f5532a;
    }

    public final /* synthetic */ Object f() {
        return this.f5534c;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void d(Status status) {
        synchronized (this.f5534c) {
            this.f5535d = status;
            i(status);
        }
    }

    public final void i(Status status) {
        synchronized (this.f5534c) {
            try {
                if (j()) {
                    android.support.v4.media.session.b.a(com.google.android.gms.common.internal.s.k(null));
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

    public final void g() {
    }

    public static final void k(com.google.android.gms.common.api.k kVar) {
    }
}
