package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends f0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24478b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f24479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24480b;

        @Override // x7.f0.d.a
        public f0.d a() {
            List list = this.f24479a;
            if (list != null) {
                return new f(list, this.f24480b);
            }
            throw new IllegalStateException("Missing required properties: files");
        }

        @Override // x7.f0.d.a
        public f0.d.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.f24479a = list;
            return this;
        }

        @Override // x7.f0.d.a
        public f0.d.a c(String str) {
            this.f24480b = str;
            return this;
        }
    }

    @Override // x7.f0.d
    public List b() {
        return this.f24477a;
    }

    @Override // x7.f0.d
    public String c() {
        return this.f24478b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.d) {
            f0.d dVar = (f0.d) obj;
            if (this.f24477a.equals(dVar.b()) && ((str = this.f24478b) != null ? str.equals(dVar.c()) : dVar.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f24477a.hashCode() ^ 1000003) * 1000003;
        String str = this.f24478b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f24477a + ", orgId=" + this.f24478b + "}";
    }

    public f(List list, String str) {
        this.f24477a = list;
        this.f24478b = str;
    }
}
