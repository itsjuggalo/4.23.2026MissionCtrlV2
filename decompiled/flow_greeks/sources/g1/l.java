package g1;

import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import cd.h0;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import d1.b;
import g1.l;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import x0.w;
import x0.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends d1.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f9974g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends v implements pd.k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CancellationSignal f9976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Executor f9977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ x0.e f9978d;

        /* JADX INFO: renamed from: g1.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0177a extends v implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Executor f9979a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x0.e f9980b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ x f9981c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0177a(Executor executor, x0.e eVar, x xVar) {
                super(0);
                this.f9979a = executor;
                this.f9980b = eVar;
                this.f9981c = xVar;
            }

            public static final void b(x0.e eVar, x xVar) {
                eVar.onResult(xVar);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m262invoke();
                return h0.f3852a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m262invoke() {
                Executor executor = this.f9979a;
                final x0.e eVar = this.f9980b;
                final x xVar = this.f9981c;
                executor.execute(new Runnable() { // from class: g1.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.a.C0177a.b(eVar, xVar);
                    }
                });
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends v implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Executor f9982a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x0.e f9983b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Exception f9984c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Executor executor, x0.e eVar, Exception exc) {
                super(0);
                this.f9982a = executor;
                this.f9983b = eVar;
                this.f9984c = exc;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(x0.e eVar, Exception exc) {
                eVar.onError(exc instanceof y0.m ? (y0.h) exc : new y0.k(exc.getMessage()));
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m263invoke();
                return h0.f3852a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m263invoke() {
                Executor executor = this.f9982a;
                final x0.e eVar = this.f9983b;
                final Exception exc = this.f9984c;
                executor.execute(new Runnable() { // from class: g1.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.a.b.b(eVar, exc);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CancellationSignal cancellationSignal, Executor executor, x0.e eVar) {
            super(1);
            this.f9976b = cancellationSignal;
            this.f9977c = executor;
            this.f9978d = eVar;
        }

        public final void a(i5.e eVar) {
            try {
                l lVar = l.this;
                t.c(eVar);
                x xVarL = lVar.l(eVar);
                b.a aVar = d1.b.f7497f;
                d1.b.e(this.f9976b, new C0177a(this.f9977c, this.f9978d, xVarL));
            } catch (Exception e10) {
                b.a aVar2 = d1.b.f7497f;
                d1.b.e(this.f9976b, new b(this.f9977c, this.f9978d, e10));
            }
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((i5.e) obj);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f9985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0.e f9986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m0 f9987c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Executor executor, x0.e eVar, m0 m0Var) {
            super(0);
            this.f9985a = executor;
            this.f9986b = eVar;
            this.f9987c = m0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(x0.e eVar, m0 m0Var) {
            eVar.onError(m0Var.f14947a);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m264invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m264invoke() {
            Executor executor = this.f9985a;
            final x0.e eVar = this.f9986b;
            final m0 m0Var = this.f9987c;
            executor.execute(new Runnable() { // from class: g1.n
                @Override // java.lang.Runnable
                public final void run() {
                    l.b.b(eVar, m0Var);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context) {
        super(context);
        t.f(context, "context");
        this.f9974g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(pd.k kVar, Object obj) {
        kVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(CancellationSignal cancellationSignal, Executor executor, x0.e eVar, Exception e10) {
        t.f(e10, "e");
        m0 m0Var = new m0();
        m0Var.f14947a = new y0.k("Get restore credential failed for unknown reason, failure: " + e10.getMessage());
        if (e10 instanceof com.google.android.gms.common.api.b) {
            com.google.android.gms.common.api.b bVar = (com.google.android.gms.common.api.b) e10;
            if (bVar.getStatusCode() == 40201) {
                m0Var.f14947a = new y0.k("The restore credential internal service had a failure, failure: " + e10.getMessage());
            } else {
                m0Var.f14947a = new y0.k("The restore credential service failed with unsupported status code, failure: " + e10.getMessage() + ", status code: " + bVar.getStatusCode());
            }
        }
        d1.b.e(cancellationSignal, new b(executor, eVar, m0Var));
    }

    public i5.c k(w request) {
        t.f(request, "request");
        for (x0.g gVar : request.a()) {
        }
        t.s("credentialOption");
        throw null;
    }

    public x l(i5.e response) {
        t.f(response, "response");
        return new x(x0.c.f24129c.b("androidx.credentials.TYPE_RESTORE_CREDENTIAL", response.R()));
    }

    public void m(w request, final x0.e callback, final Executor executor, final CancellationSignal cancellationSignal) {
        t.f(request, "request");
        t.f(callback, "callback");
        t.f(executor, "executor");
        if (CredentialProviderPlayServicesImpl.INSTANCE.a(cancellationSignal)) {
            return;
        }
        Task taskD = i5.g.a(this.f9974g).d(k(request));
        final a aVar = new a(cancellationSignal, executor, callback);
        taskD.addOnSuccessListener(new OnSuccessListener() { // from class: g1.i
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                l.n(aVar, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: g1.j
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                l.o(cancellationSignal, executor, callback, exc);
            }
        });
    }
}
