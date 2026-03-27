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

/* JADX INFO: renamed from: n.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2384a implements N.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f21538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f21539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f21540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f21541g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public char f21543i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f21545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f21546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f21547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f21548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f21549o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21542h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21544j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f21550p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f21551q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f21552r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21553s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21554t = 16;

    public C2384a(Context context, int i8, int i9, int i10, int i11, CharSequence charSequence) {
        this.f21546l = context;
        this.f21535a = i9;
        this.f21536b = i8;
        this.f21537c = i11;
        this.f21538d = charSequence;
    }

    public final void a() {
        Drawable drawable = this.f21545k;
        if (drawable != null) {
            if (this.f21552r || this.f21553s) {
                Drawable drawableI = M.a.i(drawable);
                this.f21545k = drawableI;
                Drawable drawableMutate = drawableI.mutate();
                this.f21545k = drawableMutate;
                if (this.f21552r) {
                    M.a.f(drawableMutate, this.f21550p);
                }
                if (this.f21553s) {
                    M.a.g(this.f21545k, this.f21551q);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public N.b setActionView(int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public N.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public N.b setShowAsActionFlags(int i8) {
        setShowAsAction(i8);
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
        return this.f21544j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f21543i;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f21548n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f21536b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f21545k;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f21550p;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f21551q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f21540f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f21535a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f21542h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f21541g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f21537c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f21538d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f21539e;
        return charSequence != null ? charSequence : this.f21538d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f21549o;
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
        return (this.f21554t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f21554t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f21554t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f21554t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8) {
        this.f21543i = Character.toLowerCase(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f21554t = (z7 ? 1 : 0) | (this.f21554t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        this.f21554t = (z7 ? 2 : 0) | (this.f21554t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public N.b setContentDescription(CharSequence charSequence) {
        this.f21548n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        this.f21554t = (z7 ? 16 : 0) | (this.f21554t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i8) {
        this.f21545k = I.a.e(this.f21546l, i8);
        a();
        return this;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f21550p = colorStateList;
        this.f21552r = true;
        a();
        return this;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f21551q = mode;
        this.f21553s = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f21540f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8) {
        this.f21541g = c8;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f21547m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9) {
        this.f21541g = c8;
        this.f21543i = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i8) {
        this.f21538d = this.f21546l.getResources().getString(i8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f21539e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public N.b setTooltipText(CharSequence charSequence) {
        this.f21549o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        this.f21554t = (this.f21554t & 8) | (z7 ? 0 : 8);
        return this;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8, int i8) {
        this.f21543i = Character.toLowerCase(c8);
        this.f21544j = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f21545k = drawable;
        a();
        return this;
    }

    @Override // N.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c8, int i8) {
        this.f21541g = c8;
        this.f21542h = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9, int i8, int i9) {
        this.f21541g = c8;
        this.f21542h = KeyEvent.normalizeMetaState(i8);
        this.f21543i = Character.toLowerCase(c9);
        this.f21544j = KeyEvent.normalizeMetaState(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f21538d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i8) {
    }
}
