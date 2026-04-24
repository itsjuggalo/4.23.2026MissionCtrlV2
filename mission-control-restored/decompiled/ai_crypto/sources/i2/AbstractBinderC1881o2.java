package i2;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;

/* JADX INFO: renamed from: i2.o2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1881o2 extends zzbm implements InterfaceC1889p2 {
    public AbstractBinderC1881o2() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i7, Parcel parcel, Parcel parcel2, int i8) {
        if (i7 != 2) {
            return false;
        }
        K6 k62 = (K6) zzbn.zzb(parcel, K6.CREATOR);
        zzbn.zzf(parcel);
        w(k62);
        return true;
    }
}
