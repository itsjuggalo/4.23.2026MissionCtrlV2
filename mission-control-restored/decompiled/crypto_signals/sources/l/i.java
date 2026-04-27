package l;

import D.E;
import D.G;
import Z.B;
import Z.H;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Build;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m.InterfaceC0827l;
import u.AbstractC1193h;

/* JADX INFO: loaded from: classes.dex */
public class i implements Menu {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f7981u = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f7983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7985d;
    public B e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f7986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f7987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7988h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f7989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f7991l;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public j f7998s;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7992m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7993n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7994o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7995p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f7996q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList f7997r = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7999t = false;

    public i(Context context) {
        boolean zB;
        boolean z6 = false;
        this.f7982a = context;
        Resources resources = context.getResources();
        this.f7983b = resources;
        this.f7986f = new ArrayList();
        this.f7987g = new ArrayList();
        this.f7988h = true;
        this.i = new ArrayList();
        this.f7989j = new ArrayList();
        this.f7990k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = G.f197a;
            if (Build.VERSION.SDK_INT >= 28) {
                zB = E.b(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zB = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zB) {
                z6 = true;
            }
        }
        this.f7985d = z6;
    }

    public final j a(int i, int i6, int i7, CharSequence charSequence) {
        int i8;
        int i9 = ((-65536) & i7) >> 16;
        if (i9 < 0 || i9 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i10 = (f7981u[i9] << 16) | (65535 & i7);
        j jVar = new j(this, i, i6, i7, i10, charSequence);
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i8 = 0;
                break;
            }
            if (((j) arrayList.get(size)).f8005d <= i10) {
                i8 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i8, jVar);
        o(true);
        return jVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i9;
        PackageManager packageManager = this.f7982a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i8 & 1) == 0) {
            removeGroup(i);
        }
        for (int i10 = 0; i10 < size; i10++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i10);
            int i11 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i11 < 0 ? intent : intentArr[i11]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            j jVarA = a(i, i6, i7, resolveInfo.loadLabel(packageManager));
            jVarA.setIcon(resolveInfo.loadIcon(packageManager));
            jVarA.f8007g = intent2;
            if (menuItemArr != null && (i9 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i9] = jVarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(p pVar, Context context) {
        this.f7997r.add(new WeakReference(pVar));
        pVar.g(context, this);
        this.f7990k = true;
    }

    public final void c(boolean z6) {
        if (this.f7995p) {
            return;
        }
        this.f7995p = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f7997r;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                pVar.a(this, z6);
            }
        }
        this.f7995p = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        j jVar = this.f7998s;
        if (jVar != null) {
            d(jVar);
        }
        this.f7986f.clear();
        o(true);
    }

    public final void clearHeader() {
        this.f7991l = null;
        o(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(j jVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f7997r;
        boolean zK = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f7998s == jVar) {
            s();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                p pVar = (p) weakReference.get();
                if (pVar != null) {
                    zK = pVar.k(jVar);
                    if (zK) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            r();
            if (zK) {
                this.f7998s = null;
            }
        }
        return zK;
    }

    public boolean e(i iVar, MenuItem menuItem) {
        InterfaceC0827l interfaceC0827l;
        B b3 = this.e;
        if (b3 == null || (interfaceC0827l = ((ActionMenuView) b3.f3700b).f4275C) == null) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) ((Toolbar) ((Y3.j) interfaceC0827l).f3665b).f4384K.f9531c).iterator();
        while (it.hasNext()) {
            if (((H) it.next()).f3712a.p()) {
                return true;
            }
        }
        return false;
    }

    public boolean f(j jVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f7997r;
        boolean zF = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        s();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            p pVar = (p) weakReference.get();
            if (pVar != null) {
                zF = pVar.f(jVar);
                if (zF) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        r();
        if (zF) {
            this.f7998s = jVar;
        }
        return zF;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            j jVar = (j) arrayList.get(i6);
            if (jVar.f8002a == i) {
                return jVar;
            }
            if (jVar.hasSubMenu() && (menuItemFindItem = jVar.f8014o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final j g(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f7996q;
        arrayList.clear();
        h(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (j) arrayList.get(0);
        }
        boolean zM = m();
        for (int i6 = 0; i6 < size; i6++) {
            j jVar = (j) arrayList.get(i6);
            char c6 = zM ? jVar.f8009j : jVar.f8008h;
            char[] cArr = keyData.meta;
            if ((c6 == cArr[0] && (metaState & 2) == 0) || ((c6 == cArr[2] && (metaState & 2) != 0) || (zM && c6 == '\b' && i == 67))) {
                return jVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.f7986f.get(i);
    }

    public final void h(ArrayList arrayList, int i, KeyEvent keyEvent) {
        boolean zM = m();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList2 = this.f7986f;
            int size = arrayList2.size();
            for (int i6 = 0; i6 < size; i6++) {
                j jVar = (j) arrayList2.get(i6);
                if (jVar.hasSubMenu()) {
                    jVar.f8014o.h(arrayList, i, keyEvent);
                }
                char c6 = zM ? jVar.f8009j : jVar.f8008h;
                if ((modifiers & 69647) == ((zM ? jVar.f8010k : jVar.i) & 69647) && c6 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c6 == cArr[0] || c6 == cArr[2] || (zM && c6 == '\b' && i == 67)) && jVar.isEnabled()) {
                        arrayList.add(jVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((j) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListK = k();
        if (this.f7990k) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f7997r;
            boolean zH = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                p pVar = (p) weakReference.get();
                if (pVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zH |= pVar.h();
                }
            }
            ArrayList arrayList = this.i;
            ArrayList arrayList2 = this.f7989j;
            if (zH) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListK.size();
                for (int i = 0; i < size; i++) {
                    j jVar = (j) arrayListK.get(i);
                    if ((jVar.f8023x & 32) == 32) {
                        arrayList.add(jVar);
                    } else {
                        arrayList2.add(jVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(k());
            }
            this.f7990k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return g(i, keyEvent) != null;
    }

    public final ArrayList k() {
        boolean z6 = this.f7988h;
        ArrayList arrayList = this.f7987g;
        if (!z6) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f7986f;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            j jVar = (j) arrayList2.get(i);
            if (jVar.isVisible()) {
                arrayList.add(jVar);
            }
        }
        this.f7988h = false;
        this.f7990k = true;
        return arrayList;
    }

    public boolean l() {
        return this.f7999t;
    }

    public boolean m() {
        return this.f7984c;
    }

    public boolean n() {
        return this.f7985d;
    }

    public final void o(boolean z6) {
        if (this.f7992m) {
            this.f7993n = true;
            if (z6) {
                this.f7994o = true;
                return;
            }
            return;
        }
        if (z6) {
            this.f7988h = true;
            this.f7990k = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f7997r;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        s();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            p pVar = (p) weakReference.get();
            if (pVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                pVar.c();
            }
        }
        r();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MenuItem r6, l.k r7, int r8) {
        /*
            r5 = this;
            l.j r6 = (l.j) r6
            r0 = 0
            if (r6 == 0) goto Laf
            boolean r1 = r6.isEnabled()
            if (r1 != 0) goto Ld
            goto Laf
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r6.f8015p
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r6)
            if (r1 == 0) goto L1a
        L18:
            r1 = r2
            goto L36
        L1a:
            l.i r1 = r6.f8013n
            boolean r3 = r1.e(r1, r6)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r6.f8007g
            if (r3 == 0) goto L35
            android.content.Context r1 = r1.f7982a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L18
        L2d:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L35:
            r1 = r0
        L36:
            int r3 = r6.y
            r3 = r3 & 8
            if (r3 == 0) goto L4b
            android.view.View r3 = r6.f8024z
            if (r3 == 0) goto L4b
            boolean r6 = r6.expandActionView()
            r1 = r1 | r6
            if (r1 == 0) goto Lae
            r5.c(r2)
            goto Lae
        L4b:
            boolean r3 = r6.hasSubMenu()
            if (r3 != 0) goto L59
            r6 = r8 & 1
            if (r6 != 0) goto Lae
            r5.c(r2)
            goto Lae
        L59:
            r8 = r8 & 4
            if (r8 != 0) goto L60
            r5.c(r0)
        L60:
            boolean r8 = r6.hasSubMenu()
            if (r8 != 0) goto L74
            l.t r8 = new l.t
            android.content.Context r3 = r5.f7982a
            r8.<init>(r3, r5, r6)
            r6.f8014o = r8
            java.lang.CharSequence r3 = r6.e
            r8.setHeaderTitle(r3)
        L74:
            l.t r6 = r6.f8014o
            java.util.concurrent.CopyOnWriteArrayList r8 = r5.f7997r
            boolean r3 = r8.isEmpty()
            if (r3 == 0) goto L7f
            goto La8
        L7f:
            if (r7 == 0) goto L85
            boolean r0 = r7.i(r6)
        L85:
            java.util.Iterator r7 = r8.iterator()
        L89:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto La8
            java.lang.Object r3 = r7.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            l.p r4 = (l.p) r4
            if (r4 != 0) goto La1
            r8.remove(r3)
            goto L89
        La1:
            if (r0 != 0) goto L89
            boolean r0 = r4.i(r6)
            goto L89
        La8:
            r1 = r1 | r0
            if (r1 != 0) goto Lae
            r5.c(r2)
        Lae:
            return r1
        Laf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.i.p(android.view.MenuItem, l.k, int):boolean");
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i6) {
        return p(findItem(i), null, i6);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i6) {
        j jVarG = g(i, keyEvent);
        boolean zP = jVarG != null ? p(jVarG, null, i6) : false;
        if ((i6 & 2) != 0) {
            c(true);
        }
        return zP;
    }

    public final void q(int i, CharSequence charSequence, int i6, View view) {
        if (view != null) {
            this.f7991l = null;
        } else {
            if (i > 0) {
                this.f7991l = this.f7983b.getText(i);
            } else if (charSequence != null) {
                this.f7991l = charSequence;
            }
            if (i6 > 0) {
                AbstractC1193h.getDrawable(this.f7982a, i6);
            }
        }
        o(false);
    }

    public final void r() {
        this.f7992m = false;
        if (this.f7993n) {
            this.f7993n = false;
            o(this.f7994o);
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                i7 = -1;
                break;
            } else if (((j) arrayList.get(i7)).f8003b == i) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 >= 0) {
            int size2 = arrayList.size() - i7;
            while (true) {
                int i8 = i6 + 1;
                if (i6 >= size2 || ((j) arrayList.get(i7)).f8003b != i) {
                    break;
                }
                if (i7 >= 0) {
                    ArrayList arrayList2 = this.f7986f;
                    if (i7 < arrayList2.size()) {
                        arrayList2.remove(i7);
                    }
                }
                i6 = i8;
            }
            o(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (((j) arrayList.get(i6)).f8002a == i) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            ArrayList arrayList2 = this.f7986f;
            if (i6 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i6);
            o(true);
        }
    }

    public final void s() {
        if (this.f7992m) {
            return;
        }
        this.f7992m = true;
        this.f7993n = false;
        this.f7994o = false;
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z6, boolean z7) {
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            j jVar = (j) arrayList.get(i6);
            if (jVar.f8003b == i) {
                jVar.f8023x = (jVar.f8023x & (-5)) | (z7 ? 4 : 0);
                jVar.setCheckable(z6);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z6) {
        this.f7999t = z6;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z6) {
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            j jVar = (j) arrayList.get(i6);
            if (jVar.f8003b == i) {
                jVar.setEnabled(z6);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z6) {
        ArrayList arrayList = this.f7986f;
        int size = arrayList.size();
        boolean z7 = false;
        for (int i6 = 0; i6 < size; i6++) {
            j jVar = (j) arrayList.get(i6);
            if (jVar.f8003b == i) {
                int i7 = jVar.f8023x;
                int i8 = (i7 & (-9)) | (z6 ? 0 : 8);
                jVar.f8023x = i8;
                if (i7 != i8) {
                    z7 = true;
                }
            }
        }
        if (z7) {
            o(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z6) {
        this.f7984c = z6;
        o(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f7986f.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.f7983b.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f7983b.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i6, int i7, CharSequence charSequence) {
        return a(i, i6, i7, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i6, int i7, CharSequence charSequence) {
        j jVarA = a(i, i6, i7, charSequence);
        t tVar = new t(this.f7982a, this, jVarA);
        jVarA.f8014o = tVar;
        tVar.setHeaderTitle(jVarA.e);
        return tVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i6, int i7, int i8) {
        return a(i, i6, i7, this.f7983b.getString(i8));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i6, int i7, int i8) {
        return addSubMenu(i, i6, i7, this.f7983b.getString(i8));
    }

    public i j() {
        return this;
    }
}
