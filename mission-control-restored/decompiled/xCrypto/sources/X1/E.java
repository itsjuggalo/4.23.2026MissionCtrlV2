package X1;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class E extends p implements F {
    public E() {
        super("com.google.android.play.core.integrity.protocol.IRequestDialogCallback");
    }

    @Override // X1.p
    public final boolean a(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 != 2) {
            return false;
        }
        Bundle bundle = (Bundle) q.a(parcel, Bundle.CREATOR);
        q.b(parcel);
        b(bundle);
        return true;
    }
}
