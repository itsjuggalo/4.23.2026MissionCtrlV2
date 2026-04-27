package m0;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0963i;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: renamed from: m0.P, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2198P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2225y f18628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f18629b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f18636i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f18638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f18640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f18641n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f18642o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f18643p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f18644q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList f18646s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f18630c = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18637j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f18645r = false;

    /* JADX INFO: renamed from: m0.P$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AbstractComponentCallbacksC2216p f18648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f18651e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18652f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f18653g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public AbstractC0963i.b f18654h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public AbstractC0963i.b f18655i;

        public a() {
        }

        public a(int i7, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
            this.f18647a = i7;
            this.f18648b = abstractComponentCallbacksC2216p;
            this.f18649c = false;
            AbstractC0963i.b bVar = AbstractC0963i.b.RESUMED;
            this.f18654h = bVar;
            this.f18655i = bVar;
        }

        public a(int i7, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, boolean z7) {
            this.f18647a = i7;
            this.f18648b = abstractComponentCallbacksC2216p;
            this.f18649c = z7;
            AbstractC0963i.b bVar = AbstractC0963i.b.RESUMED;
            this.f18654h = bVar;
            this.f18655i = bVar;
        }
    }

    public AbstractC2198P(AbstractC2225y abstractC2225y, ClassLoader classLoader) {
        this.f18628a = abstractC2225y;
        this.f18629b = classLoader;
    }

    public AbstractC2198P b(int i7, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, String str) {
        k(i7, abstractComponentCallbacksC2216p, str, 1);
        return this;
    }

    public AbstractC2198P c(ViewGroup viewGroup, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, String str) {
        abstractComponentCallbacksC2216p.f18843I = viewGroup;
        return b(viewGroup.getId(), abstractComponentCallbacksC2216p, str);
    }

    public AbstractC2198P d(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, String str) {
        k(0, abstractComponentCallbacksC2216p, str, 1);
        return this;
    }

    public void e(a aVar) {
        this.f18630c.add(aVar);
        aVar.f18650d = this.f18631d;
        aVar.f18651e = this.f18632e;
        aVar.f18652f = this.f18633f;
        aVar.f18653g = this.f18634g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public AbstractC2198P j() {
        if (this.f18636i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f18637j = false;
        return this;
    }

    public void k(int i7, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, String str, int i8) {
        String str2 = abstractComponentCallbacksC2216p.f18853S;
        if (str2 != null) {
            n0.c.f(abstractComponentCallbacksC2216p, str2);
        }
        Class<?> cls = abstractComponentCallbacksC2216p.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = abstractComponentCallbacksC2216p.f18835A;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + abstractComponentCallbacksC2216p + ": was " + abstractComponentCallbacksC2216p.f18835A + " now " + str);
            }
            abstractComponentCallbacksC2216p.f18835A = str;
        }
        if (i7 != 0) {
            if (i7 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + abstractComponentCallbacksC2216p + " with tag " + str + " to container view with no id");
            }
            int i9 = abstractComponentCallbacksC2216p.f18888y;
            if (i9 != 0 && i9 != i7) {
                throw new IllegalStateException("Can't change container ID of fragment " + abstractComponentCallbacksC2216p + ": was " + abstractComponentCallbacksC2216p.f18888y + " now " + i7);
            }
            abstractComponentCallbacksC2216p.f18888y = i7;
            abstractComponentCallbacksC2216p.f18889z = i7;
        }
        e(new a(i8, abstractComponentCallbacksC2216p));
    }

    public AbstractC2198P l(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        e(new a(3, abstractComponentCallbacksC2216p));
        return this;
    }

    public AbstractC2198P m(int i7, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        return n(i7, abstractComponentCallbacksC2216p, null);
    }

    public AbstractC2198P n(int i7, AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p, String str) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        k(i7, abstractComponentCallbacksC2216p, str, 2);
        return this;
    }

    public AbstractC2198P o(boolean z7) {
        this.f18645r = z7;
        return this;
    }
}
