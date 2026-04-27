package I6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends E0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f4332e = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E0 f4333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final E0 f4334d;

    public static final class a {
        public a() {
        }

        public final E0 a(E0 first, E0 second) {
            AbstractC2304t.f(first, "first");
            AbstractC2304t.f(second, "second");
            return first.f() ? second : second.f() ? first : new D(first, second, null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public D(E0 e02, E0 e03) {
        this.f4333c = e02;
        this.f4334d = e03;
    }

    public static final E0 i(E0 e02, E0 e03) {
        return f4332e.a(e02, e03);
    }

    @Override // I6.E0
    public boolean a() {
        return this.f4333c.a() || this.f4334d.a();
    }

    @Override // I6.E0
    public boolean b() {
        return this.f4333c.b() || this.f4334d.b();
    }

    @Override // I6.E0
    public S5.h d(S5.h annotations) {
        AbstractC2304t.f(annotations, "annotations");
        return this.f4334d.d(this.f4333c.d(annotations));
    }

    @Override // I6.E0
    public B0 e(S key) {
        AbstractC2304t.f(key, "key");
        B0 b0E = this.f4333c.e(key);
        return b0E == null ? this.f4334d.e(key) : b0E;
    }

    @Override // I6.E0
    public boolean f() {
        return false;
    }

    @Override // I6.E0
    public S g(S topLevelType, N0 position) {
        AbstractC2304t.f(topLevelType, "topLevelType");
        AbstractC2304t.f(position, "position");
        return this.f4334d.g(this.f4333c.g(topLevelType, position), position);
    }

    public /* synthetic */ D(E0 e02, E0 e03, AbstractC2296k abstractC2296k) {
        this(e02, e03);
    }
}
