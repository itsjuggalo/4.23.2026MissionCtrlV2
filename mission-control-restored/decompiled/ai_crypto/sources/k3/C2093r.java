package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2093r extends AbstractC2074F.e.d.a.b.AbstractC0279e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f17930c;

    /* JADX INFO: renamed from: k3.r$b */
    public static final class b extends AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f17933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f17934d;

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a
        public AbstractC2074F.e.d.a.b.AbstractC0279e a() {
            String str;
            List list;
            if (this.f17934d == 1 && (str = this.f17931a) != null && (list = this.f17933c) != null) {
                return new C2093r(str, this.f17932b, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17931a == null) {
                sb.append(" name");
            }
            if ((1 & this.f17934d) == 0) {
                sb.append(" importance");
            }
            if (this.f17933c == null) {
                sb.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f17933c = list;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a c(int i7) {
            this.f17932b = i7;
            this.f17934d = (byte) (this.f17934d | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0280a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f17931a = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e
    public List b() {
        return this.f17930c;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e
    public int c() {
        return this.f17929b;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e
    public String d() {
        return this.f17928a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a.b.AbstractC0279e)) {
            return false;
        }
        AbstractC2074F.e.d.a.b.AbstractC0279e abstractC0279e = (AbstractC2074F.e.d.a.b.AbstractC0279e) obj;
        return this.f17928a.equals(abstractC0279e.d()) && this.f17929b == abstractC0279e.c() && this.f17930c.equals(abstractC0279e.b());
    }

    public int hashCode() {
        return ((((this.f17928a.hashCode() ^ 1000003) * 1000003) ^ this.f17929b) * 1000003) ^ this.f17930c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f17928a + ", importance=" + this.f17929b + ", frames=" + this.f17930c + "}";
    }

    public C2093r(String str, int i7, List list) {
        this.f17928a = str;
        this.f17929b = i7;
        this.f17930c = list;
    }
}
