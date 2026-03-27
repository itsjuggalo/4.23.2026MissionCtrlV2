package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class S extends F {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.e f10916c;

    public S(com.google.android.gms.common.api.e eVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f10916c = eVar;
    }

    @Override // com.google.android.gms.common.api.f
    public final AbstractC1167d a(AbstractC1167d abstractC1167d) {
        return this.f10916c.doRead(abstractC1167d);
    }

    @Override // com.google.android.gms.common.api.f
    public final AbstractC1167d b(AbstractC1167d abstractC1167d) {
        return this.f10916c.doWrite(abstractC1167d);
    }

    @Override // com.google.android.gms.common.api.f
    public final Context e() {
        return this.f10916c.getApplicationContext();
    }

    @Override // com.google.android.gms.common.api.f
    public final Looper f() {
        return this.f10916c.getLooper();
    }
}
