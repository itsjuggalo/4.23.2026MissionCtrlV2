package androidx.activity;

import cd.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f919h;

    public m(Executor executor, Function0 reportFullyDrawn) {
        kotlin.jvm.internal.t.f(executor, "executor");
        kotlin.jvm.internal.t.f(reportFullyDrawn, "reportFullyDrawn");
        this.f912a = executor;
        this.f913b = reportFullyDrawn;
        this.f914c = new Object();
        this.f918g = new ArrayList();
        this.f919h = new Runnable() { // from class: androidx.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(this.f911a);
            }
        };
    }

    public static final void d(m this$0) {
        kotlin.jvm.internal.t.f(this$0, "this$0");
        synchronized (this$0.f914c) {
            try {
                this$0.f916e = false;
                if (this$0.f915d == 0 && !this$0.f917f) {
                    this$0.f913b.invoke();
                    this$0.b();
                }
                h0 h0Var = h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f914c) {
            try {
                this.f917f = true;
                Iterator it = this.f918g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f918g.clear();
                h0 h0Var = h0.f3852a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f914c) {
            z10 = this.f917f;
        }
        return z10;
    }
}
