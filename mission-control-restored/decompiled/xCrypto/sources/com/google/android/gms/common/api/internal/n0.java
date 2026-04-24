package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends com.google.android.gms.common.api.n implements com.google.android.gms.common.api.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f9811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l0 f9812f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f9807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.api.h f9808b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f9809c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Status f9810d = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9813g = false;

    public n0(WeakReference weakReference) {
        AbstractC0940s.l(weakReference, "GoogleApiClient reference must not be null");
        this.f9811e = weakReference;
        com.google.android.gms.common.api.f fVar = (com.google.android.gms.common.api.f) weakReference.get();
        this.f9812f = new l0(this, fVar != null ? fVar.f() : Looper.getMainLooper());
    }

    public static final void k(com.google.android.gms.common.api.k kVar) {
    }

    @Override // com.google.android.gms.common.api.l
    public final void a(com.google.android.gms.common.api.k kVar) {
        synchronized (this.f9809c) {
            try {
                if (!kVar.getStatus().o()) {
                    g(kVar.getStatus());
                    k(kVar);
                } else if (j()) {
                    android.support.v4.media.session.b.a(AbstractC0940s.k(null));
                    throw null;
                }
            } finally {
            }
        }
    }

    public final com.google.android.gms.common.api.n b(com.google.android.gms.common.api.m mVar) {
        n0 n0Var;
        synchronized (this.f9809c) {
            AbstractC0940s.o(true, "Cannot call then() twice.");
            AbstractC0940s.o(true, "Cannot call then() and andFinally() on the same TransformedResult.");
            n0Var = new n0(this.f9811e);
            this.f9807a = n0Var;
            h();
        }
        return n0Var;
    }

    public final void f(com.google.android.gms.common.api.h hVar) {
        synchronized (this.f9809c) {
            this.f9808b = hVar;
            h();
        }
    }

    public final void g(Status status) {
        synchronized (this.f9809c) {
            this.f9810d = status;
            i(status);
        }
    }

    public final void h() {
    }

    public final void i(Status status) {
        synchronized (this.f9809c) {
            try {
                if (j()) {
                    android.support.v4.media.session.b.a(AbstractC0940s.k(null));
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
