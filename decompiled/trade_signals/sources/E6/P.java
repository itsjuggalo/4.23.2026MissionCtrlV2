package E6;

import R5.AbstractC0862t;
import R5.AbstractC0863u;
import R5.InterfaceC0845b;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f952c;

        static {
            int[] iArr = new int[l6.j.values().length];
            try {
                iArr[l6.j.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[l6.j.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[l6.j.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[l6.j.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f950a = iArr;
            int[] iArr2 = new int[InterfaceC0845b.a.values().length];
            try {
                iArr2[InterfaceC0845b.a.DECLARATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[InterfaceC0845b.a.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[InterfaceC0845b.a.DELEGATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[InterfaceC0845b.a.SYNTHESIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f951b = iArr2;
            int[] iArr3 = new int[l6.x.values().length];
            try {
                iArr3[l6.x.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[l6.x.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[l6.x.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[l6.x.PROTECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[l6.x.PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[l6.x.LOCAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            f952c = iArr3;
        }
    }

    public static final AbstractC0863u a(O o8, l6.x xVar) {
        AbstractC0863u abstractC0863u;
        AbstractC2304t.f(o8, "<this>");
        int i8 = xVar == null ? -1 : a.f952c[xVar.ordinal()];
        String str = "PRIVATE";
        switch (i8) {
            case 1:
                abstractC0863u = AbstractC0862t.f7260d;
                str = "INTERNAL";
                break;
            case 2:
            default:
                abstractC0863u = AbstractC0862t.f7257a;
                break;
            case 3:
                abstractC0863u = AbstractC0862t.f7258b;
                str = "PRIVATE_TO_THIS";
                break;
            case 4:
                abstractC0863u = AbstractC0862t.f7259c;
                str = "PROTECTED";
                break;
            case 5:
                abstractC0863u = AbstractC0862t.f7261e;
                str = "PUBLIC";
                break;
            case 6:
                abstractC0863u = AbstractC0862t.f7262f;
                str = "LOCAL";
                break;
        }
        AbstractC2304t.e(abstractC0863u, str);
        return abstractC0863u;
    }

    public static final InterfaceC0845b.a b(O o8, l6.j jVar) {
        AbstractC2304t.f(o8, "<this>");
        int i8 = jVar == null ? -1 : a.f950a[jVar.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                return InterfaceC0845b.a.FAKE_OVERRIDE;
            }
            if (i8 == 3) {
                return InterfaceC0845b.a.DELEGATION;
            }
            if (i8 == 4) {
                return InterfaceC0845b.a.SYNTHESIZED;
            }
        }
        return InterfaceC0845b.a.DECLARATION;
    }
}
