package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzgp extends IOException {
    public zzgp() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzgp(long j4, long j5, int i4, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i4))), th);
    }

    public zzgp(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
