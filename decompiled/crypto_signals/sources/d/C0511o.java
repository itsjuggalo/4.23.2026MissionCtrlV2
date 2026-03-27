package d;

import Z.C0270l;
import Z.G;
import Z.O;
import Z.P;
import Z.Z;
import Z.a0;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: renamed from: d.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0511o extends kotlin.jvm.internal.k implements R4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0517u f5926b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0511o(C0517u c0517u, int i) {
        super(1);
        this.f5925a = i;
        this.f5926b = c0517u;
    }

    @Override // R4.l
    public final Object invoke(Object obj) {
        Object objPrevious;
        Object objPrevious2;
        switch (this.f5925a) {
            case 0:
                kotlin.jvm.internal.j.e((C0498b) obj, "backEvent");
                C0517u c0517u = this.f5926b;
                H4.f fVar = c0517u.f5941b;
                fVar.getClass();
                ListIterator listIterator = fVar.listIterator(fVar.f575c);
                while (true) {
                    if (listIterator.hasPrevious()) {
                        objPrevious = listIterator.previous();
                        if (((G) objPrevious).f3708a) {
                        }
                    } else {
                        objPrevious = null;
                    }
                }
                G g2 = (G) objPrevious;
                if (c0517u.f5942c != null) {
                    c0517u.a();
                }
                c0517u.f5942c = g2;
                if (g2 != null) {
                    boolean zK = P.K(3);
                    P p3 = g2.f3711d;
                    if (zK) {
                        Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager " + p3);
                    }
                    p3.x();
                    p3.y(new O(p3), false);
                }
                return G4.l.f540a;
            default:
                C0498b backEvent = (C0498b) obj;
                kotlin.jvm.internal.j.e(backEvent, "backEvent");
                C0517u c0517u2 = this.f5926b;
                G g5 = c0517u2.f5942c;
                if (g5 == null) {
                    H4.f fVar2 = c0517u2.f5941b;
                    fVar2.getClass();
                    ListIterator listIterator2 = fVar2.listIterator(fVar2.f575c);
                    while (true) {
                        if (listIterator2.hasPrevious()) {
                            objPrevious2 = listIterator2.previous();
                            if (((G) objPrevious2).f3708a) {
                            }
                        } else {
                            objPrevious2 = null;
                        }
                    }
                    g5 = (G) objPrevious2;
                }
                if (g5 != null) {
                    boolean zK2 = P.K(2);
                    P p6 = g5.f3711d;
                    if (zK2) {
                        Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager " + p6);
                    }
                    if (p6.f3742h != null) {
                        for (C0270l c0270l : p6.f(new ArrayList(Collections.singletonList(p6.f3742h)), 0, 1)) {
                            c0270l.getClass();
                            if (P.K(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.f5880c);
                            }
                            ArrayList arrayList = c0270l.f3847c;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((a0) it.next()).getClass();
                                H4.n.e0(arrayList2, null);
                            }
                            List listO0 = H4.h.o0(H4.h.r0(arrayList2));
                            int size = listO0.size();
                            for (int i = 0; i < size; i++) {
                                ((Z) listO0.get(i)).b(backEvent, c0270l.f3845a);
                            }
                        }
                        Iterator it2 = p6.f3746m.iterator();
                        if (it2.hasNext()) {
                            it2.next().getClass();
                            throw new ClassCastException();
                        }
                    }
                }
                return G4.l.f540a;
        }
    }
}
