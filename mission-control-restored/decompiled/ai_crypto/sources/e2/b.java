package e2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import e2.c;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends Q1.a {
    public static final Parcelable.Creator<b> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f13575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f13576d;

    public b(int i7, byte[] bArr, String str, List list) {
        this.f13573a = i7;
        this.f13574b = bArr;
        try {
            this.f13575c = c.a(str);
            this.f13576d = list;
        } catch (c.a e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public byte[] A() {
        return this.f13574b;
    }

    public c B() {
        return this.f13575c;
    }

    public List C() {
        return this.f13576d;
    }

    public int D() {
        return this.f13573a;
    }

    public boolean equals(Object obj) {
        List list;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Arrays.equals(this.f13574b, bVar.f13574b) || !this.f13575c.equals(bVar.f13575c)) {
            return false;
        }
        List list2 = this.f13576d;
        if (list2 == null && bVar.f13576d == null) {
            return true;
        }
        return list2 != null && (list = bVar.f13576d) != null && list2.containsAll(list) && bVar.f13576d.containsAll(this.f13576d);
    }

    public int hashCode() {
        return AbstractC1206q.c(Integer.valueOf(Arrays.hashCode(this.f13574b)), this.f13575c, this.f13576d);
    }

    public String toString() {
        List list = this.f13576d;
        return String.format("{keyHandle: %s, version: %s, transports: %s}", W1.c.c(this.f13574b), this.f13575c, list == null ? "null" : list.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, D());
        Q1.c.k(parcel, 2, A(), false);
        Q1.c.E(parcel, 3, this.f13575c.toString(), false);
        Q1.c.I(parcel, 4, C(), false);
        Q1.c.b(parcel, iA);
    }
}
