package A1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J1.a f19b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J1.a f20c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21d;

    public c(Context context, J1.a aVar, J1.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f18a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f19b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f20c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f21d = str;
    }

    @Override // A1.h
    public Context b() {
        return this.f18a;
    }

    @Override // A1.h
    public String c() {
        return this.f21d;
    }

    @Override // A1.h
    public J1.a d() {
        return this.f20c;
    }

    @Override // A1.h
    public J1.a e() {
        return this.f19b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f18a.equals(hVar.b()) && this.f19b.equals(hVar.e()) && this.f20c.equals(hVar.d()) && this.f21d.equals(hVar.c());
    }

    public int hashCode() {
        return ((((((this.f18a.hashCode() ^ 1000003) * 1000003) ^ this.f19b.hashCode()) * 1000003) ^ this.f20c.hashCode()) * 1000003) ^ this.f21d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f18a + ", wallClock=" + this.f19b + ", monotonicClock=" + this.f20c + ", backendName=" + this.f21d + "}";
    }
}
