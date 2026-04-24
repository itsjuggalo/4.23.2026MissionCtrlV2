package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class V extends H {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.e f9741c;

    public V(com.google.android.gms.common.api.e eVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f9741c = eVar;
    }

    @Override // com.google.android.gms.common.api.f
    public final AbstractC0901e a(AbstractC0901e abstractC0901e) {
        return this.f9741c.doRead(abstractC0901e);
    }

    @Override // com.google.android.gms.common.api.f
    public final AbstractC0901e b(AbstractC0901e abstractC0901e) {
        return this.f9741c.doWrite(abstractC0901e);
    }

    @Override // com.google.android.gms.common.api.f
    public final Context e() {
        return this.f9741c.getApplicationContext();
    }

    @Override // com.google.android.gms.common.api.f
    public final Looper f() {
        return this.f9741c.getLooper();
    }
}
