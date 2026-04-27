package androidx.concurrent.futures;

import e2.InterfaceFutureC1233e;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f6837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f6838c = e.n();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6839d;

        public void a() {
            this.f6836a = null;
            this.f6837b = null;
            this.f6838c.set(null);
        }

        public boolean b(Object obj) {
            this.f6839d = true;
            d dVar = this.f6837b;
            boolean z4 = dVar != null && dVar.b(obj);
            if (z4) {
                d();
            }
            return z4;
        }

        public boolean c() {
            this.f6839d = true;
            d dVar = this.f6837b;
            boolean z4 = dVar != null && dVar.a(true);
            if (z4) {
                d();
            }
            return z4;
        }

        public final void d() {
            this.f6836a = null;
            this.f6837b = null;
            this.f6838c = null;
        }

        public boolean e(Throwable th) {
            this.f6839d = true;
            d dVar = this.f6837b;
            boolean z4 = dVar != null && dVar.c(th);
            if (z4) {
                d();
            }
            return z4;
        }

        public void finalize() {
            e eVar;
            d dVar = this.f6837b;
            if (dVar != null && !dVar.isDone()) {
                dVar.c(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f6836a));
            }
            if (this.f6839d || (eVar = this.f6838c) == null) {
                return;
            }
            eVar.set(null);
        }
    }

    public static final class b extends Throwable {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: renamed from: androidx.concurrent.futures.c$c, reason: collision with other inner class name */
    public interface InterfaceC0099c {
        Object a(a aVar);
    }

    public static final class d implements InterfaceFutureC1233e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f6840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.concurrent.futures.a f6841b = new a();

        public class a extends androidx.concurrent.futures.a {
            public a() {
            }

            @Override // androidx.concurrent.futures.a
            public String pendingToString() {
                a aVar = (a) d.this.f6840a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f6836a + "]";
            }
        }

        public d(a aVar) {
            this.f6840a = new WeakReference(aVar);
        }

        public boolean a(boolean z4) {
            return this.f6841b.cancel(z4);
        }

        @Override // e2.InterfaceFutureC1233e
        public void addListener(Runnable runnable, Executor executor) {
            this.f6841b.addListener(runnable, executor);
        }

        public boolean b(Object obj) {
            return this.f6841b.set(obj);
        }

        public boolean c(Throwable th) {
            return this.f6841b.setException(th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z4) {
            a aVar = (a) this.f6840a.get();
            boolean zCancel = this.f6841b.cancel(z4);
            if (zCancel && aVar != null) {
                aVar.a();
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.f6841b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f6841b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f6841b.isDone();
        }

        public String toString() {
            return this.f6841b.toString();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j4, TimeUnit timeUnit) {
            return this.f6841b.get(j4, timeUnit);
        }
    }

    public static InterfaceFutureC1233e a(InterfaceC0099c interfaceC0099c) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.f6837b = dVar;
        aVar.f6836a = interfaceC0099c.getClass();
        try {
            Object objA = interfaceC0099c.a(aVar);
            if (objA != null) {
                aVar.f6836a = objA;
                return dVar;
            }
        } catch (Exception e4) {
            dVar.c(e4);
        }
        return dVar;
    }
}
