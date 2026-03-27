package R0;

import R0.c;
import android.graphics.Rect;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f4633d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O0.b f4634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f4635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b f4636c;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final void a(O0.b bounds) {
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
        public static final a f4637b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f4638c = new b("FOLD");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f4639d = new b("HINGE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4640a;

        public static final class a {
            public /* synthetic */ a(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b a() {
                return b.f4638c;
            }

            public final b b() {
                return b.f4639d;
            }

            public a() {
            }
        }

        public b(String str) {
            this.f4640a = str;
        }

        public String toString() {
            return this.f4640a;
        }
    }

    public d(O0.b featureBounds, b type, c.b state) {
        r.f(featureBounds, "featureBounds");
        r.f(type, "type");
        r.f(state, "state");
        this.f4634a = featureBounds;
        this.f4635b = type;
        this.f4636c = state;
        f4633d.a(featureBounds);
    }

    @Override // R0.a
    public Rect a() {
        return this.f4634a.f();
    }

    @Override // R0.c
    public c.a b() {
        return (this.f4634a.d() == 0 || this.f4634a.a() == 0) ? c.a.f4626c : c.a.f4627d;
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
        return r.b(this.f4634a, dVar.f4634a) && r.b(this.f4635b, dVar.f4635b) && r.b(getState(), dVar.getState());
    }

    @Override // R0.c
    public c.b getState() {
        return this.f4636c;
    }

    public int hashCode() {
        return (((this.f4634a.hashCode() * 31) + this.f4635b.hashCode()) * 31) + getState().hashCode();
    }

    public String toString() {
        return d.class.getSimpleName() + " { " + this.f4634a + ", type=" + this.f4635b + ", state=" + getState() + " }";
    }
}
