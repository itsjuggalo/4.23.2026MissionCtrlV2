package j2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c2.AbstractC1250a;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC1250a implements IInterface {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void G(j jVar, f fVar) {
        Parcel parcelD = D();
        c2.c.c(parcelD, jVar);
        c2.c.d(parcelD, fVar);
        E(12, parcelD);
    }
}
