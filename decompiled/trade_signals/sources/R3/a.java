package R3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f7114b;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f7116b;

        public a a() {
            return new a(this.f7115a, this.f7116b);
        }

        public b b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f7115a = str;
            }
            return this;
        }

        public b c(d dVar) {
            this.f7116b = dVar;
            return this;
        }
    }

    public a(String str, d dVar) {
        this.f7113a = str;
        this.f7114b = dVar;
    }

    public static b a() {
        return new b();
    }

    public String b() {
        return this.f7113a;
    }

    public d c() {
        return this.f7114b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (hashCode() != aVar.hashCode()) {
            return false;
        }
        String str = this.f7113a;
        if ((str == null && aVar.f7113a != null) || (str != null && !str.equals(aVar.f7113a))) {
            return false;
        }
        d dVar = this.f7114b;
        return (dVar == null && aVar.f7114b == null) || (dVar != null && dVar.equals(aVar.f7114b));
    }

    public int hashCode() {
        String str = this.f7113a;
        int iHashCode = str != null ? str.hashCode() : 0;
        d dVar = this.f7114b;
        return iHashCode + (dVar != null ? dVar.hashCode() : 0);
    }
}
