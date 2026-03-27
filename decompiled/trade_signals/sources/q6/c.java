package q6;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f22659c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f22660d = new c("");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f22661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c f22662b;

    public static final class a {
        public a() {
        }

        public final c a(f shortName) {
            AbstractC2304t.f(shortName, "shortName");
            return new c(d.f22663e.a(shortName));
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public c(String fqName) {
        AbstractC2304t.f(fqName, "fqName");
        this.f22661a = new d(fqName, this);
    }

    public final String a() {
        return this.f22661a.a();
    }

    public final c b(f name) {
        AbstractC2304t.f(name, "name");
        return new c(this.f22661a.b(name), this);
    }

    public final boolean c() {
        return this.f22661a.e();
    }

    public final c d() {
        c cVar = this.f22662b;
        if (cVar != null) {
            return cVar;
        }
        if (!(!c())) {
            throw new IllegalStateException("root".toString());
        }
        c cVar2 = new c(this.f22661a.g());
        this.f22662b = cVar2;
        return cVar2;
    }

    public final List e() {
        return this.f22661a.h();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && AbstractC2304t.b(this.f22661a, ((c) obj).f22661a);
    }

    public final f f() {
        return this.f22661a.j();
    }

    public final f g() {
        return this.f22661a.k();
    }

    public final boolean h(f segment) {
        AbstractC2304t.f(segment, "segment");
        return this.f22661a.l(segment);
    }

    public int hashCode() {
        return this.f22661a.hashCode();
    }

    public final d i() {
        return this.f22661a;
    }

    public String toString() {
        return this.f22661a.toString();
    }

    public c(d fqName) {
        AbstractC2304t.f(fqName, "fqName");
        this.f22661a = fqName;
    }

    public c(d dVar, c cVar) {
        this.f22661a = dVar;
        this.f22662b = cVar;
    }
}
