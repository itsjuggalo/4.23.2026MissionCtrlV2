package E3;

import G3.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f1623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f1624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f1625d;

    public a(int i7, k kVar, byte[] bArr, byte[] bArr2) {
        this.f1622a = i7;
        if (kVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f1623b = kVar;
        if (bArr == null) {
            throw new NullPointerException("Null arrayValue");
        }
        this.f1624c = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Null directionalValue");
        }
        this.f1625d = bArr2;
    }

    @Override // E3.e
    public byte[] c() {
        return this.f1624c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f1622a == eVar.j() && this.f1623b.equals(eVar.i())) {
            boolean z7 = eVar instanceof a;
            if (Arrays.equals(this.f1624c, z7 ? ((a) eVar).f1624c : eVar.c())) {
                if (Arrays.equals(this.f1625d, z7 ? ((a) eVar).f1625d : eVar.h())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // E3.e
    public byte[] h() {
        return this.f1625d;
    }

    public int hashCode() {
        return ((((((this.f1622a ^ 1000003) * 1000003) ^ this.f1623b.hashCode()) * 1000003) ^ Arrays.hashCode(this.f1624c)) * 1000003) ^ Arrays.hashCode(this.f1625d);
    }

    @Override // E3.e
    public k i() {
        return this.f1623b;
    }

    @Override // E3.e
    public int j() {
        return this.f1622a;
    }

    public String toString() {
        return "IndexEntry{indexId=" + this.f1622a + ", documentKey=" + this.f1623b + ", arrayValue=" + Arrays.toString(this.f1624c) + ", directionalValue=" + Arrays.toString(this.f1625d) + "}";
    }
}
