package com.google.android.recaptcha.internal;

import H4.g;
import H4.h;
import H4.p;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzhy {
    private List zza = p.f577a;

    public final long zza(long[] jArr) {
        Iterator it = h.j0(this.zza, g.j0(jArr)).iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = Long.valueOf(((Number) next).longValue() ^ ((Number) it.next()).longValue());
        }
        return ((Number) next).longValue();
    }

    public final void zzb(long[] jArr) {
        this.zza = g.j0(jArr);
    }
}
