package P1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: P1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0502m extends A1.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<C0502m> CREATOR = new L();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f3436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0503n f3437b;

    public C0502m(Status status, C0503n c0503n) {
        this.f3436a = status;
        this.f3437b = c0503n;
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this.f3436a;
    }

    public C0503n i() {
        return this.f3437b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, getStatus(), i4, false);
        A1.c.C(parcel, 2, i(), i4, false);
        A1.c.b(parcel, iA);
    }
}
