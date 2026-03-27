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
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public class d implements B.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final int[] f6407A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f6409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f6412e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f6420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f6421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f6422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f6423p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f6431x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6433z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6419l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6424q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6425r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6426s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6427t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6428u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f6429v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList f6430w = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6432y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f6413f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f6414g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6415h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f6416i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f6417j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6418k = true;

    public interface a {
        boolean a(d dVar, MenuItem menuItem);

        void b(d dVar);
    }

    public interface b {
        boolean a(e eVar);
    }

    public d(Context context) {
        this.f6408a = context;
        this.f6409b = context.getResources();
        T(true);
    }

    public static int m(ArrayList arrayList, int i4) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((e) arrayList.get(size)).d() <= i4) {
                return size + 1;
            }
        }
        return 0;
    }

    public static int x(int i4) {
        int i5 = ((-65536) & i4) >> 16;
        if (i5 >= 0) {
            int[] iArr = f6407A;
            if (i5 < iArr.length) {
                return (i4 & 65535) | (iArr[i5] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public ArrayList A() {
        if (!this.f6415h) {
            return this.f6414g;
        }
        this.f6414g.clear();
        int size = this.f6413f.size();
        for (int i4 = 0; i4 < size; i4++) {
            e eVar = (e) this.f6413f.get(i4);
            if (eVar.isVisible()) {
                this.f6414g.add(eVar);
            }
        }
        this.f6415h = false;
        this.f6418k = true;
        return this.f6414g;
    }

    public boolean B() {
        return this.f6432y;
    }

    public boolean C() {
        return this.f6410c;
    }

    public boolean D() {
        return this.f6411d;
    }

    public void E(e eVar) {
        this.f6418k = true;
        G(true);
    }

    public void F(e eVar) {
        this.f6415h = true;
        G(true);
    }

    public void G(boolean z4) {
        if (this.f6424q) {
            this.f6425r = true;
            if (z4) {
                this.f6426s = true;
                return;
            }
            return;
        }
        if (z4) {
            this.f6415h = true;
            this.f6418k = true;
        }
        h(z4);
    }

    public boolean H(MenuItem menuItem, int i4) {
        return I(menuItem, null, i4);
    }

    public boolean I(MenuItem menuItem, g gVar, int i4) {
        e eVar = (e) menuItem;
        if (eVar == null || !eVar.isEnabled()) {
            return false;
        }
        boolean zJ = eVar.j();
        eVar.g();
        if (eVar.i()) {
            boolean zExpandActionView = eVar.expandActionView() | zJ;
            if (zExpandActionView) {
                d(true);
            }
            return zExpandActionView;
        }
        if (!eVar.hasSubMenu()) {
            if ((i4 & 1) == 0) {
                d(true);
            }
            return zJ;
        }
        if ((i4 & 4) == 0) {
            d(false);
        }
        if (!eVar.hasSubMenu()) {
            eVar.w(new j(s(), this, eVar));
        }
        boolean zI = i((j) eVar.getSubMenu(), gVar) | zJ;
        if (!zI) {
            d(true);
        }
        return zI;
    }

    public final void J(int i4, boolean z4) {
        if (i4 < 0 || i4 >= this.f6413f.size()) {
            return;
        }
        this.f6413f.remove(i4);
        if (z4) {
            G(true);
        }
    }

    public void K(g gVar) {
        for (WeakReference weakReference : this.f6430w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null || gVar2 == gVar) {
                this.f6430w.remove(weakReference);
            }
        }
    }

    public void L(a aVar) {
        this.f6412e = aVar;
    }

    public void M(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f6413f.size();
        V();
        for (int i4 = 0; i4 < size; i4++) {
            e eVar = (e) this.f6413f.get(i4);
            if (eVar.getGroupId() == groupId && eVar.l() && eVar.isCheckable()) {
                eVar.r(eVar == menuItem);
            }
        }
        U();
    }

    public d N(int i4) {
        P(0, null, i4, null, null);
        return this;
    }

    public d O(Drawable drawable) {
        P(0, null, 0, drawable, null);
        return this;
    }

    public final void P(int i4, CharSequence charSequence, int i5, Drawable drawable, View view) {
        Resources resourcesY = y();
        if (view != null) {
            this.f6423p = view;
            this.f6421n = null;
            this.f6422o = null;
        } else {
            if (i4 > 0) {
                this.f6421n = resourcesY.getText(i4);
            } else if (charSequence != null) {
                this.f6421n = charSequence;
            }
            if (i5 > 0) {
                this.f6422o = AbstractC1909a.getDrawable(s(), i5);
            } else if (drawable != null) {
                this.f6422o = drawable;
            }
            this.f6423p = null;
        }
        G(false);
    }

    public d Q(int i4) {
        P(i4, null, 0, null, null);
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
            android.content.res.Resources r3 = r2.f6409b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f6408a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f6408a
            boolean r3 = H.I.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f6411d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.d.T(boolean):void");
    }

    public void U() {
        this.f6424q = false;
        if (this.f6425r) {
            this.f6425r = false;
            G(this.f6426s);
        }
    }

    public void V() {
        if (this.f6424q) {
            return;
        }
        this.f6424q = true;
        this.f6425r = false;
        this.f6426s = false;
    }

    public MenuItem a(int i4, int i5, int i6, CharSequence charSequence) {
        int iX = x(i6);
        e eVarF = f(i4, i5, i6, iX, charSequence, this.f6419l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f6420m;
        if (contextMenuInfo != null) {
            eVarF.u(contextMenuInfo);
        }
        ArrayList arrayList = this.f6413f;
        arrayList.add(m(arrayList, iX), eVarF);
        G(true);
        return eVarF;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        int i8;
        PackageManager packageManager = this.f6408a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i7 & 1) == 0) {
            removeGroup(i4);
        }
        for (int i9 = 0; i9 < size; i9++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i9);
            int i10 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i10 < 0 ? intent : intentArr[i10]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i4, i5, i6, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i8 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i8] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(g gVar, Context context) {
        this.f6430w.add(new WeakReference(gVar));
        gVar.h(context, this);
        this.f6418k = true;
    }

    public void c() {
        a aVar = this.f6412e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        e eVar = this.f6431x;
        if (eVar != null) {
            e(eVar);
        }
        this.f6413f.clear();
        G(true);
    }

    public void clearHeader() {
        this.f6422o = null;
        this.f6421n = null;
        this.f6423p = null;
        G(false);
    }

    @Override // android.view.Menu
    public void close() {
        d(true);
    }

    public final void d(boolean z4) {
        if (this.f6428u) {
            return;
        }
        this.f6428u = true;
        for (WeakReference weakReference : this.f6430w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f6430w.remove(weakReference);
            } else {
                gVar.a(this, z4);
            }
        }
        this.f6428u = false;
    }

    public boolean e(e eVar) {
        boolean zD = false;
        if (!this.f6430w.isEmpty() && this.f6431x == eVar) {
            V();
            for (WeakReference weakReference : this.f6430w) {
                g gVar = (g) weakReference.get();
                if (gVar != null) {
                    zD = gVar.d(this, eVar);
                    if (zD) {
                        break;
                    }
                } else {
                    this.f6430w.remove(weakReference);
                }
            }
            U();
            if (zD) {
                this.f6431x = null;
            }
        }
        return zD;
    }

    public final e f(int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        return new e(this, i4, i5, i6, i7, charSequence, i8);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i4) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = (e) this.f6413f.get(i5);
            if (eVar.getItemId() == i4) {
                return eVar;
            }
            if (eVar.hasSubMenu() && (menuItemFindItem = eVar.getSubMenu().findItem(i4)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public boolean g(d dVar, MenuItem menuItem) {
        a aVar = this.f6412e;
        return aVar != null && aVar.a(dVar, menuItem);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i4) {
        return (MenuItem) this.f6413f.get(i4);
    }

    public final void h(boolean z4) {
        if (this.f6430w.isEmpty()) {
            return;
        }
        V();
        for (WeakReference weakReference : this.f6430w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f6430w.remove(weakReference);
            } else {
                gVar.b(z4);
            }
        }
        U();
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f6433z) {
            return true;
        }
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((e) this.f6413f.get(i4)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(j jVar, g gVar) {
        if (this.f6430w.isEmpty()) {
            return false;
        }
        boolean zJ = gVar != null ? gVar.j(jVar) : false;
        for (WeakReference weakReference : this.f6430w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null) {
                this.f6430w.remove(weakReference);
            } else if (!zJ) {
                zJ = gVar2.j(jVar);
            }
        }
        return zJ;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return o(i4, keyEvent) != null;
    }

    public boolean j(e eVar) {
        boolean zF = false;
        if (this.f6430w.isEmpty()) {
            return false;
        }
        V();
        for (WeakReference weakReference : this.f6430w) {
            g gVar = (g) weakReference.get();
            if (gVar != null) {
                zF = gVar.f(this, eVar);
                if (zF) {
                    break;
                }
            } else {
                this.f6430w.remove(weakReference);
            }
        }
        U();
        if (zF) {
            this.f6431x = eVar;
        }
        return zF;
    }

    public int k(int i4) {
        return l(i4, 0);
    }

    public int l(int i4, int i5) {
        int size = size();
        if (i5 < 0) {
            i5 = 0;
        }
        while (i5 < size) {
            if (((e) this.f6413f.get(i5)).getGroupId() == i4) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public int n(int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (((e) this.f6413f.get(i5)).getItemId() == i4) {
                return i5;
            }
        }
        return -1;
    }

    public e o(int i4, KeyEvent keyEvent) {
        ArrayList arrayList = this.f6429v;
        arrayList.clear();
        p(arrayList, i4, keyEvent);
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
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = (e) arrayList.get(i5);
            char alphabeticShortcut = zC ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zC && alphabeticShortcut == '\b' && i4 == 67))) {
                return eVar;
            }
        }
        return null;
    }

    public void p(List list, int i4, KeyEvent keyEvent) {
        boolean zC = C();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i4 == 67) {
            int size = this.f6413f.size();
            for (int i5 = 0; i5 < size; i5++) {
                e eVar = (e) this.f6413f.get(i5);
                if (eVar.hasSubMenu()) {
                    ((d) eVar.getSubMenu()).p(list, i4, keyEvent);
                }
                char alphabeticShortcut = zC ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zC ? eVar.getAlphabeticModifiers() : eVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zC && alphabeticShortcut == '\b' && i4 == 67)) && eVar.isEnabled()) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i4, int i5) {
        return H(findItem(i4), i5);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        e eVarO = o(i4, keyEvent);
        boolean zH = eVarO != null ? H(eVarO, i5) : false;
        if ((i5 & 2) != 0) {
            d(true);
        }
        return zH;
    }

    public void q() {
        ArrayList arrayListA = A();
        if (this.f6418k) {
            boolean zC = false;
            for (WeakReference weakReference : this.f6430w) {
                g gVar = (g) weakReference.get();
                if (gVar == null) {
                    this.f6430w.remove(weakReference);
                } else {
                    zC |= gVar.c();
                }
            }
            if (zC) {
                this.f6416i.clear();
                this.f6417j.clear();
                int size = arrayListA.size();
                for (int i4 = 0; i4 < size; i4++) {
                    e eVar = (e) arrayListA.get(i4);
                    if (eVar.k()) {
                        this.f6416i.add(eVar);
                    } else {
                        this.f6417j.add(eVar);
                    }
                }
            } else {
                this.f6416i.clear();
                this.f6417j.clear();
                this.f6417j.addAll(A());
            }
            this.f6418k = false;
        }
    }

    public ArrayList r() {
        q();
        return this.f6416i;
    }

    @Override // android.view.Menu
    public void removeGroup(int i4) {
        int iK = k(i4);
        if (iK >= 0) {
            int size = this.f6413f.size() - iK;
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= size || ((e) this.f6413f.get(iK)).getGroupId() != i4) {
                    break;
                }
                J(iK, false);
                i5 = i6;
            }
            G(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i4) {
        J(n(i4), true);
    }

    public Context s() {
        return this.f6408a;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i4, boolean z4, boolean z5) {
        int size = this.f6413f.size();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = (e) this.f6413f.get(i5);
            if (eVar.getGroupId() == i4) {
                eVar.s(z5);
                eVar.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.f6432y = z4;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i4, boolean z4) {
        int size = this.f6413f.size();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = (e) this.f6413f.get(i5);
            if (eVar.getGroupId() == i4) {
                eVar.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i4, boolean z4) {
        int size = this.f6413f.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            e eVar = (e) this.f6413f.get(i5);
            if (eVar.getGroupId() == i4 && eVar.x(z4)) {
                z5 = true;
            }
        }
        if (z5) {
            G(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f6410c = z4;
        G(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f6413f.size();
    }

    public e t() {
        return this.f6431x;
    }

    public CharSequence u() {
        return this.f6421n;
    }

    public ArrayList v() {
        q();
        return this.f6417j;
    }

    public boolean w() {
        return this.f6427t;
    }

    public Resources y() {
        return this.f6409b;
    }

    public d z() {
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i4) {
        return a(0, 0, 0, this.f6409b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4) {
        return addSubMenu(0, 0, 0, this.f6409b.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return a(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        e eVar = (e) a(i4, i5, i6, charSequence);
        j jVar = new j(this.f6408a, this, eVar);
        eVar.w(jVar);
        return jVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i4, int i5, int i6, int i7) {
        return a(i4, i5, i6, this.f6409b.getString(i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return addSubMenu(i4, i5, i6, this.f6409b.getString(i7));
    }
}
