package o0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13909d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f13911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13912c;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final e a(f owner) {
            r.f(owner, "owner");
            return new e(owner, null);
        }

        public a() {
        }
    }

    public /* synthetic */ e(f fVar, AbstractC1585j abstractC1585j) {
        this(fVar);
    }

    public static final e a(f fVar) {
        return f13909d.a(fVar);
    }

    public final d b() {
        return this.f13911b;
    }

    public final void c() {
        AbstractC0846i lifecycle = this.f13910a.getLifecycle();
        if (lifecycle.b() != AbstractC0846i.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new b(this.f13910a));
        this.f13911b.e(lifecycle);
        this.f13912c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f13912c) {
            c();
        }
        AbstractC0846i lifecycle = this.f13910a.getLifecycle();
        if (!lifecycle.b().c(AbstractC0846i.b.STARTED)) {
            this.f13911b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        r.f(outBundle, "outBundle");
        this.f13911b.g(outBundle);
    }

    public e(f fVar) {
        this.f13910a = fVar;
        this.f13911b = new d();
    }
}
