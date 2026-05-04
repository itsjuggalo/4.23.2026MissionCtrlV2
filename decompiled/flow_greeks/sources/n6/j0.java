package n6;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends a implements l0 {
    public j0(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n6.l0
    public final void a(Bundle bundle, u0 u0Var) {
        Parcel parcelH = H();
        f0.c(parcelH, bundle);
        parcelH.writeStrongBinder(u0Var);
        I(6, parcelH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n6.l0
    public final void b(Bundle bundle, n0 n0Var) {
        Parcel parcelH = H();
        f0.c(parcelH, bundle);
        parcelH.writeStrongBinder(n0Var);
        I(3, parcelH);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n6.l0
    public final void m(Bundle bundle, n0 n0Var) {
        Parcel parcelH = H();
        f0.c(parcelH, bundle);
        parcelH.writeStrongBinder(n0Var);
        I(2, parcelH);
    }
}
