package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzlk extends IOException {
    public zzlk() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzlk(long j7, long j8, int i7, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j7), Long.valueOf(j8), Integer.valueOf(i7))), th);
    }

    public zzlk(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
