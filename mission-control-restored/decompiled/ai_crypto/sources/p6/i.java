package p6;

import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22092a = new a();

        public a() {
            super(null);
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f22093a = new b();

        public b() {
            super(null);
        }
    }

    public /* synthetic */ i(AbstractC2148j abstractC2148j) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String strC = H.b(getClass()).c();
        r.c(strC);
        return strC;
    }

    public i() {
    }
}
