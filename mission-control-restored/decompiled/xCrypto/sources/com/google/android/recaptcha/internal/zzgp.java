package com.google.android.recaptcha.internal;

import X2.AbstractC0765l;
import X2.x;
import com.amazon.a.a.o.b.f;
import java.util.Collection;
import java.util.Objects;
import r3.C1756c;

/* JADX INFO: loaded from: classes.dex */
public final class zzgp implements zzgx {
    public static final zzgp zza = new zzgp();

    private zzgp() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i4, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        String strQ;
        String str;
        if (zzueVarArr.length != 1) {
            throw new zzce(4, 3, null);
        }
        Object objZza = zzgdVar.zzc().zza(zzueVarArr[0]);
        if (true != Objects.nonNull(objZza)) {
            objZza = null;
        }
        if (objZza == null) {
            throw new zzce(4, 5, null);
        }
        if (objZza instanceof int[]) {
            strQ = AbstractC0765l.W((int[]) objZza, f.f8804a, "[", "]", 0, null, null, 56, null);
        } else {
            if (objZza instanceof byte[]) {
                str = new String((byte[]) objZza, C1756c.f14563b);
            } else if (objZza instanceof long[]) {
                strQ = AbstractC0765l.X((long[]) objZza, f.f8804a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof short[]) {
                strQ = AbstractC0765l.Z((short[]) objZza, f.f8804a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof float[]) {
                strQ = AbstractC0765l.V((float[]) objZza, f.f8804a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof double[]) {
                strQ = AbstractC0765l.U((double[]) objZza, f.f8804a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof char[]) {
                str = new String((char[]) objZza);
            } else if (objZza instanceof Object[]) {
                strQ = AbstractC0765l.Y((Object[]) objZza, f.f8804a, "[", "]", 0, null, null, 56, null);
            } else {
                if (!(objZza instanceof Collection)) {
                    throw new zzce(4, 5, null);
                }
                strQ = x.Q((Iterable) objZza, f.f8804a, "[", "]", 0, null, null, 56, null);
            }
            strQ = str;
        }
        zzgdVar.zzc().zze(i4, strQ);
    }
}
