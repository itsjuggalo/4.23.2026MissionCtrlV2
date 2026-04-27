package y0;

import W2.E;
import W2.q;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.r;
import t3.AbstractC1822k;
import t3.AbstractC1831o0;
import t3.InterfaceC1846w0;
import t3.L;
import t3.M;
import w3.d;
import w3.e;

/* JADX INFO: renamed from: y0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1936a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f15844a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f15845b = new LinkedHashMap();

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    public static final class C0258a extends l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f15847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ G.a f15848c;

        /* JADX INFO: renamed from: y0.a$a$a, reason: collision with other inner class name */
        public static final class C0259a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ G.a f15849a;

            public C0259a(G.a aVar) {
                this.f15849a = aVar;
            }

            @Override // w3.e
            public final Object emit(Object obj, Z2.e eVar) {
                this.f15849a.accept(obj);
                return E.f5463a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0258a(d dVar, G.a aVar, Z2.e eVar) {
            super(2, eVar);
            this.f15847b = dVar;
            this.f15848c = aVar;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new C0258a(this.f15847b, this.f15848c, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f15846a;
            if (i4 == 0) {
                q.b(obj);
                d dVar = this.f15847b;
                C0259a c0259a = new C0259a(this.f15848c);
                this.f15846a = 1;
                if (dVar.collect(c0259a, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((C0258a) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public final void a(Executor executor, G.a consumer, d flow) {
        r.f(executor, "executor");
        r.f(consumer, "consumer");
        r.f(flow, "flow");
        ReentrantLock reentrantLock = this.f15844a;
        reentrantLock.lock();
        try {
            if (this.f15845b.get(consumer) == null) {
                this.f15845b.put(consumer, AbstractC1822k.d(M.a(AbstractC1831o0.a(executor)), null, null, new C0258a(flow, consumer, null), 3, null));
            }
            E e4 = E.f5463a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(G.a consumer) {
        r.f(consumer, "consumer");
        ReentrantLock reentrantLock = this.f15844a;
        reentrantLock.lock();
        try {
            InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) this.f15845b.get(consumer);
            if (interfaceC1846w0 != null) {
                InterfaceC1846w0.a.b(interfaceC1846w0, null, 1, null);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
