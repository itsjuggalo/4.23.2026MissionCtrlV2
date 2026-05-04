package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements o, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f14924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14929g;

    public a(int i10, Object obj, Class cls, String str, String str2, int i11) {
        this.f14923a = obj;
        this.f14924b = cls;
        this.f14925c = str;
        this.f14926d = str2;
        this.f14927e = (i11 & 1) == 1;
        this.f14928f = i10;
        this.f14929g = i11 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14927e == aVar.f14927e && this.f14928f == aVar.f14928f && this.f14929g == aVar.f14929g && t.b(this.f14923a, aVar.f14923a) && t.b(this.f14924b, aVar.f14924b) && this.f14925c.equals(aVar.f14925c) && this.f14926d.equals(aVar.f14926d);
    }

    @Override // kotlin.jvm.internal.o
    public int getArity() {
        return this.f14928f;
    }

    public int hashCode() {
        Object obj = this.f14923a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.f14924b;
        return ((((((((((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.f14925c.hashCode()) * 31) + this.f14926d.hashCode()) * 31) + (this.f14927e ? 1231 : 1237)) * 31) + this.f14928f) * 31) + this.f14929g;
    }

    public String toString() {
        return n0.i(this);
    }
}
