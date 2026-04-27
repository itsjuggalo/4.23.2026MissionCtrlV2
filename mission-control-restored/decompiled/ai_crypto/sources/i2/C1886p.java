package i2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: i2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1886p extends Q1.a {
    public static final Parcelable.Creator<C1886p> CREATOR = new C1894q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f15984a;

    public C1886p(Bundle bundle) {
        this.f15984a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        Bundle bundle = this.f15984a;
        int iA = Q1.c.a(parcel);
        Q1.c.j(parcel, 1, bundle, false);
        Q1.c.b(parcel, iA);
    }
}
