package w6;

import I6.AbstractC0613d0;
import I6.S;
import R5.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f24079a = new i();

    public static final S d(O5.l lVar, H it) {
        AbstractC2304t.f(it, "it");
        AbstractC0613d0 abstractC0613d0P = it.q().P(lVar);
        AbstractC2304t.e(abstractC0613d0P, "getPrimitiveArrayKotlinType(...)");
        return abstractC0613d0P;
    }

    public static /* synthetic */ g f(i iVar, Object obj, H h8, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            h8 = null;
        }
        return iVar.e(obj, h8);
    }

    public final C2934b b(List value, S type) {
        AbstractC2304t.f(value, "value");
        AbstractC2304t.f(type, "type");
        return new z(value, type);
    }

    public final C2934b c(List list, H h8, O5.l lVar) {
        List listG0 = p5.z.G0(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listG0.iterator();
        while (it.hasNext()) {
            g gVarF = f(this, it.next(), null, 2, null);
            if (gVarF != null) {
                arrayList.add(gVarF);
            }
        }
        if (h8 == null) {
            return new C2934b(arrayList, new h(lVar));
        }
        AbstractC0613d0 abstractC0613d0P = h8.q().P(lVar);
        AbstractC2304t.e(abstractC0613d0P, "getPrimitiveArrayKotlinType(...)");
        return new z(arrayList, abstractC0613d0P);
    }

    public final g e(Object obj, H h8) {
        List listM0;
        O5.l lVar;
        if (obj instanceof Byte) {
            return new C2936d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new w(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new n(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new t(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new C2937e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new m(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new j(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new C2935c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new x((String) obj);
        }
        if (obj instanceof byte[]) {
            listM0 = AbstractC2592n.e0((byte[]) obj);
            lVar = O5.l.f6061i;
        } else if (obj instanceof short[]) {
            listM0 = AbstractC2592n.l0((short[]) obj);
            lVar = O5.l.f6062j;
        } else if (obj instanceof int[]) {
            listM0 = AbstractC2592n.i0((int[]) obj);
            lVar = O5.l.f6063k;
        } else if (obj instanceof long[]) {
            listM0 = AbstractC2592n.j0((long[]) obj);
            lVar = O5.l.f6065m;
        } else if (obj instanceof char[]) {
            listM0 = AbstractC2592n.f0((char[]) obj);
            lVar = O5.l.f6060h;
        } else if (obj instanceof float[]) {
            listM0 = AbstractC2592n.h0((float[]) obj);
            lVar = O5.l.f6064l;
        } else if (obj instanceof double[]) {
            listM0 = AbstractC2592n.g0((double[]) obj);
            lVar = O5.l.f6066n;
        } else {
            if (!(obj instanceof boolean[])) {
                if (obj == null) {
                    return new u();
                }
                return null;
            }
            listM0 = AbstractC2592n.m0((boolean[]) obj);
            lVar = O5.l.f6059g;
        }
        return c(listM0, h8, lVar);
    }
}
