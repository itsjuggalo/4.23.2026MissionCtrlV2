package l;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class t extends i implements SubMenu {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i f8054v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j f8055w;

    public t(Context context, i iVar, j jVar) {
        super(context);
        this.f8054v = iVar;
        this.f8055w = jVar;
    }

    @Override // l.i
    public final boolean d(j jVar) {
        return this.f8054v.d(jVar);
    }

    @Override // l.i
    public final boolean e(i iVar, MenuItem menuItem) {
        return super.e(iVar, menuItem) || this.f8054v.e(iVar, menuItem);
    }

    @Override // l.i
    public final boolean f(j jVar) {
        return this.f8054v.f(jVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f8055w;
    }

    @Override // l.i
    public final i j() {
        return this.f8054v.j();
    }

    @Override // l.i
    public final boolean l() {
        return this.f8054v.l();
    }

    @Override // l.i
    public final boolean m() {
        return this.f8054v.m();
    }

    @Override // l.i
    public final boolean n() {
        return this.f8054v.n();
    }

    @Override // l.i, android.view.Menu
    public final void setGroupDividerEnabled(boolean z6) {
        this.f8054v.setGroupDividerEnabled(z6);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        q(0, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        q(0, charSequence, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        q(0, null, 0, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f8055w.setIcon(drawable);
        return this;
    }

    @Override // l.i, android.view.Menu
    public final void setQwertyMode(boolean z6) {
        this.f8054v.setQwertyMode(z6);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        q(0, null, i, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        q(i, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.f8055w.setIcon(i);
        return this;
    }
}
