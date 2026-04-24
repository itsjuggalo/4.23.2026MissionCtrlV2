package com.google.android.gms.internal.p002firebaseauthapi;

import a3.d;
import java.util.logging.Level;
import java.util.logging.Logger;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class zzac {
    public static String zza(String str) {
        return zzp.zzb(str);
    }

    public static String zzb(String str) {
        return zzp.zzc(str);
    }

    public static boolean zzc(String str) {
        return zzp.zzd(str);
    }

    public static String zza(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i6 = 0; i6 < objArr.length; i6++) {
                objArr[i6] = zza(objArr[i6]);
            }
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i7 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i7)) != -1) {
            sb.append((CharSequence) strValueOf, i7, iIndexOf);
            sb.append(objArr[i]);
            i7 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) strValueOf, i7, strValueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i8 = i + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String zza(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String strK = d.k(obj.getClass().getName(), "@", Integer.toHexString(System.identityHashCode(obj)));
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", AbstractC1024h.b("Exception during lenientFormat for ", strK), (Throwable) e);
            return "<" + strK + " threw " + e.getClass().getName() + ">";
        }
    }
}
