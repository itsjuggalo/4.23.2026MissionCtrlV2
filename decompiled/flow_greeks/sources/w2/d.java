package w2;

import android.graphics.Rect;
import w2.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f23626d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t2.b f23627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f23628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b f23629c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final void a(t2.b bounds) {
            kotlin.jvm.internal.t.f(bounds, "bounds");
            if (bounds.d() == 0 && bounds.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero");
            }
            if (bounds.b() != 0 && bounds.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
            }
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f23630b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23631c = new b("FOLD");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f23632d = new b("HINGE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23633a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public final b a() {
                return b.f23631c;
            }

            public final b b() {
                return b.f23632d;
            }

            public a() {
            }
        }

        public b(String str) {
            this.f23633a = str;
        }

        public String toString() {
            return this.f23633a;
        }
    }

    public d(t2.b featureBounds, b type, c.b state) {
        kotlin.jvm.internal.t.f(featureBounds, "featureBounds");
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(state, "state");
        this.f23627a = featureBounds;
        this.f23628b = type;
        this.f23629c = state;
        f23626d.a(featureBounds);
    }

    @Override // w2.c
    public c.a a() {
        return (this.f23627a.d() == 0 || this.f23627a.a() == 0) ? c.a.f23619c : c.a.f23620d;
    }

    @Override // w2.c
    public c.b b() {
        return this.f23629c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.t.b(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        d dVar = (d) obj;
        return kotlin.jvm.internal.t.b(this.f23627a, dVar.f23627a) && kotlin.jvm.internal.t.b(this.f23628b, dVar.f23628b) && kotlin.jvm.internal.t.b(b(), dVar.b());
    }

    @Override // w2.a
    public Rect getBounds() {
        return this.f23627a.f();
    }

    public int hashCode() {
        return (((this.f23627a.hashCode() * 31) + this.f23628b.hashCode()) * 31) + b().hashCode();
    }

    public String toString() {
        return d.class.getSimpleName() + " { " + this.f23627a + ", type=" + this.f23628b + ", state=" + b() + " }";
    }
}
