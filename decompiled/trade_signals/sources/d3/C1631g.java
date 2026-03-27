package d3;

import S3.a;
import h3.InterfaceC1857A;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: d3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1631g implements InterfaceC1857A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3.a f16853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f16854b = new AtomicReference();

    public C1631g(S3.a aVar) {
        this.f16853a = aVar;
        aVar.a(new a.InterfaceC0108a() { // from class: d3.f
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar) {
                this.f16852a.f(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(ExecutorService executorService, InterfaceC1857A.b bVar, S3.b bVar2) {
        android.support.v4.media.session.b.a(bVar2.get());
        new C1627c(executorService, bVar);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(S3.b bVar) {
        AtomicReference atomicReference = this.f16854b;
        android.support.v4.media.session.b.a(bVar.get());
        atomicReference.set(null);
    }

    @Override // h3.InterfaceC1857A
    public void a(boolean z7, InterfaceC1857A.a aVar) {
        android.support.v4.media.session.b.a(this.f16854b.get());
        aVar.a(null);
    }

    @Override // h3.InterfaceC1857A
    public void b(final ExecutorService executorService, final InterfaceC1857A.b bVar) {
        this.f16853a.a(new a.InterfaceC0108a() { // from class: d3.e
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar2) {
                C1631g.e(executorService, bVar, bVar2);
            }
        });
    }
}
