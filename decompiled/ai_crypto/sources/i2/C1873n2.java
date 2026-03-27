package i2;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;

/* JADX INFO: renamed from: i2.n2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1873n2 extends zzbl implements InterfaceC1889p2 {
    public C1873n2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // i2.InterfaceC1889p2
    public final void w(K6 k62) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, k62);
        zzd(2, parcelZza);
    }
}
