package p5;

import E5.p;
import F5.AbstractC0555m;
import V4.a;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import p5.C2435i;

/* JADX INFO: renamed from: p5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2435i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21892b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final E5.j f21893c = E5.k.b(new Function0() { // from class: p5.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return C2435i.d();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.b f21894a;

    /* JADX INFO: renamed from: p5.i$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public static final void e(C2400d c2400d, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            try {
                c2400d.m(((Long) obj2).longValue());
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = Q.f21674a.b(th);
            }
            reply.a(listB);
        }

        public static final void f(C2400d c2400d, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            try {
                c2400d.e();
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = Q.f21674a.b(th);
            }
            reply.a(listB);
        }

        public final V4.h c() {
            return (V4.h) C2435i.f21893c.getValue();
        }

        public final void d(V4.b binaryMessenger, final C2400d c2400d) {
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            V4.a aVar = new V4.a(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", c());
            if (c2400d != null) {
                aVar.e(new a.d() { // from class: p5.g
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        C2435i.a.e(c2400d, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.clear", c());
            if (c2400d != null) {
                aVar2.e(new a.d() { // from class: p5.h
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        C2435i.a.f(c2400d, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
        }

        public a() {
        }
    }

    public C2435i(V4.b binaryMessenger) {
        kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
        this.f21894a = binaryMessenger;
    }

    public static final C2386b d() {
        return new C2386b();
    }

    public static final void f(Q5.k callback, String channelName, Object obj) {
        kotlin.jvm.internal.r.f(callback, "$callback");
        kotlin.jvm.internal.r.f(channelName, "$channelName");
        if (!(obj instanceof List)) {
            p.a aVar = E5.p.f1681b;
            callback.invoke(E5.p.a(E5.p.b(E5.q.a(Q.f21674a.a(channelName)))));
            return;
        }
        List list = (List) obj;
        if (list.size() <= 1) {
            p.a aVar2 = E5.p.f1681b;
            callback.invoke(E5.p.a(E5.p.b(E5.E.f1657a)));
            return;
        }
        p.a aVar3 = E5.p.f1681b;
        Object obj2 = list.get(0);
        kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = list.get(1);
        kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
        callback.invoke(E5.p.a(E5.p.b(E5.q.a(new C2379a((String) obj2, (String) obj3, (String) list.get(2))))));
    }

    public final void e(long j7, final Q5.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        final String str = "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference";
        new V4.a(this.f21894a, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", f21892b.c()).d(AbstractC0555m.b(Long.valueOf(j7)), new a.e() { // from class: p5.f
            @Override // V4.a.e
            public final void a(Object obj) {
                C2435i.f(callback, str, obj);
            }
        });
    }
}
