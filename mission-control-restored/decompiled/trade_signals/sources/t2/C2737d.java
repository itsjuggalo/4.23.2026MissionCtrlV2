package t2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: t2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2737d extends AbstractC2734a implements InterfaceC2739f {
    public C2737d(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t2.InterfaceC2739f
    public final void e(String str, Bundle bundle, InterfaceC2741h interfaceC2741h) {
        Parcel parcelD = D();
        parcelD.writeString(str);
        int i8 = AbstractC2736c.f23293a;
        parcelD.writeInt(1);
        bundle.writeToParcel(parcelD, 0);
        parcelD.writeStrongBinder(interfaceC2741h);
        E(2, parcelD);
    }
}
