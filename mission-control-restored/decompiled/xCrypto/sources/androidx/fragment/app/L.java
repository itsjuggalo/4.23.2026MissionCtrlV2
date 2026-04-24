package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.K;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class L extends androidx.lifecycle.J {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final K.b f7318k = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7322g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f7319d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f7320e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f7321f = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7323h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7324i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7325j = false;

    public class a implements K.b {
        @Override // androidx.lifecycle.K.b
        public androidx.lifecycle.J a(Class cls) {
            return new L(true);
        }
    }

    public L(boolean z4) {
        this.f7322g = z4;
    }

    public static L l(androidx.lifecycle.M m4) {
        return (L) new androidx.lifecycle.K(m4, f7318k).a(L.class);
    }

    @Override // androidx.lifecycle.J
    public void d() {
        if (I.J0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f7323h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && L.class == obj.getClass()) {
            L l4 = (L) obj;
            if (this.f7319d.equals(l4.f7319d) && this.f7320e.equals(l4.f7320e) && this.f7321f.equals(l4.f7321f)) {
                return true;
            }
        }
        return false;
    }

    public void f(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (this.f7325j) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f7319d.containsKey(abstractComponentCallbacksC0828p.mWho)) {
                return;
            }
            this.f7319d.put(abstractComponentCallbacksC0828p.mWho, abstractComponentCallbacksC0828p);
            if (I.J0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + abstractComponentCallbacksC0828p);
            }
        }
    }

    public void g(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, boolean z4) {
        if (I.J0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + abstractComponentCallbacksC0828p);
        }
        i(abstractComponentCallbacksC0828p.mWho, z4);
    }

    public void h(String str, boolean z4) {
        if (I.J0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        i(str, z4);
    }

    public int hashCode() {
        return (((this.f7319d.hashCode() * 31) + this.f7320e.hashCode()) * 31) + this.f7321f.hashCode();
    }

    public final void i(String str, boolean z4) {
        L l4 = (L) this.f7320e.get(str);
        if (l4 != null) {
            if (z4) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(l4.f7320e.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    l4.h((String) it.next(), true);
                }
            }
            l4.d();
            this.f7320e.remove(str);
        }
        androidx.lifecycle.M m4 = (androidx.lifecycle.M) this.f7321f.get(str);
        if (m4 != null) {
            m4.a();
            this.f7321f.remove(str);
        }
    }

    public AbstractComponentCallbacksC0828p j(String str) {
        return (AbstractComponentCallbacksC0828p) this.f7319d.get(str);
    }

    public L k(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        L l4 = (L) this.f7320e.get(abstractComponentCallbacksC0828p.mWho);
        if (l4 != null) {
            return l4;
        }
        L l5 = new L(this.f7322g);
        this.f7320e.put(abstractComponentCallbacksC0828p.mWho, l5);
        return l5;
    }

    public Collection m() {
        return new ArrayList(this.f7319d.values());
    }

    public androidx.lifecycle.M n(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        androidx.lifecycle.M m4 = (androidx.lifecycle.M) this.f7321f.get(abstractComponentCallbacksC0828p.mWho);
        if (m4 != null) {
            return m4;
        }
        androidx.lifecycle.M m5 = new androidx.lifecycle.M();
        this.f7321f.put(abstractComponentCallbacksC0828p.mWho, m5);
        return m5;
    }

    public boolean o() {
        return this.f7323h;
    }

    public void p(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (this.f7325j) {
            if (I.J0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f7319d.remove(abstractComponentCallbacksC0828p.mWho) == null || !I.J0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + abstractComponentCallbacksC0828p);
        }
    }

    public void q(boolean z4) {
        this.f7325j = z4;
    }

    public boolean r(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (this.f7319d.containsKey(abstractComponentCallbacksC0828p.mWho)) {
            return this.f7322g ? this.f7323h : !this.f7324i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f7319d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f7320e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f7321f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
