package g8;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface h {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        RED,
        BLACK
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {
        public abstract void a(Object obj, Object obj2);
    }

    h a();

    h b(Object obj, Object obj2, Comparator comparator);

    h c(Object obj, Object obj2, a aVar, h hVar, h hVar2);

    h d(Object obj, Comparator comparator);

    void e(b bVar);

    boolean f();

    h g();

    Object getKey();

    Object getValue();

    h h();

    h i();

    boolean isEmpty();

    int size();
}
