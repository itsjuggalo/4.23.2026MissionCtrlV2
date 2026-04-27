package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkr;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzkr<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkq<MessageType, BuilderType>> implements zznl {
    protected int zza = 0;

    public static void zzce(Iterable iterable, List list) {
        zzkq.zzaU(iterable, list);
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final zzlg zzcb() {
        try {
            int iZzcn = zzcn();
            zzlg zzlgVar = zzlg.zzb;
            byte[] bArr = new byte[iZzcn];
            int i4 = zzll.zzb;
            zzlj zzljVar = new zzlj(bArr, 0, iZzcn);
            zzcB(zzljVar);
            return zzld.zza(zzljVar, bArr);
        } catch (IOException e4) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e4);
        }
    }

    public final byte[] zzcc() {
        try {
            int iZzcn = zzcn();
            byte[] bArr = new byte[iZzcn];
            int i4 = zzll.zzb;
            zzlj zzljVar = new zzlj(bArr, 0, iZzcn);
            zzcB(zzljVar);
            zzljVar.zzE();
            return bArr;
        } catch (IOException e4) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e4);
        }
    }

    public int zzcd(zznw zznwVar) {
        throw null;
    }
}
