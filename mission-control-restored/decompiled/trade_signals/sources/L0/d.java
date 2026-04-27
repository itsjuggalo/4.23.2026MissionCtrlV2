package L0;

import L0.c;
import android.graphics.Rect;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f4957d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I0.b f4958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f4959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b f4960c;

    public static final class a {
        public a() {
        }

        public final void a(I0.b bounds) {
            AbstractC2304t.f(bounds, "bounds");
            if (bounds.d() == 0 && bounds.a() == 0) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (bounds.b() != 0 && bounds.c() != 0) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4961b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4962c = new b("FOLD");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f4963d = new b("HINGE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4964a;

        public static final class a {
            public a() {
            }

            public final b a() {
                return b.f4962c;
            }

            public final b b() {
                return b.f4963d;
            }

            public /* synthetic */ a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        public b(String str) {
            this.f4964a = str;
        }

        public String toString() {
            return this.f4964a;
        }
    }

    public d(I0.b featureBounds, b type, c.b state) {
        AbstractC2304t.f(featureBounds, "featureBounds");
        AbstractC2304t.f(type, "type");
        AbstractC2304t.f(state, "state");
        this.f4958a = featureBounds;
        this.f4959b = type;
        this.f4960c = state;
        f4957d.a(featureBounds);
    }

    @Override // L0.c
    public c.a a() {
        return (this.f4958a.d() == 0 || this.f4958a.a() == 0) ? c.a.f4950c : c.a.f4951d;
    }

    @Override // L0.c
    public c.b b() {
        return this.f4960c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC2304t.b(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        d dVar = (d) obj;
        return AbstractC2304t.b(this.f4958a, dVar.f4958a) && AbstractC2304t.b(this.f4959b, dVar.f4959b) && AbstractC2304t.b(b(), dVar.b());
    }

    @Override // L0.a
    public Rect getBounds() {
        return this.f4958a.f();
    }

    public int hashCode() {
        return (((this.f4958a.hashCode() * 31) + this.f4959b.hashCode()) * 31) + b().hashCode();
    }

    public String toString() {
        return d.class.getSimpleName() + " { " + this.f4958a + ", type=" + this.f4959b + ", state=" + b() + " }";
    }
}
