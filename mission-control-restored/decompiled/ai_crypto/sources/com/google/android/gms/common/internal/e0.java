package com.google.android.gms.common.internal;

import P1.C0648b;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0648b f11076a;

    public e0(C0648b c0648b) {
        AbstractC1207s.b(c0648b.D(), "ResolvableConnectionException can only be created with a connection result containing a resolution.");
        this.f11076a = c0648b;
    }
}
