package j5;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.internal.auth_blockstore.zzab;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import i5.h;
import j5.a;
import j5.b;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends com.google.android.gms.common.api.f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13900a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.g f13901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f13903d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends a.AbstractC0094a {
        @Override // com.google.android.gms.common.api.a.AbstractC0094a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e commonSettings, a.d.C0095a apiOptions, com.google.android.gms.common.api.internal.f connectedListener, n connectionFailedListener) {
            t.f(context, "context");
            t.f(looper, "looper");
            t.f(commonSettings, "commonSettings");
            t.f(apiOptions, "apiOptions");
            t.f(connectedListener, "connectedListener");
            t.f(connectionFailedListener, "connectionFailedListener");
            return new g(context, looper, commonSettings, connectedListener, connectionFailedListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends a.AbstractBinderC0240a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f13904a;

        public c(TaskCompletionSource taskCompletionSource) {
            this.f13904a = taskCompletionSource;
        }

        @Override // j5.a
        public void D(Status status, boolean z10) {
            t.f(status, "status");
            w.b(status, Boolean.valueOf(z10), this.f13904a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f13905a;

        public d(TaskCompletionSource taskCompletionSource) {
            this.f13905a = taskCompletionSource;
        }

        @Override // j5.b
        public void A(Status status, i5.e response) {
            t.f(status, "status");
            t.f(response, "response");
            w.b(status, response, this.f13905a);
        }
    }

    static {
        a.g gVar = new a.g();
        f13901b = gVar;
        a aVar = new a();
        f13902c = aVar;
        f13903d = new com.google.android.gms.common.api.a("RestoreCredential.API", aVar, gVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(context, f13903d, a.d.J, f.a.f5486c);
        t.f(context, "context");
    }

    public static final void i(i5.a request, g gVar, TaskCompletionSource taskCompletionSource) {
        t.f(request, "$request");
        ((j5.c) gVar.getService()).o(request, new c(taskCompletionSource));
    }

    public static final void j(i5.c request, g gVar, TaskCompletionSource taskCompletionSource) {
        t.f(request, "$request");
        ((j5.c) gVar.getService()).B(request, new d(taskCompletionSource));
    }

    @Override // i5.h
    public Task b(final i5.a request) {
        t.f(request, "request");
        Task taskDoRead = doRead(v.a().d(zzab.zzi).b(new q() { // from class: j5.d
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                f.i(request, (g) obj, (TaskCompletionSource) obj2);
            }
        }).e(1694).a());
        t.e(taskDoRead, "doRead(...)");
        return taskDoRead;
    }

    @Override // i5.h
    public Task d(final i5.c request) {
        t.f(request, "request");
        Task taskDoRead = doRead(v.a().d(zzab.zzk).b(new q() { // from class: j5.e
            @Override // com.google.android.gms.common.api.internal.q
            public final void accept(Object obj, Object obj2) {
                f.j(request, (g) obj, (TaskCompletionSource) obj2);
            }
        }).e(1695).a());
        t.e(taskDoRead, "doRead(...)");
        return taskDoRead;
    }
}
