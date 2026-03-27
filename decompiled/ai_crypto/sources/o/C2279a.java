package o;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: o.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2279a implements K.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f19895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f19896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f19897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f19898g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public char f19900i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f19902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f19903l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f19904m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f19905n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f19906o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19899h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19901j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f19907p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f19908q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19909r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f19910s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f19911t = 16;

    public C2279a(Context context, int i7, int i8, int i9, int i10, CharSequence charSequence) {
        this.f19903l = context;
        this.f19892a = i8;
        this.f19893b = i7;
        this.f19894c = i10;
        this.f19895d = charSequence;
    }

    public final void a() {
        Drawable drawable = this.f19902k;
        if (drawable != null) {
            if (this.f19909r || this.f19910s) {
                Drawable drawableL = J.a.l(drawable);
                this.f19902k = drawableL;
                Drawable drawableMutate = drawableL.mutate();
                this.f19902k = drawableMutate;
                if (this.f19909r) {
                    J.a.i(drawableMutate, this.f19907p);
                }
                if (this.f19910s) {
                    J.a.j(this.f19902k, this.f19908q);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public K.b setActionView(int i7) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public K.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public K.b setShowAsActionFlags(int i7) {
        setShowAsAction(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f19901j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f19900i;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f19905n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f19893b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f19902k;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f19907p;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f19908q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f19897f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f19892a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f19899h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f19898g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f19894c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f19895d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f19896e;
        return charSequence != null ? charSequence : this.f19895d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f19906o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f19911t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f19911t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f19911t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f19911t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7) {
        this.f19900i = Character.toLowerCase(c7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f19911t = (z7 ? 1 : 0) | (this.f19911t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.f19911t = (z7 ? 2 : 0) | (this.f19911t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f19911t = (z7 ? 16 : 0) | (this.f19911t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f19902k = drawable;
        a();
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f19907p = colorStateList;
        this.f19909r = true;
        a();
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f19908q = mode;
        this.f19910s = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f19897f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c7) {
        this.f19898g = c7;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f19904m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8) {
        this.f19898g = c7;
        this.f19900i = Character.toLowerCase(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f19895d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f19896e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        this.f19911t = (this.f19911t & 8) | (z7 ? 0 : 8);
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c7, int i7) {
        this.f19900i = Character.toLowerCase(c7);
        this.f19901j = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public K.b setContentDescription(CharSequence charSequence) {
        this.f19905n = charSequence;
        return this;
    }

    @Override // K.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c7, int i7) {
        this.f19898g = c7;
        this.f19899h = KeyEvent.normalizeMetaState(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i7) {
        this.f19895d = this.f19903l.getResources().getString(i7);
        return this;
    }

    @Override // android.view.MenuItem
    public K.b setTooltipText(CharSequence charSequence) {
        this.f19906o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i7) {
        this.f19902k = G.a.getDrawable(this.f19903l, i7);
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c7, char c8, int i7, int i8) {
        this.f19898g = c7;
        this.f19899h = KeyEvent.normalizeMetaState(i7);
        this.f19900i = Character.toLowerCase(c8);
        this.f19901j = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i7) {
    }
}
