package m4;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v4.a f15859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v4.a f15860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15861d;

    public c(Context context, v4.a aVar, v4.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f15858a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f15859b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f15860c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f15861d = str;
    }

    @Override // m4.h
    public Context b() {
        return this.f15858a;
    }

    @Override // m4.h
    public String c() {
        return this.f15861d;
    }

    @Override // m4.h
    public v4.a d() {
        return this.f15860c;
    }

    @Override // m4.h
    public v4.a e() {
        return this.f15859b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f15858a.equals(hVar.b()) && this.f15859b.equals(hVar.e()) && this.f15860c.equals(hVar.d()) && this.f15861d.equals(hVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f15858a.hashCode() ^ 1000003) * 1000003) ^ this.f15859b.hashCode()) * 1000003) ^ this.f15860c.hashCode()) * 1000003) ^ this.f15861d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f15858a + ", wallClock=" + this.f15859b + ", monotonicClock=" + this.f15860c + ", backendName=" + this.f15861d + "}";
    }
}
