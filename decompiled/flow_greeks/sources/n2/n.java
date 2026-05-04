package n2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f16582a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal f16583b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList f16584c = new ArrayList();

    public static void a(ViewGroup viewGroup, l lVar) {
        if (f16584c.contains(viewGroup) || !t0.c0.z(viewGroup)) {
            return;
        }
        f16584c.add(viewGroup);
        if (lVar == null) {
            lVar = f16582a;
        }
        l lVarClone = lVar.clone();
        d(viewGroup, lVarClone);
        k.b(viewGroup, null);
        c(viewGroup, lVarClone);
    }

    public static w.a b() {
        w.a aVar;
        WeakReference weakReference = (WeakReference) f16583b.get();
        if (weakReference != null && (aVar = (w.a) weakReference.get()) != null) {
            return aVar;
        }
        w.a aVar2 = new w.a();
        f16583b.set(new WeakReference(aVar2));
        return aVar2;
    }

    public static void c(ViewGroup viewGroup, l lVar) {
        if (lVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(lVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void d(ViewGroup viewGroup, l lVar) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((l) it.next()).P(viewGroup);
            }
        }
        if (lVar != null) {
            lVar.l(viewGroup, true);
        }
        k.a(viewGroup);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f16585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f16586b;

        /* JADX INFO: renamed from: n2.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0296a extends m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w.a f16587a;

            public C0296a(w.a aVar) {
                this.f16587a = aVar;
            }

            @Override // n2.l.f
            public void d(l lVar) {
                ((ArrayList) this.f16587a.get(a.this.f16586b)).remove(lVar);
                lVar.R(this);
            }
        }

        public a(l lVar, ViewGroup viewGroup) {
            this.f16585a = lVar;
            this.f16586b = viewGroup;
        }

        public final void a() {
            this.f16586b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f16586b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!n.f16584c.remove(this.f16586b)) {
                return true;
            }
            w.a aVarB = n.b();
            ArrayList arrayList = (ArrayList) aVarB.get(this.f16586b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                aVarB.put(this.f16586b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f16585a);
            this.f16585a.a(new C0296a(aVarB));
            this.f16585a.l(this.f16586b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).T(this.f16586b);
                }
            }
            this.f16585a.Q(this.f16586b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            n.f16584c.remove(this.f16586b);
            ArrayList arrayList = (ArrayList) n.b().get(this.f16586b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((l) it.next()).T(this.f16586b);
                }
            }
            this.f16585a.m(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
