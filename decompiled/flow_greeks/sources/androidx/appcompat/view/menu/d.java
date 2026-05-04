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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements n0.a {
    public static final int[] A = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f1033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f1036e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f1044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f1045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f1046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f1047p;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f1055x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1057z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1043l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1048q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1049r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1050s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1051t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1052u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f1053v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CopyOnWriteArrayList f1054w = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1056y = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f1037f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f1038g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1039h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f1040i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f1041j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1042k = true;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        boolean a(d dVar, MenuItem menuItem);

        void b(d dVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        boolean a(e eVar);
    }

    public d(Context context) {
        this.f1032a = context;
        this.f1033b = context.getResources();
        U(true);
    }

    public static int m(ArrayList arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((e) arrayList.get(size)).d() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public static int x(int i10) {
        int i11 = ((-65536) & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = A;
            if (i11 < iArr.length) {
                return (i10 & 65535) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public ArrayList A() {
        if (!this.f1039h) {
            return this.f1038g;
        }
        this.f1038g.clear();
        int size = this.f1037f.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) this.f1037f.get(i10);
            if (eVar.isVisible()) {
                this.f1038g.add(eVar);
            }
        }
        this.f1039h = false;
        this.f1042k = true;
        return this.f1038g;
    }

    public boolean B() {
        return !this.f1048q;
    }

    public boolean C() {
        return this.f1056y;
    }

    public boolean D() {
        return this.f1034c;
    }

    public boolean E() {
        return this.f1035d;
    }

    public void F(e eVar) {
        this.f1042k = true;
        H(true);
    }

    public void G(e eVar) {
        this.f1039h = true;
        H(true);
    }

    public void H(boolean z10) {
        if (this.f1048q) {
            this.f1049r = true;
            if (z10) {
                this.f1050s = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f1039h = true;
            this.f1042k = true;
        }
        h(z10);
    }

    public boolean I(MenuItem menuItem, int i10) {
        return J(menuItem, null, i10);
    }

    public boolean J(MenuItem menuItem, g gVar, int i10) {
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
            if ((i10 & 1) == 0) {
                d(true);
            }
            return zJ;
        }
        if ((i10 & 4) == 0) {
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

    public final void K(int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.f1037f.size()) {
            return;
        }
        this.f1037f.remove(i10);
        if (z10) {
            H(true);
        }
    }

    public void L(g gVar) {
        for (WeakReference weakReference : this.f1054w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null || gVar2 == gVar) {
                this.f1054w.remove(weakReference);
            }
        }
    }

    public void M(a aVar) {
        this.f1036e = aVar;
    }

    public void N(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1037f.size();
        W();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) this.f1037f.get(i10);
            if (eVar.getGroupId() == groupId && eVar.l() && eVar.isCheckable()) {
                eVar.r(eVar == menuItem);
            }
        }
        V();
    }

    public d O(int i10) {
        Q(0, null, i10, null, null);
        return this;
    }

    public d P(Drawable drawable) {
        Q(0, null, 0, drawable, null);
        return this;
    }

    public final void Q(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources resourcesY = y();
        if (view != null) {
            this.f1047p = view;
            this.f1045n = null;
            this.f1046o = null;
        } else {
            if (i10 > 0) {
                this.f1045n = resourcesY.getText(i10);
            } else if (charSequence != null) {
                this.f1045n = charSequence;
            }
            if (i11 > 0) {
                this.f1046o = i0.a.f(s(), i11);
            } else if (drawable != null) {
                this.f1046o = drawable;
            }
            this.f1047p = null;
        }
        H(false);
    }

    public d R(int i10) {
        Q(i10, null, 0, null, null);
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
            android.content.res.Resources r3 = r2.f1033b
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.f1032a
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f1032a
            boolean r3 = t0.f0.l(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f1035d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.d.U(boolean):void");
    }

    public void V() {
        this.f1048q = false;
        if (this.f1049r) {
            this.f1049r = false;
            H(this.f1050s);
        }
    }

    public void W() {
        if (this.f1048q) {
            return;
        }
        this.f1048q = true;
        this.f1049r = false;
        this.f1050s = false;
    }

    public MenuItem a(int i10, int i11, int i12, CharSequence charSequence) {
        int iX = x(i12);
        e eVarF = f(i10, i11, i12, iX, charSequence, this.f1043l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1044m;
        if (contextMenuInfo != null) {
            eVarF.u(contextMenuInfo);
        }
        ArrayList arrayList = this.f1037f;
        arrayList.add(m(arrayList, iX), eVarF);
        H(true);
        return eVarF;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        PackageManager packageManager = this.f1032a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i15 = 0; i15 < size; i15++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i15);
            int i16 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i16 < 0 ? intent : intentArr[i16]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i14 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i14] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(g gVar, Context context) {
        this.f1054w.add(new WeakReference(gVar));
        gVar.h(context, this);
        this.f1042k = true;
    }

    public void c() {
        a aVar = this.f1036e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        e eVar = this.f1055x;
        if (eVar != null) {
            e(eVar);
        }
        this.f1037f.clear();
        H(true);
    }

    public void clearHeader() {
        this.f1046o = null;
        this.f1045n = null;
        this.f1047p = null;
        H(false);
    }

    @Override // android.view.Menu
    public void close() {
        d(true);
    }

    public final void d(boolean z10) {
        if (this.f1052u) {
            return;
        }
        this.f1052u = true;
        for (WeakReference weakReference : this.f1054w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f1054w.remove(weakReference);
            } else {
                gVar.a(this, z10);
            }
        }
        this.f1052u = false;
    }

    public boolean e(e eVar) {
        boolean zD = false;
        if (!this.f1054w.isEmpty() && this.f1055x == eVar) {
            W();
            for (WeakReference weakReference : this.f1054w) {
                g gVar = (g) weakReference.get();
                if (gVar != null) {
                    zD = gVar.d(this, eVar);
                    if (zD) {
                        break;
                    }
                } else {
                    this.f1054w.remove(weakReference);
                }
            }
            V();
            if (zD) {
                this.f1055x = null;
            }
        }
        return zD;
    }

    public final e f(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new e(this, i10, i11, i12, i13, charSequence, i14);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i10) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = (e) this.f1037f.get(i11);
            if (eVar.getItemId() == i10) {
                return eVar;
            }
            if (eVar.hasSubMenu() && (menuItemFindItem = eVar.getSubMenu().findItem(i10)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public boolean g(d dVar, MenuItem menuItem) {
        a aVar = this.f1036e;
        return aVar != null && aVar.a(dVar, menuItem);
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i10) {
        return (MenuItem) this.f1037f.get(i10);
    }

    public final void h(boolean z10) {
        if (this.f1054w.isEmpty()) {
            return;
        }
        W();
        for (WeakReference weakReference : this.f1054w) {
            g gVar = (g) weakReference.get();
            if (gVar == null) {
                this.f1054w.remove(weakReference);
            } else {
                gVar.b(z10);
            }
        }
        V();
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1057z) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((e) this.f1037f.get(i10)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(j jVar, g gVar) {
        if (this.f1054w.isEmpty()) {
            return false;
        }
        boolean zJ = gVar != null ? gVar.j(jVar) : false;
        for (WeakReference weakReference : this.f1054w) {
            g gVar2 = (g) weakReference.get();
            if (gVar2 == null) {
                this.f1054w.remove(weakReference);
            } else if (!zJ) {
                zJ = gVar2.j(jVar);
            }
        }
        return zJ;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return o(i10, keyEvent) != null;
    }

    public boolean j(e eVar) {
        boolean zF = false;
        if (this.f1054w.isEmpty()) {
            return false;
        }
        W();
        for (WeakReference weakReference : this.f1054w) {
            g gVar = (g) weakReference.get();
            if (gVar != null) {
                zF = gVar.f(this, eVar);
                if (zF) {
                    break;
                }
            } else {
                this.f1054w.remove(weakReference);
            }
        }
        V();
        if (zF) {
            this.f1055x = eVar;
        }
        return zF;
    }

    public int k(int i10) {
        return l(i10, 0);
    }

    public int l(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (((e) this.f1037f.get(i11)).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public int n(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((e) this.f1037f.get(i11)).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public e o(int i10, KeyEvent keyEvent) {
        ArrayList arrayList = this.f1053v;
        arrayList.clear();
        p(arrayList, i10, keyEvent);
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
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = (e) arrayList.get(i11);
            char alphabeticShortcut = zD ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zD && alphabeticShortcut == '\b' && i10 == 67))) {
                return eVar;
            }
        }
        return null;
    }

    public void p(List list, int i10, KeyEvent keyEvent) {
        boolean zD = D();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.f1037f.size();
            for (int i11 = 0; i11 < size; i11++) {
                e eVar = (e) this.f1037f.get(i11);
                if (eVar.hasSubMenu()) {
                    ((d) eVar.getSubMenu()).p(list, i10, keyEvent);
                }
                char alphabeticShortcut = zD ? eVar.getAlphabeticShortcut() : eVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zD ? eVar.getAlphabeticModifiers() : eVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zD && alphabeticShortcut == '\b' && i10 == 67)) && eVar.isEnabled()) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i10, int i11) {
        return I(findItem(i10), i11);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        e eVarO = o(i10, keyEvent);
        boolean zI = eVarO != null ? I(eVarO, i11) : false;
        if ((i11 & 2) != 0) {
            d(true);
        }
        return zI;
    }

    public void q() {
        ArrayList arrayListA = A();
        if (this.f1042k) {
            boolean zC = false;
            for (WeakReference weakReference : this.f1054w) {
                g gVar = (g) weakReference.get();
                if (gVar == null) {
                    this.f1054w.remove(weakReference);
                } else {
                    zC |= gVar.c();
                }
            }
            if (zC) {
                this.f1040i.clear();
                this.f1041j.clear();
                int size = arrayListA.size();
                for (int i10 = 0; i10 < size; i10++) {
                    e eVar = (e) arrayListA.get(i10);
                    if (eVar.k()) {
                        this.f1040i.add(eVar);
                    } else {
                        this.f1041j.add(eVar);
                    }
                }
            } else {
                this.f1040i.clear();
                this.f1041j.clear();
                this.f1041j.addAll(A());
            }
            this.f1042k = false;
        }
    }

    public ArrayList r() {
        q();
        return this.f1040i;
    }

    @Override // android.view.Menu
    public void removeGroup(int i10) {
        int iK = k(i10);
        if (iK >= 0) {
            int size = this.f1037f.size() - iK;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || ((e) this.f1037f.get(iK)).getGroupId() != i10) {
                    break;
                }
                K(iK, false);
                i11 = i12;
            }
            H(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i10) {
        K(n(i10), true);
    }

    public Context s() {
        return this.f1032a;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.f1037f.size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = (e) this.f1037f.get(i11);
            if (eVar.getGroupId() == i10) {
                eVar.s(z11);
                eVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f1056y = z10;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.f1037f.size();
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = (e) this.f1037f.get(i11);
            if (eVar.getGroupId() == i10) {
                eVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i10, boolean z10) {
        int size = this.f1037f.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = (e) this.f1037f.get(i11);
            if (eVar.getGroupId() == i10 && eVar.x(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            H(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f1034c = z10;
        H(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1037f.size();
    }

    public e t() {
        return this.f1055x;
    }

    public CharSequence u() {
        return this.f1045n;
    }

    public ArrayList v() {
        q();
        return this.f1041j;
    }

    public boolean w() {
        return this.f1051t;
    }

    public Resources y() {
        return this.f1033b;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10) {
        return a(0, 0, 0, this.f1033b.getString(i10));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, this.f1033b.getString(i10));
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        e eVar = (e) a(i10, i11, i12, charSequence);
        j jVar = new j(this.f1032a, this, eVar);
        eVar.w(jVar);
        return jVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f1033b.getString(i13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, this.f1033b.getString(i13));
    }

    public d z() {
        return this;
    }
}
