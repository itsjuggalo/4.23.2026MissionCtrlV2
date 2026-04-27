package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaje;
import com.google.android.gms.internal.p002firebaseauthapi.zzajf;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzajf<MessageType extends zzajf<MessageType, BuilderType>, BuilderType extends zzaje<MessageType, BuilderType>> implements zzamc {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamc
    public final zzajp a_() {
        try {
            zzaju zzajuVarZzc = zzajp.zzc(zzl());
            zza(zzajuVarZzc.zzb());
            return zzajuVarZzc.zza();
        } catch (IOException e7) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e7);
        }
    }

    public int zza(zzamv zzamvVar) {
        int iZzi = zzi();
        if (iZzi != -1) {
            return iZzi;
        }
        int iZza = zzamvVar.zza(this);
        zzb(iZza);
        return iZza;
    }

    public void zzb(int i7) {
        throw new UnsupportedOperationException();
    }

    public int zzi() {
        throw new UnsupportedOperationException();
    }

    public final byte[] zzk() {
        try {
            byte[] bArr = new byte[zzl()];
            zzakg zzakgVarZzb = zzakg.zzb(bArr);
            zza(zzakgVarZzb);
            zzakgVarZzb.zzb();
            return bArr;
        } catch (IOException e7) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e7);
        }
    }

    public final void zza(OutputStream outputStream) {
        zzakg zzakgVarZza = zzakg.zza(outputStream, zzakg.zzf(zzl()));
        zza(zzakgVarZza);
        zzakgVarZza.zzc();
    }
}
