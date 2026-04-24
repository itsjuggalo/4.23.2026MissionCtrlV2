package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2081f extends AbstractC2074F.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17800b;

    /* JADX INFO: renamed from: k3.f$b */
    public static final class b extends AbstractC2074F.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f17801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17802b;

        @Override // k3.AbstractC2074F.d.a
        public AbstractC2074F.d a() {
            List list = this.f17801a;
            if (list != null) {
                return new C2081f(list, this.f17802b);
            }
            throw new IllegalStateException("Missing required properties: files");
        }

        @Override // k3.AbstractC2074F.d.a
        public AbstractC2074F.d.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.f17801a = list;
            return this;
        }

        @Override // k3.AbstractC2074F.d.a
        public AbstractC2074F.d.a c(String str) {
            this.f17802b = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.d
    public List b() {
        return this.f17799a;
    }

    @Override // k3.AbstractC2074F.d
    public String c() {
        return this.f17800b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.d)) {
            return false;
        }
        AbstractC2074F.d dVar = (AbstractC2074F.d) obj;
        if (this.f17799a.equals(dVar.b())) {
            String str = this.f17800b;
            if (str == null) {
                if (dVar.c() == null) {
                    return true;
                }
            } else if (str.equals(dVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f17799a.hashCode() ^ 1000003) * 1000003;
        String str = this.f17800b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f17799a + ", orgId=" + this.f17800b + "}";
    }

    public C2081f(List list, String str) {
        this.f17799a = list;
        this.f17800b = str;
    }
}
