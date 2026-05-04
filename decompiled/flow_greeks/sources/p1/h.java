package p1;

import cd.h0;
import cd.o;
import dd.a0;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import l1.e0;
import o1.f;
import o1.g;
import o1.h;
import p1.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f18186a = new h();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18187a;

        static {
            int[] iArr = new int[h.b.values().length];
            try {
                iArr[h.b.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h.b.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[h.b.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[h.b.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[h.b.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[h.b.STRING_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[h.b.BYTES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[h.b.VALUE_NOT_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f18187a = iArr;
        }
    }

    @Override // l1.e0
    public Object a(InputStream inputStream, gd.e eVar) throws l1.d {
        o1.f fVarA = o1.d.f17447a.a(inputStream);
        c cVarB = g.b(new f.b[0]);
        Map mapR = fVarA.R();
        t.e(mapR, "preferencesProto.preferencesMap");
        for (Map.Entry entry : mapR.entrySet()) {
            String name = (String) entry.getKey();
            o1.h value = (o1.h) entry.getValue();
            h hVar = f18186a;
            t.e(name, "name");
            t.e(value, "value");
            hVar.d(name, value, cVarB);
        }
        return cVarB.d();
    }

    public final void d(String str, o1.h hVar, c cVar) throws l1.d {
        h.b bVarG0 = hVar.g0();
        switch (bVarG0 == null ? -1 : a.f18187a[bVarG0.ordinal()]) {
            case -1:
                throw new l1.d("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new o();
            case 1:
                cVar.j(i.a(str), Boolean.valueOf(hVar.X()));
                return;
            case 2:
                cVar.j(i.d(str), Float.valueOf(hVar.b0()));
                return;
            case 3:
                cVar.j(i.c(str), Double.valueOf(hVar.a0()));
                return;
            case 4:
                cVar.j(i.e(str), Integer.valueOf(hVar.c0()));
                return;
            case 5:
                cVar.j(i.f(str), Long.valueOf(hVar.d0()));
                return;
            case 6:
                f.a aVarG = i.g(str);
                String strE0 = hVar.e0();
                t.e(strE0, "value.string");
                cVar.j(aVarG, strE0);
                return;
            case 7:
                f.a aVarH = i.h(str);
                List listT = hVar.f0().T();
                t.e(listT, "value.stringSet.stringsList");
                cVar.j(aVarH, a0.N0(listT));
                return;
            case 8:
                f.a aVarB = i.b(str);
                byte[] bArrY = hVar.Y().y();
                t.e(bArrY, "value.bytes.toByteArray()");
                cVar.j(aVarB, bArrY);
                return;
            case 9:
                throw new l1.d("Value not set.", null, 2, null);
        }
    }

    @Override // l1.e0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public f b() {
        return g.a();
    }

    public final o1.h f(Object obj) {
        if (obj instanceof Boolean) {
            androidx.datastore.preferences.protobuf.t tVarI = o1.h.h0().q(((Boolean) obj).booleanValue()).i();
            t.e(tVarI, "newBuilder().setBoolean(value).build()");
            return (o1.h) tVarI;
        }
        if (obj instanceof Float) {
            androidx.datastore.preferences.protobuf.t tVarI2 = o1.h.h0().t(((Number) obj).floatValue()).i();
            t.e(tVarI2, "newBuilder().setFloat(value).build()");
            return (o1.h) tVarI2;
        }
        if (obj instanceof Double) {
            androidx.datastore.preferences.protobuf.t tVarI3 = o1.h.h0().s(((Number) obj).doubleValue()).i();
            t.e(tVarI3, "newBuilder().setDouble(value).build()");
            return (o1.h) tVarI3;
        }
        if (obj instanceof Integer) {
            androidx.datastore.preferences.protobuf.t tVarI4 = o1.h.h0().v(((Number) obj).intValue()).i();
            t.e(tVarI4, "newBuilder().setInteger(value).build()");
            return (o1.h) tVarI4;
        }
        if (obj instanceof Long) {
            androidx.datastore.preferences.protobuf.t tVarI5 = o1.h.h0().w(((Number) obj).longValue()).i();
            t.e(tVarI5, "newBuilder().setLong(value).build()");
            return (o1.h) tVarI5;
        }
        if (obj instanceof String) {
            androidx.datastore.preferences.protobuf.t tVarI6 = o1.h.h0().x((String) obj).i();
            t.e(tVarI6, "newBuilder().setString(value).build()");
            return (o1.h) tVarI6;
        }
        if (obj instanceof Set) {
            h.a aVarH0 = o1.h.h0();
            g.a aVarU = o1.g.U();
            t.d(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            androidx.datastore.preferences.protobuf.t tVarI7 = aVarH0.y(aVarU.q((Set) obj)).i();
            t.e(tVarI7, "newBuilder()\n           …                 .build()");
            return (o1.h) tVarI7;
        }
        if (obj instanceof byte[]) {
            androidx.datastore.preferences.protobuf.t tVarI8 = o1.h.h0().r(androidx.datastore.preferences.protobuf.f.f((byte[]) obj)).i();
            t.e(tVarI8, "newBuilder().setBytes(By….copyFrom(value)).build()");
            return (o1.h) tVarI8;
        }
        throw new IllegalStateException("PreferencesSerializer does not support type: " + obj.getClass().getName());
    }

    @Override // l1.e0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Object c(f fVar, OutputStream outputStream, gd.e eVar) {
        Map mapA = fVar.a();
        f.a aVarU = o1.f.U();
        for (Map.Entry entry : mapA.entrySet()) {
            aVarU.q(((f.a) entry.getKey()).a(), f(entry.getValue()));
        }
        ((o1.f) aVarU.i()).i(outputStream);
        return h0.f3852a;
    }
}
