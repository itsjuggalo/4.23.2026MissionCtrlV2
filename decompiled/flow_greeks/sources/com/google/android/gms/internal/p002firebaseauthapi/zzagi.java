package com.google.android.gms.internal.p002firebaseauthapi;

import com.amazon.a.a.o.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzagi {
    public static String zza(String str) {
        try {
            Object objInvoke = Class.forName(b.at).getDeclaredMethod(b.au, String.class).invoke(null, str);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
