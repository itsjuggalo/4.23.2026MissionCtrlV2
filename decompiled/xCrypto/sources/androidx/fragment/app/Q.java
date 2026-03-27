package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0846i;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0837z f7352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f7353b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7360i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f7364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7365n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f7366o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f7367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f7368q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList f7370s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f7354c = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7361j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7369r = false;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractComponentCallbacksC0828p f7372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7374d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7375e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7376f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7377g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public AbstractC0846i.b f7378h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public AbstractC0846i.b f7379i;

        public a() {
        }

        public a(int i4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
            this.f7371a = i4;
            this.f7372b = abstractComponentCallbacksC0828p;
            this.f7373c = false;
            AbstractC0846i.b bVar = AbstractC0846i.b.RESUMED;
            this.f7378h = bVar;
            this.f7379i = bVar;
        }

        public a(int i4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, boolean z4) {
            this.f7371a = i4;
            this.f7372b = abstractComponentCallbacksC0828p;
            this.f7373c = z4;
            AbstractC0846i.b bVar = AbstractC0846i.b.RESUMED;
            this.f7378h = bVar;
            this.f7379i = bVar;
        }
    }

    public Q(AbstractC0837z abstractC0837z, ClassLoader classLoader) {
        this.f7352a = abstractC0837z;
        this.f7353b = classLoader;
    }

    public Q b(int i4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, String str) {
        k(i4, abstractComponentCallbacksC0828p, str, 1);
        return this;
    }

    public Q c(ViewGroup viewGroup, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, String str) {
        abstractComponentCallbacksC0828p.mContainer = viewGroup;
        return b(viewGroup.getId(), abstractComponentCallbacksC0828p, str);
    }

    public Q d(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, String str) {
        k(0, abstractComponentCallbacksC0828p, str, 1);
        return this;
    }

    public void e(a aVar) {
        this.f7354c.add(aVar);
        aVar.f7374d = this.f7355d;
        aVar.f7375e = this.f7356e;
        aVar.f7376f = this.f7357f;
        aVar.f7377g = this.f7358g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public Q j() {
        if (this.f7360i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f7361j = false;
        return this;
    }

    public void k(int i4, AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, String str, int i5) {
        String str2 = abstractComponentCallbacksC0828p.mPreviousWho;
        if (str2 != null) {
            Y.c.f(abstractComponentCallbacksC0828p, str2);
        }
        Class<?> cls = abstractComponentCallbacksC0828p.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = abstractComponentCallbacksC0828p.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + abstractComponentCallbacksC0828p + ": was " + abstractComponentCallbacksC0828p.mTag + " now " + str);
            }
            abstractComponentCallbacksC0828p.mTag = str;
        }
        if (i4 != 0) {
            if (i4 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + abstractComponentCallbacksC0828p + " with tag " + str + " to container view with no id");
            }
            int i6 = abstractComponentCallbacksC0828p.mFragmentId;
            if (i6 != 0 && i6 != i4) {
                throw new IllegalStateException("Can't change container ID of fragment " + abstractComponentCallbacksC0828p + ": was " + abstractComponentCallbacksC0828p.mFragmentId + " now " + i4);
            }
            abstractComponentCallbacksC0828p.mFragmentId = i4;
            abstractComponentCallbacksC0828p.mContainerId = i4;
        }
        e(new a(i5, abstractComponentCallbacksC0828p));
    }

    public Q l(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        e(new a(3, abstractComponentCallbacksC0828p));
        return this;
    }

    public Q m(boolean z4) {
        this.f7369r = z4;
        return this;
    }
}
