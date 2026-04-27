package K1;

import J1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zza implements IInterface {
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int a0() {
        Parcel parcelZzB = zzB(6, zza());
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    public final int b0(J1.a aVar, String str, boolean z4) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z4 ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    public final int c0(J1.a aVar, String str, boolean z4) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z4 ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i4 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i4;
    }

    public final J1.a d0(J1.a aVar, String str, int i4) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        Parcel parcelZzB = zzB(2, parcelZza);
        J1.a aVarB = a.AbstractBinderC0026a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final J1.a e0(J1.a aVar, String str, int i4, J1.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(8, parcelZza);
        J1.a aVarB = a.AbstractBinderC0026a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final J1.a f0(J1.a aVar, String str, int i4) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i4);
        Parcel parcelZzB = zzB(4, parcelZza);
        J1.a aVarB = a.AbstractBinderC0026a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final J1.a g0(J1.a aVar, String str, boolean z4, long j4) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z4 ? 1 : 0);
        parcelZza.writeLong(j4);
        Parcel parcelZzB = zzB(7, parcelZza);
        J1.a aVarB = a.AbstractBinderC0026a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
