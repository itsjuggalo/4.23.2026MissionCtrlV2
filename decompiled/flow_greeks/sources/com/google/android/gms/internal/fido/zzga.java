package com.google.android.gms.internal.fido;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzga extends zzfq implements Serializable {
    private final MessageDigest zza;
    private final int zzb;
    private final boolean zzc;
    private final String zzd;

    public zzga(String str, String str2) {
        MessageDigest messageDigestZzb = zzb("SHA-256");
        this.zza = messageDigestZzb;
        this.zzb = messageDigestZzb.getDigestLength();
        this.zzd = "Hashing.sha256()";
        this.zzc = zzc(messageDigestZzb);
    }

    private static MessageDigest zzb(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    private static boolean zzc(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public final String toString() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.fido.zzfu
    public final zzfv zza() {
        zzfy zzfyVar = null;
        if (this.zzc) {
            try {
                return new zzfz((MessageDigest) this.zza.clone(), this.zzb, zzfyVar);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new zzfz(zzb(this.zza.getAlgorithm()), this.zzb, zzfyVar);
    }
}
