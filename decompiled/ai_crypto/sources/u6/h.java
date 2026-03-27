package u6;

import Q5.k;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public interface h {

    public static final class a {

        /* JADX INFO: renamed from: u6.h$a$a, reason: collision with other inner class name */
        public static final class C0382a extends s implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n6.b f24706a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0382a(n6.b bVar) {
                super(1);
                this.f24706a = bVar;
            }

            @Override // Q5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final n6.b invoke(List it) {
                r.f(it, "it");
                return this.f24706a;
            }
        }

        public static void a(h hVar, X5.c kClass, n6.b serializer) {
            r.f(kClass, "kClass");
            r.f(serializer, "serializer");
            hVar.c(kClass, new C0382a(serializer));
        }
    }

    void a(X5.c cVar, k kVar);

    void b(X5.c cVar, k kVar);

    void c(X5.c cVar, k kVar);

    void d(X5.c cVar, X5.c cVar2, n6.b bVar);

    void e(X5.c cVar, n6.b bVar);
}
