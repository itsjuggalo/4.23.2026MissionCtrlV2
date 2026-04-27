package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.d;

/* JADX INFO: loaded from: classes.dex */
public class j extends d implements SubMenu {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public d f6500B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f6501C;

    public j(Context context, d dVar, e eVar) {
        super(context);
        this.f6500B = dVar;
        this.f6501C = eVar;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean B() {
        return this.f6500B.B();
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean C() {
        return this.f6500B.C();
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean D() {
        return this.f6500B.D();
    }

    @Override // androidx.appcompat.view.menu.d
    public void L(d.a aVar) {
        this.f6500B.L(aVar);
    }

    public Menu W() {
        return this.f6500B;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean e(e eVar) {
        return this.f6500B.e(eVar);
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean g(d dVar, MenuItem menuItem) {
        return super.g(dVar, menuItem) || this.f6500B.g(dVar, menuItem);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f6501C;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean j(e eVar) {
        return this.f6500B.j(eVar);
    }

    @Override // androidx.appcompat.view.menu.d, android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.f6500B.setGroupDividerEnabled(z4);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.O(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.R(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.S(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f6501C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.d, android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f6500B.setQwertyMode(z4);
    }

    @Override // androidx.appcompat.view.menu.d
    public d z() {
        return this.f6500B.z();
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i4) {
        return (SubMenu) super.N(i4);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i4) {
        return (SubMenu) super.Q(i4);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i4) {
        this.f6501C.setIcon(i4);
        return this;
    }
}
