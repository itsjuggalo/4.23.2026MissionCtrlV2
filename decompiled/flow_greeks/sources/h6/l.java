package h6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends n5.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m5.b f11038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q0 f11039c;

    public l(int i10, m5.b bVar, q0 q0Var) {
        this.f11037a = i10;
        this.f11038b = bVar;
        this.f11039c = q0Var;
    }

    public final m5.b R() {
        return this.f11038b;
    }

    public final q0 S() {
        return this.f11039c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f11037a);
        n5.c.C(parcel, 2, this.f11038b, i10, false);
        n5.c.C(parcel, 3, this.f11039c, i10, false);
        n5.c.b(parcel, iA);
    }
}
