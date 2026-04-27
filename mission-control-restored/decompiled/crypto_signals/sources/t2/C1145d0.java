package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1145d0 extends G0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10090a;

    public C1145d0(String str) {
        this.f10090a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G0)) {
            return false;
        }
        return this.f10090a.equals(((C1145d0) ((G0) obj)).f10090a);
    }

    public final int hashCode() {
        return this.f10090a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return AbstractC1024h.d(new StringBuilder("Log{content="), this.f10090a, "}");
    }
}
