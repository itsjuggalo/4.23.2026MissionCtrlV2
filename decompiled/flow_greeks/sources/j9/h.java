package j9;

import bb.d0;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f14240a = new Comparator() { // from class: j9.g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((h) obj).getKey().compareTo(((h) obj2).getKey());
        }
    };

    r a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    v f();

    s getData();

    k getKey();

    d0 h(q qVar);

    boolean i();

    boolean j();

    v k();
}
