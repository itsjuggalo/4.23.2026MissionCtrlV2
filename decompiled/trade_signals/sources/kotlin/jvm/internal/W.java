package kotlin.jvm.internal;

import o5.C2470H;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class W implements I5.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20475a = new a(null);

    public static final class a {

        /* JADX INFO: renamed from: kotlin.jvm.internal.W$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0344a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20476a;

            static {
                int[] iArr = new int[I5.t.values().length];
                try {
                    iArr[I5.t.f4301a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[I5.t.f4302b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[I5.t.f4303c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f20476a = iArr;
            }
        }

        public a() {
        }

        public final String a(I5.r typeParameter) {
            String str;
            AbstractC2304t.f(typeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i8 = C0344a.f20476a[typeParameter.p().ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    str = "in ";
                } else {
                    if (i8 != 3) {
                        throw new C2487o();
                    }
                    str = "out ";
                }
                sb.append(str);
            } else {
                C2470H c2470h = C2470H.f21956a;
            }
            sb.append(typeParameter.getName());
            return sb.toString();
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
