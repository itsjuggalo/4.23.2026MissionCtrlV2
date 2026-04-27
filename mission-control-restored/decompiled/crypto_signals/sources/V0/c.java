package V0;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3185a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f3185a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f3185a.equals(((c) obj).f3185a);
    }

    public final int hashCode() {
        return this.f3185a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return AbstractC1024h.d(new StringBuilder("Encoding{name=\""), this.f3185a, "\"}");
    }
}
