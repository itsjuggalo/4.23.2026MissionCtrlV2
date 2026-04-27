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

/* JADX INFO: loaded from: classes.dex */
public class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7348a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f7349b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f7350c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public L f7351d;

    public void A(L l4) {
        this.f7351d = l4;
    }

    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? (Bundle) this.f7350c.put(str, bundle) : (Bundle) this.f7350c.remove(str);
    }

    public void a(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        if (this.f7348a.contains(abstractComponentCallbacksC0828p)) {
            throw new IllegalStateException("Fragment already added: " + abstractComponentCallbacksC0828p);
        }
        synchronized (this.f7348a) {
            this.f7348a.add(abstractComponentCallbacksC0828p);
        }
        abstractComponentCallbacksC0828p.mAdded = true;
    }

    public void b() {
        this.f7349b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f7349b.get(str) != null;
    }

    public void d(int i4) {
        for (O o4 : this.f7349b.values()) {
            if (o4 != null) {
                o4.s(i4);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f7349b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (O o4 : this.f7349b.values()) {
                printWriter.print(str);
                if (o4 != null) {
                    AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
                    printWriter.println(abstractComponentCallbacksC0828pK);
                    abstractComponentCallbacksC0828pK.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f7348a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i4 = 0; i4 < size; i4++) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = (AbstractComponentCallbacksC0828p) this.f7348a.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0828p.toString());
            }
        }
    }

    public AbstractComponentCallbacksC0828p f(String str) {
        O o4 = (O) this.f7349b.get(str);
        if (o4 != null) {
            return o4.k();
        }
        return null;
    }

    public AbstractComponentCallbacksC0828p g(int i4) {
        for (int size = this.f7348a.size() - 1; size >= 0; size--) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = (AbstractComponentCallbacksC0828p) this.f7348a.get(size);
            if (abstractComponentCallbacksC0828p != null && abstractComponentCallbacksC0828p.mFragmentId == i4) {
                return abstractComponentCallbacksC0828p;
            }
        }
        for (O o4 : this.f7349b.values()) {
            if (o4 != null) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
                if (abstractComponentCallbacksC0828pK.mFragmentId == i4) {
                    return abstractComponentCallbacksC0828pK;
                }
            }
        }
        return null;
    }

    public AbstractComponentCallbacksC0828p h(String str) {
        if (str != null) {
            for (int size = this.f7348a.size() - 1; size >= 0; size--) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p = (AbstractComponentCallbacksC0828p) this.f7348a.get(size);
                if (abstractComponentCallbacksC0828p != null && str.equals(abstractComponentCallbacksC0828p.mTag)) {
                    return abstractComponentCallbacksC0828p;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (O o4 : this.f7349b.values()) {
            if (o4 != null) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
                if (str.equals(abstractComponentCallbacksC0828pK.mTag)) {
                    return abstractComponentCallbacksC0828pK;
                }
            }
        }
        return null;
    }

    public AbstractComponentCallbacksC0828p i(String str) {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pFindFragmentByWho;
        for (O o4 : this.f7349b.values()) {
            if (o4 != null && (abstractComponentCallbacksC0828pFindFragmentByWho = o4.k().findFragmentByWho(str)) != null) {
                return abstractComponentCallbacksC0828pFindFragmentByWho;
            }
        }
        return null;
    }

    public int j(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        View view;
        View view2;
        ViewGroup viewGroup = abstractComponentCallbacksC0828p.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f7348a.indexOf(abstractComponentCallbacksC0828p);
        for (int i4 = iIndexOf - 1; i4 >= 0; i4--) {
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p2 = (AbstractComponentCallbacksC0828p) this.f7348a.get(i4);
            if (abstractComponentCallbacksC0828p2.mContainer == viewGroup && (view2 = abstractComponentCallbacksC0828p2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f7348a.size()) {
                return -1;
            }
            AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p3 = (AbstractComponentCallbacksC0828p) this.f7348a.get(iIndexOf);
            if (abstractComponentCallbacksC0828p3.mContainer == viewGroup && (view = abstractComponentCallbacksC0828p3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (O o4 : this.f7349b.values()) {
            if (o4 != null) {
                arrayList.add(o4);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (O o4 : this.f7349b.values()) {
            if (o4 != null) {
                arrayList.add(o4.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public HashMap m() {
        return this.f7350c;
    }

    public O n(String str) {
        return (O) this.f7349b.get(str);
    }

    public List o() {
        ArrayList arrayList;
        if (this.f7348a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f7348a) {
            arrayList = new ArrayList(this.f7348a);
        }
        return arrayList;
    }

    public L p() {
        return this.f7351d;
    }

    public Bundle q(String str) {
        return (Bundle) this.f7350c.get(str);
    }

    public void r(O o4) {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
        if (c(abstractComponentCallbacksC0828pK.mWho)) {
            return;
        }
        this.f7349b.put(abstractComponentCallbacksC0828pK.mWho, o4);
        if (abstractComponentCallbacksC0828pK.mRetainInstanceChangedWhileDetached) {
            if (abstractComponentCallbacksC0828pK.mRetainInstance) {
                this.f7351d.f(abstractComponentCallbacksC0828pK);
            } else {
                this.f7351d.p(abstractComponentCallbacksC0828pK);
            }
            abstractComponentCallbacksC0828pK.mRetainInstanceChangedWhileDetached = false;
        }
        if (I.J0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + abstractComponentCallbacksC0828pK);
        }
    }

    public void s(O o4) {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
        if (abstractComponentCallbacksC0828pK.mRetainInstance) {
            this.f7351d.p(abstractComponentCallbacksC0828pK);
        }
        if (this.f7349b.get(abstractComponentCallbacksC0828pK.mWho) == o4 && ((O) this.f7349b.put(abstractComponentCallbacksC0828pK.mWho, null)) != null && I.J0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + abstractComponentCallbacksC0828pK);
        }
    }

    public void t() {
        Iterator it = this.f7348a.iterator();
        while (it.hasNext()) {
            O o4 = (O) this.f7349b.get(((AbstractComponentCallbacksC0828p) it.next()).mWho);
            if (o4 != null) {
                o4.m();
            }
        }
        for (O o5 : this.f7349b.values()) {
            if (o5 != null) {
                o5.m();
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o5.k();
                if (abstractComponentCallbacksC0828pK.mRemoving && !abstractComponentCallbacksC0828pK.isInBackStack()) {
                    if (abstractComponentCallbacksC0828pK.mBeingSaved && !this.f7350c.containsKey(abstractComponentCallbacksC0828pK.mWho)) {
                        B(abstractComponentCallbacksC0828pK.mWho, o5.q());
                    }
                    s(o5);
                }
            }
        }
    }

    public void u(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        synchronized (this.f7348a) {
            this.f7348a.remove(abstractComponentCallbacksC0828p);
        }
        abstractComponentCallbacksC0828p.mAdded = false;
    }

    public void v() {
        this.f7349b.clear();
    }

    public void w(List list) {
        this.f7348a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pF = f(str);
                if (abstractComponentCallbacksC0828pF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (I.J0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + abstractComponentCallbacksC0828pF);
                }
                a(abstractComponentCallbacksC0828pF);
            }
        }
    }

    public void x(HashMap map) {
        this.f7350c.clear();
        this.f7350c.putAll(map);
    }

    public ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f7349b.size());
        for (O o4 : this.f7349b.values()) {
            if (o4 != null) {
                AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pK = o4.k();
                B(abstractComponentCallbacksC0828pK.mWho, o4.q());
                arrayList.add(abstractComponentCallbacksC0828pK.mWho);
                if (I.J0(2)) {
                    Log.v("FragmentManager", "Saved state of " + abstractComponentCallbacksC0828pK + ": " + abstractComponentCallbacksC0828pK.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    public ArrayList z() {
        synchronized (this.f7348a) {
            try {
                if (this.f7348a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f7348a.size());
                for (AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p : this.f7348a) {
                    arrayList.add(abstractComponentCallbacksC0828p.mWho);
                    if (I.J0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + abstractComponentCallbacksC0828p.mWho + "): " + abstractComponentCallbacksC0828p);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
