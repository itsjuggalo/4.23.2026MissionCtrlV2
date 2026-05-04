package z9;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import u9.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f25611a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25612b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25613c = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            if (dVar.a() > dVar2.a()) {
                return -1;
            }
            return dVar.a() < dVar2.a() ? 1 : 0;
        }
    }

    public void a(View view, boolean z10) {
        d dVar = new d(view, z10);
        dVar.f(this.f25612b, this.f25613c);
        this.f25611a.add(dVar);
    }

    public void b(int i10) {
        float f10;
        ArrayList<d> arrayList = new ArrayList();
        for (d dVar : this.f25611a) {
            if (dVar.d()) {
                arrayList.add(dVar);
            }
        }
        Collections.sort(arrayList, new a());
        Iterator it = arrayList.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += ((d) it.next()).a();
        }
        if (arrayList.size() >= 6) {
            throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
        }
        float f11 = 1.0f - ((r1 - 1) * 0.2f);
        l.d("VVGM (minFrac, maxFrac)", 0.2f, f11);
        float f12 = 0.0f;
        for (d dVar2 : arrayList) {
            float fA = dVar2.a() / iA;
            if (fA > f11) {
                f12 += fA - f11;
                f10 = f11;
            } else {
                f10 = fA;
            }
            if (fA < 0.2f) {
                float fMin = Math.min(0.2f - fA, f12);
                f12 -= fMin;
                f10 = fA + fMin;
            }
            l.d("\t(desired, granted)", fA, f10);
            dVar2.f(this.f25612b, (int) (f10 * i10));
        }
    }

    public int c() {
        int iA = 0;
        for (d dVar : this.f25611a) {
            if (!dVar.d()) {
                iA += dVar.a();
            }
        }
        return iA;
    }

    public int d() {
        Iterator it = this.f25611a.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += ((d) it.next()).a();
        }
        return iA;
    }

    public List e() {
        return this.f25611a;
    }

    public void f(int i10, int i11) {
        this.f25612b = i10;
        this.f25613c = i11;
        this.f25611a = new ArrayList();
    }
}
