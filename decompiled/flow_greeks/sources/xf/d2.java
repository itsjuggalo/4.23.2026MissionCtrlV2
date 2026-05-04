package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f24948a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d2 f24949b = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends d2 {
        @Override // xf.d2
        public /* bridge */ /* synthetic */ a2 e(r0 r0Var) {
            return (a2) i(r0Var);
        }

        @Override // xf.d2
        public boolean f() {
            return true;
        }

        public Void i(r0 key) {
            kotlin.jvm.internal.t.f(key, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends d2 {
        public c() {
        }

        @Override // xf.d2
        public boolean a() {
            return false;
        }

        @Override // xf.d2
        public boolean b() {
            return false;
        }

        @Override // xf.d2
        public ge.h d(ge.h annotations) {
            kotlin.jvm.internal.t.f(annotations, "annotations");
            return d2.this.d(annotations);
        }

        @Override // xf.d2
        public a2 e(r0 key) {
            kotlin.jvm.internal.t.f(key, "key");
            return d2.this.e(key);
        }

        @Override // xf.d2
        public boolean f() {
            return d2.this.f();
        }

        @Override // xf.d2
        public r0 g(r0 topLevelType, m2 position) {
            kotlin.jvm.internal.t.f(topLevelType, "topLevelType");
            kotlin.jvm.internal.t.f(position, "position");
            return d2.this.g(topLevelType, position);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public final f2 c() {
        f2 f2VarG = f2.g(this);
        kotlin.jvm.internal.t.e(f2VarG, "create(...)");
        return f2VarG;
    }

    public ge.h d(ge.h annotations) {
        kotlin.jvm.internal.t.f(annotations, "annotations");
        return annotations;
    }

    public abstract a2 e(r0 r0Var);

    public boolean f() {
        return false;
    }

    public r0 g(r0 topLevelType, m2 position) {
        kotlin.jvm.internal.t.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.t.f(position, "position");
        return topLevelType;
    }

    public final d2 h() {
        return new c();
    }
}
