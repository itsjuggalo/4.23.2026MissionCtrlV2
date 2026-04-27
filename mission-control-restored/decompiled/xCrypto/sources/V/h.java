package V;

import S.A;
import S.C0518d;
import U.f;
import U.g;
import U.h;
import V.f;
import W2.E;
import W2.m;
import X2.x;
import androidx.datastore.preferences.protobuf.AbstractC0793f;
import androidx.datastore.preferences.protobuf.AbstractC0806t;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class h implements A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f5285a = new h();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5286a;

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
            f5286a = iArr;
        }
    }

    @Override // S.A
    public Object b(InputStream inputStream, Z2.e eVar) throws C0518d {
        U.f fVarA = U.d.f5234a.a(inputStream);
        c cVarB = g.b(new f.b[0]);
        Map mapN = fVarA.N();
        r.e(mapN, "preferencesProto.preferencesMap");
        for (Map.Entry entry : mapN.entrySet()) {
            String name = (String) entry.getKey();
            U.h value = (U.h) entry.getValue();
            h hVar = f5285a;
            r.e(name, "name");
            r.e(value, "value");
            hVar.d(name, value, cVarB);
        }
        return cVarB.d();
    }

    public final void d(String str, U.h hVar, c cVar) throws C0518d {
        h.b bVarC0 = hVar.c0();
        switch (bVarC0 == null ? -1 : a.f5286a[bVarC0.ordinal()]) {
            case -1:
                throw new C0518d("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new m();
            case 1:
                cVar.j(i.a(str), Boolean.valueOf(hVar.T()));
                return;
            case 2:
                cVar.j(i.d(str), Float.valueOf(hVar.X()));
                return;
            case 3:
                cVar.j(i.c(str), Double.valueOf(hVar.W()));
                return;
            case 4:
                cVar.j(i.e(str), Integer.valueOf(hVar.Y()));
                return;
            case 5:
                cVar.j(i.f(str), Long.valueOf(hVar.Z()));
                return;
            case 6:
                f.a aVarG = i.g(str);
                String strA0 = hVar.a0();
                r.e(strA0, "value.string");
                cVar.j(aVarG, strA0);
                return;
            case 7:
                f.a aVarH = i.h(str);
                List listP = hVar.b0().P();
                r.e(listP, "value.stringSet.stringsList");
                cVar.j(aVarH, x.l0(listP));
                return;
            case 8:
                f.a aVarB = i.b(str);
                byte[] bArrU = hVar.U().u();
                r.e(bArrU, "value.bytes.toByteArray()");
                cVar.j(aVarB, bArrU);
                return;
            case 9:
                throw new C0518d("Value not set.", null, 2, null);
        }
    }

    @Override // S.A
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public f a() {
        return g.a();
    }

    public final U.h f(Object obj) {
        if (obj instanceof Boolean) {
            AbstractC0806t abstractC0806tE = U.h.d0().m(((Boolean) obj).booleanValue()).e();
            r.e(abstractC0806tE, "newBuilder().setBoolean(value).build()");
            return (U.h) abstractC0806tE;
        }
        if (obj instanceof Float) {
            AbstractC0806t abstractC0806tE2 = U.h.d0().p(((Number) obj).floatValue()).e();
            r.e(abstractC0806tE2, "newBuilder().setFloat(value).build()");
            return (U.h) abstractC0806tE2;
        }
        if (obj instanceof Double) {
            AbstractC0806t abstractC0806tE3 = U.h.d0().o(((Number) obj).doubleValue()).e();
            r.e(abstractC0806tE3, "newBuilder().setDouble(value).build()");
            return (U.h) abstractC0806tE3;
        }
        if (obj instanceof Integer) {
            AbstractC0806t abstractC0806tE4 = U.h.d0().q(((Number) obj).intValue()).e();
            r.e(abstractC0806tE4, "newBuilder().setInteger(value).build()");
            return (U.h) abstractC0806tE4;
        }
        if (obj instanceof Long) {
            AbstractC0806t abstractC0806tE5 = U.h.d0().r(((Number) obj).longValue()).e();
            r.e(abstractC0806tE5, "newBuilder().setLong(value).build()");
            return (U.h) abstractC0806tE5;
        }
        if (obj instanceof String) {
            AbstractC0806t abstractC0806tE6 = U.h.d0().s((String) obj).e();
            r.e(abstractC0806tE6, "newBuilder().setString(value).build()");
            return (U.h) abstractC0806tE6;
        }
        if (obj instanceof Set) {
            h.a aVarD0 = U.h.d0();
            g.a aVarQ = U.g.Q();
            r.d(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            AbstractC0806t abstractC0806tE7 = aVarD0.t(aVarQ.m((Set) obj)).e();
            r.e(abstractC0806tE7, "newBuilder()\n           …                 .build()");
            return (U.h) abstractC0806tE7;
        }
        if (obj instanceof byte[]) {
            AbstractC0806t abstractC0806tE8 = U.h.d0().n(AbstractC0793f.l((byte[]) obj)).e();
            r.e(abstractC0806tE8, "newBuilder().setBytes(By….copyFrom(value)).build()");
            return (U.h) abstractC0806tE8;
        }
        throw new IllegalStateException("PreferencesSerializer does not support type: " + obj.getClass().getName());
    }

    @Override // S.A
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Object c(f fVar, OutputStream outputStream, Z2.e eVar) {
        Map mapA = fVar.a();
        f.a aVarQ = U.f.Q();
        for (Map.Entry entry : mapA.entrySet()) {
            aVarQ.m(((f.a) entry.getKey()).a(), f(entry.getValue()));
        }
        ((U.f) aVarQ.e()).e(outputStream);
        return E.f5463a;
    }
}
