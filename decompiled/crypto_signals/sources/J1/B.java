package J1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractC0036l {
    public static final Parcelable.Creator<B> CREATOR = new H1.b(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f667d;
    public final Integer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final L f668f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final V f669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C0030f f670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f671m;

    public B(byte[] bArr, Double d4, String str, ArrayList arrayList, Integer num, L l6, String str2, C0030f c0030f, Long l7) {
        com.google.android.gms.common.internal.I.g(bArr);
        this.f664a = bArr;
        this.f665b = d4;
        com.google.android.gms.common.internal.I.g(str);
        this.f666c = str;
        this.f667d = arrayList;
        this.e = num;
        this.f668f = l6;
        this.f671m = l7;
        if (str2 != null) {
            try {
                this.f669k = V.a(str2);
            } catch (U e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            this.f669k = null;
        }
        this.f670l = c0030f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof B)) {
            return false;
        }
        B b3 = (B) obj;
        if (!Arrays.equals(this.f664a, b3.f664a) || !com.google.android.gms.common.internal.I.j(this.f665b, b3.f665b) || !com.google.android.gms.common.internal.I.j(this.f666c, b3.f666c)) {
            return false;
        }
        ArrayList arrayList = this.f667d;
        ArrayList arrayList2 = b3.f667d;
        return ((arrayList == null && arrayList2 == null) || (arrayList != null && arrayList2 != null && arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList))) && com.google.android.gms.common.internal.I.j(this.e, b3.e) && com.google.android.gms.common.internal.I.j(this.f668f, b3.f668f) && com.google.android.gms.common.internal.I.j(this.f669k, b3.f669k) && com.google.android.gms.common.internal.I.j(this.f670l, b3.f670l) && com.google.android.gms.common.internal.I.j(this.f671m, b3.f671m);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(Arrays.hashCode(this.f664a)), this.f665b, this.f666c, this.f667d, this.e, this.f668f, this.f669k, this.f670l, this.f671m});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.M(parcel, 2, this.f664a, false);
        u0.N(parcel, 3, this.f665b);
        u0.T(parcel, 4, this.f666c, false);
        u0.W(parcel, 5, this.f667d, false);
        u0.Q(parcel, 6, this.e);
        u0.S(parcel, 7, this.f668f, i, false);
        V v2 = this.f669k;
        u0.T(parcel, 8, v2 == null ? null : v2.f700a, false);
        u0.S(parcel, 9, this.f670l, i, false);
        u0.R(parcel, 10, this.f671m);
        u0.a0(iX, parcel);
    }
}
