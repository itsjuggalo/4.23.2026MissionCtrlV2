package j2;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: j2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2205b extends T1.a {
    public static final Parcelable.Creator<C2205b> CREATOR = new C2206c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f19991c;

    public C2205b(int i8, int i9, Intent intent) {
        this.f19989a = i8;
        this.f19990b = i9;
        this.f19991c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int i9 = this.f19989a;
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, i9);
        T1.c.j(parcel, 2, this.f19990b);
        T1.c.o(parcel, 3, this.f19991c, i8, false);
        T1.c.b(parcel, iA);
    }
}
