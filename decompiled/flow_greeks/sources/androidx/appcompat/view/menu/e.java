package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements n0.b {
    public View A;
    public MenuItem.OnActionExpandListener B;
    public ContextMenu.ContextMenuInfo D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f1062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f1063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f1064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f1065h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f1067j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f1069l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f1071n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f1072o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Runnable f1073p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1074q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f1075r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f1076s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1083z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1066i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1068k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1070m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f1077t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f1078u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1079v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1080w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1081x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1082y = 16;
    public boolean C = false;

    public e(d dVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f1071n = dVar;
        this.f1058a = i11;
        this.f1059b = i10;
        this.f1060c = i12;
        this.f1061d = i13;
        this.f1062e = charSequence;
        this.f1083z = i14;
    }

    public static void b(StringBuilder sb2, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    public boolean A() {
        return (this.f1083z & 4) == 4;
    }

    public void a() {
        this.f1071n.F(this);
    }

    public final Drawable c(Drawable drawable) {
        if (drawable != null && this.f1081x && (this.f1079v || this.f1080w)) {
            drawable = m0.a.i(drawable).mutate();
            if (this.f1079v) {
                m0.a.f(drawable, this.f1077t);
            }
            if (this.f1080w) {
                m0.a.g(drawable, this.f1078u);
            }
            this.f1081x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1083z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1071n.e(this);
        }
        return false;
    }

    public int d() {
        return this.f1061d;
    }

    public char e() {
        return this.f1071n.D() ? this.f1067j : this.f1065h;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        if (!i()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1071n.j(this);
        }
        return false;
    }

    public String f() {
        char cE = e();
        if (cE == 0) {
            return "";
        }
        Resources resources = this.f1071n.s().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f1071n.s()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(g.g.f9759m));
        }
        int i10 = this.f1071n.D() ? this.f1068k : this.f1066i;
        b(sb2, i10, 65536, resources.getString(g.g.f9755i));
        b(sb2, i10, 4096, resources.getString(g.g.f9751e));
        b(sb2, i10, 2, resources.getString(g.g.f9750d));
        b(sb2, i10, 1, resources.getString(g.g.f9756j));
        b(sb2, i10, 4, resources.getString(g.g.f9758l));
        b(sb2, i10, 8, resources.getString(g.g.f9754h));
        if (cE == '\b') {
            sb2.append(resources.getString(g.g.f9752f));
        } else if (cE == '\n') {
            sb2.append(resources.getString(g.g.f9753g));
        } else if (cE != ' ') {
            sb2.append(cE);
        } else {
            sb2.append(resources.getString(g.g.f9757k));
        }
        return sb2.toString();
    }

    public t0.b g() {
        return null;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1068k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1067j;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1075r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1059b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1069l;
        if (drawable != null) {
            return c(drawable);
        }
        if (this.f1070m == 0) {
            return null;
        }
        Drawable drawableB = i.a.b(this.f1071n.s(), this.f1070m);
        this.f1070m = 0;
        this.f1069l = drawableB;
        return c(drawableB);
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1077t;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1078u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1064g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1058a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1066i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1065h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1060c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1072o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1062e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1063f;
        return charSequence != null ? charSequence : this.f1062e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1076s;
    }

    public CharSequence h(h.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1072o != null;
    }

    public boolean i() {
        return ((this.f1083z & 8) == 0 || this.A == null) ? false : true;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1082y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1082y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1082y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1082y & 8) == 0;
    }

    public boolean j() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1074q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        d dVar = this.f1071n;
        if (dVar.g(dVar, this)) {
            return true;
        }
        Runnable runnable = this.f1073p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1064g == null) {
            return false;
        }
        try {
            this.f1071n.s().startActivity(this.f1064g);
            return true;
        } catch (ActivityNotFoundException e10) {
            Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            return false;
        }
    }

    public boolean k() {
        return (this.f1082y & 32) == 32;
    }

    public boolean l() {
        return (this.f1082y & 4) != 0;
    }

    public boolean m() {
        return (this.f1083z & 1) == 1;
    }

    public boolean n() {
        return (this.f1083z & 2) == 2;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public n0.b setActionView(int i10) {
        Context contextS = this.f1071n.s();
        setActionView(LayoutInflater.from(contextS).inflate(i10, (ViewGroup) new LinearLayout(contextS), false));
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public n0.b setActionView(View view) {
        int i10;
        this.A = view;
        if (view != null && view.getId() == -1 && (i10 = this.f1058a) > 0) {
            view.setId(i10);
        }
        this.f1071n.F(this);
        return this;
    }

    public void q(boolean z10) {
        this.C = z10;
        this.f1071n.H(false);
    }

    public void r(boolean z10) {
        int i10 = this.f1082y;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.f1082y = i11;
        if (i10 != i11) {
            this.f1071n.H(false);
        }
    }

    public void s(boolean z10) {
        this.f1082y = (z10 ? 4 : 0) | (this.f1082y & (-5));
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f1067j == c10) {
            return this;
        }
        this.f1067j = Character.toLowerCase(c10);
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f1082y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f1082y = i11;
        if (i10 != i11) {
            this.f1071n.H(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f1082y & 4) != 0) {
            this.f1071n.N(this);
            return this;
        }
        r(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f1082y |= 16;
        } else {
            this.f1082y &= -17;
        }
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1070m = 0;
        this.f1069l = drawable;
        this.f1081x = true;
        this.f1071n.H(false);
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1077t = colorStateList;
        this.f1079v = true;
        this.f1081x = true;
        this.f1071n.H(false);
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1078u = mode;
        this.f1080w = true;
        this.f1081x = true;
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1064g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f1065h == c10) {
            return this;
        }
        this.f1065h = c10;
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1074q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1065h = c10;
        this.f1067j = Character.toLowerCase(c11);
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1083z = i10;
        this.f1071n.F(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1062e = charSequence;
        this.f1071n.H(false);
        j jVar = this.f1072o;
        if (jVar != null) {
            jVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1063f = charSequence;
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (x(z10)) {
            this.f1071n.G(this);
        }
        return this;
    }

    public void t(boolean z10) {
        if (z10) {
            this.f1082y |= 32;
        } else {
            this.f1082y &= -33;
        }
    }

    public String toString() {
        CharSequence charSequence = this.f1062e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.D = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public n0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void w(j jVar) {
        this.f1072o = jVar;
        jVar.setHeaderTitle(getTitle());
    }

    public boolean x(boolean z10) {
        int i10 = this.f1082y;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f1082y = i11;
        return i10 != i11;
    }

    public boolean y() {
        return this.f1071n.w();
    }

    public boolean z() {
        return this.f1071n.E() && e() != 0;
    }

    @Override // android.view.MenuItem
    public n0.b setContentDescription(CharSequence charSequence) {
        this.f1075r = charSequence;
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public n0.b setTooltipText(CharSequence charSequence) {
        this.f1076s = charSequence;
        this.f1071n.H(false);
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f1067j == c10 && this.f1068k == i10) {
            return this;
        }
        this.f1067j = Character.toLowerCase(c10);
        this.f1068k = KeyEvent.normalizeMetaState(i10);
        this.f1071n.H(false);
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f1065h == c10 && this.f1066i == i10) {
            return this;
        }
        this.f1065h = c10;
        this.f1066i = KeyEvent.normalizeMetaState(i10);
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1065h = c10;
        this.f1066i = KeyEvent.normalizeMetaState(i10);
        this.f1067j = Character.toLowerCase(c11);
        this.f1068k = KeyEvent.normalizeMetaState(i11);
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1069l = null;
        this.f1070m = i10;
        this.f1081x = true;
        this.f1071n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f1071n.s().getString(i10));
    }
}
