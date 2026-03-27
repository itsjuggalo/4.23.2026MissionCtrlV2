package O1;

import O1.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends A1.a {
    public static final Parcelable.Creator<b> CREATOR = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f3114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3115d;

    public b(int i4, byte[] bArr, String str, List list) {
        this.f3112a = i4;
        this.f3113b = bArr;
        try {
            this.f3114c = c.a(str);
            this.f3115d = list;
        } catch (c.a e4) {
            throw new IllegalArgumentException(e4);
        }
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
        if (!Arrays.equals(this.f3113b, bVar.f3113b) || !this.f3114c.equals(bVar.f3114c)) {
            return false;
        }
        List list2 = this.f3115d;
        if (list2 == null && bVar.f3115d == null) {
            return true;
        }
        return list2 != null && (list = bVar.f3115d) != null && list2.containsAll(list) && bVar.f3115d.containsAll(this.f3115d);
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(Arrays.hashCode(this.f3113b)), this.f3114c, this.f3115d);
    }

    public byte[] i() {
        return this.f3113b;
    }

    public c k() {
        return this.f3114c;
    }

    public List l() {
        return this.f3115d;
    }

    public int m() {
        return this.f3112a;
    }

    public String toString() {
        List list = this.f3115d;
        return String.format("{keyHandle: %s, version: %s, transports: %s}", G1.c.c(this.f3113b), this.f3114c, list == null ? "null" : list.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, m());
        A1.c.k(parcel, 2, i(), false);
        A1.c.E(parcel, 3, this.f3114c.toString(), false);
        A1.c.I(parcel, 4, l(), false);
        A1.c.b(parcel, iA);
    }
}
