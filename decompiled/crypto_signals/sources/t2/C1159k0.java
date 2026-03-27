package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1159k0 extends M0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10150a;

    public C1159k0(String str) {
        this.f10150a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof M0)) {
            return false;
        }
        return this.f10150a.equals(((C1159k0) ((M0) obj)).f10150a);
    }

    public final int hashCode() {
        return this.f10150a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return AbstractC1024h.d(new StringBuilder("User{identifier="), this.f10150a, "}");
    }
}
