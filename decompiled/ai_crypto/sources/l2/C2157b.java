package l2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: l2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2157b extends Q1.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<C2157b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f18299c;

    public C2157b(int i7, int i8, Intent intent) {
        this.f18297a = i7;
        this.f18298b = i8;
        this.f18299c = intent;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f18298b == 0 ? Status.f10838f : Status.f10842j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int i8 = this.f18297a;
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, i8);
        Q1.c.t(parcel, 2, this.f18298b);
        Q1.c.C(parcel, 3, this.f18299c, i7, false);
        Q1.c.b(parcel, iA);
    }
}
