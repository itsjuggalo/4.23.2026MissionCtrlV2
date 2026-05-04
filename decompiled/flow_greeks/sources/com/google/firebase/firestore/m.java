package com.google.firebase.firestore;

import a7.s;
import bb.d0;
import com.google.firebase.firestore.d;
import com.google.protobuf.s1;
import d9.q0;
import d9.y1;
import j9.u;
import j9.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n9.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseFirestore f6210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.a f6211b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6212a;

        static {
            int[] iArr = new int[d.a.values().length];
            f6212a = iArr;
            try {
                iArr[d.a.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6212a[d.a.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public m(FirebaseFirestore firebaseFirestore, d.a aVar) {
        this.f6210a = firebaseFirestore;
        this.f6211b = aVar;
    }

    public final List a(bb.b bVar) {
        ArrayList arrayList = new ArrayList(bVar.i0());
        Iterator it = bVar.h().iterator();
        while (it.hasNext()) {
            arrayList.add(f((d0) it.next()));
        }
        return arrayList;
    }

    public Map b(Map map) {
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            map2.put((String) entry.getKey(), f((d0) entry.getValue()));
        }
        return map2;
    }

    public final Object c(d0 d0Var) {
        j9.f fVarC = j9.f.c(d0Var.t0());
        j9.k kVarI = j9.k.i(d0Var.t0());
        j9.f fVarB = this.f6210a.B();
        if (!fVarC.equals(fVarB)) {
            v.e("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", kVarI.s(), fVarC.i(), fVarC.h(), fVarB.i(), fVarB.h());
        }
        return new c(kVarI, this.f6210a);
    }

    public final Object d(d0 d0Var) {
        int i10 = a.f6212a[this.f6211b.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            return e(u.a(d0Var));
        }
        d0 d0VarB = u.b(d0Var);
        if (d0VarB == null) {
            return null;
        }
        return f(d0VarB);
    }

    public final Object e(s1 s1Var) {
        return new s(s1Var.e0(), s1Var.d0());
    }

    public Object f(d0 d0Var) {
        switch (y.I(d0Var)) {
            case 0:
                return null;
            case 1:
                return Boolean.valueOf(d0Var.m0());
            case 2:
                return d0Var.w0().equals(d0.c.INTEGER_VALUE) ? Long.valueOf(d0Var.r0()) : Double.valueOf(d0Var.p0());
            case 3:
                return e(d0Var.v0());
            case 4:
                return d(d0Var);
            case 5:
                return d0Var.u0();
            case 6:
                return d9.e.b(d0Var.n0());
            case 7:
                return c(d0Var);
            case 8:
                return new q0(d0Var.q0().d0(), d0Var.q0().e0());
            case 9:
                return a(d0Var.l0());
            case 10:
                return g(d0Var.s0().d0());
            case 11:
                return b(d0Var.s0().d0());
            default:
                throw n9.b.a("Unknown value type: " + d0Var.w0(), new Object[0]);
        }
    }

    public y1 g(Map map) {
        List listH = ((d0) map.get("value")).l0().h();
        double[] dArr = new double[listH.size()];
        for (int i10 = 0; i10 < listH.size(); i10++) {
            dArr[i10] = ((d0) listH.get(i10)).p0();
        }
        return new y1(dArr);
    }
}
