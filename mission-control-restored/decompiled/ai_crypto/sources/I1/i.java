package I1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class i extends Q1.a {
    public static final Parcelable.Creator<i> CREATOR = new C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f2925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2927c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f2928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2930c;

        public i a() {
            return new i(this.f2928a, this.f2929b, this.f2930c);
        }

        public a b(m mVar) {
            this.f2928a = mVar;
            return this;
        }

        public final a c(String str) {
            this.f2929b = str;
            return this;
        }

        public final a d(int i7) {
            this.f2930c = i7;
            return this;
        }
    }

    public i(m mVar, String str, int i7) {
        this.f2925a = (m) AbstractC1207s.k(mVar);
        this.f2926b = str;
        this.f2927c = i7;
    }

    public static a A() {
        return new a();
    }

    public static a C(i iVar) {
        AbstractC1207s.k(iVar);
        a aVarA = A();
        aVarA.b(iVar.B());
        aVarA.d(iVar.f2927c);
        String str = iVar.f2926b;
        if (str != null) {
            aVarA.c(str);
        }
        return aVarA;
    }

    public m B() {
        return this.f2925a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return AbstractC1206q.b(this.f2925a, iVar.f2925a) && AbstractC1206q.b(this.f2926b, iVar.f2926b) && this.f2927c == iVar.f2927c;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2925a, this.f2926b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, B(), i7, false);
        Q1.c.E(parcel, 2, this.f2926b, false);
        Q1.c.t(parcel, 3, this.f2927c);
        Q1.c.b(parcel, iA);
    }
}
