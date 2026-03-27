package l2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends Q1.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f18300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18301b;

    public h(List list, String str) {
        this.f18300a = list;
        this.f18301b = str;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f18301b != null ? Status.f10838f : Status.f10842j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        List list = this.f18300a;
        int iA = Q1.c.a(parcel);
        Q1.c.G(parcel, 1, list, false);
        Q1.c.E(parcel, 2, this.f18301b, false);
        Q1.c.b(parcel, iA);
    }
}
