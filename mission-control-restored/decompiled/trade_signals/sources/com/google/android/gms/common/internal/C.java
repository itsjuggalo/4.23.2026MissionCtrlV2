package com.google.android.gms.common.internal;

import S1.InterfaceC0872d;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1283c;

/* JADX INFO: loaded from: classes.dex */
public final class C implements AbstractC1283c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0872d f14921a;

    public C(InterfaceC0872d interfaceC0872d) {
        this.f14921a = interfaceC0872d;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c.a
    public final void onConnected(Bundle bundle) {
        this.f14921a.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1283c.a
    public final void onConnectionSuspended(int i8) {
        this.f14921a.onConnectionSuspended(i8);
    }
}
