package L2;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f1047b = new f(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1048a;

    public f(String str) {
        this.f1048a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            String str = ((f) obj).f1048a;
            String str2 = this.f1048a;
            if (str2 != null) {
                return str2.equals(str);
            }
            if (str == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f1048a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return AbstractC1024h.d(new StringBuilder("User(uid:"), this.f1048a, ")");
    }
}
