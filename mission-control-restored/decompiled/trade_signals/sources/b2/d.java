package b2;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractC1190a implements f {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // b2.f
    public final boolean f(boolean z7) {
        Parcel parcelD = D();
        c.a(parcelD, true);
        Parcel parcelE = E(2, parcelD);
        boolean zB = c.b(parcelE);
        parcelE.recycle();
        return zB;
    }

    @Override // b2.f
    public final String zzc() {
        Parcel parcelE = E(1, D());
        String string = parcelE.readString();
        parcelE.recycle();
        return string;
    }
}
