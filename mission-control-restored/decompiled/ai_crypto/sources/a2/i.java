package a2;

import Z1.a;
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
        int i7 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i7;
    }

    public final int b0(Z1.a aVar, String str, boolean z7) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z7 ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i7 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i7;
    }

    public final int c0(Z1.a aVar, String str, boolean z7) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z7 ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i7 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i7;
    }

    public final Z1.a d0(Z1.a aVar, String str, int i7) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i7);
        Parcel parcelZzB = zzB(2, parcelZza);
        Z1.a aVarB = a.AbstractBinderC0104a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final Z1.a e0(Z1.a aVar, String str, int i7, Z1.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i7);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(8, parcelZza);
        Z1.a aVarB = a.AbstractBinderC0104a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final Z1.a f0(Z1.a aVar, String str, int i7) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i7);
        Parcel parcelZzB = zzB(4, parcelZza);
        Z1.a aVarB = a.AbstractBinderC0104a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }

    public final Z1.a g0(Z1.a aVar, String str, boolean z7, long j7) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z7 ? 1 : 0);
        parcelZza.writeLong(j7);
        Parcel parcelZzB = zzB(7, parcelZza);
        Z1.a aVarB = a.AbstractBinderC0104a.b(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarB;
    }
}
