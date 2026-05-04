package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends androidx.lifecycle.i0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j0.b f2169k = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2173g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f2170d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f2171e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f2172f = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2174h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2175i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2176j = false;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements j0.b {
        @Override // androidx.lifecycle.j0.b
        public androidx.lifecycle.i0 a(Class cls) {
            return new l0(true);
        }
    }

    public l0(boolean z10) {
        this.f2173g = z10;
    }

    public static l0 l(androidx.lifecycle.l0 l0Var) {
        return (l0) new androidx.lifecycle.j0(l0Var, f2169k).a(l0.class);
    }

    @Override // androidx.lifecycle.i0
    public void d() {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2174h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l0.class == obj.getClass()) {
            l0 l0Var = (l0) obj;
            if (this.f2170d.equals(l0Var.f2170d) && this.f2171e.equals(l0Var.f2171e) && this.f2172f.equals(l0Var.f2172f)) {
                return true;
            }
        }
        return false;
    }

    public void f(p pVar) {
        if (this.f2176j) {
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f2170d.containsKey(pVar.mWho)) {
                return;
            }
            this.f2170d.put(pVar.mWho, pVar);
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + pVar);
            }
        }
    }

    public void g(p pVar, boolean z10) {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + pVar);
        }
        i(pVar.mWho, z10);
    }

    public void h(String str, boolean z10) {
        if (i0.J0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        i(str, z10);
    }

    public int hashCode() {
        return (((this.f2170d.hashCode() * 31) + this.f2171e.hashCode()) * 31) + this.f2172f.hashCode();
    }

    public final void i(String str, boolean z10) {
        l0 l0Var = (l0) this.f2171e.get(str);
        if (l0Var != null) {
            if (z10) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(l0Var.f2171e.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    l0Var.h((String) it.next(), true);
                }
            }
            l0Var.d();
            this.f2171e.remove(str);
        }
        androidx.lifecycle.l0 l0Var2 = (androidx.lifecycle.l0) this.f2172f.get(str);
        if (l0Var2 != null) {
            l0Var2.a();
            this.f2172f.remove(str);
        }
    }

    public p j(String str) {
        return (p) this.f2170d.get(str);
    }

    public l0 k(p pVar) {
        l0 l0Var = (l0) this.f2171e.get(pVar.mWho);
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = new l0(this.f2173g);
        this.f2171e.put(pVar.mWho, l0Var2);
        return l0Var2;
    }

    public Collection m() {
        return new ArrayList(this.f2170d.values());
    }

    public androidx.lifecycle.l0 n(p pVar) {
        androidx.lifecycle.l0 l0Var = (androidx.lifecycle.l0) this.f2172f.get(pVar.mWho);
        if (l0Var != null) {
            return l0Var;
        }
        androidx.lifecycle.l0 l0Var2 = new androidx.lifecycle.l0();
        this.f2172f.put(pVar.mWho, l0Var2);
        return l0Var2;
    }

    public boolean o() {
        return this.f2174h;
    }

    public void p(p pVar) {
        if (this.f2176j) {
            if (i0.J0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f2170d.remove(pVar.mWho) == null || !i0.J0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + pVar);
        }
    }

    public void q(boolean z10) {
        this.f2176j = z10;
    }

    public boolean r(p pVar) {
        if (this.f2170d.containsKey(pVar.mWho)) {
            return this.f2173g ? this.f2174h : !this.f2175i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f2170d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f2171e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f2172f.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
