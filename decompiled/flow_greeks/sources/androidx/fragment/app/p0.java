package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2263a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2264b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f2265c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f2266d;

    public void A(l0 l0Var) {
        this.f2266d = l0Var;
    }

    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? (Bundle) this.f2265c.put(str, bundle) : (Bundle) this.f2265c.remove(str);
    }

    public void a(p pVar) {
        if (this.f2263a.contains(pVar)) {
            throw new IllegalStateException("Fragment already added: " + pVar);
        }
        synchronized (this.f2263a) {
            this.f2263a.add(pVar);
        }
        pVar.mAdded = true;
    }

    public void b() {
        this.f2264b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f2264b.get(str) != null;
    }

    public void d(int i10) {
        for (o0 o0Var : this.f2264b.values()) {
            if (o0Var != null) {
                o0Var.s(i10);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2264b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (o0 o0Var : this.f2264b.values()) {
                printWriter.print(str);
                if (o0Var != null) {
                    p pVarK = o0Var.k();
                    printWriter.println(pVarK);
                    pVarK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2263a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = (p) this.f2263a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(pVar.toString());
            }
        }
    }

    public p f(String str) {
        o0 o0Var = (o0) this.f2264b.get(str);
        if (o0Var != null) {
            return o0Var.k();
        }
        return null;
    }

    public p g(int i10) {
        for (int size = this.f2263a.size() - 1; size >= 0; size--) {
            p pVar = (p) this.f2263a.get(size);
            if (pVar != null && pVar.mFragmentId == i10) {
                return pVar;
            }
        }
        for (o0 o0Var : this.f2264b.values()) {
            if (o0Var != null) {
                p pVarK = o0Var.k();
                if (pVarK.mFragmentId == i10) {
                    return pVarK;
                }
            }
        }
        return null;
    }

    public p h(String str) {
        if (str != null) {
            for (int size = this.f2263a.size() - 1; size >= 0; size--) {
                p pVar = (p) this.f2263a.get(size);
                if (pVar != null && str.equals(pVar.mTag)) {
                    return pVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (o0 o0Var : this.f2264b.values()) {
            if (o0Var != null) {
                p pVarK = o0Var.k();
                if (str.equals(pVarK.mTag)) {
                    return pVarK;
                }
            }
        }
        return null;
    }

    public p i(String str) {
        p pVarFindFragmentByWho;
        for (o0 o0Var : this.f2264b.values()) {
            if (o0Var != null && (pVarFindFragmentByWho = o0Var.k().findFragmentByWho(str)) != null) {
                return pVarFindFragmentByWho;
            }
        }
        return null;
    }

    public int j(p pVar) {
        View view;
        View view2;
        ViewGroup viewGroup = pVar.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f2263a.indexOf(pVar);
        for (int i10 = iIndexOf - 1; i10 >= 0; i10--) {
            p pVar2 = (p) this.f2263a.get(i10);
            if (pVar2.mContainer == viewGroup && (view2 = pVar2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f2263a.size()) {
                return -1;
            }
            p pVar3 = (p) this.f2263a.get(iIndexOf);
            if (pVar3.mContainer == viewGroup && (view = pVar3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (o0 o0Var : this.f2264b.values()) {
            if (o0Var != null) {
                arrayList.add(o0Var);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (o0 o0Var : this.f2264b.values()) {
            if (o0Var != null) {
                arrayList.add(o0Var.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public HashMap m() {
        return this.f2265c;
    }

    public o0 n(String str) {
        return (o0) this.f2264b.get(str);
    }

    public List o() {
        ArrayList arrayList;
        if (this.f2263a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f2263a) {
            arrayList = new ArrayList(this.f2263a);
        }
        return arrayList;
    }

    public l0 p() {
        return this.f2266d;
    }

    public Bundle q(String str) {
        return (Bundle) this.f2265c.get(str);
    }

    public void r(o0 o0Var) {
        p pVarK = o0Var.k();
        if (c(pVarK.mWho)) {
            return;
        }
        this.f2264b.put(pVarK.mWho, o0Var);
        if (pVarK.mRetainInstanceChangedWhileDetached) {
            if (pVarK.mRetainInstance) {
                this.f2266d.f(pVarK);
            } else {
                this.f2266d.p(pVarK);
            }
            pVarK.mRetainInstanceChangedWhileDetached = false;
        }
        if (i0.J0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + pVarK);
        }
    }

    public void s(o0 o0Var) {
        p pVarK = o0Var.k();
        if (pVarK.mRetainInstance) {
            this.f2266d.p(pVarK);
        }
        if (this.f2264b.get(pVarK.mWho) == o0Var && ((o0) this.f2264b.put(pVarK.mWho, null)) != null && i0.J0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + pVarK);
        }
    }

    public void t() {
        Iterator it = this.f2263a.iterator();
        while (it.hasNext()) {
            o0 o0Var = (o0) this.f2264b.get(((p) it.next()).mWho);
            if (o0Var != null) {
                o0Var.m();
            }
        }
        for (o0 o0Var2 : this.f2264b.values()) {
            if (o0Var2 != null) {
                o0Var2.m();
                p pVarK = o0Var2.k();
                if (pVarK.mRemoving && !pVarK.isInBackStack()) {
                    if (pVarK.mBeingSaved && !this.f2265c.containsKey(pVarK.mWho)) {
                        B(pVarK.mWho, o0Var2.q());
                    }
                    s(o0Var2);
                }
            }
        }
    }

    public void u(p pVar) {
        synchronized (this.f2263a) {
            this.f2263a.remove(pVar);
        }
        pVar.mAdded = false;
    }

    public void v() {
        this.f2264b.clear();
    }

    public void w(List list) {
        this.f2263a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                p pVarF = f(str);
                if (pVarF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + pVarF);
                }
                a(pVarF);
            }
        }
    }

    public void x(HashMap map) {
        this.f2265c.clear();
        this.f2265c.putAll(map);
    }

    public ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f2264b.size());
        for (o0 o0Var : this.f2264b.values()) {
            if (o0Var != null) {
                p pVarK = o0Var.k();
                B(pVarK.mWho, o0Var.q());
                arrayList.add(pVarK.mWho);
                if (i0.J0(2)) {
                    Log.v("FragmentManager", "Saved state of " + pVarK + ": " + pVarK.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    public ArrayList z() {
        synchronized (this.f2263a) {
            try {
                if (this.f2263a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f2263a.size());
                for (p pVar : this.f2263a) {
                    arrayList.add(pVar.mWho);
                    if (i0.J0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + pVar.mWho + "): " + pVar);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
