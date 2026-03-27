package R3;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f7134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7135b;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f7136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7137b;

        public d a() {
            if (TextUtils.isEmpty(this.f7137b)) {
                throw new IllegalArgumentException("Button model must have a color");
            }
            n nVar = this.f7136a;
            if (nVar != null) {
                return new d(nVar, this.f7137b);
            }
            throw new IllegalArgumentException("Button model must have text");
        }

        public b b(String str) {
            this.f7137b = str;
            return this;
        }

        public b c(n nVar) {
            this.f7136a = nVar;
            return this;
        }
    }

    public d(n nVar, String str) {
        this.f7134a = nVar;
        this.f7135b = str;
    }

    public static b a() {
        return new b();
    }

    public String b() {
        return this.f7135b;
    }

    public n c() {
        return this.f7134a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return hashCode() == dVar.hashCode() && this.f7134a.equals(dVar.f7134a) && this.f7135b.equals(dVar.f7135b);
    }

    public int hashCode() {
        return this.f7134a.hashCode() + this.f7135b.hashCode();
    }
}
