package l7;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import h7.o;
import h7.p;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements e7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntegrityManager f15535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f15536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f15537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f15538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f15539f;

    public i(a7.g gVar, Executor executor, Executor executor2) {
        this(gVar.r().f(), IntegrityManagerFactory.create(gVar.m()), new o(gVar), executor, executor2, new p());
    }

    public static /* synthetic */ Task e(final i iVar, IntegrityTokenResponse integrityTokenResponse) {
        iVar.getClass();
        final a aVar = new a(integrityTokenResponse.token());
        return Tasks.call(iVar.f15538e, new Callable() { // from class: l7.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                i iVar2 = this.f15529a;
                return iVar2.f15536c.b(aVar.a().getBytes("UTF-8"), 3, iVar2.f15539f);
            }
        });
    }

    @Override // e7.a
    public Task a() {
        return g().onSuccessTask(this.f15537d, new SuccessContinuation() { // from class: l7.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return i.e(this.f15528a, (IntegrityTokenResponse) obj);
            }
        }).onSuccessTask(this.f15537d, new SuccessContinuation() { // from class: l7.e
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Tasks.forResult(h7.b.c((h7.a) obj));
            }
        });
    }

    public final Task g() {
        final b bVar = new b();
        return Tasks.call(this.f15538e, new Callable() { // from class: l7.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                i iVar = this.f15531a;
                return c.a(iVar.f15536c.c(bVar.a().getBytes("UTF-8"), iVar.f15539f));
            }
        }).onSuccessTask(this.f15537d, new SuccessContinuation() { // from class: l7.h
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                i iVar = this.f15533a;
                return iVar.f15535b.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(iVar.f15534a)).setNonce(((c) obj).b()).build());
            }
        });
    }

    public i(String str, IntegrityManager integrityManager, o oVar, Executor executor, Executor executor2, p pVar) {
        this.f15534a = str;
        this.f15535b = integrityManager;
        this.f15536c = oVar;
        this.f15537d = executor;
        this.f15538e = executor2;
        this.f15539f = pVar;
    }
}
