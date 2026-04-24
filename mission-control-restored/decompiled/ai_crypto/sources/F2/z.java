package F2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class z extends AbstractC0463a implements B {
    public z(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // F2.B
    public final void a(Bundle bundle, F f7) {
        Parcel parcelA0 = a0();
        q.c(parcelA0, bundle);
        parcelA0.writeStrongBinder(f7);
        b0(3, parcelA0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // F2.B
    public final void h(Bundle bundle, D d7) {
        Parcel parcelA0 = a0();
        q.c(parcelA0, bundle);
        parcelA0.writeStrongBinder(d7);
        b0(2, parcelA0);
    }
}
