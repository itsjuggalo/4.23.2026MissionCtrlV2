package i2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class h7 extends Q1.a {
    public static final Parcelable.Creator<h7> CREATOR = new i7();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f15822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f15824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Double f15825g;

    public h7(int i7, String str, long j7, Long l7, Float f7, String str2, String str3, Double d7) {
        this.f15819a = i7;
        this.f15820b = str;
        this.f15821c = j7;
        this.f15822d = l7;
        this.f15825g = i7 == 1 ? f7 != null ? Double.valueOf(f7.doubleValue()) : null : d7;
        this.f15823e = str2;
        this.f15824f = str3;
    }

    public final Object A() {
        Long l7 = this.f15822d;
        if (l7 != null) {
            return l7;
        }
        Double d7 = this.f15825g;
        if (d7 != null) {
            return d7;
        }
        String str = this.f15823e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        i7.a(this, parcel, i7);
    }

    public h7(j7 j7Var) {
        this(j7Var.f15867c, j7Var.f15868d, j7Var.f15869e, j7Var.f15866b);
    }

    public h7(String str, long j7, Object obj, String str2) {
        AbstractC1207s.e(str);
        this.f15819a = 2;
        this.f15820b = str;
        this.f15821c = j7;
        this.f15824f = str2;
        if (obj == null) {
            this.f15822d = null;
            this.f15825g = null;
            this.f15823e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f15822d = (Long) obj;
            this.f15825g = null;
            this.f15823e = null;
        } else if (obj instanceof String) {
            this.f15822d = null;
            this.f15825g = null;
            this.f15823e = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f15822d = null;
                this.f15825g = (Double) obj;
                this.f15823e = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
