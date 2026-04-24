package com.google.firebase.firestore;

import A3.Y;
import A3.Z;
import A3.i0;
import K3.AbstractC0612b;
import K3.z;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Y f12157e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f12154b == gVar.f12154b && this.f12155c == gVar.f12155c && this.f12156d == gVar.f12156d && this.f12153a.equals(gVar.f12153a)) {
            return Objects.equals(this.f12157e, gVar.f12157e);
        }
        return false;
    }

    public Y f() {
        return this.f12157e;
    }

    public long g() {
        Y y7 = this.f12157e;
        if (y7 == null) {
            return this.f12156d;
        }
        if (y7 instanceof i0) {
            return ((i0) y7).a();
        }
        ((Z) y7).a();
        return -1L;
    }

    public String h() {
        return this.f12153a;
    }

    public int hashCode() {
        int iHashCode = ((((this.f12153a.hashCode() * 31) + (this.f12154b ? 1 : 0)) * 31) + (this.f12155c ? 1 : 0)) * 31;
        long j7 = this.f12156d;
        int i7 = (iHashCode + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        Y y7 = this.f12157e;
        return i7 + (y7 != null ? y7.hashCode() : 0);
    }

    public boolean i() {
        Y y7 = this.f12157e;
        return y7 != null ? y7 instanceof i0 : this.f12155c;
    }

    public boolean j() {
        return this.f12154b;
    }

    public String toString() {
        if (("FirebaseFirestoreSettings{host=" + this.f12153a + ", sslEnabled=" + this.f12154b + ", persistenceEnabled=" + this.f12155c + ", cacheSizeBytes=" + this.f12156d + ", cacheSettings=" + this.f12157e) == null) {
            return "null";
        }
        return this.f12157e.toString() + "}";
    }

    public g(b bVar) {
        this.f12153a = bVar.f12158a;
        this.f12154b = bVar.f12159b;
        this.f12155c = bVar.f12160c;
        this.f12156d = bVar.f12161d;
        this.f12157e = bVar.f12162e;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f12161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Y f12162e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12163f;

        public b() {
            this.f12163f = false;
            this.f12158a = "firestore.googleapis.com";
            this.f12159b = true;
            this.f12160c = true;
            this.f12161d = 104857600L;
        }

        public g f() {
            if (this.f12159b || !this.f12158a.equals("firestore.googleapis.com")) {
                return new g(this);
            }
            throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
        }

        public b g(String str) {
            this.f12158a = (String) z.c(str, "Provided host must not be null.");
            return this;
        }

        public b h(Y y7) {
            if (this.f12163f) {
                throw new IllegalStateException("Deprecated setPersistenceEnabled() or setCacheSizeBytes() is already used, remove those first.");
            }
            if (!(y7 instanceof Z) && !(y7 instanceof i0)) {
                throw new IllegalArgumentException("Only MemoryCacheSettings and PersistentCacheSettings are accepted");
            }
            this.f12162e = y7;
            return this;
        }

        public b i(boolean z7) {
            this.f12159b = z7;
            return this;
        }

        public b(g gVar) {
            this.f12163f = false;
            z.c(gVar, "Provided settings must not be null.");
            this.f12158a = gVar.f12153a;
            this.f12159b = gVar.f12154b;
            this.f12160c = gVar.f12155c;
            long j7 = gVar.f12156d;
            this.f12161d = j7;
            if (!this.f12160c || j7 != 104857600) {
                this.f12163f = true;
            }
            if (!this.f12163f) {
                this.f12162e = gVar.f12157e;
            } else {
                AbstractC0612b.d(gVar.f12157e == null, "Given settings object mixes both cache config APIs, which is impossible.", new Object[0]);
            }
        }
    }
}
