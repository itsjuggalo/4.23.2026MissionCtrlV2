package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f10327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f10328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f10329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f10333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f10334h;

    public n(Executor executor, Function0 reportFullyDrawn) {
        AbstractC2304t.f(executor, "executor");
        AbstractC2304t.f(reportFullyDrawn, "reportFullyDrawn");
        this.f10327a = executor;
        this.f10328b = reportFullyDrawn;
        this.f10329c = new Object();
        this.f10333g = new ArrayList();
        this.f10334h = new Runnable() { // from class: androidx.activity.m
            @Override // java.lang.Runnable
            public final void run() {
                n.d(this.f10326a);
            }
        };
    }

    public static final void d(n this$0) {
        AbstractC2304t.f(this$0, "this$0");
        synchronized (this$0.f10329c) {
            try {
                this$0.f10331e = false;
                if (this$0.f10330d == 0 && !this$0.f10332f) {
                    this$0.f10328b.invoke();
                    this$0.b();
                }
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f10329c) {
            try {
                this.f10332f = true;
                Iterator it = this.f10333g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f10333g.clear();
                C2470H c2470h = C2470H.f21956a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z7;
        synchronized (this.f10329c) {
            z7 = this.f10332f;
        }
        return z7;
    }
}
