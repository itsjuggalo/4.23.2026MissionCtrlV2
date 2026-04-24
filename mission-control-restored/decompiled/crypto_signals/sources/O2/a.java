package O2;

import Q2.h;
import U2.r;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f2331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f2332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f2333d;

    public a(int i, h hVar, byte[] bArr, byte[] bArr2) {
        this.f2330a = i;
        if (hVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f2331b = hVar;
        if (bArr == null) {
            throw new NullPointerException("Null arrayValue");
        }
        this.f2332c = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Null directionalValue");
        }
        this.f2333d = bArr2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a aVar = (a) obj;
        int iCompare = Integer.compare(this.f2330a, aVar.f2330a);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = this.f2331b.compareTo(aVar.f2331b);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iB = r.b(this.f2332c, aVar.f2332c);
        return iB != 0 ? iB : r.b(this.f2333d, aVar.f2333d);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f2330a == aVar.f2330a && this.f2331b.equals(aVar.f2331b) && Arrays.equals(this.f2332c, aVar.f2332c) && Arrays.equals(this.f2333d, aVar.f2333d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f2330a ^ 1000003) * 1000003) ^ this.f2331b.f2674a.hashCode()) * 1000003) ^ Arrays.hashCode(this.f2332c)) * 1000003) ^ Arrays.hashCode(this.f2333d);
    }

    public final String toString() {
        return "IndexEntry{indexId=" + this.f2330a + ", documentKey=" + this.f2331b + ", arrayValue=" + Arrays.toString(this.f2332c) + ", directionalValue=" + Arrays.toString(this.f2333d) + "}";
    }
}
