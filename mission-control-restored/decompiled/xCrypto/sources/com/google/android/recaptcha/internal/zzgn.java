package com.google.android.recaptcha.internal;

import X2.AbstractC0765l;
import X2.AbstractC0770q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgn implements zzgx {
    public static final zzgn zza = new zzgn();

    private zzgn() {
    }

    private static final boolean zzb(List list) {
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((zzue) it.next()).zzR()));
        }
        return !arrayList.contains(Boolean.FALSE);
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i4, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        if (!zzb(AbstractC0765l.j0(zzueVarArr))) {
            throw new zzce(4, 5, null);
        }
        for (zzue zzueVar : zzueVarArr) {
            zzgdVar.zzc().zzb(zzueVar.zzi());
        }
    }
}
