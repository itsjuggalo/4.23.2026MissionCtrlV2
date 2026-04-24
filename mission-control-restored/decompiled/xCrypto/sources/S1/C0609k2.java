package S1;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import java.util.List;

/* JADX INFO: renamed from: S1.k2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0609k2 extends zzbl implements InterfaceC0625m2 {
    public C0609k2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // S1.InterfaceC0625m2
    public final void zze(List list) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzd(2, parcelZza);
    }
}
