package androidx.appcompat.view.menu;

import Q.AbstractC0661b;
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
import h.AbstractC1662g;
import j.AbstractC2040a;

/* JADX INFO: loaded from: classes.dex */
public final class e implements K.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public View f6583A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f6584B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f6586D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f6591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f6592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f6593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f6594h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f6596j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f6598l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f6600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f6601o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Runnable f6602p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f6603q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f6604r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f6605s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6612z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6595i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6597k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6599m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f6606t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f6607u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6608v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6609w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6610x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6611y = 16;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f6585C = false;

    public e(d dVar, int i7, int i8, int i9, int i10, CharSequence charSequence, int i11) {
        this.f6600n = dVar;
        this.f6587a = i8;
        this.f6588b = i7;
        this.f6589c = i9;
        this.f6590d = i10;
        this.f6591e = charSequence;
        this.f6612z = i11;
    }

    public static void b(StringBuilder sb, int i7, int i8, String str) {
        if ((i7 & i8) == i8) {
            sb.append(str);
        }
    }

    public boolean A() {
        return (this.f6612z & 4) == 4;
    }

    public void a() {
        this.f6600n.E(this);
    }

    public final Drawable c(Drawable drawable) {
        if (drawable != null && this.f6610x && (this.f6608v || this.f6609w)) {
            drawable = J.a.l(drawable).mutate();
            if (this.f6608v) {
                J.a.i(drawable, this.f6606t);
            }
            if (this.f6609w) {
                J.a.j(drawable, this.f6607u);
            }
            this.f6610x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f6612z & 8) == 0) {
            return false;
        }
        if (this.f6583A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f6584B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f6600n.e(this);
        }
        return false;
    }

    public int d() {
        return this.f6590d;
    }

    public char e() {
        return this.f6600n.C() ? this.f6596j : this.f6594h;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        if (!i()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f6584B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f6600n.j(this);
        }
        return false;
    }

    public String f() {
        char cE = e();
        if (cE == 0) {
            return "";
        }
        Resources resources = this.f6600n.s().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f6600n.s()).hasPermanentMenuKey()) {
            sb.append(resources.getString(AbstractC1662g.f14472m));
        }
        int i7 = this.f6600n.C() ? this.f6597k : this.f6595i;
        b(sb, i7, 65536, resources.getString(AbstractC1662g.f14468i));
        b(sb, i7, 4096, resources.getString(AbstractC1662g.f14464e));
        b(sb, i7, 2, resources.getString(AbstractC1662g.f14463d));
        b(sb, i7, 1, resources.getString(AbstractC1662g.f14469j));
        b(sb, i7, 4, resources.getString(AbstractC1662g.f14471l));
        b(sb, i7, 8, resources.getString(AbstractC1662g.f14467h));
        if (cE == '\b') {
            sb.append(resources.getString(AbstractC1662g.f14465f));
        } else if (cE == '\n') {
            sb.append(resources.getString(AbstractC1662g.f14466g));
        } else if (cE != ' ') {
            sb.append(cE);
        } else {
            sb.append(resources.getString(AbstractC1662g.f14470k));
        }
        return sb.toString();
    }

    public AbstractC0661b g() {
        return null;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View view = this.f6583A;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f6597k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f6596j;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f6604r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f6588b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f6598l;
        if (drawable != null) {
            return c(drawable);
        }
        if (this.f6599m == 0) {
            return null;
        }
        Drawable drawableB = AbstractC2040a.b(this.f6600n.s(), this.f6599m);
        this.f6599m = 0;
        this.f6598l = drawableB;
        return c(drawableB);
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f6606t;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f6607u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f6593g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f6587a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f6586D;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f6595i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f6594h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f6589c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f6601o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f6591e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f6592f;
        return charSequence != null ? charSequence : this.f6591e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f6605s;
    }

    public CharSequence h(h.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f6601o != null;
    }

    public boolean i() {
        return ((this.f6612z & 8) == 0 || this.f6583A == null) ? false : true;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f6585C;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f6611y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f6611y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f6611y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f6611y & 8) == 0;
    }

    public boolean j() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f6603q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        d dVar = this.f6600n;
        if (dVar.g(dVar, this)) {
            return true;
        }
        Runnable runnable = this.f6602p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f6593g == null) {
            return false;
        }
        try {
            this.f6600n.s().startActivity(this.f6593g);
            return true;
        } catch (ActivityNotFoundException e7) {
            Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e7);
            return false;
        }
    }

    public boolean k() {
        return (this.f6611y & 32) == 32;
    }

    public boolean l() {
        return (this.f6611y & 4) != 0;
    }

    public boolean m() {
        return (this.f6612z & 1) == 1;
    }

    public boolean n() {
        return (this.f6612z & 2) == 2;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public K.b setActionView(int i7) {
        Context contextS = this.f6600n.s();
        setActionView(LayoutInflater.from(contextS).inflate(i7, (ViewGroup) new LinearLayout(contextS), false));
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public K.b setActionView(View view) {
        int i7;
        this.f6583A = view;
        if (view != null && view.getId() == -1 && (i7 = this.f6587a) > 0) {
            view.setId(i7);
        }
        this.f6600n.E(this);
        return this;
    }

    public void q(boolean z7) {
        this.f6585C = z7;
        this.f6600n.G(false);
    }

    public void r(boolean z7) {
        int i7 = this.f6611y;
        int i8 = (z7 ? 2 : 0) | (i7 & (-3));
        this.f6611y = i8;
        if (i7 != i8) {
            this.f6600n.G(false);
        }
    }

    public void s(boolean z7) {
        this.f6611y = (z7 ? 4 : 0) | (this.f6611y & (-5));
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7) {
        if (this.f6596j == c7) {
            return this;
        }
        this.f6596j = Character.toLowerCase(c7);
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        int i7 = this.f6611y;
        int i8 = (z7 ? 1 : 0) | (i7 & (-2));
        this.f6611y = i8;
        if (i7 != i8) {
            this.f6600n.G(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        if ((this.f6611y & 4) != 0) {
            this.f6600n.M(this);
        } else {
            r(z7);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        if (z7) {
            this.f6611y |= 16;
        } else {
            this.f6611y &= -17;
        }
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f6599m = 0;
        this.f6598l = drawable;
        this.f6610x = true;
        this.f6600n.G(false);
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f6606t = colorStateList;
        this.f6608v = true;
        this.f6610x = true;
        this.f6600n.G(false);
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f6607u = mode;
        this.f6609w = true;
        this.f6610x = true;
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f6593g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7) {
        if (this.f6594h == c7) {
            return this;
        }
        this.f6594h = c7;
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f6584B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f6603q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8) {
        this.f6594h = c7;
        this.f6596j = Character.toLowerCase(c8);
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i7) {
        int i8 = i7 & 3;
        if (i8 != 0 && i8 != 1 && i8 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f6612z = i7;
        this.f6600n.E(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f6591e = charSequence;
        this.f6600n.G(false);
        j jVar = this.f6601o;
        if (jVar != null) {
            jVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f6592f = charSequence;
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        if (x(z7)) {
            this.f6600n.F(this);
        }
        return this;
    }

    public void t(boolean z7) {
        if (z7) {
            this.f6611y |= 32;
        } else {
            this.f6611y &= -33;
        }
    }

    public String toString() {
        CharSequence charSequence = this.f6591e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f6586D = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public K.b setShowAsActionFlags(int i7) {
        setShowAsAction(i7);
        return this;
    }

    public void w(j jVar) {
        this.f6601o = jVar;
        jVar.setHeaderTitle(getTitle());
    }

    public boolean x(boolean z7) {
        int i7 = this.f6611y;
        int i8 = (z7 ? 0 : 8) | (i7 & (-9));
        this.f6611y = i8;
        return i7 != i8;
    }

    public boolean y() {
        return this.f6600n.w();
    }

    public boolean z() {
        return this.f6600n.D() && e() != 0;
    }

    @Override // android.view.MenuItem
    public K.b setContentDescription(CharSequence charSequence) {
        this.f6604r = charSequence;
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public K.b setTooltipText(CharSequence charSequence) {
        this.f6605s = charSequence;
        this.f6600n.G(false);
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7, int i7) {
        if (this.f6596j == c7 && this.f6597k == i7) {
            return this;
        }
        this.f6596j = Character.toLowerCase(c7);
        this.f6597k = KeyEvent.normalizeMetaState(i7);
        this.f6600n.G(false);
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c7, int i7) {
        if (this.f6594h == c7 && this.f6595i == i7) {
            return this;
        }
        this.f6594h = c7;
        this.f6595i = KeyEvent.normalizeMetaState(i7);
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f6594h = c7;
        this.f6595i = KeyEvent.normalizeMetaState(i7);
        this.f6596j = Character.toLowerCase(c8);
        this.f6597k = KeyEvent.normalizeMetaState(i8);
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f6598l = null;
        this.f6599m = i7;
        this.f6610x = true;
        this.f6600n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        return setTitle(this.f6600n.s().getString(i7));
    }
}
