package i2;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.ArrayList;

/* JADX INFO: renamed from: i2.l2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1857l2 extends zzbm implements InterfaceC1865m2 {
    public AbstractBinderC1857l2() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int i7, Parcel parcel, Parcel parcel2, int i8) {
        if (i7 != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(B6.CREATOR);
        zzbn.zzf(parcel);
        zze(arrayListCreateTypedArrayList);
        return true;
    }
}
