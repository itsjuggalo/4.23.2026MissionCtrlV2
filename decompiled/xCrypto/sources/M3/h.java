package M3;

import i3.k;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public interface h {

    public static final class a {

        /* JADX INFO: renamed from: M3.h$a$a, reason: collision with other inner class name */
        public static final class C0048a extends s implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ F3.b f2698a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0048a(F3.b bVar) {
                super(1);
                this.f2698a = bVar;
            }

            @Override // i3.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final F3.b invoke(List it) {
                r.f(it, "it");
                return this.f2698a;
            }
        }

        public static void a(h hVar, InterfaceC1716c kClass, F3.b serializer) {
            r.f(kClass, "kClass");
            r.f(serializer, "serializer");
            hVar.d(kClass, new C0048a(serializer));
        }
    }

    void a(InterfaceC1716c interfaceC1716c, F3.b bVar);

    void b(InterfaceC1716c interfaceC1716c, k kVar);

    void c(InterfaceC1716c interfaceC1716c, InterfaceC1716c interfaceC1716c2, F3.b bVar);

    void d(InterfaceC1716c interfaceC1716c, k kVar);

    void e(InterfaceC1716c interfaceC1716c, k kVar);
}
