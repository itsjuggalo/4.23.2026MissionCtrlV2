package H3;

import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f764a = new a();

        public a() {
            super(null);
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f765a = new b();

        public b() {
            super(null);
        }
    }

    public /* synthetic */ i(AbstractC1585j abstractC1585j) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String strB = G.b(getClass()).b();
        r.c(strB);
        return strB;
    }

    public i() {
    }
}
