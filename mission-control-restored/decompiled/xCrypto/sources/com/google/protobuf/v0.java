package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class v0 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11243a;

    public v0(W w4) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f11243a = null;
    }

    public D a() {
        return new D(getMessage());
    }
}
