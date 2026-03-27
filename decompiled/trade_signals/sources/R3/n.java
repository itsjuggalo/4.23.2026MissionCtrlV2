package R3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7180b;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7182b;

        public n a() {
            if (TextUtils.isEmpty(this.f7182b)) {
                throw new IllegalArgumentException("Text model must have a color");
            }
            return new n(this.f7181a, this.f7182b);
        }

        public b b(String str) {
            this.f7182b = str;
            return this;
        }

        public b c(String str) {
            this.f7181a = str;
            return this;
        }
    }

    public n(String str, String str2) {
        this.f7179a = str;
        this.f7180b = str2;
    }

    public static b a() {
        return new b();
    }

    public String b() {
        return this.f7180b;
    }

    public String c() {
        return this.f7179a;
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
        String str = this.f7179a;
        return (str != null || nVar.f7179a == null) && (str == null || str.equals(nVar.f7179a)) && this.f7180b.equals(nVar.f7180b);
    }

    public int hashCode() {
        String str = this.f7179a;
        return str != null ? str.hashCode() + this.f7180b.hashCode() : this.f7180b.hashCode();
    }
}
