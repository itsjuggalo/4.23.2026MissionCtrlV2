package d3;

import S3.a;
import h3.InterfaceC1857A;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: d3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1628d implements InterfaceC1857A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S3.a f16848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f16849b = new AtomicReference();

    public C1628d(S3.a aVar) {
        this.f16848a = aVar;
        aVar.a(new a.InterfaceC0108a() { // from class: d3.a
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar) {
                this.f16843a.f(bVar);
            }
        });
    }

    public static /* synthetic */ void e(ExecutorService executorService, InterfaceC1857A.b bVar, S3.b bVar2) {
        android.support.v4.media.session.b.a(bVar2.get());
        new C1627c(executorService, bVar);
        throw null;
    }

    @Override // h3.InterfaceC1857A
    public void a(boolean z7, InterfaceC1857A.a aVar) {
        android.support.v4.media.session.b.a(this.f16849b.get());
        aVar.a(null);
    }

    @Override // h3.InterfaceC1857A
    public void b(final ExecutorService executorService, final InterfaceC1857A.b bVar) {
        this.f16848a.a(new a.InterfaceC0108a() { // from class: d3.b
            @Override // S3.a.InterfaceC0108a
            public final void a(S3.b bVar2) {
                C1628d.e(executorService, bVar, bVar2);
            }
        });
    }

    public final /* synthetic */ void f(S3.b bVar) {
        AtomicReference atomicReference = this.f16849b;
        android.support.v4.media.session.b.a(bVar.get());
        atomicReference.set(null);
    }
}
