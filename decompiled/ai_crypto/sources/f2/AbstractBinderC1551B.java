package f2;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

/* JADX INFO: renamed from: f2.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1551B extends zzb implements InterfaceC1552C {
    public AbstractBinderC1551B() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static InterfaceC1552C zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterfaceQueryLocalInterface instanceof InterfaceC1552C ? (InterfaceC1552C) iInterfaceQueryLocalInterface : new C1550A(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i7, Parcel parcel, Parcel parcel2, int i8) {
        if (i7 != 1) {
            return false;
        }
        zzd((Location) zzc.zzb(parcel, Location.CREATOR));
        return true;
    }
}
