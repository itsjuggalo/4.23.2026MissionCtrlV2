package com.google.android.gms.common.internal;

import u1.C1200b;

/* JADX INFO: loaded from: classes.dex */
public final class J extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1200b f5200a;

    public J(C1200b c1200b) {
        I.a("ResolvableConnectionException can only be created with a connection result containing a resolution.", (c1200b.f10274b == 0 || c1200b.f10275c == null) ? false : true);
        this.f5200a = c1200b;
    }
}
