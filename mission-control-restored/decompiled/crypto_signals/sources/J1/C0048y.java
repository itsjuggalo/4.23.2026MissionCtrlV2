package J1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import t2.u0;

/* JADX INFO: renamed from: J1.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0048y extends AbstractC0036l {
    public static final Parcelable.Creator<C0048y> CREATOR = new H1.b(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F f767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f769d;
    public final Double e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f770f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0037m f771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f772l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final L f773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EnumC0029e f774n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C0030f f775o;

    public C0048y(C c6, F f6, byte[] bArr, ArrayList arrayList, Double d4, ArrayList arrayList2, C0037m c0037m, Integer num, L l6, String str, C0030f c0030f) {
        com.google.android.gms.common.internal.I.g(c6);
        this.f766a = c6;
        com.google.android.gms.common.internal.I.g(f6);
        this.f767b = f6;
        com.google.android.gms.common.internal.I.g(bArr);
        this.f768c = bArr;
        com.google.android.gms.common.internal.I.g(arrayList);
        this.f769d = arrayList;
        this.e = d4;
        this.f770f = arrayList2;
        this.f771k = c0037m;
        this.f772l = num;
        this.f773m = l6;
        if (str != null) {
            try {
                this.f774n = EnumC0029e.a(str);
            } catch (C0028d e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            this.f774n = null;
        }
        this.f775o = c0030f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0048y)) {
            return false;
        }
        C0048y c0048y = (C0048y) obj;
        if (!com.google.android.gms.common.internal.I.j(this.f766a, c0048y.f766a) || !com.google.android.gms.common.internal.I.j(this.f767b, c0048y.f767b) || !Arrays.equals(this.f768c, c0048y.f768c) || !com.google.android.gms.common.internal.I.j(this.e, c0048y.e)) {
            return false;
        }
        ArrayList arrayList = this.f769d;
        ArrayList arrayList2 = c0048y.f769d;
        if (!arrayList.containsAll(arrayList2) || !arrayList2.containsAll(arrayList)) {
            return false;
        }
        ArrayList arrayList3 = this.f770f;
        ArrayList arrayList4 = c0048y.f770f;
        return ((arrayList3 == null && arrayList4 == null) || (arrayList3 != null && arrayList4 != null && arrayList3.containsAll(arrayList4) && arrayList4.containsAll(arrayList3))) && com.google.android.gms.common.internal.I.j(this.f771k, c0048y.f771k) && com.google.android.gms.common.internal.I.j(this.f772l, c0048y.f772l) && com.google.android.gms.common.internal.I.j(this.f773m, c0048y.f773m) && com.google.android.gms.common.internal.I.j(this.f774n, c0048y.f774n) && com.google.android.gms.common.internal.I.j(this.f775o, c0048y.f775o);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f766a, this.f767b, Integer.valueOf(Arrays.hashCode(this.f768c)), this.f769d, this.e, this.f770f, this.f771k, this.f772l, this.f773m, this.f774n, this.f775o});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.S(parcel, 2, this.f766a, i, false);
        u0.S(parcel, 3, this.f767b, i, false);
        u0.M(parcel, 4, this.f768c, false);
        u0.W(parcel, 5, this.f769d, false);
        u0.N(parcel, 6, this.e);
        u0.W(parcel, 7, this.f770f, false);
        u0.S(parcel, 8, this.f771k, i, false);
        u0.Q(parcel, 9, this.f772l);
        u0.S(parcel, 10, this.f773m, i, false);
        EnumC0029e enumC0029e = this.f774n;
        u0.T(parcel, 11, enumC0029e == null ? null : enumC0029e.f716a, false);
        u0.S(parcel, 12, this.f775o, i, false);
        u0.a0(iX, parcel);
    }
}
