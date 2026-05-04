package com.google.android.recaptcha.internal;

import com.amazon.a.a.o.b.f;
import dd.a0;
import dd.n;
import java.util.Collection;
import java.util.Objects;
import kg.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzgp implements zzgx {
    public static final zzgp zza = new zzgp();

    private zzgp() {
    }

    @Override // com.google.android.recaptcha.internal.zzgx
    public final void zza(int i10, zzgd zzgdVar, zzue... zzueVarArr) throws zzce {
        String strI0;
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
            strI0 = n.g0((int[]) objZza, f.f4598a, "[", "]", 0, null, null, 56, null);
        } else {
            if (objZza instanceof byte[]) {
                str = new String((byte[]) objZza, c.f14857b);
            } else if (objZza instanceof long[]) {
                strI0 = n.h0((long[]) objZza, f.f4598a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof short[]) {
                strI0 = n.j0((short[]) objZza, f.f4598a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof float[]) {
                strI0 = n.f0((float[]) objZza, f.f4598a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof double[]) {
                strI0 = n.e0((double[]) objZza, f.f4598a, "[", "]", 0, null, null, 56, null);
            } else if (objZza instanceof char[]) {
                str = new String((char[]) objZza);
            } else if (objZza instanceof Object[]) {
                strI0 = n.i0((Object[]) objZza, f.f4598a, "[", "]", 0, null, null, 56, null);
            } else {
                if (!(objZza instanceof Collection)) {
                    throw new zzce(4, 5, null);
                }
                strI0 = a0.i0((Iterable) objZza, f.f4598a, "[", "]", 0, null, null, 56, null);
            }
            strI0 = str;
        }
        zzgdVar.zzc().zze(i10, strI0);
    }
}
