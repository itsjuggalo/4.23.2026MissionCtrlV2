package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class I extends AbstractC0894a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f9710a;

    public I(B b4) {
        this.f9710a = new WeakReference(b4);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0894a
    public final AbstractC0894a b(Runnable runnable) {
        B b4 = (B) this.f9710a.get();
        if (b4 == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        b4.c(runnable);
        return this;
    }
}
