package M6;

import I6.N0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5437a;

        static {
            int[] iArr = new int[N0.values().length];
            try {
                iArr[N0.f4370e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[N0.f4371f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[N0.f4372g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5437a = iArr;
        }
    }

    public static final t a(N0 n02) {
        AbstractC2304t.f(n02, "<this>");
        int i8 = a.f5437a[n02.ordinal()];
        if (i8 == 1) {
            return t.f5440d;
        }
        if (i8 == 2) {
            return t.f5438b;
        }
        if (i8 == 3) {
            return t.f5439c;
        }
        throw new C2487o();
    }
}
