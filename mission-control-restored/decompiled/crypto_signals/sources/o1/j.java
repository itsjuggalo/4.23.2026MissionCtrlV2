package o1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import java.util.Arrays;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: loaded from: classes.dex */
public final class j extends AbstractC1255a {
    public static final Parcelable.Creator<j> CREATOR = new r(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8655d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8656f;

    public j(String str, String str2, String str3, String str4, boolean z6, int i) {
        I.g(str);
        this.f8652a = str;
        this.f8653b = str2;
        this.f8654c = str3;
        this.f8655d = str4;
        this.e = z6;
        this.f8656f = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return I.j(this.f8652a, jVar.f8652a) && I.j(this.f8655d, jVar.f8655d) && I.j(this.f8653b, jVar.f8653b) && I.j(Boolean.valueOf(this.e), Boolean.valueOf(jVar.e)) && this.f8656f == jVar.f8656f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8652a, this.f8653b, this.f8655d, Boolean.valueOf(this.e), Integer.valueOf(this.f8656f)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.T(parcel, 1, this.f8652a, false);
        u0.T(parcel, 2, this.f8653b, false);
        u0.T(parcel, 3, this.f8654c, false);
        u0.T(parcel, 4, this.f8655d, false);
        u0.b0(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        u0.b0(parcel, 6, 4);
        parcel.writeInt(this.f8656f);
        u0.a0(iX, parcel);
    }
}
