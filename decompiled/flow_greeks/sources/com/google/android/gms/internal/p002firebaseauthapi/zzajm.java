package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzajm;
import com.google.android.gms.internal.p002firebaseauthapi.zzajo;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzajm<MessageType extends zzajm<MessageType, BuilderType>, BuilderType extends zzajo<MessageType, BuilderType>> implements zzamm {
    protected int zza = 0;

    public int zza(zzanb zzanbVar) {
        int iZzi = zzi();
        if (iZzi != -1) {
            return iZzi;
        }
        int iZza = zzanbVar.zza(this);
        zzb(iZza);
        return iZza;
    }

    public void zzb(int i10) {
        throw new UnsupportedOperationException();
    }

    public int zzi() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamm
    public final zzajv zzj() {
        try {
            zzake zzakeVarZzc = zzajv.zzc(zzl());
            zza(zzakeVarZzc.zzb());
            return zzakeVarZzc.zza();
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }

    public final byte[] zzk() {
        try {
            byte[] bArr = new byte[zzl()];
            zzakn zzaknVarZzb = zzakn.zzb(bArr);
            zza(zzaknVarZzb);
            zzaknVarZzb.zzb();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e10);
        }
    }

    public final void zza(OutputStream outputStream) {
        zzakn zzaknVarZza = zzakn.zza(outputStream, zzakn.zze(zzl()));
        zza(zzaknVarZza);
        zzaknVarZza.zzc();
    }
}
