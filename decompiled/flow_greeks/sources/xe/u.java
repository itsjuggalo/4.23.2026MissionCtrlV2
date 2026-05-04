package xe;

import xe.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f24924a = new u();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24925a;

        static {
            int[] iArr = new int[ce.l.values().length];
            try {
                iArr[ce.l.f3919g.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ce.l.f3920h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ce.l.f3921i.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ce.l.f3922j.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ce.l.f3923k.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ce.l.f3924l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ce.l.f3925m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ce.l.f3926n.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f24925a = iArr;
        }
    }

    @Override // xe.t
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public s e(s possiblyPrimitiveType) {
        kotlin.jvm.internal.t.f(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (!(possiblyPrimitiveType instanceof s.d)) {
            return possiblyPrimitiveType;
        }
        s.d dVar = (s.d) possiblyPrimitiveType;
        if (dVar.i() == null) {
            return possiblyPrimitiveType;
        }
        String strF = of.d.c(dVar.i().l()).f();
        kotlin.jvm.internal.t.e(strF, "getInternalName(...)");
        return c(strF);
    }

    @Override // xe.t
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public s b(String representation) {
        of.e eVar;
        kotlin.jvm.internal.t.f(representation, "representation");
        representation.length();
        char cCharAt = representation.charAt(0);
        of.e[] eVarArrValues = of.e.values();
        int length = eVarArrValues.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                eVar = null;
                break;
            }
            eVar = eVarArrValues[i10];
            if (eVar.h().charAt(0) == cCharAt) {
                break;
            }
            i10++;
        }
        if (eVar != null) {
            return new s.d(eVar);
        }
        if (cCharAt == 'V') {
            return new s.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = representation.substring(1);
            kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
            return new s.a(b(strSubstring));
        }
        if (cCharAt == 'L') {
            kg.c0.S(representation, ';', false, 2, null);
        }
        String strSubstring2 = representation.substring(1, representation.length() - 1);
        kotlin.jvm.internal.t.e(strSubstring2, "substring(...)");
        return new s.c(strSubstring2);
    }

    @Override // xe.t
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public s.c c(String internalName) {
        kotlin.jvm.internal.t.f(internalName, "internalName");
        return new s.c(internalName);
    }

    @Override // xe.t
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public s d(ce.l primitiveType) {
        kotlin.jvm.internal.t.f(primitiveType, "primitiveType");
        switch (a.f24925a[primitiveType.ordinal()]) {
            case 1:
                return s.f24912a.a();
            case 2:
                return s.f24912a.c();
            case 3:
                return s.f24912a.b();
            case 4:
                return s.f24912a.h();
            case 5:
                return s.f24912a.f();
            case 6:
                return s.f24912a.e();
            case 7:
                return s.f24912a.g();
            case 8:
                return s.f24912a.d();
            default:
                throw new cd.o();
        }
    }

    @Override // xe.t
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public s f() {
        return c("java/lang/Class");
    }

    @Override // xe.t
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public String a(s type) {
        String strH;
        kotlin.jvm.internal.t.f(type, "type");
        if (type instanceof s.a) {
            return '[' + a(((s.a) type).i());
        }
        if (type instanceof s.d) {
            of.e eVarI = ((s.d) type).i();
            return (eVarI == null || (strH = eVarI.h()) == null) ? "V" : strH;
        }
        if (!(type instanceof s.c)) {
            throw new cd.o();
        }
        return 'L' + ((s.c) type).i() + ';';
    }
}
