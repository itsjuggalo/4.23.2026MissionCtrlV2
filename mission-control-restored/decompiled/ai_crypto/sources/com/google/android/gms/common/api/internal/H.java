package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c;

/* JADX INFO: loaded from: classes.dex */
public final class H implements ComponentCallbacks2C1166c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1170g f10887a;

    public H(C1170g c1170g) {
        this.f10887a = c1170g;
    }

    @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C1166c.a
    public final void a(boolean z7) {
        C1170g c1170g = this.f10887a;
        c1170g.f10971n.sendMessage(c1170g.f10971n.obtainMessage(1, Boolean.valueOf(z7)));
    }
}
