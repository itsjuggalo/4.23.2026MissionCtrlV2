package d6;

import android.content.Context;
import c6.h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.identitycredentials.GetCredentialRequest;
import com.google.android.gms.internal.identity_credentials.zze;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends com.google.android.gms.common.api.f implements c6.f {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f7829a;

        public a(TaskCompletionSource taskCompletionSource) {
            this.f7829a = taskCompletionSource;
        }

        @Override // d6.a
        public void F(Status status, h hVar) {
            t.f(status, "status");
            w.b(status, hVar, this.f7829a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context, g.f7832c, a.d.J, f.a.f5486c);
        t.f(context, "context");
    }

    public static final void h(GetCredentialRequest request, d dVar, TaskCompletionSource taskCompletionSource) {
        t.f(request, "$request");
        ((b) dVar.getService()).n(new a(taskCompletionSource), request);
    }

    @Override // c6.f
    public Task a(final GetCredentialRequest request) {
        t.f(request, "request");
        Task taskDoRead = doRead(v.a().d(zze.zza).b(new q() { // from class: d6.e
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                f.h(request, (d) obj, (TaskCompletionSource) obj2);
            }
        }).e(32701).a());
        t.e(taskDoRead, "doRead(...)");
        return taskDoRead;
    }
}
