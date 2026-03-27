package a2;

import Z1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class j extends zza implements IInterface {
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final Z1.a b(Z1.a aVar, String str, int i7, Z1.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i7);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(2, parcelZza);
        Z1.a aVarB = a.AbstractBinderC0104a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final Z1.a c(Z1.a aVar, String str, int i7, Z1.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i7);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(3, parcelZza);
        Z1.a aVarB = a.AbstractBinderC0104a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
