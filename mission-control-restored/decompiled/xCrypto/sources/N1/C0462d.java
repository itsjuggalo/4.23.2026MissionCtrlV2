package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: renamed from: N1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0462d extends A1.a {
    public static final Parcelable.Creator<C0462d> CREATOR = new n0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0 f2765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F f2766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final I0 f2767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final K f2768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final M f2769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final E0 f2770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final P f2771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C0482s f2772i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final S f2773j;

    public C0462d(r rVar, C0 c02, F f4, I0 i02, K k4, M m4, E0 e02, P p4, C0482s c0482s, S s4) {
        this.f2764a = rVar;
        this.f2766c = f4;
        this.f2765b = c02;
        this.f2767d = i02;
        this.f2768e = k4;
        this.f2769f = m4;
        this.f2770g = e02;
        this.f2771h = p4;
        this.f2772i = c0482s;
        this.f2773j = s4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0462d)) {
            return false;
        }
        C0462d c0462d = (C0462d) obj;
        return AbstractC0939q.b(this.f2764a, c0462d.f2764a) && AbstractC0939q.b(this.f2765b, c0462d.f2765b) && AbstractC0939q.b(this.f2766c, c0462d.f2766c) && AbstractC0939q.b(this.f2767d, c0462d.f2767d) && AbstractC0939q.b(this.f2768e, c0462d.f2768e) && AbstractC0939q.b(this.f2769f, c0462d.f2769f) && AbstractC0939q.b(this.f2770g, c0462d.f2770g) && AbstractC0939q.b(this.f2771h, c0462d.f2771h) && AbstractC0939q.b(this.f2772i, c0462d.f2772i) && AbstractC0939q.b(this.f2773j, c0462d.f2773j);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2764a, this.f2765b, this.f2766c, this.f2767d, this.f2768e, this.f2769f, this.f2770g, this.f2771h, this.f2772i, this.f2773j);
    }

    public r i() {
        return this.f2764a;
    }

    public F k() {
        return this.f2766c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 2, i(), i4, false);
        A1.c.C(parcel, 3, this.f2765b, i4, false);
        A1.c.C(parcel, 4, k(), i4, false);
        A1.c.C(parcel, 5, this.f2767d, i4, false);
        A1.c.C(parcel, 6, this.f2768e, i4, false);
        A1.c.C(parcel, 7, this.f2769f, i4, false);
        A1.c.C(parcel, 8, this.f2770g, i4, false);
        A1.c.C(parcel, 9, this.f2771h, i4, false);
        A1.c.C(parcel, 10, this.f2772i, i4, false);
        A1.c.C(parcel, 11, this.f2773j, i4, false);
        A1.c.b(parcel, iA);
    }
}
