package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.i;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f2268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f2269b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2276i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f2280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f2282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f2283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f2284q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList f2286s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f2270c = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2277j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2285r = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f2288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2290d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2291e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2292f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2293g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public i.b f2294h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public i.b f2295i;

        public a() {
        }

        public a(int i10, p pVar) {
            this.f2287a = i10;
            this.f2288b = pVar;
            this.f2289c = false;
            i.b bVar = i.b.RESUMED;
            this.f2294h = bVar;
            this.f2295i = bVar;
        }

        public a(int i10, p pVar, boolean z10) {
            this.f2287a = i10;
            this.f2288b = pVar;
            this.f2289c = z10;
            i.b bVar = i.b.RESUMED;
            this.f2294h = bVar;
            this.f2295i = bVar;
        }
    }

    public q0(z zVar, ClassLoader classLoader) {
        this.f2268a = zVar;
        this.f2269b = classLoader;
    }

    public q0 b(int i10, p pVar, String str) {
        k(i10, pVar, str, 1);
        return this;
    }

    public q0 c(ViewGroup viewGroup, p pVar, String str) {
        pVar.mContainer = viewGroup;
        return b(viewGroup.getId(), pVar, str);
    }

    public q0 d(p pVar, String str) {
        k(0, pVar, str, 1);
        return this;
    }

    public void e(a aVar) {
        this.f2270c.add(aVar);
        aVar.f2290d = this.f2271d;
        aVar.f2291e = this.f2272e;
        aVar.f2292f = this.f2273f;
        aVar.f2293g = this.f2274g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public q0 j() {
        if (this.f2276i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f2277j = false;
        return this;
    }

    public void k(int i10, p pVar, String str, int i11) {
        String str2 = pVar.mPreviousWho;
        if (str2 != null) {
            v1.c.f(pVar, str2);
        }
        Class<?> cls = pVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = pVar.mTag;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + pVar + ": was " + pVar.mTag + " now " + str);
            }
            pVar.mTag = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + pVar + " with tag " + str + " to container view with no id");
            }
            int i12 = pVar.mFragmentId;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + pVar + ": was " + pVar.mFragmentId + " now " + i10);
            }
            pVar.mFragmentId = i10;
            pVar.mContainerId = i10;
        }
        e(new a(i11, pVar));
    }

    public q0 l(p pVar) {
        e(new a(3, pVar));
        return this;
    }

    public q0 m(boolean z10) {
        this.f2285r = z10;
        return this;
    }
}
