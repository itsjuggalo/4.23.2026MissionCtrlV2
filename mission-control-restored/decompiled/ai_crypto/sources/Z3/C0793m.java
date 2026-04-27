package Z3;

/* JADX INFO: renamed from: Z3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0793m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5950a;

    public C0793m(String str) {
        this.f5950a = str;
    }

    public final String a() {
        return this.f5950a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0793m) && kotlin.jvm.internal.r.b(this.f5950a, ((C0793m) obj).f5950a);
    }

    public int hashCode() {
        String str = this.f5950a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FirebaseSessionsData(sessionId=" + this.f5950a + ')';
    }
}
