package com.google.android.recaptcha.internal;

import F5.AbstractC0552j;
import F5.AbstractC0556n;
import F5.v;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzhy {
    private List zza = AbstractC0556n.g();

    public final long zza(long[] jArr) {
        Iterator it = v.V(this.zza, AbstractC0552j.h0(jArr)).iterator();
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
        this.zza = AbstractC0552j.h0(jArr);
    }
}
