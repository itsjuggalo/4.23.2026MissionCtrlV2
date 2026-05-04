package h6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends n5.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11034b;

    public h(List list, String str) {
        this.f11033a = list;
        this.f11034b = str;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f11034b != null ? Status.f5455f : Status.f5459j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.f11033a;
        int iA = n5.c.a(parcel);
        n5.c.G(parcel, 1, list, false);
        n5.c.E(parcel, 2, this.f11034b, false);
        n5.c.b(parcel, iA);
    }
}
