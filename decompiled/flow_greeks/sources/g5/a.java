package g5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends n5.a {
    public static final Parcelable.Creator<a> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f10052c;

    public a(int i10, int i11, Bundle bundle) {
        this.f10050a = i10;
        this.f10051b = i11;
        this.f10052c = bundle;
    }

    public int R() {
        return this.f10051b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f10050a);
        n5.c.t(parcel, 2, R());
        n5.c.j(parcel, 3, this.f10052c, false);
        n5.c.b(parcel, iA);
    }
}
