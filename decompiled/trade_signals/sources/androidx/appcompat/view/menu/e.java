package androidx.appcompat.view.menu;

import T.AbstractC0920b;
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
import g.AbstractC1770g;
import i.AbstractC1906a;

/* JADX INFO: loaded from: classes.dex */
public final class e implements N.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public View f10476A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f10477B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f10479D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f10484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f10485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f10486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f10487h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f10489j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f10491l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f10493n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f10494o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Runnable f10495p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f10496q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f10497r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f10498s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10505z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10488i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10490k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10492m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f10499t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f10500u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10501v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10502w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10503x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10504y = 16;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f10478C = false;

    public e(d dVar, int i8, int i9, int i10, int i11, CharSequence charSequence, int i12) {
        this.f10493n = dVar;
        this.f10480a = i9;
        this.f10481b = i8;
        this.f10482c = i10;
        this.f10483d = i11;
        this.f10484e = charSequence;
        this.f10505z = i12;
    }

    public static void b(StringBuilder sb, int i8, int i9, String str) {
        if ((i8 & i9) == i9) {
            sb.append(str);
        }
    }

    public boolean A() {
        return (this.f10505z & 4) == 4;
    }

    public void a() {
        this.f10493n.F(this);
    }

    public final Drawable c(Drawable drawable) {
        if (drawable != null && this.f10503x && (this.f10501v || this.f10502w)) {
            drawable = M.a.i(drawable).mutate();
            if (this.f10501v) {
                M.a.f(drawable, this.f10499t);
            }
            if (this.f10502w) {
                M.a.g(drawable, this.f10500u);
            }
            this.f10503x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f10505z & 8) == 0) {
            return false;
        }
        if (this.f10476A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f10477B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f10493n.e(this);
        }
        return false;
    }

    public int d() {
        return this.f10483d;
    }

    public char e() {
        return this.f10493n.D() ? this.f10489j : this.f10487h;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        if (!i()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f10477B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f10493n.j(this);
        }
        return false;
    }

    public String f() {
        int i8;
        char cE = e();
        if (cE == 0) {
            return "";
        }
        Resources resources = this.f10493n.s().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f10493n.s()).hasPermanentMenuKey()) {
            sb.append(resources.getString(AbstractC1770g.f17769m));
        }
        int i9 = this.f10493n.D() ? this.f10490k : this.f10488i;
        b(sb, i9, 65536, resources.getString(AbstractC1770g.f17765i));
        b(sb, i9, 4096, resources.getString(AbstractC1770g.f17761e));
        b(sb, i9, 2, resources.getString(AbstractC1770g.f17760d));
        b(sb, i9, 1, resources.getString(AbstractC1770g.f17766j));
        b(sb, i9, 4, resources.getString(AbstractC1770g.f17768l));
        b(sb, i9, 8, resources.getString(AbstractC1770g.f17764h));
        if (cE == '\b') {
            i8 = AbstractC1770g.f17762f;
        } else if (cE == '\n') {
            i8 = AbstractC1770g.f17763g;
        } else {
            if (cE != ' ') {
                sb.append(cE);
                return sb.toString();
            }
            i8 = AbstractC1770g.f17767k;
        }
        sb.append(resources.getString(i8));
        return sb.toString();
    }

    public AbstractC0920b g() {
        return null;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View view = this.f10476A;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f10490k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f10489j;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f10497r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f10481b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f10491l;
        if (drawable != null) {
            return c(drawable);
        }
        if (this.f10492m == 0) {
            return null;
        }
        Drawable drawableB = AbstractC1906a.b(this.f10493n.s(), this.f10492m);
        this.f10492m = 0;
        this.f10491l = drawableB;
        return c(drawableB);
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f10499t;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f10500u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f10486g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f10480a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f10479D;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f10488i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f10487h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f10482c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f10494o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f10484e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f10485f;
        return charSequence != null ? charSequence : this.f10484e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f10498s;
    }

    public CharSequence h(h.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f10494o != null;
    }

    public boolean i() {
        return ((this.f10505z & 8) == 0 || this.f10476A == null) ? false : true;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f10478C;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f10504y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f10504y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f10504y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f10504y & 8) == 0;
    }

    public boolean j() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f10496q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        d dVar = this.f10493n;
        if (dVar.g(dVar, this)) {
            return true;
        }
        Runnable runnable = this.f10495p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f10486g == null) {
            return false;
        }
        try {
            this.f10493n.s().startActivity(this.f10486g);
            return true;
        } catch (ActivityNotFoundException e8) {
            Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e8);
            return false;
        }
    }

    public boolean k() {
        return (this.f10504y & 32) == 32;
    }

    public boolean l() {
        return (this.f10504y & 4) != 0;
    }

    public boolean m() {
        return (this.f10505z & 1) == 1;
    }

    public boolean n() {
        return (this.f10505z & 2) == 2;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public N.b setActionView(int i8) {
        Context contextS = this.f10493n.s();
        setActionView(LayoutInflater.from(contextS).inflate(i8, (ViewGroup) new LinearLayout(contextS), false));
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public N.b setActionView(View view) {
        int i8;
        this.f10476A = view;
        if (view != null && view.getId() == -1 && (i8 = this.f10480a) > 0) {
            view.setId(i8);
        }
        this.f10493n.F(this);
        return this;
    }

    public void q(boolean z7) {
        this.f10478C = z7;
        this.f10493n.H(false);
    }

    public void r(boolean z7) {
        int i8 = this.f10504y;
        int i9 = (z7 ? 2 : 0) | (i8 & (-3));
        this.f10504y = i9;
        if (i8 != i9) {
            this.f10493n.H(false);
        }
    }

    public void s(boolean z7) {
        this.f10504y = (z7 ? 4 : 0) | (this.f10504y & (-5));
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8) {
        if (this.f10489j == c8) {
            return this;
        }
        this.f10489j = Character.toLowerCase(c8);
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        int i8 = this.f10504y;
        int i9 = (z7 ? 1 : 0) | (i8 & (-2));
        this.f10504y = i9;
        if (i8 != i9) {
            this.f10493n.H(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        if ((this.f10504y & 4) != 0) {
            this.f10493n.N(this);
        } else {
            r(z7);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public N.b setContentDescription(CharSequence charSequence) {
        this.f10497r = charSequence;
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f10504y = z7 ? this.f10504y | 16 : this.f10504y & (-17);
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i8) {
        this.f10491l = null;
        this.f10492m = i8;
        this.f10503x = true;
        this.f10493n.H(false);
        return this;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f10499t = colorStateList;
        this.f10501v = true;
        this.f10503x = true;
        this.f10493n.H(false);
        return this;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f10500u = mode;
        this.f10502w = true;
        this.f10503x = true;
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f10486g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8) {
        if (this.f10487h == c8) {
            return this;
        }
        this.f10487h = c8;
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f10477B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f10496q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9) {
        this.f10487h = c8;
        this.f10489j = Character.toLowerCase(c9);
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i8) {
        int i9 = i8 & 3;
        if (i9 != 0 && i9 != 1 && i9 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f10505z = i8;
        this.f10493n.F(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i8) {
        return setTitle(this.f10493n.s().getString(i8));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f10485f = charSequence;
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public N.b setTooltipText(CharSequence charSequence) {
        this.f10498s = charSequence;
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        if (x(z7)) {
            this.f10493n.G(this);
        }
        return this;
    }

    public void t(boolean z7) {
        this.f10504y = z7 ? this.f10504y | 32 : this.f10504y & (-33);
    }

    public String toString() {
        CharSequence charSequence = this.f10484e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f10479D = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public N.b setShowAsActionFlags(int i8) {
        setShowAsAction(i8);
        return this;
    }

    public void w(j jVar) {
        this.f10494o = jVar;
        jVar.setHeaderTitle(getTitle());
    }

    public boolean x(boolean z7) {
        int i8 = this.f10504y;
        int i9 = (z7 ? 0 : 8) | (i8 & (-9));
        this.f10504y = i9;
        return i8 != i9;
    }

    public boolean y() {
        return this.f10493n.w();
    }

    public boolean z() {
        return this.f10493n.E() && e() != 0;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8, int i8) {
        if (this.f10489j == c8 && this.f10490k == i8) {
            return this;
        }
        this.f10489j = Character.toLowerCase(c8);
        this.f10490k = KeyEvent.normalizeMetaState(i8);
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f10492m = 0;
        this.f10491l = drawable;
        this.f10503x = true;
        this.f10493n.H(false);
        return this;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c8, int i8) {
        if (this.f10487h == c8 && this.f10488i == i8) {
            return this;
        }
        this.f10487h = c8;
        this.f10488i = KeyEvent.normalizeMetaState(i8);
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9, int i8, int i9) {
        this.f10487h = c8;
        this.f10488i = KeyEvent.normalizeMetaState(i8);
        this.f10489j = Character.toLowerCase(c9);
        this.f10490k = KeyEvent.normalizeMetaState(i9);
        this.f10493n.H(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f10484e = charSequence;
        this.f10493n.H(false);
        j jVar = this.f10494o;
        if (jVar != null) {
            jVar.setHeaderTitle(charSequence);
        }
        return this;
    }
}
