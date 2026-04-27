package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: N1.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0488y extends A1.a {
    public static final Parcelable.Creator<C0488y> CREATOR = new Z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2872c;

    public C0488y(String str, String str2, String str3) {
        this.f2870a = (String) AbstractC0940s.k(str);
        this.f2871b = (String) AbstractC0940s.k(str2);
        this.f2872c = str3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0488y)) {
            return false;
        }
        C0488y c0488y = (C0488y) obj;
        return AbstractC0939q.b(this.f2870a, c0488y.f2870a) && AbstractC0939q.b(this.f2871b, c0488y.f2871b) && AbstractC0939q.b(this.f2872c, c0488y.f2872c);
    }

    public String getName() {
        return this.f2871b;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2870a, this.f2871b, this.f2872c);
    }

    public String i() {
        return this.f2872c;
    }

    public String k() {
        return this.f2870a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, k(), false);
        A1.c.E(parcel, 3, getName(), false);
        A1.c.E(parcel, 4, i(), false);
        A1.c.b(parcel, iA);
    }
}
