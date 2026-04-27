package q4;

/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K f9321b;

    public M(String str, K k6) {
        this.f9320a = str;
        this.f9321b = k6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M)) {
            return false;
        }
        M m5 = (M) obj;
        return kotlin.jvm.internal.j.a(this.f9320a, m5.f9320a) && this.f9321b == m5.f9321b;
    }

    public final int hashCode() {
        String str = this.f9320a;
        return this.f9321b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "StringListResult(jsonEncodedValue=" + this.f9320a + ", type=" + this.f9321b + ")";
    }
}
