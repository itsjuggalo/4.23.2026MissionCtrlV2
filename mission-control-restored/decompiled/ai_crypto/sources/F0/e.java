package F0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0963i;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1888d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1891c;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final e a(f owner) {
            r.f(owner, "owner");
            return new e(owner, null);
        }

        public a() {
        }
    }

    public /* synthetic */ e(f fVar, AbstractC2148j abstractC2148j) {
        this(fVar);
    }

    public static final e a(f fVar) {
        return f1888d.a(fVar);
    }

    public final d b() {
        return this.f1890b;
    }

    public final void c() {
        AbstractC0963i abstractC0963iA = this.f1889a.a();
        if (abstractC0963iA.b() != AbstractC0963i.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        abstractC0963iA.a(new b(this.f1889a));
        this.f1890b.e(abstractC0963iA);
        this.f1891c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f1891c) {
            c();
        }
        AbstractC0963i abstractC0963iA = this.f1889a.a();
        if (!abstractC0963iA.b().b(AbstractC0963i.b.STARTED)) {
            this.f1890b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + abstractC0963iA.b()).toString());
    }

    public final void e(Bundle outBundle) {
        r.f(outBundle, "outBundle");
        this.f1890b.g(outBundle);
    }

    public e(f fVar) {
        this.f1889a = fVar;
        this.f1890b = new d();
    }
}
