package e3;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public interface h {

    public enum a {
        RED,
        BLACK
    }

    public static abstract class b {
        public abstract void a(Object obj, Object obj2);
    }

    h a(Object obj, Object obj2, a aVar, h hVar, h hVar2);

    h b();

    h c(Object obj, Object obj2, Comparator comparator);

    h d(Object obj, Comparator comparator);

    boolean e();

    h f();

    void g(b bVar);

    Object getKey();

    Object getValue();

    h h();

    h i();

    boolean isEmpty();

    int size();
}
