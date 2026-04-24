package I0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import u.C2736a;

/* JADX INFO: renamed from: I0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0573n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AbstractC0571l f2836a = new C0561b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal f2837b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList f2838c = new ArrayList();

    public static void a(ViewGroup viewGroup, AbstractC0571l abstractC0571l) {
        if (f2838c.contains(viewGroup) || !Q.N.P(viewGroup)) {
            return;
        }
        f2838c.add(viewGroup);
        if (abstractC0571l == null) {
            abstractC0571l = f2836a;
        }
        AbstractC0571l abstractC0571lClone = abstractC0571l.clone();
        d(viewGroup, abstractC0571lClone);
        AbstractC0570k.b(viewGroup, null);
        c(viewGroup, abstractC0571lClone);
    }

    public static C2736a b() {
        C2736a c2736a;
        WeakReference weakReference = (WeakReference) f2837b.get();
        if (weakReference != null && (c2736a = (C2736a) weakReference.get()) != null) {
            return c2736a;
        }
        C2736a c2736a2 = new C2736a();
        f2837b.set(new WeakReference(c2736a2));
        return c2736a2;
    }

    public static void c(ViewGroup viewGroup, AbstractC0571l abstractC0571l) {
        if (abstractC0571l == null || viewGroup == null) {
            return;
        }
        a aVar = new a(abstractC0571l, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void d(ViewGroup viewGroup, AbstractC0571l abstractC0571l) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((AbstractC0571l) it.next()).N(viewGroup);
            }
        }
        if (abstractC0571l != null) {
            abstractC0571l.k(viewGroup, true);
        }
        AbstractC0570k.a(viewGroup);
    }

    /* JADX INFO: renamed from: I0.n$a */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC0571l f2839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f2840b;

        /* JADX INFO: renamed from: I0.n$a$a, reason: collision with other inner class name */
        public class C0028a extends AbstractC0572m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C2736a f2841a;

            public C0028a(C2736a c2736a) {
                this.f2841a = c2736a;
            }

            @Override // I0.AbstractC0571l.f
            public void e(AbstractC0571l abstractC0571l) {
                ((ArrayList) this.f2841a.get(a.this.f2840b)).remove(abstractC0571l);
                abstractC0571l.P(this);
            }
        }

        public a(AbstractC0571l abstractC0571l, ViewGroup viewGroup) {
            this.f2839a = abstractC0571l;
            this.f2840b = viewGroup;
        }

        public final void a() {
            this.f2840b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2840b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!AbstractC0573n.f2838c.remove(this.f2840b)) {
                return true;
            }
            C2736a c2736aB = AbstractC0573n.b();
            ArrayList arrayList = (ArrayList) c2736aB.get(this.f2840b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                c2736aB.put(this.f2840b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f2839a);
            this.f2839a.a(new C0028a(c2736aB));
            this.f2839a.k(this.f2840b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((AbstractC0571l) it.next()).R(this.f2840b);
                }
            }
            this.f2839a.O(this.f2840b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            AbstractC0573n.f2838c.remove(this.f2840b);
            ArrayList arrayList = (ArrayList) AbstractC0573n.b().get(this.f2840b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC0571l) it.next()).R(this.f2840b);
                }
            }
            this.f2839a.l(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
