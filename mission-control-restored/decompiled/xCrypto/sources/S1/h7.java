package S1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public final class h7 extends A1.a {
    public static final Parcelable.Creator<h7> CREATOR = new i7();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f4663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Double f4666g;

    public h7(int i4, String str, long j4, Long l4, Float f4, String str2, String str3, Double d4) {
        this.f4660a = i4;
        this.f4661b = str;
        this.f4662c = j4;
        this.f4663d = l4;
        this.f4666g = i4 == 1 ? f4 != null ? Double.valueOf(f4.doubleValue()) : null : d4;
        this.f4664e = str2;
        this.f4665f = str3;
    }

    public final Object i() {
        Long l4 = this.f4663d;
        if (l4 != null) {
            return l4;
        }
        Double d4 = this.f4666g;
        if (d4 != null) {
            return d4;
        }
        String str = this.f4664e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        i7.a(this, parcel, i4);
    }

    public h7(j7 j7Var) {
        this(j7Var.f4708c, j7Var.f4709d, j7Var.f4710e, j7Var.f4707b);
    }

    public h7(String str, long j4, Object obj, String str2) {
        AbstractC0940s.e(str);
        this.f4660a = 2;
        this.f4661b = str;
        this.f4662c = j4;
        this.f4665f = str2;
        if (obj == null) {
            this.f4663d = null;
            this.f4666g = null;
            this.f4664e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f4663d = (Long) obj;
            this.f4666g = null;
            this.f4664e = null;
        } else if (obj instanceof String) {
            this.f4663d = null;
            this.f4666g = null;
            this.f4664e = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f4663d = null;
                this.f4666g = (Double) obj;
                this.f4664e = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
