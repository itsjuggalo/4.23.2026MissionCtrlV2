package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.t1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1402t1 extends IOException {
    public C1402t1(long j8, long j9, int i8, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j8), Long.valueOf(j9), Integer.valueOf(i8))), th);
    }

    public C1402t1(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
