package ea;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f8567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8568b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f8569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8570b;

        public d a() {
            if (TextUtils.isEmpty(this.f8570b)) {
                throw new IllegalArgumentException("Button model must have a color");
            }
            n nVar = this.f8569a;
            if (nVar != null) {
                return new d(nVar, this.f8570b);
            }
            throw new IllegalArgumentException("Button model must have text");
        }

        public b b(String str) {
            this.f8570b = str;
            return this;
        }

        public b c(n nVar) {
            this.f8569a = nVar;
            return this;
        }
    }

    public static b a() {
        return new b();
    }

    public String b() {
        return this.f8568b;
    }

    public n c() {
        return this.f8567a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return hashCode() == dVar.hashCode() && this.f8567a.equals(dVar.f8567a) && this.f8568b.equals(dVar.f8568b);
    }

    public int hashCode() {
        return this.f8567a.hashCode() + this.f8568b.hashCode();
    }

    public d(n nVar, String str) {
        this.f8567a = nVar;
        this.f8568b = str;
    }
}
