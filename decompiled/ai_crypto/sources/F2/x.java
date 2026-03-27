package F2;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class x extends p implements y {
    public x() {
        super("com.google.android.play.core.integrity.protocol.IExpressIntegrityServiceCallback");
    }

    @Override // F2.p
    public final boolean a(int i7, Parcel parcel, Parcel parcel2, int i8) {
        if (i7 == 2) {
            Bundle bundle = (Bundle) q.a(parcel, Bundle.CREATOR);
            q.b(parcel);
            e(bundle);
            return true;
        }
        if (i7 == 3) {
            Bundle bundle2 = (Bundle) q.a(parcel, Bundle.CREATOR);
            q.b(parcel);
            c(bundle2);
            return true;
        }
        if (i7 == 4) {
            Bundle bundle3 = (Bundle) q.a(parcel, Bundle.CREATOR);
            q.b(parcel);
            d(bundle3);
            return true;
        }
        if (i7 != 5) {
            return false;
        }
        Bundle bundle4 = (Bundle) q.a(parcel, Bundle.CREATOR);
        q.b(parcel);
        b(bundle4);
        return true;
    }
}
