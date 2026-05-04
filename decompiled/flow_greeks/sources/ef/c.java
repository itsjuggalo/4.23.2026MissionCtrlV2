package ef;

import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8783c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f8784d = new c("");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c f8786b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final c a(f shortName) {
            t.f(shortName, "shortName");
            return new c(d.f8787e.a(shortName));
        }

        public a() {
        }
    }

    public c(String fqName) {
        t.f(fqName, "fqName");
        this.f8785a = new d(fqName, this);
    }

    public final String a() {
        return this.f8785a.a();
    }

    public final c b(f name) {
        t.f(name, "name");
        return new c(this.f8785a.b(name), this);
    }

    public final boolean c() {
        return this.f8785a.e();
    }

    public final c d() {
        c cVar = this.f8786b;
        if (cVar != null) {
            return cVar;
        }
        if (c()) {
            throw new IllegalStateException("root");
        }
        c cVar2 = new c(this.f8785a.g());
        this.f8786b = cVar2;
        return cVar2;
    }

    public final List e() {
        return this.f8785a.h();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && t.b(this.f8785a, ((c) obj).f8785a);
    }

    public final f f() {
        return this.f8785a.j();
    }

    public final f g() {
        return this.f8785a.k();
    }

    public final boolean h(f segment) {
        t.f(segment, "segment");
        return this.f8785a.l(segment);
    }

    public int hashCode() {
        return this.f8785a.hashCode();
    }

    public final d i() {
        return this.f8785a;
    }

    public String toString() {
        return this.f8785a.toString();
    }

    public c(d fqName) {
        t.f(fqName, "fqName");
        this.f8785a = fqName;
    }

    public c(d dVar, c cVar) {
        this.f8785a = dVar;
        this.f8786b = cVar;
    }
}
