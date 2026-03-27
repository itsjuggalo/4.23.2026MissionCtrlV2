package l;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import x.AbstractC1393a;

/* JADX INFO: loaded from: classes.dex */
public final class j implements MenuItem {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f8000A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8005d;
    public CharSequence e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f8006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f8007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f8008h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f8009j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f8011l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i f8013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public t f8014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f8015p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f8016q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f8017r;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f8024z;
    public int i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8010k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8012m = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f8018s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f8019t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8020u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8021v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8022w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8023x = 16;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f8001B = false;
    public int y = 0;

    public j(i iVar, int i, int i6, int i7, int i8, CharSequence charSequence) {
        this.f8013n = iVar;
        this.f8002a = i6;
        this.f8003b = i;
        this.f8004c = i7;
        this.f8005d = i8;
        this.e = charSequence;
    }

    public static void a(StringBuilder sb, int i, int i6, String str) {
        if ((i & i6) == i6) {
            sb.append(str);
        }
    }

    public final Drawable b(Drawable drawable) {
        if (drawable != null && this.f8022w && (this.f8020u || this.f8021v)) {
            drawable = drawable.mutate();
            if (this.f8020u) {
                AbstractC1393a.h(drawable, this.f8018s);
            }
            if (this.f8021v) {
                AbstractC1393a.i(drawable, this.f8019t);
            }
            this.f8022w = false;
        }
        return drawable;
    }

    public final j c(CharSequence charSequence) {
        this.f8016q = charSequence;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.f8024z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f8000A;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f8013n.d(this);
        }
        return false;
    }

    public final void d(boolean z6) {
        if (z6) {
            this.f8023x |= 32;
        } else {
            this.f8023x &= -33;
        }
    }

    public final j e(CharSequence charSequence) {
        this.f8017r = charSequence;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        MenuItem.OnActionExpandListener onActionExpandListener;
        if ((((this.y & 8) == 0 || this.f8024z == null) ? false : true) && ((onActionExpandListener = this.f8000A) == null || onActionExpandListener.onMenuItemActionExpand(this))) {
            return this.f8013n.f(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f8024z;
        if (view != null) {
            return view;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f8010k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f8009j;
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f8016q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f8003b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f8011l;
        if (drawable != null) {
            return b(drawable);
        }
        int i = this.f8012m;
        if (i == 0) {
            return null;
        }
        Drawable drawableR = D1.b.r(this.f8013n.f7982a, i);
        this.f8012m = 0;
        this.f8011l = drawableR;
        return b(drawableR);
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f8018s;
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f8019t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f8007g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f8002a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f8008h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f8004c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f8014o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f8006f;
        return charSequence != null ? charSequence : this.e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f8017r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f8014o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f8001B;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f8023x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f8023x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f8023x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f8023x & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f8024z = view;
        if (view != null && view.getId() == -1 && (i = this.f8002a) > 0) {
            view.setId(i);
        }
        i iVar = this.f8013n;
        iVar.f7990k = true;
        iVar.o(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c6) {
        if (this.f8009j == c6) {
            return this;
        }
        this.f8009j = Character.toLowerCase(c6);
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z6) {
        int i = this.f8023x;
        int i6 = (z6 ? 1 : 0) | (i & (-2));
        this.f8023x = i6;
        if (i != i6) {
            this.f8013n.o(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z6) {
        int i = this.f8023x;
        if ((i & 4) == 0) {
            int i6 = (i & (-3)) | (z6 ? 2 : 0);
            this.f8023x = i6;
            if (i != i6) {
                this.f8013n.o(false);
            }
            return this;
        }
        i iVar = this.f8013n;
        iVar.getClass();
        ArrayList arrayList = iVar.f7986f;
        int size = arrayList.size();
        iVar.s();
        for (int i7 = 0; i7 < size; i7++) {
            j jVar = (j) arrayList.get(i7);
            if (jVar.f8003b == this.f8003b && (jVar.f8023x & 4) != 0 && jVar.isCheckable()) {
                boolean z7 = jVar == this;
                int i8 = jVar.f8023x;
                int i9 = (z7 ? 2 : 0) | (i8 & (-3));
                jVar.f8023x = i9;
                if (i8 != i9) {
                    jVar.f8013n.o(false);
                }
            }
        }
        iVar.r();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        c(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z6) {
        if (z6) {
            this.f8023x |= 16;
        } else {
            this.f8023x &= -17;
        }
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f8012m = 0;
        this.f8011l = drawable;
        this.f8022w = true;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8018s = colorStateList;
        this.f8020u = true;
        this.f8022w = true;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f8019t = mode;
        this.f8021v = true;
        this.f8022w = true;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f8007g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c6) {
        if (this.f8008h == c6) {
            return this;
        }
        this.f8008h = c6;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f8000A = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f8015p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c6, char c7) {
        this.f8008h = c6;
        this.f8009j = Character.toLowerCase(c7);
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i6 = i & 3;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = i;
        i iVar = this.f8013n;
        iVar.f7990k = true;
        iVar.o(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.f8013n.o(false);
        t tVar = this.f8014o;
        if (tVar != null) {
            tVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f8006f = charSequence;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        e(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z6) {
        int i = this.f8023x;
        int i6 = (z6 ? 0 : 8) | (i & (-9));
        this.f8023x = i6;
        if (i != i6) {
            i iVar = this.f8013n;
            iVar.f7988h = true;
            iVar.o(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c6, int i) {
        if (this.f8009j == c6 && this.f8010k == i) {
            return this;
        }
        this.f8009j = Character.toLowerCase(c6);
        this.f8010k = KeyEvent.normalizeMetaState(i);
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c6, int i) {
        if (this.f8008h == c6 && this.i == i) {
            return this;
        }
        this.f8008h = c6;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c6, char c7, int i, int i6) {
        this.f8008h = c6;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f8009j = Character.toLowerCase(c7);
        this.f8010k = KeyEvent.normalizeMetaState(i6);
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f8011l = null;
        this.f8012m = i;
        this.f8022w = true;
        this.f8013n.o(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f8013n.f7982a.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i6;
        Context context = this.f8013n.f7982a;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f8024z = viewInflate;
        if (viewInflate != null && viewInflate.getId() == -1 && (i6 = this.f8002a) > 0) {
            viewInflate.setId(i6);
        }
        i iVar = this.f8013n;
        iVar.f7990k = true;
        iVar.o(true);
        return this;
    }
}
