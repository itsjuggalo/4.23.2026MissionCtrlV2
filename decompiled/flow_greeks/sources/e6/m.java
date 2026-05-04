package e6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends n5.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<m> CREATOR = new l0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f8429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f8430b;

    public m(Status status, n nVar) {
        this.f8429a = status;
        this.f8430b = nVar;
    }

    public n R() {
        return this.f8430b;
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this.f8429a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, getStatus(), i10, false);
        n5.c.C(parcel, 2, R(), i10, false);
        n5.c.b(parcel, iA);
    }
}
