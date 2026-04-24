package r7;

import B5.k;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import r7.i;

/* JADX INFO: loaded from: classes2.dex */
public interface i {

    public static final class a {
        public static void b(i iVar, I5.d kClass, final k7.b serializer) {
            AbstractC2304t.f(kClass, "kClass");
            AbstractC2304t.f(serializer, "serializer");
            iVar.c(kClass, new k() { // from class: r7.h
                @Override // B5.k
                public final Object invoke(Object obj) {
                    return i.a.c(serializer, (List) obj);
                }
            });
        }

        public static k7.b c(k7.b bVar, List it) {
            AbstractC2304t.f(it, "it");
            return bVar;
        }
    }

    void a(I5.d dVar, k kVar);

    void b(I5.d dVar, k7.b bVar);

    void c(I5.d dVar, k kVar);

    void d(I5.d dVar, k kVar);

    void e(I5.d dVar, I5.d dVar2, k7.b bVar);
}
