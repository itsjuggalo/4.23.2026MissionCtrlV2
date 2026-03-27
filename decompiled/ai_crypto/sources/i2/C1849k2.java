package i2;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import java.util.List;

/* JADX INFO: renamed from: i2.k2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1849k2 extends zzbl implements InterfaceC1865m2 {
    public C1849k2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // i2.InterfaceC1865m2
    public final void zze(List list) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzd(2, parcelZza);
    }
}
