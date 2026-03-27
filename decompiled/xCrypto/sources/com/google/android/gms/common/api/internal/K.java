package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ComponentCallbacks2C0900d;

/* JADX INFO: loaded from: classes.dex */
public final class K implements ComponentCallbacks2C0900d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0904h f9712a;

    public K(C0904h c0904h) {
        this.f9712a = c0904h;
    }

    @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C0900d.a
    public final void onBackgroundStateChanged(boolean z4) {
        C0904h c0904h = this.f9712a;
        c0904h.f9788n.sendMessage(c0904h.f9788n.obtainMessage(1, Boolean.valueOf(z4)));
    }
}
