package v;

import M2.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: v.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2760c {

    /* JADX INFO: renamed from: v.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f24733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f24734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C2761d f24735c = C2761d.w();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24736d;

        public void a() {
            this.f24733a = null;
            this.f24734b = null;
            this.f24735c.s(null);
        }

        public boolean b(Object obj) {
            this.f24736d = true;
            d dVar = this.f24734b;
            boolean z7 = dVar != null && dVar.c(obj);
            if (z7) {
                d();
            }
            return z7;
        }

        public boolean c() {
            this.f24736d = true;
            d dVar = this.f24734b;
            boolean z7 = dVar != null && dVar.b(true);
            if (z7) {
                d();
            }
            return z7;
        }

        public final void d() {
            this.f24733a = null;
            this.f24734b = null;
            this.f24735c = null;
        }

        public boolean e(Throwable th) {
            this.f24736d = true;
            d dVar = this.f24734b;
            boolean z7 = dVar != null && dVar.d(th);
            if (z7) {
                d();
            }
            return z7;
        }

        public void finalize() {
            C2761d c2761d;
            d dVar = this.f24734b;
            if (dVar != null && !dVar.isDone()) {
                dVar.d(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f24733a));
            }
            if (this.f24736d || (c2761d = this.f24735c) == null) {
                return;
            }
            c2761d.s(null);
        }
    }

    /* JADX INFO: renamed from: v.c$b */
    public static final class b extends Throwable {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: renamed from: v.c$c, reason: collision with other inner class name */
    public interface InterfaceC0385c {
        Object a(a aVar);
    }

    /* JADX INFO: renamed from: v.c$d */
    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f24737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2758a f24738b = new a();

        /* JADX INFO: renamed from: v.c$d$a */
        public class a extends AbstractC2758a {
            public a() {
            }

            @Override // v.AbstractC2758a
            public String p() {
                a aVar = (a) d.this.f24737a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f24733a + "]";
            }
        }

        public d(a aVar) {
            this.f24737a = new WeakReference(aVar);
        }

        @Override // M2.e
        public void a(Runnable runnable, Executor executor) {
            this.f24738b.a(runnable, executor);
        }

        public boolean b(boolean z7) {
            return this.f24738b.cancel(z7);
        }

        public boolean c(Object obj) {
            return this.f24738b.s(obj);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z7) {
            a aVar = (a) this.f24737a.get();
            boolean zCancel = this.f24738b.cancel(z7);
            if (zCancel && aVar != null) {
                aVar.a();
            }
            return zCancel;
        }

        public boolean d(Throwable th) {
            return this.f24738b.t(th);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.f24738b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f24738b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f24738b.isDone();
        }

        public String toString() {
            return this.f24738b.toString();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j7, TimeUnit timeUnit) {
            return this.f24738b.get(j7, timeUnit);
        }
    }

    public static e a(InterfaceC0385c interfaceC0385c) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.f24734b = dVar;
        aVar.f24733a = interfaceC0385c.getClass();
        try {
            Object objA = interfaceC0385c.a(aVar);
            if (objA != null) {
                aVar.f24733a = objA;
            }
        } catch (Exception e7) {
            dVar.d(e7);
        }
        return dVar;
    }
}
