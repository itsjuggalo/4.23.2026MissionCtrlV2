package s1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B1.a f22973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B1.a f22974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22975d;

    public c(Context context, B1.a aVar, B1.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f22972a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f22973b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f22974c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f22975d = str;
    }

    @Override // s1.h
    public Context b() {
        return this.f22972a;
    }

    @Override // s1.h
    public String c() {
        return this.f22975d;
    }

    @Override // s1.h
    public B1.a d() {
        return this.f22974c;
    }

    @Override // s1.h
    public B1.a e() {
        return this.f22973b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f22972a.equals(hVar.b()) && this.f22973b.equals(hVar.e()) && this.f22974c.equals(hVar.d()) && this.f22975d.equals(hVar.c());
    }

    public int hashCode() {
        return ((((((this.f22972a.hashCode() ^ 1000003) * 1000003) ^ this.f22973b.hashCode()) * 1000003) ^ this.f22974c.hashCode()) * 1000003) ^ this.f22975d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f22972a + ", wallClock=" + this.f22973b + ", monotonicClock=" + this.f22974c + ", backendName=" + this.f22975d + "}";
    }
}
