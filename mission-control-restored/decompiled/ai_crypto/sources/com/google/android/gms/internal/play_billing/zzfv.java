package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfu;
import com.google.android.gms.internal.play_billing.zzfv;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfv<MessageType extends zzfv<MessageType, BuilderType>, BuilderType extends zzfu<MessageType, BuilderType>> implements zzim {
    protected int zza = 0;

    public static void zzg(Iterable iterable, List list) {
        zzfu.zzc(iterable, list);
    }

    public int zze(zzix zzixVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzim
    public final zzgk zzf() {
        try {
            int iZzk = zzk();
            zzgk zzgkVar = zzgk.zzb;
            byte[] bArr = new byte[iZzk];
            zzgo zzgoVar = new zzgo(bArr, 0, iZzk);
            zzJ(zzgoVar);
            zzgoVar.zzB();
            return new zzgi(bArr);
        } catch (IOException e7) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e7);
        }
    }

    public final byte[] zzh() {
        try {
            int iZzk = zzk();
            byte[] bArr = new byte[iZzk];
            zzgo zzgoVar = new zzgo(bArr, 0, iZzk);
            zzJ(zzgoVar);
            zzgoVar.zzB();
            return bArr;
        } catch (IOException e7) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e7);
        }
    }
}
