package f2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzb;

/* JADX INFO: renamed from: f2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1595u extends zzb implements InterfaceC1596v {
    public static InterfaceC1596v zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return iInterfaceQueryLocalInterface instanceof InterfaceC1596v ? (InterfaceC1596v) iInterfaceQueryLocalInterface : new C1594t(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i7, Parcel parcel, Parcel parcel2, int i8) {
        throw null;
    }
}
