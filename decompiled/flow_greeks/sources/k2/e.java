package k2;

import android.os.Bundle;
import androidx.lifecycle.i;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f14486d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f14488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14489c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final e a(f owner) {
            t.f(owner, "owner");
            return new e(owner, null);
        }

        public a() {
        }
    }

    public /* synthetic */ e(f fVar, k kVar) {
        this(fVar);
    }

    public static final e a(f fVar) {
        return f14486d.a(fVar);
    }

    public final d b() {
        return this.f14488b;
    }

    public final void c() {
        i lifecycle = this.f14487a.getLifecycle();
        if (lifecycle.b() != i.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new b(this.f14487a));
        this.f14488b.e(lifecycle);
        this.f14489c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f14489c) {
            c();
        }
        i lifecycle = this.f14487a.getLifecycle();
        if (!lifecycle.b().b(i.b.STARTED)) {
            this.f14488b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle outBundle) {
        t.f(outBundle, "outBundle");
        this.f14488b.g(outBundle);
    }

    public e(f fVar) {
        this.f14487a = fVar;
        this.f14488b = new d();
    }
}
