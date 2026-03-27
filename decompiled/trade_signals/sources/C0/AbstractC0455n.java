package C0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import w.C2882a;

/* JADX INFO: renamed from: C0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0455n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AbstractC0453l f558a = new C0443b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal f559b = new ThreadLocal();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList f560c = new ArrayList();

    public static void a(ViewGroup viewGroup, AbstractC0453l abstractC0453l) {
        if (f560c.contains(viewGroup) || !T.D.z(viewGroup)) {
            return;
        }
        f560c.add(viewGroup);
        if (abstractC0453l == null) {
            abstractC0453l = f558a;
        }
        AbstractC0453l abstractC0453lClone = abstractC0453l.clone();
        d(viewGroup, abstractC0453lClone);
        AbstractC0452k.b(viewGroup, null);
        c(viewGroup, abstractC0453lClone);
    }

    public static C2882a b() {
        C2882a c2882a;
        WeakReference weakReference = (WeakReference) f559b.get();
        if (weakReference != null && (c2882a = (C2882a) weakReference.get()) != null) {
            return c2882a;
        }
        C2882a c2882a2 = new C2882a();
        f559b.set(new WeakReference(c2882a2));
        return c2882a2;
    }

    public static void c(ViewGroup viewGroup, AbstractC0453l abstractC0453l) {
        if (abstractC0453l == null || viewGroup == null) {
            return;
        }
        a aVar = new a(abstractC0453l, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void d(ViewGroup viewGroup, AbstractC0453l abstractC0453l) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((AbstractC0453l) it.next()).Q(viewGroup);
            }
        }
        if (abstractC0453l != null) {
            abstractC0453l.m(viewGroup, true);
        }
        AbstractC0452k.a(viewGroup);
    }

    /* JADX INFO: renamed from: C0.n$a */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC0453l f561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f562b;

        /* JADX INFO: renamed from: C0.n$a$a, reason: collision with other inner class name */
        public class C0007a extends AbstractC0454m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C2882a f563a;

            public C0007a(C2882a c2882a) {
                this.f563a = c2882a;
            }

            @Override // C0.AbstractC0453l.f
            public void d(AbstractC0453l abstractC0453l) {
                ((ArrayList) this.f563a.get(a.this.f562b)).remove(abstractC0453l);
                abstractC0453l.S(this);
            }
        }

        public a(AbstractC0453l abstractC0453l, ViewGroup viewGroup) {
            this.f561a = abstractC0453l;
            this.f562b = viewGroup;
        }

        public final void a() {
            this.f562b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f562b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!AbstractC0455n.f560c.remove(this.f562b)) {
                return true;
            }
            C2882a c2882aB = AbstractC0455n.b();
            ArrayList arrayList = (ArrayList) c2882aB.get(this.f562b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                c2882aB.put(this.f562b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f561a);
            this.f561a.b(new C0007a(c2882aB));
            this.f561a.m(this.f562b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((AbstractC0453l) it.next()).U(this.f562b);
                }
            }
            this.f561a.R(this.f562b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            AbstractC0455n.f560c.remove(this.f562b);
            ArrayList arrayList = (ArrayList) AbstractC0455n.b().get(this.f562b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AbstractC0453l) it.next()).U(this.f562b);
                }
            }
            this.f561a.o(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
