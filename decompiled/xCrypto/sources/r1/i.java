package r1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class i extends A1.a {
    public static final Parcelable.Creator<i> CREATOR = new C();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f14541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14543c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f14544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14546c;

        public i a() {
            return new i(this.f14544a, this.f14545b, this.f14546c);
        }

        public a b(m mVar) {
            this.f14544a = mVar;
            return this;
        }

        public final a c(String str) {
            this.f14545b = str;
            return this;
        }

        public final a d(int i4) {
            this.f14546c = i4;
            return this;
        }
    }

    public i(m mVar, String str, int i4) {
        this.f14541a = (m) AbstractC0940s.k(mVar);
        this.f14542b = str;
        this.f14543c = i4;
    }

    public static a i() {
        return new a();
    }

    public static a l(i iVar) {
        AbstractC0940s.k(iVar);
        a aVarI = i();
        aVarI.b(iVar.k());
        aVarI.d(iVar.f14543c);
        String str = iVar.f14542b;
        if (str != null) {
            aVarI.c(str);
        }
        return aVarI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return AbstractC0939q.b(this.f14541a, iVar.f14541a) && AbstractC0939q.b(this.f14542b, iVar.f14542b) && this.f14543c == iVar.f14543c;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14541a, this.f14542b);
    }

    public m k() {
        return this.f14541a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, k(), i4, false);
        A1.c.E(parcel, 2, this.f14542b, false);
        A1.c.t(parcel, 3, this.f14543c);
        A1.c.b(parcel, iA);
    }
}
