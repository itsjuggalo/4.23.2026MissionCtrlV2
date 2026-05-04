package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzdr;
import com.google.android.gms.internal.play_billing.zzds;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzds<MessageType extends zzds<MessageType, BuilderType>, BuilderType extends zzdr<MessageType, BuilderType>> implements zzgl {
    protected int zza = 0;

    public static void zzg(Iterable iterable, List list) {
        byte[] bArr = zzfo.zzb;
        int size = ((Collection) iterable).size();
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + size);
        } else if (list instanceof zzgt) {
            ((zzgt) list).zzf(list.size() + size);
        }
        int size2 = list.size();
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i10 = 0; i10 < size3; i10++) {
            Object obj = list2.get(i10);
            if (obj == null) {
                String str = "Element at index " + (list.size() - size2) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size2) {
                        throw new NullPointerException(str);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj);
            }
        }
    }

    public final byte[] zzM() {
        try {
            int iZzj = zzj();
            byte[] bArr = new byte[iZzj];
            int i10 = zzep.zzb;
            zzem zzemVar = new zzem(bArr, 0, iZzj);
            zzL(zzemVar);
            zzemVar.zzE();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e10);
        }
    }

    public int zze(zzgv zzgvVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgl
    public final zzei zzf() {
        try {
            int iZzj = zzj();
            zzei zzeiVar = zzei.zzb;
            byte[] bArr = new byte[iZzj];
            int i10 = zzep.zzb;
            zzem zzemVar = new zzem(bArr, 0, iZzj);
            zzL(zzemVar);
            return zzee.zza(zzemVar, bArr);
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }
}
