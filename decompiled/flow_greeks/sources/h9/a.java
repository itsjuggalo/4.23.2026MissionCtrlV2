package h9;

import j9.k;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f11241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f11242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f11243d;

    public a(int i10, k kVar, byte[] bArr, byte[] bArr2) {
        this.f11240a = i10;
        if (kVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f11241b = kVar;
        if (bArr == null) {
            throw new NullPointerException("Null arrayValue");
        }
        this.f11242c = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Null directionalValue");
        }
        this.f11243d = bArr2;
    }

    @Override // h9.e
    public byte[] c() {
        return this.f11242c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f11240a == eVar.k() && this.f11241b.equals(eVar.i())) {
                boolean z10 = eVar instanceof a;
                if (Arrays.equals(this.f11242c, z10 ? ((a) eVar).f11242c : eVar.c())) {
                    if (Arrays.equals(this.f11243d, z10 ? ((a) eVar).f11243d : eVar.h())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // h9.e
    public byte[] h() {
        return this.f11243d;
    }

    public int hashCode() {
        return ((((((this.f11240a ^ 1000003) * 1000003) ^ this.f11241b.hashCode()) * 1000003) ^ Arrays.hashCode(this.f11242c)) * 1000003) ^ Arrays.hashCode(this.f11243d);
    }

    @Override // h9.e
    public k i() {
        return this.f11241b;
    }

    @Override // h9.e
    public int k() {
        return this.f11240a;
    }

    public String toString() {
        return "IndexEntry{indexId=" + this.f11240a + ", documentKey=" + this.f11241b + ", arrayValue=" + Arrays.toString(this.f11242c) + ", directionalValue=" + Arrays.toString(this.f11243d) + "}";
    }
}
