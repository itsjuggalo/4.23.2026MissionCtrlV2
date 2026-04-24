package f4;

import x3.InterfaceC2956a;

/* JADX INFO: renamed from: f4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1752a implements InterfaceC2956a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2956a f17529a = new C1752a();

    /* JADX INFO: renamed from: f4.a$a, reason: collision with other inner class name */
    public static final class C0302a implements w3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0302a f17530a = new C0302a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w3.d f17531b = w3.d.d("rolloutId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w3.d f17532c = w3.d.d("variantId");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final w3.d f17533d = w3.d.d("parameterKey");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final w3.d f17534e = w3.d.d("parameterValue");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final w3.d f17535f = w3.d.d("templateVersion");

        @Override // w3.InterfaceC2923b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC1755d abstractC1755d, w3.f fVar) {
            fVar.g(f17531b, abstractC1755d.d());
            fVar.g(f17532c, abstractC1755d.f());
            fVar.g(f17533d, abstractC1755d.b());
            fVar.g(f17534e, abstractC1755d.c());
            fVar.a(f17535f, abstractC1755d.e());
        }
    }

    @Override // x3.InterfaceC2956a
    public void a(x3.b bVar) {
        C0302a c0302a = C0302a.f17530a;
        bVar.a(AbstractC1755d.class, c0302a);
        bVar.a(C1753b.class, c0302a);
    }
}
