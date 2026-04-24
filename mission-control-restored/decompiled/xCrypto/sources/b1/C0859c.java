package b1;

import android.content.Context;
import k1.InterfaceC1567a;

/* JADX INFO: renamed from: b1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0859c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1567a f8245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1567a f8246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8247d;

    public C0859c(Context context, InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f8244a = context;
        if (interfaceC1567a == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f8245b = interfaceC1567a;
        if (interfaceC1567a2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f8246c = interfaceC1567a2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f8247d = str;
    }

    @Override // b1.h
    public Context b() {
        return this.f8244a;
    }

    @Override // b1.h
    public String c() {
        return this.f8247d;
    }

    @Override // b1.h
    public InterfaceC1567a d() {
        return this.f8246c;
    }

    @Override // b1.h
    public InterfaceC1567a e() {
        return this.f8245b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f8244a.equals(hVar.b()) && this.f8245b.equals(hVar.e()) && this.f8246c.equals(hVar.d()) && this.f8247d.equals(hVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f8244a.hashCode() ^ 1000003) * 1000003) ^ this.f8245b.hashCode()) * 1000003) ^ this.f8246c.hashCode()) * 1000003) ^ this.f8247d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f8244a + ", wallClock=" + this.f8245b + ", monotonicClock=" + this.f8246c + ", backendName=" + this.f8247d + "}";
    }
}
