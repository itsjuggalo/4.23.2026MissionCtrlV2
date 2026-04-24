package K1;

import J1.a;
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

    public final J1.a b(J1.a aVar, String str, int i4, J1.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(2, parcelZza);
        J1.a aVarB = a.AbstractBinderC0026a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final J1.a c(J1.a aVar, String str, int i4, J1.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(3, parcelZza);
        J1.a aVarB = a.AbstractBinderC0026a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
