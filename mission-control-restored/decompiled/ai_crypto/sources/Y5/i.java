package Y5;

import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q5.o f5662a;

        public a(Q5.o oVar) {
            this.f5662a = oVar;
        }

        @Override // Y5.f
        public Iterator iterator() {
            return i.a(this.f5662a);
        }
    }

    public static Iterator a(Q5.o block) {
        r.f(block, "block");
        g gVar = new g();
        gVar.k(I5.b.a(block, gVar, gVar));
        return gVar;
    }

    public static f b(Q5.o block) {
        r.f(block, "block");
        return new a(block);
    }
}
