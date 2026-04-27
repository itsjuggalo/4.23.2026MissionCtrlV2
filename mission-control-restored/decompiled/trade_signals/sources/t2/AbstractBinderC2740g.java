package t2;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: t2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC2740g extends AbstractBinderC2735b implements InterfaceC2741h {
    public AbstractBinderC2740g() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override // t2.AbstractBinderC2735b
    public final boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 != 2) {
            return false;
        }
        Parcelable.Creator creator = Bundle.CREATOR;
        int i10 = AbstractC2736c.f23293a;
        Bundle bundle = (Bundle) (parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel));
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail <= 0) {
            zzb(bundle);
            return true;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + iDataAvail);
    }
}
