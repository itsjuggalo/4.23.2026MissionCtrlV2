package g4;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1788C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18018d;

    public C1788C(String processName, int i8, int i9, boolean z7) {
        AbstractC2304t.f(processName, "processName");
        this.f18015a = processName;
        this.f18016b = i8;
        this.f18017c = i9;
        this.f18018d = z7;
    }

    public final int a() {
        return this.f18017c;
    }

    public final int b() {
        return this.f18016b;
    }

    public final String c() {
        return this.f18015a;
    }

    public final boolean d() {
        return this.f18018d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1788C)) {
            return false;
        }
        C1788C c1788c = (C1788C) obj;
        return AbstractC2304t.b(this.f18015a, c1788c.f18015a) && this.f18016b == c1788c.f18016b && this.f18017c == c1788c.f18017c && this.f18018d == c1788c.f18018d;
    }

    public int hashCode() {
        return (((((this.f18015a.hashCode() * 31) + Integer.hashCode(this.f18016b)) * 31) + Integer.hashCode(this.f18017c)) * 31) + Boolean.hashCode(this.f18018d);
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f18015a + ", pid=" + this.f18016b + ", importance=" + this.f18017c + ", isDefaultProcess=" + this.f18018d + ')';
    }
}
