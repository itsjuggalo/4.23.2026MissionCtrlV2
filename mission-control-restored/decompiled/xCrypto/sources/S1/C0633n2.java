package S1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzbn;

/* JADX INFO: renamed from: S1.n2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0633n2 extends zzbl implements InterfaceC0649p2 {
    public C0633n2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // S1.InterfaceC0649p2
    public final void v(K6 k6) {
        Parcel parcelZza = zza();
        zzbn.zzc(parcelZza, k6);
        zzd(2, parcelZza);
    }
}
