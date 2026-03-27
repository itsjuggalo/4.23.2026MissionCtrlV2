package f2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: f2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1587m extends Q1.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<C1587m> CREATOR = new C1561L();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f14101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1588n f14102b;

    public C1587m(Status status, C1588n c1588n) {
        this.f14101a = status;
        this.f14102b = c1588n;
    }

    public C1588n A() {
        return this.f14102b;
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this.f14101a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, getStatus(), i7, false);
        Q1.c.C(parcel, 2, A(), i7, false);
        Q1.c.b(parcel, iA);
    }
}
