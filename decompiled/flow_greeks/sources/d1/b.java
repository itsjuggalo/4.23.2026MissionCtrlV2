package d1;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import cd.h0;
import d1.b;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.k;
import pd.o;
import x0.e;
import y0.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends d1.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f7497f = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f7498e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: d1.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0139a extends v implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f7499a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m0 f7500b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0139a(k kVar, m0 m0Var) {
                super(0);
                this.f7499a = kVar;
                this.f7500b = m0Var;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m251invoke();
                return h0.f3852a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m251invoke() {
                this.f7499a.invoke(this.f7500b.f14947a);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final void a(CancellationSignal cancellationSignal, Function0 onResultOrException) {
            t.f(onResultOrException, "onResultOrException");
            if (CredentialProviderPlayServicesImpl.INSTANCE.a(cancellationSignal)) {
                return;
            }
            onResultOrException.invoke();
        }

        public final String b() {
            return "activity is cancelled by the user.";
        }

        public final String c(int i10) {
            return "activity with result code: " + i10 + " indicating not RESULT_OK";
        }

        public final boolean d(int i10, o cancelOnError, k onError, CancellationSignal cancellationSignal) {
            t.f(cancelOnError, "cancelOnError");
            t.f(onError, "onError");
            if (i10 == -1) {
                return false;
            }
            m0 m0Var = new m0();
            m0Var.f14947a = new y0.k(c(i10));
            if (i10 == 0) {
                m0Var.f14947a = new f(b());
            }
            cancelOnError.invoke(cancellationSignal, new C0139a(onError, m0Var));
            return true;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: d1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0140b extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f7501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f7502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f7503c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0140b(Executor executor, e eVar, Object obj) {
            super(0);
            this.f7501a = executor;
            this.f7502b = eVar;
            this.f7503c = obj;
        }

        public static final void b(e eVar, Object obj) {
            eVar.onError(obj);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m252invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m252invoke() {
            Executor executor = this.f7501a;
            final e eVar = this.f7502b;
            final Object obj = this.f7503c;
            executor.execute(new Runnable() { // from class: d1.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.C0140b.b(eVar, obj);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        t.f(context, "context");
        this.f7498e = context;
    }

    public static final void e(CancellationSignal cancellationSignal, Function0 function0) {
        f7497f.a(cancellationSignal, function0);
    }

    public static final boolean g(int i10, o oVar, k kVar, CancellationSignal cancellationSignal) {
        return f7497f.d(i10, oVar, kVar, cancellationSignal);
    }

    public final boolean f(Bundle resultData, o conversionFn, Executor executor, e callback, CancellationSignal cancellationSignal) {
        t.f(resultData, "resultData");
        t.f(conversionFn, "conversionFn");
        t.f(executor, "executor");
        t.f(callback, "callback");
        if (!resultData.getBoolean("FAILURE_RESPONSE")) {
            return false;
        }
        e(cancellationSignal, new C0140b(executor, callback, conversionFn.invoke(resultData.getString("EXCEPTION_TYPE"), resultData.getString("EXCEPTION_MESSAGE"))));
        return true;
    }
}
