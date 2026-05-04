package com.google.protobuf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class t1 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7153a;

    public t1(u0 u0Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f7153a = null;
    }

    public d0 a() {
        return new d0(getMessage());
    }
}
