package A0;

import A0.c;
import android.graphics.Rect;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import x0.C1913b;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1913b f13a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f14b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b f15c;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final void a(C1913b bounds) {
            r.f(bounds, "bounds");
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

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f16b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f17c = new b("FOLD");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f18d = new b("HINGE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19a;

        public static final class a {
            public /* synthetic */ a(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b a() {
                return b.f17c;
            }

            public final b b() {
                return b.f18d;
            }

            public a() {
            }
        }

        public b(String str) {
            this.f19a = str;
        }

        public String toString() {
            return this.f19a;
        }
    }

    public d(C1913b featureBounds, b type, c.b state) {
        r.f(featureBounds, "featureBounds");
        r.f(type, "type");
        r.f(state, "state");
        this.f13a = featureBounds;
        this.f14b = type;
        this.f15c = state;
        f12d.a(featureBounds);
    }

    @Override // A0.a
    public Rect a() {
        return this.f13a.f();
    }

    @Override // A0.c
    public c.a b() {
        return (this.f13a.d() == 0 || this.f13a.a() == 0) ? c.a.f5c : c.a.f6d;
    }

    @Override // A0.c
    public c.b c() {
        return this.f15c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!r.b(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        r.d(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        d dVar = (d) obj;
        return r.b(this.f13a, dVar.f13a) && r.b(this.f14b, dVar.f14b) && r.b(c(), dVar.c());
    }

    public int hashCode() {
        return (((this.f13a.hashCode() * 31) + this.f14b.hashCode()) * 31) + c().hashCode();
    }

    public String toString() {
        return d.class.getSimpleName() + " { " + this.f13a + ", type=" + this.f14b + ", state=" + c() + " }";
    }
}
