package jg;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pd.o f14395a;

        public a(pd.o oVar) {
            this.f14395a = oVar;
        }

        @Override // jg.h
        public Iterator iterator() {
            return k.a(this.f14395a);
        }
    }

    public static Iterator a(pd.o block) {
        kotlin.jvm.internal.t.f(block, "block");
        i iVar = new i();
        iVar.l(hd.b.a(block, iVar, iVar));
        return iVar;
    }

    public static h b(pd.o block) {
        kotlin.jvm.internal.t.f(block, "block");
        return new a(block);
    }
}
