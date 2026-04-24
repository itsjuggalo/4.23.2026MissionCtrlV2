package com.google.android.gms.internal.play_billing;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.u2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1408u2 extends RuntimeException {
    public C1408u2(InterfaceC1334f2 interfaceC1334f2) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final R1 a() {
        return new R1(getMessage());
    }
}
