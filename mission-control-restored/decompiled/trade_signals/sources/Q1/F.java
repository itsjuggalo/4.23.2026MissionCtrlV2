package Q1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class F extends T1.a {
    public static final Parcelable.Creator<F> CREATOR = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6665d;

    public F(boolean z7, String str, int i8, int i9) {
        this.f6662a = z7;
        this.f6663b = str;
        this.f6664c = M.a(i8) - 1;
        this.f6665d = s.a(i9) - 1;
    }

    public final String a() {
        return this.f6663b;
    }

    public final boolean d() {
        return this.f6662a;
    }

    public final int e() {
        return s.a(this.f6665d);
    }

    public final int f() {
        return M.a(this.f6664c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.c(parcel, 1, this.f6662a);
        T1.c.p(parcel, 2, this.f6663b, false);
        T1.c.j(parcel, 3, this.f6664c);
        T1.c.j(parcel, 4, this.f6665d);
        T1.c.b(parcel, iA);
    }
}
