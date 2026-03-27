package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzgp extends IOException {
    public zzgp() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzgp(long j7, long j8, int i7, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j7), Long.valueOf(j8), Integer.valueOf(i7))), th);
    }

    public zzgp(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
