package com.google.android.gms.internal.p002firebaseauthapi;

import G1.c;
import com.amazon.a.a.o.c.a.b;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzahp {
    public static long zza(String str) {
        zzaho zzahoVarZzb = zzb(str);
        return zzahoVarZzb.zza().longValue() - zzahoVarZzb.zzb().longValue();
    }

    private static zzaho zzb(String str) {
        AbstractC0940s.e(str);
        List<String> listZza = zzv.zza(b.f8816a).zza((CharSequence) str);
        if (listZza.size() >= 2) {
            try {
                return zzaho.zza(new String(c.b(listZza.get(1)), "UTF-8"));
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException("Unable to decode token", e4);
            }
        }
        throw new RuntimeException("Invalid idToken " + str);
    }
}
