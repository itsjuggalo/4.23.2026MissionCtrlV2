package S1;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;

/* JADX INFO: renamed from: S1.o2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0641o2 extends zzbm implements InterfaceC0649p2 {
    public AbstractBinderC0641o2() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 != 2) {
            return false;
        }
        K6 k6 = (K6) zzbn.zzb(parcel, K6.CREATOR);
        zzbn.zzf(parcel);
        v(k6);
        return true;
    }
}
