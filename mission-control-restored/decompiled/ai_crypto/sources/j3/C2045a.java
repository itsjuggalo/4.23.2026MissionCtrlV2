package j3;

import w3.InterfaceC2775a;
import w3.InterfaceC2776b;

/* JADX INFO: renamed from: j3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2045a implements InterfaceC2775a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2775a f17370a = new C2045a();

    /* JADX INFO: renamed from: j3.a$a, reason: collision with other inner class name */
    public static final class C0264a implements v3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0264a f17371a = new C0264a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final v3.d f17372b = v3.d.d("rolloutId");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v3.d f17373c = v3.d.d("parameterKey");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final v3.d f17374d = v3.d.d("parameterValue");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final v3.d f17375e = v3.d.d("variantId");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final v3.d f17376f = v3.d.d("templateVersion");

        @Override // v3.InterfaceC2766b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC2054j abstractC2054j, v3.f fVar) {
            fVar.d(f17372b, abstractC2054j.e());
            fVar.d(f17373c, abstractC2054j.c());
            fVar.d(f17374d, abstractC2054j.d());
            fVar.d(f17375e, abstractC2054j.g());
            fVar.c(f17376f, abstractC2054j.f());
        }
    }

    @Override // w3.InterfaceC2775a
    public void a(InterfaceC2776b interfaceC2776b) {
        C0264a c0264a = C0264a.f17371a;
        interfaceC2776b.a(AbstractC2054j.class, c0264a);
        interfaceC2776b.a(C2046b.class, c0264a);
    }
}
