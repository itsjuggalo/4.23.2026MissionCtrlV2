package c5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k extends n5.a {
    public static final Parcelable.Creator<k> CREATOR = new g0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f3670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3672c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f3673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3675c;

        public k a() {
            return new k(this.f3673a, this.f3674b, this.f3675c);
        }

        public a b(o oVar) {
            this.f3673a = oVar;
            return this;
        }

        public final a c(int i10) {
            this.f3675c = i10;
            return this;
        }

        public final a d(String str) {
            this.f3674b = str;
            return this;
        }
    }

    public k(o oVar, String str, int i10) {
        this.f3670a = (o) com.google.android.gms.common.internal.s.k(oVar);
        this.f3671b = str;
        this.f3672c = i10;
    }

    public static a R() {
        return new a();
    }

    public static a T(k kVar) {
        com.google.android.gms.common.internal.s.k(kVar);
        a aVarR = R();
        aVarR.b(kVar.S());
        aVarR.c(kVar.f3672c);
        String str = kVar.f3671b;
        if (str != null) {
            aVarR.d(str);
        }
        return aVarR;
    }

    public o S() {
        return this.f3670a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return com.google.android.gms.common.internal.q.b(this.f3670a, kVar.f3670a) && com.google.android.gms.common.internal.q.b(this.f3671b, kVar.f3671b) && this.f3672c == kVar.f3672c;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f3670a, this.f3671b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, S(), i10, false);
        n5.c.E(parcel, 2, this.f3671b, false);
        n5.c.t(parcel, 3, this.f3672c);
        n5.c.b(parcel, iA);
    }
}
