package com.google.android.recaptcha.internal;

import X2.AbstractC0765l;
import X2.AbstractC0769p;
import X2.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzhy {
    private List zza = AbstractC0769p.g();

    public final long zza(long[] jArr) {
        Iterator it = x.U(this.zza, AbstractC0765l.i0(jArr)).iterator();
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
        this.zza = AbstractC0765l.i0(jArr);
    }
}
