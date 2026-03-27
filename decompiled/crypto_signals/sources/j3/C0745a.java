package j3;

import kotlin.jvm.internal.j;
import q2.C0931j;

/* JADX INFO: renamed from: j3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0745a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j5.d f7745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0931j f7746b = null;

    public C0745a(j5.d dVar) {
        this.f7745a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0745a)) {
            return false;
        }
        C0745a c0745a = (C0745a) obj;
        return this.f7745a.equals(c0745a.f7745a) && j.a(this.f7746b, c0745a.f7746b);
    }

    public final int hashCode() {
        int iHashCode = this.f7745a.hashCode() * 31;
        C0931j c0931j = this.f7746b;
        return iHashCode + (c0931j == null ? 0 : c0931j.hashCode());
    }

    public final String toString() {
        return "Dependency(mutex=" + this.f7745a + ", subscriber=" + this.f7746b + ')';
    }
}
