package a3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: a3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0869p extends Z2.L {
    public static final Parcelable.Creator<C0869p> CREATOR = new C0875s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f6270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f6271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0855i f6272e;

    public C0869p() {
    }

    public static C0869p B(String str, C0855i c0855i) {
        AbstractC1207s.e(str);
        C0869p c0869p = new C0869p();
        c0869p.f6268a = str;
        c0869p.f6272e = c0855i;
        return c0869p;
    }

    public static C0869p C(List list, String str) {
        AbstractC1207s.k(list);
        AbstractC1207s.e(str);
        C0869p c0869p = new C0869p();
        c0869p.f6270c = new ArrayList();
        c0869p.f6271d = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Z2.J j7 = (Z2.J) it.next();
            if (j7 instanceof Z2.S) {
                c0869p.f6270c.add((Z2.S) j7);
            } else {
                if (!(j7 instanceof Z2.Y)) {
                    throw new IllegalArgumentException("MultiFactorInfo must be either PhoneMultiFactorInfo or TotpMultiFactorInfo. The factorId of this MultiFactorInfo: " + j7.B());
                }
                c0869p.f6271d.add((Z2.Y) j7);
            }
        }
        c0869p.f6269b = str;
        return c0869p;
    }

    public final C0855i A() {
        return this.f6272e;
    }

    public final String D() {
        return this.f6268a;
    }

    public final boolean E() {
        return this.f6268a != null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, this.f6268a, false);
        Q1.c.E(parcel, 2, this.f6269b, false);
        Q1.c.I(parcel, 3, this.f6270c, false);
        Q1.c.I(parcel, 4, this.f6271d, false);
        Q1.c.C(parcel, 5, this.f6272e, i7, false);
        Q1.c.b(parcel, iA);
    }

    public final String zzc() {
        return this.f6269b;
    }

    public C0869p(String str, String str2, List list, List list2, C0855i c0855i) {
        this.f6268a = str;
        this.f6269b = str2;
        this.f6270c = list;
        this.f6271d = list2;
        this.f6272e = c0855i;
    }
}
