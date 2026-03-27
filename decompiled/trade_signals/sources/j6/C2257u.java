package j6;

import j6.AbstractC2255s;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;
import z6.C3020d;
import z6.EnumC3021e;

/* JADX INFO: renamed from: j6.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2257u implements InterfaceC2256t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2257u f20231a = new C2257u();

    /* JADX INFO: renamed from: j6.u$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20232a;

        static {
            int[] iArr = new int[O5.l.values().length];
            try {
                iArr[O5.l.f6059g.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[O5.l.f6060h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[O5.l.f6061i.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[O5.l.f6062j.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[O5.l.f6063k.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[O5.l.f6064l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[O5.l.f6065m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[O5.l.f6066n.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f20232a = iArr;
        }
    }

    @Override // j6.InterfaceC2256t
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC2255s d(AbstractC2255s possiblyPrimitiveType) {
        AbstractC2304t.f(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (!(possiblyPrimitiveType instanceof AbstractC2255s.d)) {
            return possiblyPrimitiveType;
        }
        AbstractC2255s.d dVar = (AbstractC2255s.d) possiblyPrimitiveType;
        if (dVar.i() == null) {
            return possiblyPrimitiveType;
        }
        String strF = C3020d.c(dVar.i().m()).f();
        AbstractC2304t.e(strF, "getInternalName(...)");
        return c(strF);
    }

    @Override // j6.InterfaceC2256t
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC2255s b(String representation) {
        EnumC3021e enumC3021e;
        AbstractC2304t.f(representation, "representation");
        representation.length();
        char cCharAt = representation.charAt(0);
        EnumC3021e[] enumC3021eArrValues = EnumC3021e.values();
        int length = enumC3021eArrValues.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                enumC3021e = null;
                break;
            }
            enumC3021e = enumC3021eArrValues[i8];
            if (enumC3021e.i().charAt(0) == cCharAt) {
                break;
            }
            i8++;
        }
        if (enumC3021e != null) {
            return new AbstractC2255s.d(enumC3021e);
        }
        if (cCharAt == 'V') {
            return new AbstractC2255s.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = representation.substring(1);
            AbstractC2304t.e(strSubstring, "substring(...)");
            return new AbstractC2255s.a(b(strSubstring));
        }
        if (cCharAt == 'L') {
            V6.C.O(representation, ';', false, 2, null);
        }
        String strSubstring2 = representation.substring(1, representation.length() - 1);
        AbstractC2304t.e(strSubstring2, "substring(...)");
        return new AbstractC2255s.c(strSubstring2);
    }

    @Override // j6.InterfaceC2256t
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public AbstractC2255s.c c(String internalName) {
        AbstractC2304t.f(internalName, "internalName");
        return new AbstractC2255s.c(internalName);
    }

    @Override // j6.InterfaceC2256t
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public AbstractC2255s f(O5.l primitiveType) {
        AbstractC2304t.f(primitiveType, "primitiveType");
        switch (a.f20232a[primitiveType.ordinal()]) {
            case 1:
                return AbstractC2255s.f20219a.a();
            case 2:
                return AbstractC2255s.f20219a.c();
            case 3:
                return AbstractC2255s.f20219a.b();
            case 4:
                return AbstractC2255s.f20219a.h();
            case 5:
                return AbstractC2255s.f20219a.f();
            case 6:
                return AbstractC2255s.f20219a.e();
            case 7:
                return AbstractC2255s.f20219a.g();
            case 8:
                return AbstractC2255s.f20219a.d();
            default:
                throw new C2487o();
        }
    }

    @Override // j6.InterfaceC2256t
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC2255s e() {
        return c("java/lang/Class");
    }

    @Override // j6.InterfaceC2256t
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public String a(AbstractC2255s type) {
        StringBuilder sb;
        String strI;
        AbstractC2304t.f(type, "type");
        if (type instanceof AbstractC2255s.a) {
            sb = new StringBuilder();
            sb.append('[');
            sb.append(a(((AbstractC2255s.a) type).i()));
        } else {
            if (type instanceof AbstractC2255s.d) {
                EnumC3021e enumC3021eI = ((AbstractC2255s.d) type).i();
                return (enumC3021eI == null || (strI = enumC3021eI.i()) == null) ? "V" : strI;
            }
            if (!(type instanceof AbstractC2255s.c)) {
                throw new C2487o();
            }
            sb = new StringBuilder();
            sb.append('L');
            sb.append(((AbstractC2255s.c) type).i());
            sb.append(';');
        }
        return sb.toString();
    }
}
