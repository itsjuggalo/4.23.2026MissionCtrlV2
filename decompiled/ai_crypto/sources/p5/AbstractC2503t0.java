package p5;

import E5.p;
import F5.AbstractC0555m;
import V4.a;
import android.os.Message;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import p5.AbstractC2503t0;

/* JADX INFO: renamed from: p5.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2503t0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21979b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P f21980a;

    /* JADX INFO: renamed from: p5.t0$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public static final void c(AbstractC2503t0 abstractC2503t0, Object obj, a.e reply) {
            List listB;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.os.Message");
            try {
                abstractC2503t0.e((Message) obj2);
                listB = AbstractC0555m.b(null);
            } catch (Throwable th) {
                listB = Q.f21674a.b(th);
            }
            reply.a(listB);
        }

        public final void b(V4.b binaryMessenger, final AbstractC2503t0 abstractC2503t0) {
            V4.h c2386b;
            P pB;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            if (abstractC2503t0 == null || (pB = abstractC2503t0.b()) == null || (c2386b = pB.b()) == null) {
                c2386b = new C2386b();
            }
            V4.a aVar = new V4.a(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.sendToTarget", c2386b);
            if (abstractC2503t0 != null) {
                aVar.e(new a.d() { // from class: p5.s0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC2503t0.a.c(abstractC2503t0, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
        }

        public a() {
        }
    }

    public AbstractC2503t0(P pigeonRegistrar) {
        kotlin.jvm.internal.r.f(pigeonRegistrar, "pigeonRegistrar");
        this.f21980a = pigeonRegistrar;
    }

    public static final void d(Q5.k callback, String channelName, Object obj) {
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

    public P b() {
        return this.f21980a;
    }

    public final void c(Message pigeon_instanceArg, final Q5.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (b().c()) {
            p.a aVar = E5.p.f1681b;
            callback.invoke(E5.p.a(E5.p.b(E5.q.a(new C2379a("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else if (b().d().f(pigeon_instanceArg)) {
            p.a aVar2 = E5.p.f1681b;
            callback.invoke(E5.p.a(E5.p.b(E5.E.f1657a)));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance";
            new V4.a(b().a(), "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance", b().b()).d(AbstractC0555m.b(Long.valueOf(b().d().c(pigeon_instanceArg))), new a.e() { // from class: p5.r0
                @Override // V4.a.e
                public final void a(Object obj) {
                    AbstractC2503t0.d(callback, str, obj);
                }
            });
        }
    }

    public abstract void e(Message message);
}
