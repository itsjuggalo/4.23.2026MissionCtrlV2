package h3;

import p3.InterfaceC2560n;

/* JADX INFO: renamed from: h3.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1858B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1875k f18391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2560n f18392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1866b f18393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18394e;

    public C1858B(long j8, C1875k c1875k, C1866b c1866b) {
        this.f18390a = j8;
        this.f18391b = c1875k;
        this.f18392c = null;
        this.f18393d = c1866b;
        this.f18394e = true;
    }

    public C1866b a() {
        C1866b c1866b = this.f18393d;
        if (c1866b != null) {
            return c1866b;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public InterfaceC2560n b() {
        InterfaceC2560n interfaceC2560n = this.f18392c;
        if (interfaceC2560n != null) {
            return interfaceC2560n;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public C1875k c() {
        return this.f18391b;
    }

    public long d() {
        return this.f18390a;
    }

    public boolean e() {
        return this.f18392c != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1858B.class != obj.getClass()) {
            return false;
        }
        C1858B c1858b = (C1858B) obj;
        if (this.f18390a != c1858b.f18390a || !this.f18391b.equals(c1858b.f18391b) || this.f18394e != c1858b.f18394e) {
            return false;
        }
        InterfaceC2560n interfaceC2560n = this.f18392c;
        if (interfaceC2560n == null ? c1858b.f18392c != null : !interfaceC2560n.equals(c1858b.f18392c)) {
            return false;
        }
        C1866b c1866b = this.f18393d;
        C1866b c1866b2 = c1858b.f18393d;
        return c1866b == null ? c1866b2 == null : c1866b.equals(c1866b2);
    }

    public boolean f() {
        return this.f18394e;
    }

    public int hashCode() {
        int iHashCode = ((((Long.valueOf(this.f18390a).hashCode() * 31) + Boolean.valueOf(this.f18394e).hashCode()) * 31) + this.f18391b.hashCode()) * 31;
        InterfaceC2560n interfaceC2560n = this.f18392c;
        int iHashCode2 = (iHashCode + (interfaceC2560n != null ? interfaceC2560n.hashCode() : 0)) * 31;
        C1866b c1866b = this.f18393d;
        return iHashCode2 + (c1866b != null ? c1866b.hashCode() : 0);
    }

    public String toString() {
        return "UserWriteRecord{id=" + this.f18390a + " path=" + this.f18391b + " visible=" + this.f18394e + " overwrite=" + this.f18392c + " merge=" + this.f18393d + "}";
    }

    public C1858B(long j8, C1875k c1875k, InterfaceC2560n interfaceC2560n, boolean z7) {
        this.f18390a = j8;
        this.f18391b = c1875k;
        this.f18392c = interfaceC2560n;
        this.f18393d = null;
        this.f18394e = z7;
    }
}
