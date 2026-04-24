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
public class d implements N.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final int[] f10449A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f10451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f10454e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f10462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f10463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f10464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f10465p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f10473x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10475z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10461l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10466q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10467r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10468s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10469t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10470u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f10471v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList f10472w = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10474y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f10455f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f10456g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10457h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f10458i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f10459j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10460k = true;

    public interface a {
        boolean a(d dVar, MenuItem menuItem);

        void b(d dVar);
    }

    public interface b {
        boolean a(e eVar);
    }

    public d(Context context) {
        this.f10450a = context;
        this.f10451b = context.getResources();
        U(true);
    }

    public static int m(ArrayList arrayList, int i8) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((e) arrayList.get(size)).d() <= i8) {
                return size + 1;
            }
        }
        return 0;
    }

    public static int x(int i8) {
        int i9 = ((-65536) & i8) >> 16;
        if (i9 >= 0) {
            int[] iArr = f10449A;
            if (i9 < iArr.length) {
                return (i8 & 65535) | (iArr[i9] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public ArrayList A() {
        if (!this.f10457h) {
            return this.f10456g;
        }
        this.f10456g.clear();
        int size = this.f10455f.size();
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f10455f.get(i8);
            if (eVar.isVisible()) {
                this.f10456g.add(eVar);
            }
        }
        this.f10457h = false;
        this.f10460k = true;
        return this.f10456g;
    }

    public boolean B() {
        return !this.f10466q;
    }

    public boolean C() {
        return this.f10474y;
    }

    public boolean D() {
        return this.f10452c;
    }

    public boolean E() {
        return this.f10453d;
    }

    public void F(e eVar) {
        this.f10460k = true;
        H(true);
    }

    public void G(e eVar) {
        this.f10457h = true;
        H(true);
    }

    public void H(boolean z7) {
        if (this.f10466q) {
            this.f10467r = true;
            if (z7) {
                this.f10468s = true;
                return;
            }
            return;
        }
        if (z7) {
            this.f10457h = true;
            this.f10460k = true;
        }
        h(z7);
    }

    public boolean I(MenuItem menuItem, int i8) {
        return J(menuItem, null, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[PHI: r1
      0x0021: PHI (r1v4 boolean) = (r1v2 boolean), (r1v1 boolean), (r1v5 boolean) binds: [B:24:0x0054, B:15:0x002d, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean J(android.view.MenuItem r5, androidx.appcompat.view.menu.g r6, int r7) {
        /*
            r4 = this;
            androidx.appcompat.view.menu.e r5 = (androidx.appcompat.view.menu.e) r5
            r0 = 0
            if (r5 == 0) goto L58
            boolean r1 = r5.isEnabled()
            if (r1 != 0) goto Lc
            goto L58
        Lc:
            boolean r1 = r5.j()
            r5.g()
            boolean r2 = r5.i()
            r3 = 1
            if (r2 == 0) goto L25
            boolean r5 = r5.expandActionView()
            r1 = r1 | r5
            if (r1 == 0) goto L57
        L21:
            r4.d(r3)
            goto L57
        L25:
            boolean r2 = r5.hasSubMenu()
            if (r2 != 0) goto L30
            r5 = r7 & 1
            if (r5 != 0) goto L57
            goto L21
        L30:
            r7 = r7 & 4
            if (r7 != 0) goto L37
            r4.d(r0)
        L37:
            boolean r7 = r5.hasSubMenu()
            if (r7 != 0) goto L49
            androidx.appcompat.view.menu.j r7 = new androidx.appcompat.view.menu.j
            android.content.Context r0 = r4.s()
            r7.<init>(r0, r4, r5)
            r5.w(r7)
        L49:
            android.view.SubMenu r5 = r5.getSubMenu()
            androidx.appcompat.view.menu.j r5 = (androidx.appcompat.view.menu.j) r5
            boolean r5 = r4.i(r5, r6)
            r1 = r1 | r5
            if (r1 != 0) goto L57
            goto L21
        L57:
            return r1
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.d.J(android.view.MenuItem, androidx.appcompat.view.menu.g, int):boolean");
    }

    public final void K(int i8, boolean z7) {
        if (i8 < 0 || i8 >= this.f10455f.size()) {
            return;
        }
        this.f10455f.remove(i8);
        if (z7) {
            H(true);
        }
    }

    public void L(g gVar) {
        for (WeakReference weakReference : this.f10472w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null || gVar2 == gVar) {
                this.f10472w.remove(weakReference);
            }
        }
    }

    public void M(a aVar) {
        this.f10454e = aVar;
    }

    public void N(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f10455f.size();
        W();
        for (int i8 = 0; i8 < size; i8++) {
            e eVar = (e) this.f10455f.get(i8);
            if (eVar.getGroupId() == groupId && eVar.l() && eVar.isCheckable()) {
                eVar.r(eVar == menuItem);
            }
        }
        V();
    }

    public d O(int i8) {
        Q(0, null, i8, null, null);
        return this;
    }

    public d P(Drawable drawable) {
        Q(0, null, 0, drawable, null);
        return this;
    }

    public final void Q(int i8, CharSequence charSequence, int i9, Drawable drawable, View view) {
        Resources resourcesY = y();
        if (view != null) {
            this.f10465p = view;
            this.f10463n = null;
            this.f10464o = null;
        } else {
            if (i8 > 0) {
                this.f10463n = resourcesY.getText(i8);
            } else if (charSequence != null) {
                this.f10463n = charSequence;
            }
            if (i9 > 0) {
                this.f10464o = I.a.e(s(), i9);
            } else if (drawable != null) {
                this.f10464o = drawable;
            }
            this.f10465p = null;
        }
        H(false);
    }

    public d R(int i8) {
        Q(i8, null, 0, null, null);
        return this;
    }

    public d S(CharSequence charSequence) {
        Q(0, charSequence, 0, null, null);
        return this;
    }

    public d T(View view) {
        Q(0, null, 0, null, view);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f10451b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f10450a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f10450a
            boolean r3 = T.H.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f10453d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.d.U(boolean):void");
    }

    public void V() {
        this.f10466q = false;
        if (this.f10467r) {
            this.f10467r = false;
            H(this.f10468s);
        }
    }

    public void W() {
        if (this.f10466q) {
            return;
        }
        this.f10466q = true;
        this.f10467r = false;
        this.f10468s = false;
    }

    public MenuItem a(int i8, int i9, int i10, CharSequence charSequence) {
        int iX = x(i10);
        e eVarF = f(i8, i9, i10, iX, charSequence, this.f10461l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f10462m;
        if (contextMenuInfo != null) {
            eVarF.u(contextMenuInfo);
        }
        ArrayList arrayList = this.f10455f;
        arrayList.add(m(arrayList, iX), eVarF);
        H(true);
        return eVarF;
    }

    @Override // android.view.Menu
    public MenuItem add(int i8) {
        return a(0, 0, 0, this.f10451b.getString(i8));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i8, int i9, int i10, ComponentName componentName, Intent[] intentArr, Intent intent, int i11, MenuItem[] menuItemArr) {
        int i12;
        PackageManager packageManager = this.f10450a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i11 & 1) == 0) {
            removeGroup(i8);
        }
        for (int i13 = 0; i13 < size; i13++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i13);
            int i14 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i14 < 0 ? intent : intentArr[i14]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i8, i9, i10, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i12 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i12] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i8) {
        return addSubMenu(0, 0, 0, this.f10451b.getString(i8));
    }

    public void b(g gVar, Context context) {
        this.f10472w.add(new WeakReference(gVar));
        gVar.h(context, this);
        this.f10460k = true;
    }

    public void c() {
        a aVar = this.f10454e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        e eVar = this.f10473x;
        if (eVar != null) {
            e(eVar);
        }
        this.f10455f.clear();
        H(true);
    }

    public void clearHeader() {
        this.f10464o = null;
        this.f10463n = null;
        this.f10465p = null;
        H(false);
    }

    @Override // android.view.Menu
    public void close() {
        d(true);
    }

    public final void d(boolean z7) {
        if (this.f10470u) {
            return;
        }
        this.f10470u = true;
        for (WeakReference weakReference : this.f10472w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f10472w.remove(weakReference);
            } else {
                gVar.a(this, z7);
            }
        }
        this.f10470u = false;
    }

    public boolean e(e eVar) {
        boolean zD = false;
        if (!this.f10472w.isEmpty() && this.f10473x == eVar) {
            W();
            for (WeakReference weakReference : this.f10472w) {
                g gVar = (g) weakReference.get();
                if (gVar != null) {
                    zD = gVar.d(this, eVar);
                    if (zD) {
                        break;
                    }
                } else {
                    this.f10472w.remove(weakReference);
                }
            }
            V();
            if (zD) {
                this.f10473x = null;
            }
        }
        return zD;
    }

    public final e f(int i8, int i9, int i10, int i11, CharSequence charSequence, int i12) {
        return new e(this, i8, i9, i10, i11, charSequence, i12);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i8) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            e eVar = (e) this.f10455f.get(i9);
            if (eVar.getItemId() == i8) {
                return eVar;
            }
            if (eVar.hasSubMenu() && (menuItemFindItem = eVar.getSubMenu().findItem(i8)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public boolean g(d dVar, MenuItem menuItem) {
        a aVar = this.f10454e;
        return aVar != null && aVar.a(dVar, menuItem);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i8) {
        return (MenuItem) this.f10455f.get(i8);
    }

    public final void h(boolean z7) {
        if (this.f10472w.isEmpty()) {
            return;
        }
        W();
        for (WeakReference weakReference : this.f10472w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f10472w.remove(weakReference);
            } else {
                gVar.b(z7);
            }
        }
        V();
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f10475z) {
            return true;
        }
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (((e) this.f10455f.get(i8)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(j jVar, g gVar) {
        if (this.f10472w.isEmpty()) {
            return false;
        }
        boolean zJ = gVar != null ? gVar.j(jVar) : false;
        for (WeakReference weakReference : this.f10472w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null) {
                this.f10472w.remove(weakReference);
            } else if (!zJ) {
                zJ = gVar2.j(jVar);
            }
        }
        return zJ;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i8, KeyEvent keyEvent) {
        return o(i8, keyEvent) != null;
    }

    public boolean j(e eVar) {
        boolean zF = false;
        if (this.f10472w.isEmpty()) {
            return false;
        }
        W();
        for (WeakReference weakReference : this.f10472w) {
            g gVar = (g) weakReference.get();
            if (gVar != null) {
                zF = gVar.f(this, eVar);
                if (zF) {
                    break;
                }
            } else {
                this.f10472w.remove(weakReference);
            }
        }
        V();
        if (zF) {
            this.f10473x = eVar;
        }
        return zF;
    }

    public int k(int i8) {
        return l(i8, 0);
    }

    public int l(int i8, int i9) {
        int size = size();
        if (i9 < 0) {
            i9 = 0;
        }
        while (i9 < size) {
            if (((e) this.f10455f.get(i9)).getGroupId() == i8) {
                return i9;
            }
            i9++;
        }
        return -1;
    }

    public int n(int i8) {
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            if (((e) this.f10455f.get(i9)).getItemId() == i8) {
                return i9;
            }
        }
        return -1;
    }

    public e o(int i8, KeyEvent keyEvent) {
        ArrayList arrayList = this.f10471v;
        arrayList.clear();
        p(arrayList, i8, keyEvent);
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
        boolean zD = D();
        for (int i9 = 0; i9 < size; i9++) {
            e eVar = (e) arrayList.get(i9);
            char alphabeticShortcut = zD ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zD && alphabeticShortcut == '\b' && i8 == 67))) {
                return eVar;
            }
        }
        return null;
    }

    public void p(List list, int i8, KeyEvent keyEvent) {
        boolean zD = D();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i8 == 67) {
            int size = this.f10455f.size();
            for (int i9 = 0; i9 < size; i9++) {
                e eVar = (e) this.f10455f.get(i9);
                if (eVar.hasSubMenu()) {
                    ((d) eVar.getSubMenu()).p(list, i8, keyEvent);
                }
                char alphabeticShortcut = zD ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zD ? eVar.getAlphabeticModifiers() : eVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zD && alphabeticShortcut == '\b' && i8 == 67)) && eVar.isEnabled()) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i8, int i9) {
        return I(findItem(i8), i9);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i8, KeyEvent keyEvent, int i9) {
        e eVarO = o(i8, keyEvent);
        boolean zI = eVarO != null ? I(eVarO, i9) : false;
        if ((i9 & 2) != 0) {
            d(true);
        }
        return zI;
    }

    public void q() {
        ArrayList arrayListA = A();
        if (this.f10460k) {
            boolean zC = false;
            for (WeakReference weakReference : this.f10472w) {
                g gVar = (g) weakReference.get();
                if (gVar == null) {
                    this.f10472w.remove(weakReference);
                } else {
                    zC |= gVar.c();
                }
            }
            if (zC) {
                this.f10458i.clear();
                this.f10459j.clear();
                int size = arrayListA.size();
                for (int i8 = 0; i8 < size; i8++) {
                    e eVar = (e) arrayListA.get(i8);
                    (eVar.k() ? this.f10458i : this.f10459j).add(eVar);
                }
            } else {
                this.f10458i.clear();
                this.f10459j.clear();
                this.f10459j.addAll(A());
            }
            this.f10460k = false;
        }
    }

    public ArrayList r() {
        q();
        return this.f10458i;
    }

    @Override // android.view.Menu
    public void removeGroup(int i8) {
        int iK = k(i8);
        if (iK >= 0) {
            int size = this.f10455f.size() - iK;
            int i9 = 0;
            while (true) {
                int i10 = i9 + 1;
                if (i9 >= size || ((e) this.f10455f.get(iK)).getGroupId() != i8) {
                    break;
                }
                K(iK, false);
                i9 = i10;
            }
            H(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i8) {
        K(n(i8), true);
    }

    public Context s() {
        return this.f10450a;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i8, boolean z7, boolean z8) {
        int size = this.f10455f.size();
        for (int i9 = 0; i9 < size; i9++) {
            e eVar = (e) this.f10455f.get(i9);
            if (eVar.getGroupId() == i8) {
                eVar.s(z8);
                eVar.setCheckable(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f10474y = z7;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i8, boolean z7) {
        int size = this.f10455f.size();
        for (int i9 = 0; i9 < size; i9++) {
            e eVar = (e) this.f10455f.get(i9);
            if (eVar.getGroupId() == i8) {
                eVar.setEnabled(z7);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i8, boolean z7) {
        int size = this.f10455f.size();
        boolean z8 = false;
        for (int i9 = 0; i9 < size; i9++) {
            e eVar = (e) this.f10455f.get(i9);
            if (eVar.getGroupId() == i8 && eVar.x(z7)) {
                z8 = true;
            }
        }
        if (z8) {
            H(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f10452c = z7;
        H(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f10455f.size();
    }

    public e t() {
        return this.f10473x;
    }

    public CharSequence u() {
        return this.f10463n;
    }

    public ArrayList v() {
        q();
        return this.f10459j;
    }

    public boolean w() {
        return this.f10469t;
    }

    public Resources y() {
        return this.f10451b;
    }

    public d z() {
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i8, int i9, int i10, int i11) {
        return a(i8, i9, i10, this.f10451b.getString(i11));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i8, int i9, int i10, int i11) {
        return addSubMenu(i8, i9, i10, this.f10451b.getString(i11));
    }

    @Override // android.view.Menu
    public MenuItem add(int i8, int i9, int i10, CharSequence charSequence) {
        return a(i8, i9, i10, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i8, int i9, int i10, CharSequence charSequence) {
        e eVar = (e) a(i8, i9, i10, charSequence);
        j jVar = new j(this.f10450a, this, eVar);
        eVar.w(jVar);
        return jVar;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }
}
