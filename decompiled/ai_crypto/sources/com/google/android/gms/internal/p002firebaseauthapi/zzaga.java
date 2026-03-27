package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.a.a.o.b;

/* JADX INFO: loaded from: classes.dex */
public final class zzaga {
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
