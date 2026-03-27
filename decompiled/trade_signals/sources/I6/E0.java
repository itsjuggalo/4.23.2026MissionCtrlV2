package I6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4337a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final E0 f4338b = new a();

    public static final class a extends E0 {
        @Override // I6.E0
        public /* bridge */ /* synthetic */ B0 e(S s8) {
            return (B0) i(s8);
        }

        @Override // I6.E0
        public boolean f() {
            return true;
        }

        public Void i(S key) {
            AbstractC2304t.f(key, "key");
            return null;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class c extends E0 {
        public c() {
        }

        @Override // I6.E0
        public boolean a() {
            return false;
        }

        @Override // I6.E0
        public boolean b() {
            return false;
        }

        @Override // I6.E0
        public S5.h d(S5.h annotations) {
            AbstractC2304t.f(annotations, "annotations");
            return E0.this.d(annotations);
        }

        @Override // I6.E0
        public B0 e(S key) {
            AbstractC2304t.f(key, "key");
            return E0.this.e(key);
        }

        @Override // I6.E0
        public boolean f() {
            return E0.this.f();
        }

        @Override // I6.E0
        public S g(S topLevelType, N0 position) {
            AbstractC2304t.f(topLevelType, "topLevelType");
            AbstractC2304t.f(position, "position");
            return E0.this.g(topLevelType, position);
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public final G0 c() {
        G0 g0G = G0.g(this);
        AbstractC2304t.e(g0G, "create(...)");
        return g0G;
    }

    public S5.h d(S5.h annotations) {
        AbstractC2304t.f(annotations, "annotations");
        return annotations;
    }

    public abstract B0 e(S s8);

    public boolean f() {
        return false;
    }

    public S g(S topLevelType, N0 position) {
        AbstractC2304t.f(topLevelType, "topLevelType");
        AbstractC2304t.f(position, "position");
        return topLevelType;
    }

    public final E0 h() {
        return new c();
    }
}
