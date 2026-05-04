package e6;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends n5.a {
    public static final Parcelable.Creator<l> CREATOR = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0 f8428d;

    public l(List list, boolean z10, boolean z11, i0 i0Var) {
        this.f8425a = list;
        this.f8426b = z10;
        this.f8427c = z11;
        this.f8428d = i0Var;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.I(parcel, 1, Collections.unmodifiableList(this.f8425a), false);
        n5.c.g(parcel, 2, this.f8426b);
        n5.c.g(parcel, 3, this.f8427c);
        n5.c.C(parcel, 5, this.f8428d, i10, false);
        n5.c.b(parcel, iA);
    }
}
