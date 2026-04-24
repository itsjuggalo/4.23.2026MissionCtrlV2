package U2;

import x3.InterfaceC2956a;

/* JADX INFO: loaded from: classes.dex */
public final class a implements InterfaceC2956a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2956a f8092a = new a();

    /* JADX INFO: renamed from: U2.a$a, reason: collision with other inner class name */
    public static final class C0117a implements w3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0117a f8093a = new C0117a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final w3.d f8094b = w3.d.d("rolloutId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final w3.d f8095c = w3.d.d("parameterKey");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final w3.d f8096d = w3.d.d("parameterValue");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final w3.d f8097e = w3.d.d("variantId");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final w3.d f8098f = w3.d.d("templateVersion");

        @Override // w3.InterfaceC2923b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j jVar, w3.f fVar) {
            fVar.g(f8094b, jVar.e());
            fVar.g(f8095c, jVar.c());
            fVar.g(f8096d, jVar.d());
            fVar.g(f8097e, jVar.g());
            fVar.a(f8098f, jVar.f());
        }
    }

    @Override // x3.InterfaceC2956a
    public void a(x3.b bVar) {
        C0117a c0117a = C0117a.f8093a;
        bVar.a(j.class, c0117a);
        bVar.a(b.class, c0117a);
    }
}
