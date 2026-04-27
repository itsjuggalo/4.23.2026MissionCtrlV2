package F1;

import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class n extends zza {
    public final E1.a a(E1.b bVar, String str, int i, E1.b bVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, bVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        zzc.zze(parcelZza, bVar2);
        Parcel parcelZzB = zzB(2, parcelZza);
        E1.a aVarA = E1.b.a(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarA;
    }

    public final E1.a b(E1.b bVar, String str, int i, E1.b bVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, bVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        zzc.zze(parcelZza, bVar2);
        Parcel parcelZzB = zzB(3, parcelZza);
        E1.a aVarA = E1.b.a(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarA;
    }
}
