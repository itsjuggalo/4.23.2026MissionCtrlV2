package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d implements K.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final int[] f6556A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f6558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f6561e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f6569m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f6570n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f6571o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f6572p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f6580x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6582z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6568l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6573q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6574r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6575s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6576t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6577u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f6578v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList f6579w = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6581y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f6562f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f6563g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6564h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f6565i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f6566j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6567k = true;

    public interface a {
        boolean a(d dVar, MenuItem menuItem);

        void b(d dVar);
    }

    public interface b {
        boolean a(e eVar);
    }

    public d(Context context) {
        this.f6557a = context;
        this.f6558b = context.getResources();
        T(true);
    }

    public static int m(ArrayList arrayList, int i7) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((e) arrayList.get(size)).d() <= i7) {
                return size + 1;
            }
        }
        return 0;
    }

    public static int x(int i7) {
        int i8 = ((-65536) & i7) >> 16;
        if (i8 >= 0) {
            int[] iArr = f6556A;
            if (i8 < iArr.length) {
                return (i7 & 65535) | (iArr[i8] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public ArrayList A() {
        if (!this.f6564h) {
            return this.f6563g;
        }
        this.f6563g.clear();
        int size = this.f6562f.size();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = (e) this.f6562f.get(i7);
            if (eVar.isVisible()) {
                this.f6563g.add(eVar);
            }
        }
        this.f6564h = false;
        this.f6567k = true;
        return this.f6563g;
    }

    public boolean B() {
        return this.f6581y;
    }

    public boolean C() {
        return this.f6559c;
    }

    public boolean D() {
        return this.f6560d;
    }

    public void E(e eVar) {
        this.f6567k = true;
        G(true);
    }

    public void F(e eVar) {
        this.f6564h = true;
        G(true);
    }

    public void G(boolean z7) {
        if (this.f6573q) {
            this.f6574r = true;
            if (z7) {
                this.f6575s = true;
                return;
            }
            return;
        }
        if (z7) {
            this.f6564h = true;
            this.f6567k = true;
        }
        h(z7);
    }

    public boolean H(MenuItem menuItem, int i7) {
        return I(menuItem, null, i7);
    }

    public boolean I(MenuItem menuItem, g gVar, int i7) {
        e eVar = (e) menuItem;
        if (eVar == null || !eVar.isEnabled()) {
            return false;
        }
        boolean zJ = eVar.j();
        eVar.g();
        if (eVar.i()) {
            zJ |= eVar.expandActionView();
            if (zJ) {
                d(true);
            }
        } else if (eVar.hasSubMenu()) {
            if ((i7 & 4) == 0) {
                d(false);
            }
            if (!eVar.hasSubMenu()) {
                eVar.w(new j(s(), this, eVar));
            }
            zJ |= i((j) eVar.getSubMenu(), gVar);
            if (!zJ) {
                d(true);
            }
        } else if ((i7 & 1) == 0) {
            d(true);
        }
        return zJ;
    }

    public final void J(int i7, boolean z7) {
        if (i7 < 0 || i7 >= this.f6562f.size()) {
            return;
        }
        this.f6562f.remove(i7);
        if (z7) {
            G(true);
        }
    }

    public void K(g gVar) {
        for (WeakReference weakReference : this.f6579w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null || gVar2 == gVar) {
                this.f6579w.remove(weakReference);
            }
        }
    }

    public void L(a aVar) {
        this.f6561e = aVar;
    }

    public void M(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f6562f.size();
        V();
        for (int i7 = 0; i7 < size; i7++) {
            e eVar = (e) this.f6562f.get(i7);
            if (eVar.getGroupId() == groupId && eVar.l() && eVar.isCheckable()) {
                eVar.r(eVar == menuItem);
            }
        }
        U();
    }

    public d N(int i7) {
        P(0, null, i7, null, null);
        return this;
    }

    public d O(Drawable drawable) {
        P(0, null, 0, drawable, null);
        return this;
    }

    public final void P(int i7, CharSequence charSequence, int i8, Drawable drawable, View view) {
        Resources resourcesY = y();
        if (view != null) {
            this.f6572p = view;
            this.f6570n = null;
            this.f6571o = null;
        } else {
            if (i7 > 0) {
                this.f6570n = resourcesY.getText(i7);
            } else if (charSequence != null) {
                this.f6570n = charSequence;
            }
            if (i8 > 0) {
                this.f6571o = G.a.getDrawable(s(), i8);
            } else if (drawable != null) {
                this.f6571o = drawable;
            }
            this.f6572p = null;
        }
        G(false);
    }

    public d Q(int i7) {
        P(i7, null, 0, null, null);
        return this;
    }

    public d R(CharSequence charSequence) {
        P(0, charSequence, 0, null, null);
        return this;
    }

    public d S(View view) {
        P(0, null, 0, null, view);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f6558b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f6557a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f6557a
            boolean r3 = Q.S.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f6560d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.d.T(boolean):void");
    }

    public void U() {
        this.f6573q = false;
        if (this.f6574r) {
            this.f6574r = false;
            G(this.f6575s);
        }
    }

    public void V() {
        if (this.f6573q) {
            return;
        }
        this.f6573q = true;
        this.f6574r = false;
        this.f6575s = false;
    }

    public MenuItem a(int i7, int i8, int i9, CharSequence charSequence) {
        int iX = x(i9);
        e eVarF = f(i7, i8, i9, iX, charSequence, this.f6568l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f6569m;
        if (contextMenuInfo != null) {
            eVarF.u(contextMenuInfo);
        }
        ArrayList arrayList = this.f6562f;
        arrayList.add(m(arrayList, iX), eVarF);
        G(true);
        return eVarF;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i7, int i8, int i9, ComponentName componentName, Intent[] intentArr, Intent intent, int i10, MenuItem[] menuItemArr) {
        int i11;
        PackageManager packageManager = this.f6557a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i10 & 1) == 0) {
            removeGroup(i7);
        }
        for (int i12 = 0; i12 < size; i12++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i12);
            int i13 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i13 < 0 ? intent : intentArr[i13]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i7, i8, i9, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i11 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i11] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(g gVar, Context context) {
        this.f6579w.add(new WeakReference(gVar));
        gVar.i(context, this);
        this.f6567k = true;
    }

    public void c() {
        a aVar = this.f6561e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        e eVar = this.f6580x;
        if (eVar != null) {
            e(eVar);
        }
        this.f6562f.clear();
        G(true);
    }

    public void clearHeader() {
        this.f6571o = null;
        this.f6570n = null;
        this.f6572p = null;
        G(false);
    }

    @Override // android.view.Menu
    public void close() {
        d(true);
    }

    public final void d(boolean z7) {
        if (this.f6577u) {
            return;
        }
        this.f6577u = true;
        for (WeakReference weakReference : this.f6579w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f6579w.remove(weakReference);
            } else {
                gVar.b(this, z7);
            }
        }
        this.f6577u = false;
    }

    public boolean e(e eVar) {
        boolean zE = false;
        if (!this.f6579w.isEmpty() && this.f6580x == eVar) {
            V();
            for (WeakReference weakReference : this.f6579w) {
                g gVar = (g) weakReference.get();
                if (gVar != null) {
                    zE = gVar.e(this, eVar);
                    if (zE) {
                        break;
                    }
                } else {
                    this.f6579w.remove(weakReference);
                }
            }
            U();
            if (zE) {
                this.f6580x = null;
            }
        }
        return zE;
    }

    public final e f(int i7, int i8, int i9, int i10, CharSequence charSequence, int i11) {
        return new e(this, i7, i8, i9, i10, charSequence, i11);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i7) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f6562f.get(i8);
            if (eVar.getItemId() == i7) {
                return eVar;
            }
            if (eVar.hasSubMenu() && (menuItemFindItem = eVar.getSubMenu().findItem(i7)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public boolean g(d dVar, MenuItem menuItem) {
        a aVar = this.f6561e;
        return aVar != null && aVar.a(dVar, menuItem);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i7) {
        return (MenuItem) this.f6562f.get(i7);
    }

    public final void h(boolean z7) {
        if (this.f6579w.isEmpty()) {
            return;
        }
        V();
        for (WeakReference weakReference : this.f6579w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f6579w.remove(weakReference);
            } else {
                gVar.c(z7);
            }
        }
        U();
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f6582z) {
            return true;
        }
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (((e) this.f6562f.get(i7)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(j jVar, g gVar) {
        if (this.f6579w.isEmpty()) {
            return false;
        }
        boolean zK = gVar != null ? gVar.k(jVar) : false;
        for (WeakReference weakReference : this.f6579w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null) {
                this.f6579w.remove(weakReference);
            } else if (!zK) {
                zK = gVar2.k(jVar);
            }
        }
        return zK;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i7, KeyEvent keyEvent) {
        return o(i7, keyEvent) != null;
    }

    public boolean j(e eVar) {
        boolean zG = false;
        if (this.f6579w.isEmpty()) {
            return false;
        }
        V();
        for (WeakReference weakReference : this.f6579w) {
            g gVar = (g) weakReference.get();
            if (gVar != null) {
                zG = gVar.g(this, eVar);
                if (zG) {
                    break;
                }
            } else {
                this.f6579w.remove(weakReference);
            }
        }
        U();
        if (zG) {
            this.f6580x = eVar;
        }
        return zG;
    }

    public int k(int i7) {
        return l(i7, 0);
    }

    public int l(int i7, int i8) {
        int size = size();
        if (i8 < 0) {
            i8 = 0;
        }
        while (i8 < size) {
            if (((e) this.f6562f.get(i8)).getGroupId() == i7) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public int n(int i7) {
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((e) this.f6562f.get(i8)).getItemId() == i7) {
                return i8;
            }
        }
        return -1;
    }

    public e o(int i7, KeyEvent keyEvent) {
        ArrayList arrayList = this.f6578v;
        arrayList.clear();
        p(arrayList, i7, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (e) arrayList.get(0);
        }
        boolean zC = C();
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) arrayList.get(i8);
            char alphabeticShortcut = zC ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zC && alphabeticShortcut == '\b' && i7 == 67))) {
                return eVar;
            }
        }
        return null;
    }

    public void p(List list, int i7, KeyEvent keyEvent) {
        boolean zC = C();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i7 == 67) {
            int size = this.f6562f.size();
            for (int i8 = 0; i8 < size; i8++) {
                e eVar = (e) this.f6562f.get(i8);
                if (eVar.hasSubMenu()) {
                    ((d) eVar.getSubMenu()).p(list, i7, keyEvent);
                }
                char alphabeticShortcut = zC ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zC ? eVar.getAlphabeticModifiers() : eVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zC && alphabeticShortcut == '\b' && i7 == 67)) && eVar.isEnabled()) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i7, int i8) {
        return H(findItem(i7), i8);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i7, KeyEvent keyEvent, int i8) {
        e eVarO = o(i7, keyEvent);
        boolean zH = eVarO != null ? H(eVarO, i8) : false;
        if ((i8 & 2) != 0) {
            d(true);
        }
        return zH;
    }

    public void q() {
        ArrayList arrayListA = A();
        if (this.f6567k) {
            boolean zD = false;
            for (WeakReference weakReference : this.f6579w) {
                g gVar = (g) weakReference.get();
                if (gVar == null) {
                    this.f6579w.remove(weakReference);
                } else {
                    zD |= gVar.d();
                }
            }
            if (zD) {
                this.f6565i.clear();
                this.f6566j.clear();
                int size = arrayListA.size();
                for (int i7 = 0; i7 < size; i7++) {
                    e eVar = (e) arrayListA.get(i7);
                    if (eVar.k()) {
                        this.f6565i.add(eVar);
                    } else {
                        this.f6566j.add(eVar);
                    }
                }
            } else {
                this.f6565i.clear();
                this.f6566j.clear();
                this.f6566j.addAll(A());
            }
            this.f6567k = false;
        }
    }

    public ArrayList r() {
        q();
        return this.f6565i;
    }

    @Override // android.view.Menu
    public void removeGroup(int i7) {
        int iK = k(i7);
        if (iK >= 0) {
            int size = this.f6562f.size() - iK;
            int i8 = 0;
            while (true) {
                int i9 = i8 + 1;
                if (i8 >= size || ((e) this.f6562f.get(iK)).getGroupId() != i7) {
                    break;
                }
                J(iK, false);
                i8 = i9;
            }
            G(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i7) {
        J(n(i7), true);
    }

    public Context s() {
        return this.f6557a;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i7, boolean z7, boolean z8) {
        int size = this.f6562f.size();
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f6562f.get(i8);
            if (eVar.getGroupId() == i7) {
                eVar.s(z8);
                eVar.setCheckable(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f6581y = z7;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i7, boolean z7) {
        int size = this.f6562f.size();
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f6562f.get(i8);
            if (eVar.getGroupId() == i7) {
                eVar.setEnabled(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i7, boolean z7) {
        int size = this.f6562f.size();
        boolean z8 = false;
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f6562f.get(i8);
            if (eVar.getGroupId() == i7 && eVar.x(z7)) {
                z8 = true;
            }
        }
        if (z8) {
            G(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f6559c = z7;
        G(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f6562f.size();
    }

    public e t() {
        return this.f6580x;
    }

    public CharSequence u() {
        return this.f6570n;
    }

    public ArrayList v() {
        q();
        return this.f6566j;
    }

    public boolean w() {
        return this.f6576t;
    }

    public Resources y() {
        return this.f6558b;
    }

    public d z() {
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i7) {
        return a(0, 0, 0, this.f6558b.getString(i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7) {
        return addSubMenu(0, 0, 0, this.f6558b.getString(i7));
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, CharSequence charSequence) {
        return a(i7, i8, i9, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, CharSequence charSequence) {
        e eVar = (e) a(i7, i8, i9, charSequence);
        j jVar = new j(this.f6557a, this, eVar);
        eVar.w(jVar);
        return jVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i7, int i8, int i9, int i10) {
        return a(i7, i8, i9, this.f6558b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i7, int i8, int i9, int i10) {
        return addSubMenu(i7, i8, i9, this.f6558b.getString(i10));
    }
}
