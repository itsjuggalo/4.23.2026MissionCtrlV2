package x5;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;
import w5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends zza implements IInterface {
    public h(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final w5.a H(w5.a aVar, String str, int i10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        Parcel parcelZzB = zzB(2, parcelZza);
        w5.a aVarH = a.AbstractBinderC0411a.H(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarH;
    }

    public final int I(w5.a aVar, String str, boolean z10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        Parcel parcelZzB = zzB(3, parcelZza);
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final w5.a J(w5.a aVar, String str, int i10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        Parcel parcelZzB = zzB(4, parcelZza);
        w5.a aVarH = a.AbstractBinderC0411a.H(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarH;
    }

    public final int K(w5.a aVar, String str, boolean z10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        Parcel parcelZzB = zzB(5, parcelZza);
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final int L() {
        Parcel parcelZzB = zzB(6, zza());
        int i10 = parcelZzB.readInt();
        parcelZzB.recycle();
        return i10;
    }

    public final w5.a M(w5.a aVar, String str, boolean z10, long j10) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(z10 ? 1 : 0);
        parcelZza.writeLong(j10);
        Parcel parcelZzB = zzB(7, parcelZza);
        w5.a aVarH = a.AbstractBinderC0411a.H(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarH;
    }

    public final w5.a N(w5.a aVar, String str, int i10, w5.a aVar2) {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, aVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(i10);
        zzc.zze(parcelZza, aVar2);
        Parcel parcelZzB = zzB(8, parcelZza);
        w5.a aVarH = a.AbstractBinderC0411a.H(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return aVarH;
    }
}
