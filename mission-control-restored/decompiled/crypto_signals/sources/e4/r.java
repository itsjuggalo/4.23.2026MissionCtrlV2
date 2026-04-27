package e4;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class r extends Z3.v {
    public static final r e = new r(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r f6332f = new r(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r f6333g = new r(2);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r f6334h = new r(3);
    public static final r i = new r(4);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6335d;

    public /* synthetic */ r(int i6) {
        this.f6335d = i6;
    }

    @Override // Z3.v
    public final Object f(byte b3, ByteBuffer byteBuffer) {
        Object obj;
        Object obj2;
        switch (this.f6335d) {
            case 0:
                switch (b3) {
                    case -128:
                        return C0575n.a((ArrayList) e(byteBuffer));
                    case -127:
                        return C0560B.a((ArrayList) e(byteBuffer));
                    case -126:
                        ArrayList arrayList = (ArrayList) e(byteBuffer);
                        C0561C c0561c = new C0561C();
                        c0561c.f6208a = (String) arrayList.get(0);
                        c0561c.f6209b = (String) arrayList.get(1);
                        obj = c0561c;
                        break;
                    case -125:
                        return D.a((ArrayList) e(byteBuffer));
                    case -124:
                        return E.a((ArrayList) e(byteBuffer));
                    case -123:
                        return F.a((ArrayList) e(byteBuffer));
                    case -122:
                        return G.a((ArrayList) e(byteBuffer));
                    case -121:
                        return H.a((ArrayList) e(byteBuffer));
                    case -120:
                        return I.a((ArrayList) e(byteBuffer));
                    case -119:
                        ArrayList arrayList2 = (ArrayList) e(byteBuffer);
                        J j4 = new J();
                        String str = (String) arrayList2.get(0);
                        if (str == null) {
                            throw new IllegalStateException("Nonnull field \"id\" is null.");
                        }
                        j4.f6239a = str;
                        obj = j4;
                        break;
                        break;
                    case -118:
                        return K.a((ArrayList) e(byteBuffer));
                    case -117:
                        return L.a((ArrayList) e(byteBuffer));
                    case -116:
                        return M.a((ArrayList) e(byteBuffer));
                    case -115:
                        return N.a((ArrayList) e(byteBuffer));
                    case -114:
                        return O.a((ArrayList) e(byteBuffer));
                    case -113:
                        return P.a((ArrayList) e(byteBuffer));
                    case -112:
                        return Q.a((ArrayList) e(byteBuffer));
                    case -111:
                        return S.a((ArrayList) e(byteBuffer));
                    default:
                        return super.f(b3, byteBuffer);
                }
                return obj;
            case 1:
                switch (b3) {
                    case -128:
                        return C0575n.a((ArrayList) e(byteBuffer));
                    case -127:
                        return C0560B.a((ArrayList) e(byteBuffer));
                    case -126:
                        ArrayList arrayList3 = (ArrayList) e(byteBuffer);
                        C0561C c0561c2 = new C0561C();
                        c0561c2.f6208a = (String) arrayList3.get(0);
                        c0561c2.f6209b = (String) arrayList3.get(1);
                        obj2 = c0561c2;
                        break;
                    case -125:
                        return D.a((ArrayList) e(byteBuffer));
                    case -124:
                        return E.a((ArrayList) e(byteBuffer));
                    case -123:
                        return F.a((ArrayList) e(byteBuffer));
                    case -122:
                        return G.a((ArrayList) e(byteBuffer));
                    case -121:
                        return H.a((ArrayList) e(byteBuffer));
                    case -120:
                        return I.a((ArrayList) e(byteBuffer));
                    case -119:
                        ArrayList arrayList4 = (ArrayList) e(byteBuffer);
                        J j6 = new J();
                        String str2 = (String) arrayList4.get(0);
                        if (str2 == null) {
                            throw new IllegalStateException("Nonnull field \"id\" is null.");
                        }
                        j6.f6239a = str2;
                        obj2 = j6;
                        break;
                        break;
                    case -118:
                        return K.a((ArrayList) e(byteBuffer));
                    case -117:
                        return L.a((ArrayList) e(byteBuffer));
                    case -116:
                        return M.a((ArrayList) e(byteBuffer));
                    case -115:
                        return N.a((ArrayList) e(byteBuffer));
                    case -114:
                        return O.a((ArrayList) e(byteBuffer));
                    case -113:
                        return P.a((ArrayList) e(byteBuffer));
                    case -112:
                        return Q.a((ArrayList) e(byteBuffer));
                    case -111:
                        return S.a((ArrayList) e(byteBuffer));
                    default:
                        return super.f(b3, byteBuffer);
                }
                return obj2;
            case 2:
                switch (b3) {
                    case -128:
                        return E.a((ArrayList) e(byteBuffer));
                    case -127:
                        return F.a((ArrayList) e(byteBuffer));
                    case -126:
                        return K.a((ArrayList) e(byteBuffer));
                    case -125:
                        return N.a((ArrayList) e(byteBuffer));
                    case -124:
                        return O.a((ArrayList) e(byteBuffer));
                    case -123:
                        return P.a((ArrayList) e(byteBuffer));
                    default:
                        return super.f(b3, byteBuffer);
                }
            case 3:
                return b3 != -128 ? super.f(b3, byteBuffer) : M.a((ArrayList) e(byteBuffer));
            default:
                switch (b3) {
                    case -128:
                        return C0575n.a((ArrayList) e(byteBuffer));
                    case -127:
                        return I.a((ArrayList) e(byteBuffer));
                    case -126:
                        ArrayList arrayList5 = (ArrayList) e(byteBuffer);
                        J j7 = new J();
                        String str3 = (String) arrayList5.get(0);
                        if (str3 == null) {
                            throw new IllegalStateException("Nonnull field \"id\" is null.");
                        }
                        j7.f6239a = str3;
                        return j7;
                    case -125:
                        return K.a((ArrayList) e(byteBuffer));
                    default:
                        return super.f(b3, byteBuffer);
                }
        }
    }

    @Override // Z3.v
    public final void k(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        switch (this.f6335d) {
            case 0:
                if (obj instanceof C0575n) {
                    byteArrayOutputStream.write(128);
                    k(byteArrayOutputStream, ((C0575n) obj).b());
                } else if (obj instanceof C0560B) {
                    byteArrayOutputStream.write(129);
                    C0560B c0560b = (C0560B) obj;
                    c0560b.getClass();
                    ArrayList arrayList = new ArrayList(2);
                    int i6 = c0560b.f6206a;
                    arrayList.add(i6 == 0 ? null : Integer.valueOf(S.i.c(i6)));
                    arrayList.add(c0560b.f6207b);
                    k(byteArrayOutputStream, arrayList);
                } else if (obj instanceof C0561C) {
                    byteArrayOutputStream.write(130);
                    C0561C c0561c = (C0561C) obj;
                    c0561c.getClass();
                    ArrayList arrayList2 = new ArrayList(2);
                    arrayList2.add(c0561c.f6208a);
                    arrayList2.add(c0561c.f6209b);
                    k(byteArrayOutputStream, arrayList2);
                } else if (obj instanceof D) {
                    byteArrayOutputStream.write(131);
                    k(byteArrayOutputStream, ((D) obj).b());
                } else if (obj instanceof E) {
                    byteArrayOutputStream.write(132);
                    k(byteArrayOutputStream, ((E) obj).b());
                } else if (obj instanceof F) {
                    byteArrayOutputStream.write(133);
                    k(byteArrayOutputStream, ((F) obj).b());
                } else if (obj instanceof G) {
                    byteArrayOutputStream.write(134);
                    k(byteArrayOutputStream, ((G) obj).b());
                } else if (obj instanceof H) {
                    byteArrayOutputStream.write(135);
                    k(byteArrayOutputStream, ((H) obj).b());
                } else if (obj instanceof I) {
                    byteArrayOutputStream.write(136);
                    k(byteArrayOutputStream, ((I) obj).b());
                } else if (obj instanceof J) {
                    byteArrayOutputStream.write(137);
                    J j4 = (J) obj;
                    j4.getClass();
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(j4.f6239a);
                    k(byteArrayOutputStream, arrayList3);
                } else if (obj instanceof K) {
                    byteArrayOutputStream.write(138);
                    k(byteArrayOutputStream, ((K) obj).b());
                } else if (obj instanceof L) {
                    byteArrayOutputStream.write(139);
                    L l6 = (L) obj;
                    l6.getClass();
                    ArrayList arrayList4 = new ArrayList(3);
                    arrayList4.add(l6.f6242a);
                    arrayList4.add(l6.f6243b);
                    arrayList4.add(l6.f6244c);
                    k(byteArrayOutputStream, arrayList4);
                } else if (obj instanceof M) {
                    byteArrayOutputStream.write(140);
                    k(byteArrayOutputStream, ((M) obj).b());
                } else if (obj instanceof N) {
                    byteArrayOutputStream.write(141);
                    k(byteArrayOutputStream, ((N) obj).b());
                } else if (obj instanceof O) {
                    byteArrayOutputStream.write(142);
                    k(byteArrayOutputStream, ((O) obj).b());
                } else if (obj instanceof P) {
                    byteArrayOutputStream.write(143);
                    k(byteArrayOutputStream, ((P) obj).b());
                } else if (obj instanceof Q) {
                    byteArrayOutputStream.write(144);
                    Q q6 = (Q) obj;
                    q6.getClass();
                    ArrayList arrayList5 = new ArrayList(4);
                    arrayList5.add(q6.f6264a);
                    arrayList5.add(q6.f6265b);
                    arrayList5.add(q6.f6266c);
                    arrayList5.add(q6.f6267d);
                    k(byteArrayOutputStream, arrayList5);
                } else if (!(obj instanceof S)) {
                    super.k(byteArrayOutputStream, obj);
                } else {
                    byteArrayOutputStream.write(145);
                    k(byteArrayOutputStream, ((S) obj).b());
                }
                break;
            case 1:
                if (obj instanceof C0575n) {
                    byteArrayOutputStream.write(128);
                    k(byteArrayOutputStream, ((C0575n) obj).b());
                } else if (obj instanceof C0560B) {
                    byteArrayOutputStream.write(129);
                    C0560B c0560b2 = (C0560B) obj;
                    c0560b2.getClass();
                    ArrayList arrayList6 = new ArrayList(2);
                    int i7 = c0560b2.f6206a;
                    arrayList6.add(i7 == 0 ? null : Integer.valueOf(S.i.c(i7)));
                    arrayList6.add(c0560b2.f6207b);
                    k(byteArrayOutputStream, arrayList6);
                } else if (obj instanceof C0561C) {
                    byteArrayOutputStream.write(130);
                    C0561C c0561c2 = (C0561C) obj;
                    c0561c2.getClass();
                    ArrayList arrayList7 = new ArrayList(2);
                    arrayList7.add(c0561c2.f6208a);
                    arrayList7.add(c0561c2.f6209b);
                    k(byteArrayOutputStream, arrayList7);
                } else if (obj instanceof D) {
                    byteArrayOutputStream.write(131);
                    k(byteArrayOutputStream, ((D) obj).b());
                } else if (obj instanceof E) {
                    byteArrayOutputStream.write(132);
                    k(byteArrayOutputStream, ((E) obj).b());
                } else if (obj instanceof F) {
                    byteArrayOutputStream.write(133);
                    k(byteArrayOutputStream, ((F) obj).b());
                } else if (obj instanceof G) {
                    byteArrayOutputStream.write(134);
                    k(byteArrayOutputStream, ((G) obj).b());
                } else if (obj instanceof H) {
                    byteArrayOutputStream.write(135);
                    k(byteArrayOutputStream, ((H) obj).b());
                } else if (obj instanceof I) {
                    byteArrayOutputStream.write(136);
                    k(byteArrayOutputStream, ((I) obj).b());
                } else if (obj instanceof J) {
                    byteArrayOutputStream.write(137);
                    J j6 = (J) obj;
                    j6.getClass();
                    ArrayList arrayList8 = new ArrayList(1);
                    arrayList8.add(j6.f6239a);
                    k(byteArrayOutputStream, arrayList8);
                } else if (obj instanceof K) {
                    byteArrayOutputStream.write(138);
                    k(byteArrayOutputStream, ((K) obj).b());
                } else if (obj instanceof L) {
                    byteArrayOutputStream.write(139);
                    L l7 = (L) obj;
                    l7.getClass();
                    ArrayList arrayList9 = new ArrayList(3);
                    arrayList9.add(l7.f6242a);
                    arrayList9.add(l7.f6243b);
                    arrayList9.add(l7.f6244c);
                    k(byteArrayOutputStream, arrayList9);
                } else if (obj instanceof M) {
                    byteArrayOutputStream.write(140);
                    k(byteArrayOutputStream, ((M) obj).b());
                } else if (obj instanceof N) {
                    byteArrayOutputStream.write(141);
                    k(byteArrayOutputStream, ((N) obj).b());
                } else if (obj instanceof O) {
                    byteArrayOutputStream.write(142);
                    k(byteArrayOutputStream, ((O) obj).b());
                } else if (obj instanceof P) {
                    byteArrayOutputStream.write(143);
                    k(byteArrayOutputStream, ((P) obj).b());
                } else if (obj instanceof Q) {
                    byteArrayOutputStream.write(144);
                    Q q7 = (Q) obj;
                    q7.getClass();
                    ArrayList arrayList10 = new ArrayList(4);
                    arrayList10.add(q7.f6264a);
                    arrayList10.add(q7.f6265b);
                    arrayList10.add(q7.f6266c);
                    arrayList10.add(q7.f6267d);
                    k(byteArrayOutputStream, arrayList10);
                } else if (!(obj instanceof S)) {
                    super.k(byteArrayOutputStream, obj);
                } else {
                    byteArrayOutputStream.write(145);
                    k(byteArrayOutputStream, ((S) obj).b());
                }
                break;
            case 2:
                if (obj instanceof E) {
                    byteArrayOutputStream.write(128);
                    k(byteArrayOutputStream, ((E) obj).b());
                } else if (obj instanceof F) {
                    byteArrayOutputStream.write(129);
                    k(byteArrayOutputStream, ((F) obj).b());
                } else if (obj instanceof K) {
                    byteArrayOutputStream.write(130);
                    k(byteArrayOutputStream, ((K) obj).b());
                } else if (obj instanceof N) {
                    byteArrayOutputStream.write(131);
                    k(byteArrayOutputStream, ((N) obj).b());
                } else if (obj instanceof O) {
                    byteArrayOutputStream.write(132);
                    k(byteArrayOutputStream, ((O) obj).b());
                } else if (!(obj instanceof P)) {
                    super.k(byteArrayOutputStream, obj);
                } else {
                    byteArrayOutputStream.write(133);
                    k(byteArrayOutputStream, ((P) obj).b());
                }
                break;
            case 3:
                if (!(obj instanceof M)) {
                    super.k(byteArrayOutputStream, obj);
                } else {
                    byteArrayOutputStream.write(128);
                    k(byteArrayOutputStream, ((M) obj).b());
                }
                break;
            default:
                if (obj instanceof C0575n) {
                    byteArrayOutputStream.write(128);
                    k(byteArrayOutputStream, ((C0575n) obj).b());
                } else if (obj instanceof I) {
                    byteArrayOutputStream.write(129);
                    k(byteArrayOutputStream, ((I) obj).b());
                } else if (obj instanceof J) {
                    byteArrayOutputStream.write(130);
                    J j7 = (J) obj;
                    j7.getClass();
                    ArrayList arrayList11 = new ArrayList(1);
                    arrayList11.add(j7.f6239a);
                    k(byteArrayOutputStream, arrayList11);
                } else if (!(obj instanceof K)) {
                    super.k(byteArrayOutputStream, obj);
                } else {
                    byteArrayOutputStream.write(131);
                    k(byteArrayOutputStream, ((K) obj).b());
                }
                break;
        }
    }
}
