package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.a.a.o.c.a.b;
import com.google.android.gms.common.internal.s;
import java.io.UnsupportedEncodingException;
import java.util.List;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahx {
    public static long zza(String str) {
        zzahw zzahwVarZzb = zzb(str);
        return zzahwVarZzb.zza().longValue() - zzahwVarZzb.zzb().longValue();
    }

    private static zzahw zzb(String str) {
        s.e(str);
        List<String> listZza = zzt.zza(b.f4610a).zza((CharSequence) str);
        if (listZza.size() >= 2) {
            try {
                return zzahw.zza(new String(c.b(listZza.get(1)), "UTF-8"));
            } catch (UnsupportedEncodingException e10) {
                throw new RuntimeException("Unable to decode token", e10);
            }
        }
        throw new RuntimeException("Invalid idToken " + str);
    }
}
