package androidx.appcompat.view.menu;

import H.AbstractC0268b;
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
import i.AbstractC1284a;

/* JADX INFO: loaded from: classes.dex */
public final class e implements B.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public View f6434A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f6435B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f6437D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f6442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f6443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f6444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f6445h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f6447j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f6449l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f6451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f6452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Runnable f6453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f6454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f6455r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f6456s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6463z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6446i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6448k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6450m = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ColorStateList f6457t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f6458u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6459v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6460w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6461x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6462y = 16;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f6436C = false;

    public e(d dVar, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        this.f6451n = dVar;
        this.f6438a = i5;
        this.f6439b = i4;
        this.f6440c = i6;
        this.f6441d = i7;
        this.f6442e = charSequence;
        this.f6463z = i8;
    }

    public static void b(StringBuilder sb, int i4, int i5, String str) {
        if ((i4 & i5) == i5) {
            sb.append(str);
        }
    }

    public boolean A() {
        return (this.f6463z & 4) == 4;
    }

    public void a() {
        this.f6451n.E(this);
    }

    public final Drawable c(Drawable drawable) {
        if (drawable != null && this.f6461x && (this.f6459v || this.f6460w)) {
            drawable = A.a.j(drawable).mutate();
            if (this.f6459v) {
                A.a.g(drawable, this.f6457t);
            }
            if (this.f6460w) {
                A.a.h(drawable, this.f6458u);
            }
            this.f6461x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f6463z & 8) == 0) {
            return false;
        }
        if (this.f6434A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f6435B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f6451n.e(this);
        }
        return false;
    }

    public int d() {
        return this.f6441d;
    }

    public char e() {
        return this.f6451n.C() ? this.f6447j : this.f6445h;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        if (!i()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f6435B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f6451n.j(this);
        }
        return false;
    }

    public String f() {
        char cE = e();
        if (cE == 0) {
            return "";
        }
        Resources resources = this.f6451n.s().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f6451n.s()).hasPermanentMenuKey()) {
            sb.append(resources.getString(g.g.f11675k));
        }
        int i4 = this.f6451n.C() ? this.f6448k : this.f6446i;
        b(sb, i4, 65536, resources.getString(g.g.f11671g));
        b(sb, i4, 4096, resources.getString(g.g.f11667c));
        b(sb, i4, 2, resources.getString(g.g.f11666b));
        b(sb, i4, 1, resources.getString(g.g.f11672h));
        b(sb, i4, 4, resources.getString(g.g.f11674j));
        b(sb, i4, 8, resources.getString(g.g.f11670f));
        if (cE == '\b') {
            sb.append(resources.getString(g.g.f11668d));
        } else if (cE == '\n') {
            sb.append(resources.getString(g.g.f11669e));
        } else if (cE != ' ') {
            sb.append(cE);
        } else {
            sb.append(resources.getString(g.g.f11673i));
        }
        return sb.toString();
    }

    public AbstractC0268b g() {
        return null;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View view = this.f6434A;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f6448k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f6447j;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f6455r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f6439b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f6449l;
        if (drawable != null) {
            return c(drawable);
        }
        if (this.f6450m == 0) {
            return null;
        }
        Drawable drawableB = AbstractC1284a.b(this.f6451n.s(), this.f6450m);
        this.f6450m = 0;
        this.f6449l = drawableB;
        return c(drawableB);
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f6457t;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f6458u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f6444g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f6438a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f6437D;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f6446i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f6445h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f6440c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f6452o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f6442e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f6443f;
        return charSequence != null ? charSequence : this.f6442e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f6456s;
    }

    public CharSequence h(h.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f6452o != null;
    }

    public boolean i() {
        return ((this.f6463z & 8) == 0 || this.f6434A == null) ? false : true;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f6436C;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f6462y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f6462y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f6462y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f6462y & 8) == 0;
    }

    public boolean j() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f6454q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        d dVar = this.f6451n;
        if (dVar.g(dVar, this)) {
            return true;
        }
        Runnable runnable = this.f6453p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f6444g == null) {
            return false;
        }
        try {
            this.f6451n.s().startActivity(this.f6444g);
            return true;
        } catch (ActivityNotFoundException e4) {
            Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e4);
            return false;
        }
    }

    public boolean k() {
        return (this.f6462y & 32) == 32;
    }

    public boolean l() {
        return (this.f6462y & 4) != 0;
    }

    public boolean m() {
        return (this.f6463z & 1) == 1;
    }

    public boolean n() {
        return (this.f6463z & 2) == 2;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public B.b setActionView(int i4) {
        Context contextS = this.f6451n.s();
        setActionView(LayoutInflater.from(contextS).inflate(i4, (ViewGroup) new LinearLayout(contextS), false));
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public B.b setActionView(View view) {
        int i4;
        this.f6434A = view;
        if (view != null && view.getId() == -1 && (i4 = this.f6438a) > 0) {
            view.setId(i4);
        }
        this.f6451n.E(this);
        return this;
    }

    public void q(boolean z4) {
        this.f6436C = z4;
        this.f6451n.G(false);
    }

    public void r(boolean z4) {
        int i4 = this.f6462y;
        int i5 = (z4 ? 2 : 0) | (i4 & (-3));
        this.f6462y = i5;
        if (i4 != i5) {
            this.f6451n.G(false);
        }
    }

    public void s(boolean z4) {
        this.f6462y = (z4 ? 4 : 0) | (this.f6462y & (-5));
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c4) {
        if (this.f6447j == c4) {
            return this;
        }
        this.f6447j = Character.toLowerCase(c4);
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z4) {
        int i4 = this.f6462y;
        int i5 = (z4 ? 1 : 0) | (i4 & (-2));
        this.f6462y = i5;
        if (i4 != i5) {
            this.f6451n.G(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z4) {
        if ((this.f6462y & 4) != 0) {
            this.f6451n.M(this);
            return this;
        }
        r(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z4) {
        if (z4) {
            this.f6462y |= 16;
        } else {
            this.f6462y &= -17;
        }
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f6450m = 0;
        this.f6449l = drawable;
        this.f6461x = true;
        this.f6451n.G(false);
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f6457t = colorStateList;
        this.f6459v = true;
        this.f6461x = true;
        this.f6451n.G(false);
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f6458u = mode;
        this.f6460w = true;
        this.f6461x = true;
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f6444g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c4) {
        if (this.f6445h == c4) {
            return this;
        }
        this.f6445h = c4;
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f6435B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f6454q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c4, char c5) {
        this.f6445h = c4;
        this.f6447j = Character.toLowerCase(c5);
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i4) {
        int i5 = i4 & 3;
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f6463z = i4;
        this.f6451n.E(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f6442e = charSequence;
        this.f6451n.G(false);
        j jVar = this.f6452o;
        if (jVar != null) {
            jVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f6443f = charSequence;
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z4) {
        if (x(z4)) {
            this.f6451n.F(this);
        }
        return this;
    }

    public void t(boolean z4) {
        if (z4) {
            this.f6462y |= 32;
        } else {
            this.f6462y &= -33;
        }
    }

    public String toString() {
        CharSequence charSequence = this.f6442e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f6437D = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public B.b setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
        return this;
    }

    public void w(j jVar) {
        this.f6452o = jVar;
        jVar.setHeaderTitle(getTitle());
    }

    public boolean x(boolean z4) {
        int i4 = this.f6462y;
        int i5 = (z4 ? 0 : 8) | (i4 & (-9));
        this.f6462y = i5;
        return i4 != i5;
    }

    public boolean y() {
        return this.f6451n.w();
    }

    public boolean z() {
        return this.f6451n.D() && e() != 0;
    }

    @Override // android.view.MenuItem
    public B.b setContentDescription(CharSequence charSequence) {
        this.f6455r = charSequence;
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public B.b setTooltipText(CharSequence charSequence) {
        this.f6456s = charSequence;
        this.f6451n.G(false);
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c4, int i4) {
        if (this.f6447j == c4 && this.f6448k == i4) {
            return this;
        }
        this.f6447j = Character.toLowerCase(c4);
        this.f6448k = KeyEvent.normalizeMetaState(i4);
        this.f6451n.G(false);
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c4, int i4) {
        if (this.f6445h == c4 && this.f6446i == i4) {
            return this;
        }
        this.f6445h = c4;
        this.f6446i = KeyEvent.normalizeMetaState(i4);
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f6445h = c4;
        this.f6446i = KeyEvent.normalizeMetaState(i4);
        this.f6447j = Character.toLowerCase(c5);
        this.f6448k = KeyEvent.normalizeMetaState(i5);
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i4) {
        this.f6449l = null;
        this.f6450m = i4;
        this.f6461x = true;
        this.f6451n.G(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i4) {
        return setTitle(this.f6451n.s().getString(i4));
    }
}
