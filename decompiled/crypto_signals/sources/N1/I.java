package N1;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbl;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class I extends zzbl implements J {
    @Override // N1.J
    public final void zze(List list) {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzd(2, parcelZza);
    }
}
