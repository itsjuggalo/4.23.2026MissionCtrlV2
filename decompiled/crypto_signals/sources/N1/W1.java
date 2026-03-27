package N1;

import android.os.Parcel;
import android.os.Parcelable;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class W1 extends AbstractC1255a {
    public static final Parcelable.Creator<W1> CREATOR = new X1(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f1427d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1428f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Double f1429k;

    public W1(int i, String str, long j4, Long l6, Float f6, String str2, String str3, Double d4) {
        this.f1424a = i;
        this.f1425b = str;
        this.f1426c = j4;
        this.f1427d = l6;
        this.f1429k = i == 1 ? f6 != null ? Double.valueOf(f6.doubleValue()) : null : d4;
        this.e = str2;
        this.f1428f = str3;
    }

    public final Object m() {
        Long l6 = this.f1427d;
        if (l6 != null) {
            return l6;
        }
        Double d4 = this.f1429k;
        if (d4 != null) {
            return d4;
        }
        String str = this.e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        X1.a(this, parcel);
    }

    public W1(long j4, Object obj, String str, String str2) {
        com.google.android.gms.common.internal.I.d(str);
        this.f1424a = 2;
        this.f1425b = str;
        this.f1426c = j4;
        this.f1428f = str2;
        if (obj == null) {
            this.f1427d = null;
            this.f1429k = null;
            this.e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f1427d = (Long) obj;
            this.f1429k = null;
            this.e = null;
        } else if (obj instanceof String) {
            this.f1427d = null;
            this.f1429k = null;
            this.e = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f1427d = null;
                this.f1429k = (Double) obj;
                this.e = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public W1(Y1 y12) {
        String str = y12.f1442c;
        this(y12.f1443d, y12.e, str, y12.f1441b);
    }
}
