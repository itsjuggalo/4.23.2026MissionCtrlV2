package j2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends T1.a {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19993b;

    public h(List list, String str) {
        this.f19992a = list;
        this.f19993b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        List list = this.f19992a;
        int iA = T1.c.a(parcel);
        T1.c.q(parcel, 1, list, false);
        T1.c.p(parcel, 2, this.f19993b, false);
        T1.c.b(parcel, iA);
    }
}
