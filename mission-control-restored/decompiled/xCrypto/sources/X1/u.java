package X1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class u extends AbstractC0740a implements w {
    public u(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X1.w
    public final void J(Bundle bundle, y yVar) {
        Parcel parcelA0 = a0();
        q.c(parcelA0, bundle);
        parcelA0.writeStrongBinder(yVar);
        b0(3, parcelA0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X1.w
    public final void N(Bundle bundle, y yVar) {
        Parcel parcelA0 = a0();
        q.c(parcelA0, bundle);
        parcelA0.writeStrongBinder(yVar);
        b0(2, parcelA0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X1.w
    public final void a(Bundle bundle, F f4) {
        Parcel parcelA0 = a0();
        q.c(parcelA0, bundle);
        parcelA0.writeStrongBinder(f4);
        b0(6, parcelA0);
    }
}
