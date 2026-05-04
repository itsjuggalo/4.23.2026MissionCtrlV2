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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements n0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f16439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f16440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f16441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char f16442g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public char f16444i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f16446k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f16447l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f16448m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f16449n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f16450o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16443h = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16445j = 4096;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f16451p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PorterDuff.Mode f16452q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16453r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16454s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f16455t = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f16447l = context;
        this.f16436a = i11;
        this.f16437b = i10;
        this.f16438c = i13;
        this.f16439d = charSequence;
    }

    public final void a() {
        Drawable drawable = this.f16446k;
        if (drawable != null) {
            if (this.f16453r || this.f16454s) {
                Drawable drawableI = m0.a.i(drawable);
                this.f16446k = drawableI;
                Drawable drawableMutate = drawableI.mutate();
                this.f16446k = drawableMutate;
                if (this.f16453r) {
                    m0.a.f(drawableMutate, this.f16451p);
                }
                if (this.f16454s) {
                    m0.a.g(this.f16446k, this.f16452q);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n0.b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n0.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public n0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
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
        return this.f16445j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f16444i;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f16449n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f16437b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f16446k;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f16451p;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f16452q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f16441f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f16436a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f16443h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f16442g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f16438c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f16439d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f16440e;
        return charSequence != null ? charSequence : this.f16439d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f16450o;
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
        return (this.f16455t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f16455t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f16455t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f16455t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f16444i = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f16455t = (z10 ? 1 : 0) | (this.f16455t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f16455t = (z10 ? 2 : 0) | (this.f16455t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f16455t = (z10 ? 16 : 0) | (this.f16455t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f16446k = drawable;
        a();
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f16451p = colorStateList;
        this.f16453r = true;
        a();
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f16452q = mode;
        this.f16454s = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f16441f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f16442g = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f16448m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f16442g = c10;
        this.f16444i = Character.toLowerCase(c11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f16439d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f16440e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f16455t = (this.f16455t & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f16444i = Character.toLowerCase(c10);
        this.f16445j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public n0.b setContentDescription(CharSequence charSequence) {
        this.f16449n = charSequence;
        return this;
    }

    @Override // n0.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f16442g = c10;
        this.f16443h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f16439d = this.f16447l.getResources().getString(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public n0.b setTooltipText(CharSequence charSequence) {
        this.f16450o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f16446k = i0.a.f(this.f16447l, i10);
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f16442g = c10;
        this.f16443h = KeyEvent.normalizeMetaState(i10);
        this.f16444i = Character.toLowerCase(c11);
        this.f16445j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
    }
}
