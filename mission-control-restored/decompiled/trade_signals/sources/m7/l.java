package m7;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21529a = new a();

        public a() {
            super(null);
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21530a = new b();

        public b() {
            super(null);
        }
    }

    public l() {
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String strR = O.b(getClass()).r();
        AbstractC2304t.c(strR);
        return strR;
    }

    public /* synthetic */ l(AbstractC2296k abstractC2296k) {
        this();
    }
}
