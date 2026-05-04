package l6;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a implements f {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l6.f
    public final void i(String str, Bundle bundle, h hVar) {
        Parcel parcelH = H();
        parcelH.writeString(str);
        int i10 = c.f15496a;
        parcelH.writeInt(1);
        bundle.writeToParcel(parcelH, 0);
        parcelH.writeStrongBinder(hVar);
        I(2, parcelH);
    }
}
