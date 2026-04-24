package r1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class m extends A1.a {
    public static final Parcelable.Creator<m> CREATOR = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14558b;

    public m(String str, String str2) {
        this.f14557a = AbstractC0940s.f(((String) AbstractC0940s.l(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.f14558b = AbstractC0940s.e(str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return AbstractC0939q.b(this.f14557a, mVar.f14557a) && AbstractC0939q.b(this.f14558b, mVar.f14558b);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f14557a, this.f14558b);
    }

    public String i() {
        return this.f14557a;
    }

    public String k() {
        return this.f14558b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 1, i(), false);
        A1.c.E(parcel, 2, k(), false);
        A1.c.b(parcel, iA);
    }
}
