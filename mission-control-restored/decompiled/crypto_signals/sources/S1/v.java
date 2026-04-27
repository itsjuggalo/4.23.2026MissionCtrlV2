package S1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends k implements w {
    @Override // S1.k
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i6) {
        if (i != 2) {
            return false;
        }
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) l.a(parcel);
        l.b(parcel);
        b(bundle);
        return true;
    }
}
