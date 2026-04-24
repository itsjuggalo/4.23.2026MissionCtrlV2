package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzaem {
    public static String zza(zzaej zzaejVar, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance("SHA-256").digest(str.getBytes()));
            int length = str2.length();
            int i4 = 0;
            while (i4 < length) {
                if (zzg.zza(str2.charAt(i4))) {
                    char[] charArray = str2.toCharArray();
                    while (i4 < length) {
                        char c4 = charArray[i4];
                        if (zzg.zza(c4)) {
                            charArray[i4] = (char) (c4 ^ ' ');
                        }
                        i4++;
                    }
                    return String.valueOf(charArray);
                }
                i4++;
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
