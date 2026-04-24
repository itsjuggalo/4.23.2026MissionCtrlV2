package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u0 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12791a;

    public u0(V v7) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f12791a = null;
    }

    public D a() {
        return new D(getMessage());
    }
}
