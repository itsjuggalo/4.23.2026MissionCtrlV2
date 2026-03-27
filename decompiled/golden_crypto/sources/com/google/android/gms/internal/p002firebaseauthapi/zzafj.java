package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.a.a.o.b;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@23.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafj {
    public static String zza(String str) {
        try {
            Object objInvoke = Class.forName(b.at).getDeclaredMethod(b.au, String.class).invoke(null, str);
            if (objInvoke != null && String.class.isAssignableFrom(objInvoke.getClass())) {
                return (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
