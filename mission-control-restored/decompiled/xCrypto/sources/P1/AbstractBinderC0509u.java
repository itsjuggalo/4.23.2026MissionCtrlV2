package P1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzb;

/* JADX INFO: renamed from: P1.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0509u extends zzb implements InterfaceC0510v {
    public static InterfaceC0510v zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return iInterfaceQueryLocalInterface instanceof InterfaceC0510v ? (InterfaceC0510v) iInterfaceQueryLocalInterface : new C0508t(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i4, Parcel parcel, Parcel parcel2, int i5) {
        throw null;
    }
}
