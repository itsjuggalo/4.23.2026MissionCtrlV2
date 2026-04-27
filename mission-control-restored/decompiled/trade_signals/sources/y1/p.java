package y1;

import android.util.SparseArray;
import y1.C2975f;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(s sVar);

        public abstract a c(b bVar);
    }

    public enum b {
        NOT_SET(0),
        EVENT_OVERRIDE(5);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final SparseArray f24397d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24399a;

        static {
            b bVar = NOT_SET;
            b bVar2 = EVENT_OVERRIDE;
            SparseArray sparseArray = new SparseArray();
            f24397d = sparseArray;
            sparseArray.put(0, bVar);
            sparseArray.put(5, bVar2);
        }

        b(int i8) {
            this.f24399a = i8;
        }
    }

    public static a a() {
        return new C2975f.b();
    }

    public abstract s b();

    public abstract b c();
}
