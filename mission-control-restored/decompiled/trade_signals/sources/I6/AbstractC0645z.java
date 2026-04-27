package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: I6.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0645z extends E0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E0 f4498c;

    public AbstractC0645z(E0 substitution) {
        AbstractC2304t.f(substitution, "substitution");
        this.f4498c = substitution;
    }

    @Override // I6.E0
    public boolean a() {
        return this.f4498c.a();
    }

    @Override // I6.E0
    public S5.h d(S5.h annotations) {
        AbstractC2304t.f(annotations, "annotations");
        return this.f4498c.d(annotations);
    }

    @Override // I6.E0
    public B0 e(S key) {
        AbstractC2304t.f(key, "key");
        return this.f4498c.e(key);
    }

    @Override // I6.E0
    public boolean f() {
        return this.f4498c.f();
    }

    @Override // I6.E0
    public S g(S topLevelType, N0 position) {
        AbstractC2304t.f(topLevelType, "topLevelType");
        AbstractC2304t.f(position, "position");
        return this.f4498c.g(topLevelType, position);
    }
}
