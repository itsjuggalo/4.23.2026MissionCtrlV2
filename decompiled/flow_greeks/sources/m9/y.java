package m9;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.f;
import rb.g;
import rb.k1;
import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y0.g f16316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y0.g f16317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y0.g f16318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile String f16319j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n9.g f16320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e9.a f16321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e9.a f16322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f16323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0 f16325f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends rb.a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.g[] f16329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Task f16330b;

        public b(rb.g[] gVarArr, Task task) {
            this.f16329a = gVarArr;
            this.f16330b = task;
        }

        @Override // rb.a0, rb.e1, rb.g
        public void b() {
            if (this.f16329a[0] == null) {
                this.f16330b.addOnSuccessListener(y.this.f16320a.o(), new OnSuccessListener() { // from class: m9.z
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        ((rb.g) obj).b();
                    }
                });
            } else {
                super.b();
            }
        }

        @Override // rb.a0, rb.e1
        public rb.g f() {
            n9.b.d(this.f16329a[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
            return this.f16329a[0];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f16332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rb.g f16333b;

        public c(e eVar, rb.g gVar) {
            this.f16332a = eVar;
            this.f16333b = gVar;
        }

        @Override // rb.g.a
        public void a(k1 k1Var, rb.y0 y0Var) {
            this.f16332a.a(k1Var);
        }

        @Override // rb.g.a
        public void c(Object obj) {
            this.f16332a.b(obj);
            this.f16333b.c(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f16335a;

        public d(TaskCompletionSource taskCompletionSource) {
            this.f16335a = taskCompletionSource;
        }

        @Override // rb.g.a
        public void a(k1 k1Var, rb.y0 y0Var) {
            if (!k1Var.p()) {
                this.f16335a.setException(y.this.f(k1Var));
            } else {
                if (this.f16335a.getTask().isComplete()) {
                    return;
                }
                this.f16335a.setException(new com.google.firebase.firestore.f("Received onClose with status OK, but no message.", f.a.INTERNAL));
            }
        }

        @Override // rb.g.a
        public void c(Object obj) {
            this.f16335a.setResult(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class e {
        public abstract void a(k1 k1Var);

        public abstract void b(Object obj);
    }

    static {
        y0.d dVar = rb.y0.f19747e;
        f16316g = y0.g.e("x-goog-api-client", dVar);
        f16317h = y0.g.e("google-cloud-resource-prefix", dVar);
        f16318i = y0.g.e("x-goog-request-params", dVar);
        f16319j = "gl-java/";
    }

    public y(n9.g gVar, e9.a aVar, e9.a aVar2, j9.f fVar, i0 i0Var, h0 h0Var) {
        this.f16320a = gVar;
        this.f16325f = i0Var;
        this.f16321b = aVar;
        this.f16322c = aVar2;
        this.f16323d = h0Var;
        this.f16324e = String.format("projects/%s/databases/%s", fVar.i(), fVar.h());
    }

    public static /* synthetic */ void a(y yVar, e eVar, Object obj, Task task) {
        yVar.getClass();
        rb.g gVar = (rb.g) task.getResult();
        gVar.e(yVar.new c(eVar, gVar), yVar.i());
        gVar.c(1);
        gVar.d(obj);
        gVar.b();
    }

    public static /* synthetic */ void b(y yVar, TaskCompletionSource taskCompletionSource, Object obj, Task task) {
        yVar.getClass();
        rb.g gVar = (rb.g) task.getResult();
        gVar.e(yVar.new d(taskCompletionSource), yVar.i());
        gVar.c(2);
        gVar.d(obj);
        gVar.b();
    }

    public static /* synthetic */ void c(y yVar, rb.g[] gVarArr, j0 j0Var, Task task) {
        yVar.getClass();
        rb.g gVar = (rb.g) task.getResult();
        gVarArr[0] = gVar;
        gVar.e(yVar.new a(j0Var, gVarArr), yVar.i());
        j0Var.a();
        gVarArr[0].c(1);
    }

    public static void m(String str) {
        f16319j = str;
    }

    public final com.google.firebase.firestore.f f(k1 k1Var) {
        return q.g(k1Var) ? new com.google.firebase.firestore.f("The Cloud Firestore client failed to establish a secure connection. This is likely a problem with your app, rather than with Cloud Firestore itself. See https://bit.ly/2XFpdma for instructions on how to enable TLS on Android 4.x devices.", f.a.c(k1Var.n().c()), k1Var.m()) : n9.g0.s(k1Var);
    }

    public final String g() {
        return String.format("%s fire/%s grpc/", f16319j, "26.0.2");
    }

    public void h() {
        this.f16321b.b();
        this.f16322c.b();
    }

    public final rb.y0 i() {
        rb.y0 y0Var = new rb.y0();
        y0Var.p(f16316g, g());
        y0Var.p(f16317h, this.f16324e);
        y0Var.p(f16318i, this.f16324e);
        i0 i0Var = this.f16325f;
        if (i0Var != null) {
            i0Var.a(y0Var);
        }
        return y0Var;
    }

    public rb.g j(rb.z0 z0Var, final j0 j0Var) {
        final rb.g[] gVarArr = {null};
        Task taskI = this.f16323d.i(z0Var);
        taskI.addOnCompleteListener(this.f16320a.o(), new OnCompleteListener() { // from class: m9.v
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                y.c(this.f16294a, gVarArr, j0Var, task);
            }
        });
        return new b(gVarArr, taskI);
    }

    public Task k(rb.z0 z0Var, final Object obj) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f16323d.i(z0Var).addOnCompleteListener(this.f16320a.o(), new OnCompleteListener() { // from class: m9.w
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                y.b(this.f16302a, taskCompletionSource, obj, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public void l(rb.z0 z0Var, final Object obj, final e eVar) {
        this.f16323d.i(z0Var).addOnCompleteListener(this.f16320a.o(), new OnCompleteListener() { // from class: m9.x
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                y.a(this.f16311a, eVar, obj, task);
            }
        });
    }

    public void n() {
        this.f16323d.n();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f16326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rb.g[] f16327b;

        public a(j0 j0Var, rb.g[] gVarArr) {
            this.f16326a = j0Var;
            this.f16327b = gVarArr;
        }

        @Override // rb.g.a
        public void a(k1 k1Var, rb.y0 y0Var) {
            try {
                this.f16326a.b(k1Var);
            } catch (Throwable th) {
                y.this.f16320a.q(th);
            }
        }

        @Override // rb.g.a
        public void b(rb.y0 y0Var) {
            try {
                this.f16326a.c(y0Var);
            } catch (Throwable th) {
                y.this.f16320a.q(th);
            }
        }

        @Override // rb.g.a
        public void c(Object obj) {
            try {
                this.f16326a.onNext(obj);
                this.f16327b[0].c(1);
            } catch (Throwable th) {
                y.this.f16320a.q(th);
            }
        }

        @Override // rb.g.a
        public void d() {
        }
    }
}
