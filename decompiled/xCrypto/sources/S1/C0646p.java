package S1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: S1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0646p extends A1.a {
    public static final Parcelable.Creator<C0646p> CREATOR = new C0654q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f4825a;

    public C0646p(Bundle bundle) {
        this.f4825a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Bundle bundle = this.f4825a;
        int iA = A1.c.a(parcel);
        A1.c.j(parcel, 1, bundle, false);
        A1.c.b(parcel, iA);
    }
}
