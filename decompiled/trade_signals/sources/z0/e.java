package z0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC1157i;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f24631d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f24632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f24633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24634c;

    public static final class a {
        public a() {
        }

        public final e a(f owner) {
            AbstractC2304t.f(owner, "owner");
            return new e(owner, null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public e(f fVar) {
        this.f24632a = fVar;
        this.f24633b = new d();
    }

    public static final e a(f fVar) {
        return f24631d.a(fVar);
    }

    public final d b() {
        return this.f24633b;
    }

    public final void c() {
        AbstractC1157i lifecycle = this.f24632a.getLifecycle();
        if (lifecycle.b() != AbstractC1157i.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new C2999b(this.f24632a));
        this.f24633b.e(lifecycle);
        this.f24634c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f24634c) {
            c();
        }
        AbstractC1157i lifecycle = this.f24632a.getLifecycle();
        if (!lifecycle.b().b(AbstractC1157i.b.STARTED)) {
            this.f24633b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        AbstractC2304t.f(outBundle, "outBundle");
        this.f24633b.g(outBundle);
    }

    public /* synthetic */ e(f fVar, AbstractC2296k abstractC2296k) {
        this(fVar);
    }
}
