package M3;

import H3.l;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f5347a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5348b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5349c = 0;

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

    public void a(View view, boolean z7) {
        d dVar = new d(view, z7);
        dVar.f(this.f5348b, this.f5349c);
        this.f5347a.add(dVar);
    }

    public void b(int i8) {
        float f8;
        ArrayList<d> arrayList = new ArrayList();
        for (d dVar : this.f5347a) {
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
        float f9 = 1.0f - ((r1 - 1) * 0.2f);
        l.d("VVGM (minFrac, maxFrac)", 0.2f, f9);
        float f10 = 0.0f;
        for (d dVar2 : arrayList) {
            float fA = dVar2.a() / iA;
            if (fA > f9) {
                f10 += fA - f9;
                f8 = f9;
            } else {
                f8 = fA;
            }
            if (fA < 0.2f) {
                float fMin = Math.min(0.2f - fA, f10);
                f10 -= fMin;
                f8 = fA + fMin;
            }
            l.d("\t(desired, granted)", fA, f8);
            dVar2.f(this.f5348b, (int) (f8 * i8));
        }
    }

    public int c() {
        int iA = 0;
        for (d dVar : this.f5347a) {
            if (!dVar.d()) {
                iA += dVar.a();
            }
        }
        return iA;
    }

    public int d() {
        Iterator it = this.f5347a.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += ((d) it.next()).a();
        }
        return iA;
    }

    public List e() {
        return this.f5347a;
    }

    public void f(int i8, int i9) {
        this.f5348b = i8;
        this.f5349c = i9;
        this.f5347a = new ArrayList();
    }
}
