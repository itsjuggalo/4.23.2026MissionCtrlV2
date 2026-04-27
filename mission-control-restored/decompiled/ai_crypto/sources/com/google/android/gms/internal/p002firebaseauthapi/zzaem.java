package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzaem {
    public static String zza(zzaej zzaejVar, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance("SHA-256").digest(str.getBytes()));
            int length = str2.length();
            int i7 = 0;
            while (i7 < length) {
                if (zzg.zza(str2.charAt(i7))) {
                    char[] charArray = str2.toCharArray();
                    while (i7 < length) {
                        char c7 = charArray[i7];
                        if (zzg.zza(c7)) {
                            charArray[i7] = (char) (c7 ^ ' ');
                        }
                        i7++;
                    }
                    return String.valueOf(charArray);
                }
                i7++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzaej.zza.c("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }

    public static void zzb(zzaej zzaejVar, String str) {
        zzaejVar.zza(str, null);
    }
}
