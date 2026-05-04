package com.google.firebase.firestore;

import d9.h1;
import d9.x0;
import d9.y0;
import java.util.Objects;
import n9.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x0 f6179e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f6176b == gVar.f6176b && this.f6177c == gVar.f6177c && this.f6178d == gVar.f6178d && this.f6175a.equals(gVar.f6175a)) {
            return Objects.equals(this.f6179e, gVar.f6179e);
        }
        return false;
    }

    public x0 f() {
        return this.f6179e;
    }

    public long g() {
        x0 x0Var = this.f6179e;
        if (x0Var == null) {
            return this.f6178d;
        }
        if (x0Var instanceof h1) {
            return ((h1) x0Var).a();
        }
        ((y0) x0Var).a();
        return -1L;
    }

    public String h() {
        return this.f6175a;
    }

    public int hashCode() {
        int iHashCode = ((((this.f6175a.hashCode() * 31) + (this.f6176b ? 1 : 0)) * 31) + (this.f6177c ? 1 : 0)) * 31;
        long j10 = this.f6178d;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        x0 x0Var = this.f6179e;
        return i10 + (x0Var != null ? x0Var.hashCode() : 0);
    }

    public boolean i() {
        x0 x0Var = this.f6179e;
        return x0Var != null ? x0Var instanceof h1 : this.f6177c;
    }

    public boolean j() {
        return this.f6176b;
    }

    public String toString() {
        if (("FirebaseFirestoreSettings{host=" + this.f6175a + ", sslEnabled=" + this.f6176b + ", persistenceEnabled=" + this.f6177c + ", cacheSizeBytes=" + this.f6178d + ", cacheSettings=" + this.f6179e) == null) {
            return "null";
        }
        return this.f6179e.toString() + "}";
    }

    public g(b bVar) {
        this.f6175a = bVar.f6180a;
        this.f6176b = bVar.f6181b;
        this.f6177c = bVar.f6182c;
        this.f6178d = bVar.f6183d;
        this.f6179e = bVar.f6184e;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f6183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public x0 f6184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6185f;

        public b() {
            this.f6185f = false;
            this.f6180a = "firestore.googleapis.com";
            this.f6181b = true;
            this.f6182c = true;
            this.f6183d = 104857600L;
        }

        public g f() {
            if (this.f6181b || !this.f6180a.equals("firestore.googleapis.com")) {
                return new g(this);
            }
            throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
        }

        public b g(String str) {
            this.f6180a = (String) x.c(str, "Provided host must not be null.");
            return this;
        }

        public b h(x0 x0Var) {
            if (this.f6185f) {
                throw new IllegalStateException("Deprecated setPersistenceEnabled() or setCacheSizeBytes() is already used, remove those first.");
            }
            if (!(x0Var instanceof y0) && !(x0Var instanceof h1)) {
                throw new IllegalArgumentException("Only MemoryCacheSettings and PersistentCacheSettings are accepted");
            }
            this.f6184e = x0Var;
            return this;
        }

        public b i(boolean z10) {
            this.f6181b = z10;
            return this;
        }

        public b(g gVar) {
            this.f6185f = false;
            x.c(gVar, "Provided settings must not be null.");
            this.f6180a = gVar.f6175a;
            this.f6181b = gVar.f6176b;
            this.f6182c = gVar.f6177c;
            long j10 = gVar.f6178d;
            this.f6183d = j10;
            if (!this.f6182c || j10 != 104857600) {
                this.f6185f = true;
            }
            if (!this.f6185f) {
                this.f6184e = gVar.f6179e;
            } else {
                n9.b.d(gVar.f6179e == null, "Given settings object mixes both cache config APIs, which is impossible.", new Object[0]);
            }
        }
    }
}
