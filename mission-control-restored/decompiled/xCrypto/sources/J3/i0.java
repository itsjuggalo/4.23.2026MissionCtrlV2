package J3;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.C1578c;
import kotlin.jvm.internal.C1579d;
import kotlin.jvm.internal.C1581f;
import kotlin.jvm.internal.C1586k;
import p3.InterfaceC1716c;
import r3.AbstractC1755b;
import s3.C1779a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f935a = X2.L.g(W2.t.a(kotlin.jvm.internal.G.b(String.class), G3.a.D(kotlin.jvm.internal.J.f13414a)), W2.t.a(kotlin.jvm.internal.G.b(Character.TYPE), G3.a.x(C1581f.f13420a)), W2.t.a(kotlin.jvm.internal.G.b(char[].class), G3.a.c()), W2.t.a(kotlin.jvm.internal.G.b(Double.TYPE), G3.a.y(C1586k.f13429a)), W2.t.a(kotlin.jvm.internal.G.b(double[].class), G3.a.d()), W2.t.a(kotlin.jvm.internal.G.b(Float.TYPE), G3.a.z(kotlin.jvm.internal.l.f13430a)), W2.t.a(kotlin.jvm.internal.G.b(float[].class), G3.a.e()), W2.t.a(kotlin.jvm.internal.G.b(Long.TYPE), G3.a.B(kotlin.jvm.internal.t.f13432a)), W2.t.a(kotlin.jvm.internal.G.b(long[].class), G3.a.h()), W2.t.a(kotlin.jvm.internal.G.b(W2.y.class), G3.a.s(W2.y.f5508b)), W2.t.a(kotlin.jvm.internal.G.b(W2.z.class), G3.a.n()), W2.t.a(kotlin.jvm.internal.G.b(Integer.TYPE), G3.a.A(kotlin.jvm.internal.q.f13431a)), W2.t.a(kotlin.jvm.internal.G.b(int[].class), G3.a.f()), W2.t.a(kotlin.jvm.internal.G.b(W2.w.class), G3.a.r(W2.w.f5503b)), W2.t.a(kotlin.jvm.internal.G.b(W2.x.class), G3.a.m()), W2.t.a(kotlin.jvm.internal.G.b(Short.TYPE), G3.a.C(kotlin.jvm.internal.I.f13413a)), W2.t.a(kotlin.jvm.internal.G.b(short[].class), G3.a.k()), W2.t.a(kotlin.jvm.internal.G.b(W2.B.class), G3.a.t(W2.B.f5458b)), W2.t.a(kotlin.jvm.internal.G.b(W2.C.class), G3.a.o()), W2.t.a(kotlin.jvm.internal.G.b(Byte.TYPE), G3.a.w(C1579d.f13418a)), W2.t.a(kotlin.jvm.internal.G.b(byte[].class), G3.a.b()), W2.t.a(kotlin.jvm.internal.G.b(W2.u.class), G3.a.q(W2.u.f5498b)), W2.t.a(kotlin.jvm.internal.G.b(W2.v.class), G3.a.l()), W2.t.a(kotlin.jvm.internal.G.b(Boolean.TYPE), G3.a.v(C1578c.f13417a)), W2.t.a(kotlin.jvm.internal.G.b(boolean[].class), G3.a.a()), W2.t.a(kotlin.jvm.internal.G.b(W2.E.class), G3.a.u(W2.E.f5463a)), W2.t.a(kotlin.jvm.internal.G.b(Void.class), G3.a.j()), W2.t.a(kotlin.jvm.internal.G.b(C1779a.class), G3.a.E(C1779a.f14679b)));

    public static final H3.e a(String serialName, H3.d kind) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(kind, "kind");
        c(serialName);
        return new h0(serialName, kind);
    }

    public static final String b(String str) {
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? AbstractC1755b.e(cCharAt) : String.valueOf(cCharAt)));
        String strSubstring = str.substring(1);
        kotlin.jvm.internal.r.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    public static final void c(String str) {
        Iterator it = f935a.keySet().iterator();
        while (it.hasNext()) {
            String strB = ((InterfaceC1716c) it.next()).b();
            kotlin.jvm.internal.r.c(strB);
            String strB2 = b(strB);
            if (r3.x.v(str, "kotlin." + strB2, true) || r3.x.v(str, strB2, true)) {
                throw new IllegalArgumentException(r3.q.i("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + str + " there already exist " + b(strB2) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }
}
