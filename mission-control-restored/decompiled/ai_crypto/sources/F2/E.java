package F2;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class E extends p implements F {
    public E() {
        super("com.google.android.play.core.integrity.protocol.IRequestDialogCallback");
    }

    @Override // F2.p
    public final boolean a(int i7, Parcel parcel, Parcel parcel2, int i8) {
        if (i7 != 2) {
            return false;
        }
        Bundle bundle = (Bundle) q.a(parcel, Bundle.CREATOR);
        q.b(parcel);
        b(bundle);
        return true;
    }
}
