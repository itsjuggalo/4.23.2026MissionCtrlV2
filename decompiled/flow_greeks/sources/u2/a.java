package u2;

import cd.h0;
import cd.s;
import hd.c;
import id.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;
import ng.k;
import ng.n0;
import ng.o0;
import ng.r1;
import ng.y1;
import pd.o;
import qg.d;
import qg.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f22152a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f22153b = new LinkedHashMap();

    /* JADX INFO: renamed from: u2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0379a extends m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f22155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s0.a f22156c;

        /* JADX INFO: renamed from: u2.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0380a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s0.a f22157a;

            public C0380a(s0.a aVar) {
                this.f22157a = aVar;
            }

            @Override // qg.e
            public final Object emit(Object obj, gd.e eVar) {
                this.f22157a.accept(obj);
                return h0.f3852a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0379a(d dVar, s0.a aVar, gd.e eVar) {
            super(2, eVar);
            this.f22155b = dVar;
            this.f22156c = aVar;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new C0379a(this.f22155b, this.f22156c, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = c.f();
            int i10 = this.f22154a;
            if (i10 == 0) {
                s.b(obj);
                d dVar = this.f22155b;
                C0380a c0380a = new C0380a(this.f22156c);
                this.f22154a = 1;
                if (dVar.collect(c0380a, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((C0379a) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public final void a(Executor executor, s0.a consumer, d flow) {
        t.f(executor, "executor");
        t.f(consumer, "consumer");
        t.f(flow, "flow");
        ReentrantLock reentrantLock = this.f22152a;
        reentrantLock.lock();
        try {
            if (this.f22153b.get(consumer) == null) {
                this.f22153b.put(consumer, k.d(o0.a(r1.b(executor)), null, null, new C0379a(flow, consumer, null), 3, null));
            }
            h0 h0Var = h0.f3852a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b(s0.a consumer) {
        t.f(consumer, "consumer");
        ReentrantLock reentrantLock = this.f22152a;
        reentrantLock.lock();
        try {
            y1 y1Var = (y1) this.f22153b.get(consumer);
            if (y1Var != null) {
                y1.a.b(y1Var, null, 1, null);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
