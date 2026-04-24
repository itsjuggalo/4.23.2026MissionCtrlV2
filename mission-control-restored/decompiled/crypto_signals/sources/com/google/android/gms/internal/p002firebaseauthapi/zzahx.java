package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Base64;
import com.google.android.gms.common.internal.I;
import java.io.UnsupportedEncodingException;
import java.util.List;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class zzahx {
    public static long zza(String str) {
        zzahw zzahwVarZzb = zzb(str);
        return zzahwVarZzb.zza().longValue() - zzahwVarZzb.zzb().longValue();
    }

    private static zzahw zzb(String str) {
        I.d(str);
        List<String> listZza = zzt.zza('.').zza((CharSequence) str);
        if (listZza.size() < 2) {
            throw new RuntimeException(AbstractC1024h.b("Invalid idToken ", str));
        }
        String str2 = listZza.get(1);
        try {
            return zzahw.zza(new String(str2 == null ? null : Base64.decode(str2, 11), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
