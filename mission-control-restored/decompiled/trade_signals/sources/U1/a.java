package U1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c2.AbstractC1250a;
import com.google.android.gms.common.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a extends AbstractC1250a implements IInterface {
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void G(r rVar) {
        Parcel parcelD = D();
        c2.c.c(parcelD, rVar);
        F(1, parcelD);
    }
}
