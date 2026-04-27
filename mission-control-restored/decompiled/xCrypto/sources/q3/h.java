package q3;

import a3.AbstractC0786b;
import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i3.o f14302a;

        public a(i3.o oVar) {
            this.f14302a = oVar;
        }

        @Override // q3.e
        public Iterator iterator() {
            return h.a(this.f14302a);
        }
    }

    public static Iterator a(i3.o block) {
        r.f(block, "block");
        f fVar = new f();
        fVar.f(AbstractC0786b.a(block, fVar, fVar));
        return fVar;
    }

    public static e b(i3.o block) {
        r.f(block, "block");
        return new a(block);
    }
}
