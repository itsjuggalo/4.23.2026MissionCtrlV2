package h6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.o0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends n5.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f11036b;

    public j(int i10, o0 o0Var) {
        this.f11035a = i10;
        this.f11036b = o0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f11035a);
        n5.c.C(parcel, 2, this.f11036b, i10, false);
        n5.c.b(parcel, iA);
    }
}
