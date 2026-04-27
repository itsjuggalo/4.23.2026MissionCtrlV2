package f1;

/* JADX INFO: renamed from: f1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0586b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Y0.j f6404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Y0.i f6405c;

    public C0586b(long j4, Y0.j jVar, Y0.i iVar) {
        this.f6403a = j4;
        this.f6404b = jVar;
        this.f6405c = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0586b) {
            C0586b c0586b = (C0586b) obj;
            if (this.f6403a == c0586b.f6403a && this.f6404b.equals(c0586b.f6404b) && this.f6405c.equals(c0586b.f6405c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f6403a;
        return ((((((int) ((j4 >>> 32) ^ j4)) ^ 1000003) * 1000003) ^ this.f6404b.hashCode()) * 1000003) ^ this.f6405c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f6403a + ", transportContext=" + this.f6404b + ", event=" + this.f6405c + "}";
    }
}
