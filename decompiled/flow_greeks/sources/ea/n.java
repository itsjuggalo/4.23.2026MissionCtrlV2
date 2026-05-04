package ea;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8613b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8615b;

        public n a() {
            if (TextUtils.isEmpty(this.f8615b)) {
                throw new IllegalArgumentException("Text model must have a color");
            }
            return new n(this.f8614a, this.f8615b);
        }

        public b b(String str) {
            this.f8615b = str;
            return this;
        }

        public b c(String str) {
            this.f8614a = str;
            return this;
        }
    }

    public static b a() {
        return new b();
    }

    public String b() {
        return this.f8613b;
    }

    public String c() {
        return this.f8612a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (hashCode() != nVar.hashCode()) {
            return false;
        }
        String str = this.f8612a;
        return (str != null || nVar.f8612a == null) && (str == null || str.equals(nVar.f8612a)) && this.f8613b.equals(nVar.f8613b);
    }

    public int hashCode() {
        String str = this.f8612a;
        return str != null ? str.hashCode() + this.f8613b.hashCode() : this.f8613b.hashCode();
    }

    public n(String str, String str2) {
        this.f8612a = str;
        this.f8613b = str2;
    }
}
