package n;

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
import x.AbstractC1909a;

/* JADX INFO: renamed from: n.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1610a implements B.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f13548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f13549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f13550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f13551h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f13553j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f13555l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Context f13557n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f13558o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f13559p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f13560q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13552i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13554k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13556m = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ColorStateList f13561r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PorterDuff.Mode f13562s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13563t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13564u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13565v = 16;

    public C1610a(Context context, int i4, int i5, int i6, int i7, CharSequence charSequence) {
        this.f13557n = context;
        this.f13544a = i5;
        this.f13545b = i4;
        this.f13546c = i6;
        this.f13547d = i7;
        this.f13548e = charSequence;
    }

    public final void a() {
        Drawable drawable = this.f13555l;
        if (drawable != null) {
            if (this.f13563t || this.f13564u) {
                Drawable drawableJ = A.a.j(drawable);
                this.f13555l = drawableJ;
                Drawable drawableMutate = drawableJ.mutate();
                this.f13555l = drawableMutate;
                if (this.f13563t) {
                    A.a.g(drawableMutate, this.f13561r);
                }
                if (this.f13564u) {
                    A.a.h(this.f13555l, this.f13562s);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public B.b setActionView(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public B.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public B.b setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
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
        return this.f13554k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f13553j;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f13559p;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f13545b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f13555l;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f13561r;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f13562s;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f13550g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f13544a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f13552i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f13551h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f13547d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f13548e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f13549f;
        return charSequence != null ? charSequence : this.f13548e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f13560q;
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
        return (this.f13565v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f13565v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f13565v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f13565v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c4) {
        this.f13553j = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z4) {
        this.f13565v = (z4 ? 1 : 0) | (this.f13565v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z4) {
        this.f13565v = (z4 ? 2 : 0) | (this.f13565v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z4) {
        this.f13565v = (z4 ? 16 : 0) | (this.f13565v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f13555l = drawable;
        this.f13556m = 0;
        a();
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f13561r = colorStateList;
        this.f13563t = true;
        a();
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13562s = mode;
        this.f13564u = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f13550g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c4) {
        this.f13551h = c4;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13558o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c4, char c5) {
        this.f13551h = c4;
        this.f13553j = Character.toLowerCase(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f13548e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13549f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z4) {
        this.f13565v = (this.f13565v & 8) | (z4 ? 0 : 8);
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c4, int i4) {
        this.f13553j = Character.toLowerCase(c4);
        this.f13554k = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public B.b setContentDescription(CharSequence charSequence) {
        this.f13559p = charSequence;
        return this;
    }

    @Override // B.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c4, int i4) {
        this.f13551h = c4;
        this.f13552i = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i4) {
        this.f13548e = this.f13557n.getResources().getString(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public B.b setTooltipText(CharSequence charSequence) {
        this.f13560q = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c4, char c5, int i4, int i5) {
        this.f13551h = c4;
        this.f13552i = KeyEvent.normalizeMetaState(i4);
        this.f13553j = Character.toLowerCase(c5);
        this.f13554k = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i4) {
        this.f13556m = i4;
        this.f13555l = AbstractC1909a.getDrawable(this.f13557n, i4);
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i4) {
    }
}
