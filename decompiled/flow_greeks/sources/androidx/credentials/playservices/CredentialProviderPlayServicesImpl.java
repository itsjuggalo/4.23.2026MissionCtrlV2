package androidx.credentials.playservices;

import android.content.Context;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import c5.i;
import cd.h0;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import g1.l;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import x0.a;
import x0.a0;
import x0.w;
import y0.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJE\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00172\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001fJ?\u0010#\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\"0\u0010H\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R(\u0010'\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b'\u0010(\u0012\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Landroidx/credentials/playservices/CredentialProviderPlayServicesImpl;", "Lx0/h;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "minApkVersion", "isGooglePlayServicesAvailable", "(Landroid/content/Context;I)I", "Lx0/w;", "request", "Landroid/os/CancellationSignal;", "cancellationSignal", "Ljava/util/concurrent/Executor;", "executor", "Lx0/e;", "Lx0/x;", "Ly0/h;", "callback", "Lcd/h0;", "onGetCredential", "(Landroid/content/Context;Lx0/w;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Lx0/e;)V", "Lx0/b;", "", "Ly0/e;", "onCreateCredential", "(Landroid/content/Context;Lx0/b;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Lx0/e;)V", "", "isAvailableOnDevice", "()Z", "(I)Z", "Lx0/a;", "Ljava/lang/Void;", "Ly0/a;", "onClearCredential", "(Lx0/a;Landroid/os/CancellationSignal;Ljava/util/concurrent/Executor;Lx0/e;)V", "Landroid/content/Context;", "Lm5/e;", "googleApiAvailability", "Lm5/e;", "getGoogleApiAvailability", "()Lm5/e;", "setGoogleApiAvailability", "(Lm5/e;)V", "getGoogleApiAvailability$annotations", "()V", "Companion", "a", "credentials-play-services-auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CredentialProviderPlayServicesImpl implements x0.h {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MIN_GMS_APK_VERSION = 230815045;
    public static final int MIN_GMS_APK_VERSION_DIGITAL_CRED = 243100000;
    public static final int MIN_GMS_APK_VERSION_RESTORE_CRED = 242200000;
    private static final String TAG = "PlayServicesImpl";
    private final Context context;
    private m5.e googleApiAvailability;

    /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final boolean a(CancellationSignal cancellationSignal) {
            if (cancellationSignal == null) {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "No cancellationSignal found");
                return false;
            }
            if (!cancellationSignal.isCanceled()) {
                return false;
            }
            Log.i(CredentialProviderPlayServicesImpl.TAG, "the flow has been canceled");
            return true;
        }

        public final void b(CancellationSignal cancellationSignal, Function0 callback) {
            t.f(callback, "callback");
            if (a(cancellationSignal)) {
                return;
            }
            callback.invoke();
        }

        public final boolean c(w request) {
            t.f(request, "request");
            for (x0.g gVar : request.a()) {
            }
            return false;
        }

        public final boolean d(w request) {
            t.f(request, "request");
            for (x0.g gVar : request.a()) {
            }
            return false;
        }

        public final boolean e(w request) {
            t.f(request, "request");
            Iterator it = request.a().iterator();
            while (it.hasNext()) {
                if (((x0.g) it.next()) instanceof j6.b) {
                    return true;
                }
            }
            return false;
        }

        public Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f1605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0.e f1606b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Executor executor, x0.e eVar) {
            super(0);
            this.f1605a = executor;
            this.f1606b = eVar;
        }

        public static final void b(x0.e eVar) {
            eVar.onError(new y0.b("clearCredentialStateAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m5invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5invoke() {
            Executor executor = this.f1605a;
            final x0.e eVar = this.f1606b;
            executor.execute(new Runnable() { // from class: c1.e
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.b.b(eVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends v implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationSignal f1607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f1608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x0.e f1609c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends v implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Executor f1610a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x0.e f1611b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Executor executor, x0.e eVar) {
                super(0);
                this.f1610a = executor;
                this.f1611b = eVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(x0.e eVar) {
                eVar.onResult(null);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m6invoke();
                return h0.f3852a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m6invoke() {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "Cleared restore credential successfully!");
                Executor executor = this.f1610a;
                final x0.e eVar = this.f1611b;
                executor.execute(new Runnable() { // from class: c1.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        CredentialProviderPlayServicesImpl.c.a.b(eVar);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CancellationSignal cancellationSignal, Executor executor, x0.e eVar) {
            super(1);
            this.f1607a = cancellationSignal;
            this.f1608b = executor;
            this.f1609c = eVar;
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h0.f3852a;
        }

        public final void invoke(Boolean bool) {
            CredentialProviderPlayServicesImpl.INSTANCE.b(this.f1607a, new a(this.f1608b, this.f1609c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f1612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0.e f1613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m0 f1614c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Executor executor, x0.e eVar, m0 m0Var) {
            super(0);
            this.f1612a = executor;
            this.f1613b = eVar;
            this.f1614c = m0Var;
        }

        public static final void b(x0.e eVar, m0 m0Var) {
            eVar.onError(m0Var.f14947a);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m7invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m7invoke() {
            Executor executor = this.f1612a;
            final x0.e eVar = this.f1613b;
            final m0 m0Var = this.f1614c;
            executor.execute(new Runnable() { // from class: c1.g
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.d.b(eVar, m0Var);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends v implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationSignal f1615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f1616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x0.e f1617c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends v implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Executor f1618a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x0.e f1619b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Executor executor, x0.e eVar) {
                super(0);
                this.f1618a = executor;
                this.f1619b = eVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(x0.e eVar) {
                eVar.onResult(null);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m8invoke();
                return h0.f3852a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m8invoke() {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "During clear credential, signed out successfully!");
                Executor executor = this.f1618a;
                final x0.e eVar = this.f1619b;
                executor.execute(new Runnable() { // from class: c1.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        CredentialProviderPlayServicesImpl.e.a.b(eVar);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(CancellationSignal cancellationSignal, Executor executor, x0.e eVar) {
            super(1);
            this.f1615a = cancellationSignal;
            this.f1616b = executor;
            this.f1617c = eVar;
        }

        public final void a(Void r52) {
            CredentialProviderPlayServicesImpl.INSTANCE.b(this.f1615a, new a(this.f1616b, this.f1617c));
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Void) obj);
            return h0.f3852a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f1620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f1621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x0.e f1622c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Exception exc, Executor executor, x0.e eVar) {
            super(0);
            this.f1620a = exc;
            this.f1621b = executor;
            this.f1622c = eVar;
        }

        public static final void b(x0.e eVar, Exception exc) {
            eVar.onError(new y0.c(exc.getMessage()));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m9invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m9invoke() {
            Log.w(CredentialProviderPlayServicesImpl.TAG, "During clear credential sign out failed with " + this.f1620a);
            Executor executor = this.f1621b;
            final x0.e eVar = this.f1622c;
            final Exception exc = this.f1620a;
            executor.execute(new Runnable() { // from class: c1.i
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.f.b(eVar, exc);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f1623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0.e f1624b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Executor executor, x0.e eVar) {
            super(0);
            this.f1623a = executor;
            this.f1624b = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(x0.e eVar) {
            eVar.onError(new j("this device requires a Google Play Services update for the given feature to be supported"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m10invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m10invoke() {
            Executor executor = this.f1623a;
            final x0.e eVar = this.f1624b;
            executor.execute(new Runnable() { // from class: c1.j
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.g.b(eVar);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends v implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f1625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0.e f1626b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Executor executor, x0.e eVar) {
            super(0);
            this.f1625a = executor;
            this.f1626b = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(x0.e eVar) {
            eVar.onError(new j("getCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m11invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m11invoke() {
            Executor executor = this.f1625a;
            final x0.e eVar = this.f1626b;
            executor.execute(new Runnable() { // from class: c1.k
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.h.b(eVar);
                }
            });
        }
    }

    public CredentialProviderPlayServicesImpl(Context context) {
        t.f(context, "context");
        this.context = context;
        m5.e eVarN = m5.e.n();
        t.e(eVarN, "getInstance(...)");
        this.googleApiAvailability = eVarN;
    }

    private final int isGooglePlayServicesAvailable(Context context, int minApkVersion) {
        return this.googleApiAvailability.h(context, minApkVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClearCredential$lambda$1(CancellationSignal cancellationSignal, Executor executor, x0.e eVar, Exception e10) {
        t.f(e10, "e");
        Log.w(TAG, "Clearing restore credential failed", e10);
        m0 m0Var = new m0();
        m0Var.f14947a = new y0.c("Clear restore credential failed for unknown reason.");
        if ((e10 instanceof com.google.android.gms.common.api.b) && ((com.google.android.gms.common.api.b) e10).getStatusCode() == 40201) {
            m0Var.f14947a = new y0.c("The restore credential internal service had a failure.");
        }
        INSTANCE.b(cancellationSignal, new d(executor, eVar, m0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClearCredential$lambda$4(CredentialProviderPlayServicesImpl credentialProviderPlayServicesImpl, CancellationSignal cancellationSignal, Executor executor, x0.e eVar, Exception e10) {
        t.f(e10, "e");
        INSTANCE.b(cancellationSignal, new f(e10, executor, eVar));
    }

    public final m5.e getGoogleApiAvailability() {
        return this.googleApiAvailability;
    }

    @Override // x0.h
    public boolean isAvailableOnDevice() {
        return isAvailableOnDevice(MIN_GMS_APK_VERSION);
    }

    @Override // x0.h
    public void onClearCredential(a request, final CancellationSignal cancellationSignal, final Executor executor, final x0.e callback) {
        t.f(request, "request");
        t.f(executor, "executor");
        t.f(callback, "callback");
        Companion companion = INSTANCE;
        if (companion.a(cancellationSignal)) {
            return;
        }
        if (!t.b(request.b(), "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
            Task taskSignOut = i.d(this.context).signOut();
            final e eVar = new e(cancellationSignal, executor, callback);
            taskSignOut.addOnSuccessListener(new OnSuccessListener() { // from class: c1.c
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    eVar.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: c1.d
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CredentialProviderPlayServicesImpl.onClearCredential$lambda$4(this.f3539a, cancellationSignal, executor, callback, exc);
                }
            });
        } else {
            if (!isAvailableOnDevice(MIN_GMS_APK_VERSION_RESTORE_CRED)) {
                companion.b(cancellationSignal, new b(executor, callback));
                return;
            }
            Task taskB = i5.g.a(this.context).b(new i5.a(request.a()));
            final c cVar = new c(cancellationSignal, executor, callback);
            taskB.addOnSuccessListener(new OnSuccessListener() { // from class: c1.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    cVar.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: c1.b
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CredentialProviderPlayServicesImpl.onClearCredential$lambda$1(cancellationSignal, executor, callback, exc);
                }
            });
        }
    }

    public void onCreateCredential(Context context, x0.b request, CancellationSignal cancellationSignal, Executor executor, x0.e callback) {
        t.f(context, "context");
        t.f(request, "request");
        t.f(executor, "executor");
        t.f(callback, "callback");
        if (!INSTANCE.a(cancellationSignal)) {
            throw new UnsupportedOperationException("Create Credential request is unsupported, not password or publickeycredential");
        }
    }

    @Override // x0.h
    public /* bridge */ /* synthetic */ void onGetCredential(Context context, a0 a0Var, CancellationSignal cancellationSignal, Executor executor, x0.e eVar) {
        super.onGetCredential(context, a0Var, cancellationSignal, executor, eVar);
    }

    @Override // x0.h
    public /* bridge */ /* synthetic */ void onPrepareCredential(w wVar, CancellationSignal cancellationSignal, Executor executor, x0.e eVar) {
        super.onPrepareCredential(wVar, cancellationSignal, executor, eVar);
    }

    public final void setGoogleApiAvailability(m5.e eVar) {
        t.f(eVar, "<set-?>");
        this.googleApiAvailability = eVar;
    }

    public final boolean isAvailableOnDevice(int minApkVersion) {
        int iIsGooglePlayServicesAvailable = isGooglePlayServicesAvailable(this.context, minApkVersion);
        boolean z10 = iIsGooglePlayServicesAvailable == 0;
        if (!z10) {
            Log.w(TAG, "Connection with Google Play Services was not successful. Connection result is: " + new m5.b(iIsGooglePlayServicesAvailable));
        }
        return z10;
    }

    @Override // x0.h
    public void onGetCredential(Context context, w request, CancellationSignal cancellationSignal, Executor executor, x0.e callback) {
        t.f(context, "context");
        t.f(request, "request");
        t.f(executor, "executor");
        t.f(callback, "callback");
        Companion companion = INSTANCE;
        if (companion.a(cancellationSignal)) {
            return;
        }
        if (companion.c(request)) {
            if (isAvailableOnDevice(MIN_GMS_APK_VERSION_DIGITAL_CRED)) {
                new g1.c(context).t(request, callback, executor, cancellationSignal);
                return;
            } else {
                companion.b(cancellationSignal, new g(executor, callback));
                return;
            }
        }
        if (companion.d(request)) {
            if (isAvailableOnDevice(MIN_GMS_APK_VERSION_RESTORE_CRED)) {
                new l(context).m(request, callback, executor, cancellationSignal);
                return;
            } else {
                companion.b(cancellationSignal, new h(executor, callback));
                return;
            }
        }
        if (companion.e(request)) {
            new h1.a(context).q(request, callback, executor, cancellationSignal);
        } else {
            new e1.b(context).q(request, callback, executor, cancellationSignal);
        }
    }

    public static /* synthetic */ void getGoogleApiAvailability$annotations() {
    }
}
