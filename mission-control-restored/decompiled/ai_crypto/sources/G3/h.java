package G3;

import java.util.Comparator;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f2439a = new Comparator() { // from class: G3.g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return h.h((h) obj, (h) obj2);
        }
    };

    static /* synthetic */ int h(h hVar, h hVar2) {
        return hVar.getKey().compareTo(hVar2.getKey());
    }

    r a();

    boolean b();

    boolean c();

    boolean e();

    boolean f();

    v g();

    s getData();

    k getKey();

    C2105D i(q qVar);

    boolean j();

    boolean k();

    v l();
}
