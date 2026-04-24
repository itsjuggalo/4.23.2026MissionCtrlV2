package j2;

import Q1.C0790b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;

/* JADX INFO: loaded from: classes.dex */
public final class l extends T1.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0790b f19997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final I f19998c;

    public l(int i8, C0790b c0790b, I i9) {
        this.f19996a = i8;
        this.f19997b = c0790b;
        this.f19998c = i9;
    }

    public final C0790b a() {
        return this.f19997b;
    }

    public final I d() {
        return this.f19998c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.j(parcel, 1, this.f19996a);
        T1.c.o(parcel, 2, this.f19997b, i8, false);
        T1.c.o(parcel, 3, this.f19998c, i8, false);
        T1.c.b(parcel, iA);
    }
}
