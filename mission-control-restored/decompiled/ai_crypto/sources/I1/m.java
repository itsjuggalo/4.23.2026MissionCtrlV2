package I1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class m extends Q1.a {
    public static final Parcelable.Creator<m> CREATOR = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2942b;

    public m(String str, String str2) {
        this.f2941a = AbstractC1207s.f(((String) AbstractC1207s.l(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.f2942b = AbstractC1207s.e(str2);
    }

    public String A() {
        return this.f2941a;
    }

    public String B() {
        return this.f2942b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return AbstractC1206q.b(this.f2941a, mVar.f2941a) && AbstractC1206q.b(this.f2942b, mVar.f2942b);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f2941a, this.f2942b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, A(), false);
        Q1.c.E(parcel, 2, B(), false);
        Q1.c.b(parcel, iA);
    }
}
