package r0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import u.C1853a;

/* JADX INFO: renamed from: r0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1740n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AbstractC1738l f14452a = new C1728b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal f14453b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList f14454c = new ArrayList();

    public static void a(ViewGroup viewGroup, AbstractC1738l abstractC1738l) {
        if (f14454c.contains(viewGroup) || !H.E.x(viewGroup)) {
            return;
        }
        f14454c.add(viewGroup);
        if (abstractC1738l == null) {
            abstractC1738l = f14452a;
        }
        AbstractC1738l abstractC1738lClone = abstractC1738l.clone();
        d(viewGroup, abstractC1738lClone);
        AbstractC1737k.b(viewGroup, null);
        c(viewGroup, abstractC1738lClone);
    }

    public static C1853a b() {
        C1853a c1853a;
        WeakReference weakReference = (WeakReference) f14453b.get();
        if (weakReference != null && (c1853a = (C1853a) weakReference.get()) != null) {
            return c1853a;
        }
        C1853a c1853a2 = new C1853a();
        f14453b.set(new WeakReference(c1853a2));
        return c1853a2;
    }

    public static void c(ViewGroup viewGroup, AbstractC1738l abstractC1738l) {
        if (abstractC1738l == null || viewGroup == null) {
            return;
        }
        a aVar = new a(abstractC1738l, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void d(ViewGroup viewGroup, AbstractC1738l abstractC1738l) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((AbstractC1738l) it.next()).N(viewGroup);
            }
        }
        if (abstractC1738l != null) {
            abstractC1738l.k(viewGroup, true);
        }
        AbstractC1737k.a(viewGroup);
    }

    /* JADX INFO: renamed from: r0.n$a */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC1738l f14455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f14456b;

        /* JADX INFO: renamed from: r0.n$a$a, reason: collision with other inner class name */
        public class C0233a extends AbstractC1739m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C1853a f14457a;

            public C0233a(C1853a c1853a) {
                this.f14457a = c1853a;
            }

            @Override // r0.AbstractC1738l.f
            public void b(AbstractC1738l abstractC1738l) {
                ((ArrayList) this.f14457a.get(a.this.f14456b)).remove(abstractC1738l);
                abstractC1738l.P(this);
            }
        }

        public a(AbstractC1738l abstractC1738l, ViewGroup viewGroup) {
            this.f14455a = abstractC1738l;
            this.f14456b = viewGroup;
        }

        public final void a() {
            this.f14456b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f14456b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!AbstractC1740n.f14454c.remove(this.f14456b)) {
                return true;
            }
            C1853a c1853aB = AbstractC1740n.b();
            ArrayList arrayList = (ArrayList) c1853aB.get(this.f14456b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                c1853aB.put(this.f14456b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f14455a);
            this.f14455a.a(new C0233a(c1853aB));
            this.f14455a.k(this.f14456b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((AbstractC1738l) it.next()).R(this.f14456b);
                }
            }
            this.f14455a.O(this.f14456b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            AbstractC1740n.f14454c.remove(this.f14456b);
            ArrayList arrayList = (ArrayList) AbstractC1740n.b().get(this.f14456b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC1738l) it.next()).R(this.f14456b);
                }
            }
            this.f14455a.l(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
