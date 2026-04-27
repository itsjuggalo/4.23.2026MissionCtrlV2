package Y0;

import android.util.Base64;
import java.util.Arrays;
import s1.C0994k;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V0.d f3567c;

    public j(String str, byte[] bArr, V0.d dVar) {
        this.f3565a = str;
        this.f3566b = bArr;
        this.f3567c = dVar;
    }

    public static C0994k a() {
        C0994k c0994k = new C0994k(22);
        c0994k.f9532d = V0.d.f3186a;
        return c0994k;
    }

    public final j b(V0.d dVar) {
        C0994k c0994kA = a();
        c0994kA.W(this.f3565a);
        if (dVar == null) {
            throw new NullPointerException("Null priority");
        }
        c0994kA.f9532d = dVar;
        c0994kA.f9531c = this.f3566b;
        return c0994kA.B();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f3565a.equals(jVar.f3565a) && Arrays.equals(this.f3566b, jVar.f3566b) && this.f3567c.equals(jVar.f3567c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f3565a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3566b)) * 1000003) ^ this.f3567c.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.f3566b;
        return "TransportContext(" + this.f3565a + ", " + this.f3567c + ", " + (bArr == null ? "" : Base64.encodeToString(bArr, 2)) + ")";
    }
}
