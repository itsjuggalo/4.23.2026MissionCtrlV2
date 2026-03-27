package V2;

import V2.F;
import java.util.List;

/* JADX INFO: renamed from: V2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0973f extends F.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8721b;

    /* JADX INFO: renamed from: V2.f$b */
    public static final class b extends F.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f8722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8723b;

        @Override // V2.F.d.a
        public F.d a() {
            List list = this.f8722a;
            if (list != null) {
                return new C0973f(list, this.f8723b);
            }
            throw new IllegalStateException("Missing required properties: files");
        }

        @Override // V2.F.d.a
        public F.d.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.f8722a = list;
            return this;
        }

        @Override // V2.F.d.a
        public F.d.a c(String str) {
            this.f8723b = str;
            return this;
        }
    }

    public C0973f(List list, String str) {
        this.f8720a = list;
        this.f8721b = str;
    }

    @Override // V2.F.d
    public List b() {
        return this.f8720a;
    }

    @Override // V2.F.d
    public String c() {
        return this.f8721b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.d)) {
            return false;
        }
        F.d dVar = (F.d) obj;
        if (this.f8720a.equals(dVar.b())) {
            String str = this.f8721b;
            String strC = dVar.c();
            if (str == null) {
                if (strC == null) {
                    return true;
                }
            } else if (str.equals(strC)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f8720a.hashCode() ^ 1000003) * 1000003;
        String str = this.f8721b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f8720a + ", orgId=" + this.f8721b + "}";
    }
}
