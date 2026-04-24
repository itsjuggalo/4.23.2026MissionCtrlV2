package D3;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: D3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0438h implements A3.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A3.r f1312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f1313c = false;

    public C0438h(Executor executor, A3.r rVar) {
        this.f1311a = executor;
        this.f1312b = rVar;
    }

    @Override // A3.r
    public void a(final Object obj, final com.google.firebase.firestore.f fVar) {
        this.f1311a.execute(new Runnable() { // from class: D3.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f1290a.c(obj, fVar);
            }
        });
    }

    public final /* synthetic */ void c(Object obj, com.google.firebase.firestore.f fVar) {
        if (this.f1313c) {
            return;
        }
        this.f1312b.a(obj, fVar);
    }

    public void d() {
        this.f1313c = true;
    }
}
