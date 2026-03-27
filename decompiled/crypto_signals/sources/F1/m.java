package F1;

import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class m extends zza {
    public final E1.a D(E1.b bVar, String str, boolean z6, long j4) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, bVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z6 ? 1 : 0);
        parcelZza.writeLong(j4);
        Parcel parcelZzB = zzB(7, parcelZza);
        E1.a aVarA = E1.b.a(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarA;
    }

    public final E1.a a(E1.b bVar, String str, int i) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, bVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
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
        Parcel parcelZzB = zzB(8, parcelZza);
        E1.a aVarA = E1.b.a(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarA;
    }

    public final E1.a i(E1.b bVar, String str, int i) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, bVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        Parcel parcelZzB = zzB(4, parcelZza);
        E1.a aVarA = E1.b.a(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarA;
    }
}
