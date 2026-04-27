package y;

import A2.f;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: y.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2966c {

    /* JADX INFO: renamed from: y.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f24234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f24235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C2967d f24236c = C2967d.N();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f24237d;

        public void a() {
            this.f24234a = null;
            this.f24235b = null;
            this.f24236c.J(null);
        }

        public boolean b(Object obj) {
            this.f24237d = true;
            d dVar = this.f24235b;
            boolean z7 = dVar != null && dVar.d(obj);
            if (z7) {
                d();
            }
            return z7;
        }

        public boolean c() {
            this.f24237d = true;
            d dVar = this.f24235b;
            boolean z7 = dVar != null && dVar.c(true);
            if (z7) {
                d();
            }
            return z7;
        }

        public final void d() {
            this.f24234a = null;
            this.f24235b = null;
            this.f24236c = null;
        }

        public boolean e(Throwable th) {
            this.f24237d = true;
            d dVar = this.f24235b;
            boolean z7 = dVar != null && dVar.e(th);
            if (z7) {
                d();
            }
            return z7;
        }

        public void finalize() {
            C2967d c2967d;
            d dVar = this.f24235b;
            if (dVar != null && !dVar.isDone()) {
                dVar.e(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f24234a));
            }
            if (this.f24237d || (c2967d = this.f24236c) == null) {
                return;
            }
            c2967d.J(null);
        }
    }

    /* JADX INFO: renamed from: y.c$b */
    public static final class b extends Throwable {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: renamed from: y.c$c, reason: collision with other inner class name */
    public interface InterfaceC0432c {
        Object a(a aVar);
    }

    /* JADX INFO: renamed from: y.c$d */
    public static final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f24238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2964a f24239b = new a();

        /* JADX INFO: renamed from: y.c$d$a */
        public class a extends AbstractC2964a {
            public a() {
            }

            @Override // y.AbstractC2964a
            public String B() {
                a aVar = (a) d.this.f24238a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f24234a + "]";
            }
        }

        public d(a aVar) {
            this.f24238a = new WeakReference(aVar);
        }

        @Override // A2.f
        public void a(Runnable runnable, Executor executor) {
            this.f24239b.a(runnable, executor);
        }

        public boolean c(boolean z7) {
            return this.f24239b.cancel(z7);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z7) {
            a aVar = (a) this.f24238a.get();
            boolean zCancel = this.f24239b.cancel(z7);
            if (zCancel && aVar != null) {
                aVar.a();
            }
            return zCancel;
        }

        public boolean d(Object obj) {
            return this.f24239b.J(obj);
        }

        public boolean e(Throwable th) {
            return this.f24239b.K(th);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.f24239b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f24239b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f24239b.isDone();
        }

        public String toString() {
            return this.f24239b.toString();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j8, TimeUnit timeUnit) {
            return this.f24239b.get(j8, timeUnit);
        }
    }

    public static f a(InterfaceC0432c interfaceC0432c) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.f24235b = dVar;
        aVar.f24234a = interfaceC0432c.getClass();
        try {
            Object objA = interfaceC0432c.a(aVar);
            if (objA != null) {
                aVar.f24234a = objA;
            }
        } catch (Exception e8) {
            dVar.e(e8);
        }
        return dVar;
    }
}
