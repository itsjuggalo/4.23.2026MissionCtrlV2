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
    public d f10542B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f10543C;

    public j(Context context, d dVar, e eVar) {
        super(context);
        this.f10542B = dVar;
        this.f10543C = eVar;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean C() {
        return this.f10542B.C();
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean D() {
        return this.f10542B.D();
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean E() {
        return this.f10542B.E();
    }

    @Override // androidx.appcompat.view.menu.d
    public void M(d.a aVar) {
        this.f10542B.M(aVar);
    }

    public Menu X() {
        return this.f10542B;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean e(e eVar) {
        return this.f10542B.e(eVar);
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean g(d dVar, MenuItem menuItem) {
        return super.g(dVar, menuItem) || this.f10542B.g(dVar, menuItem);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f10543C;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean j(e eVar) {
        return this.f10542B.j(eVar);
    }

    @Override // androidx.appcompat.view.menu.d, android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f10542B.setGroupDividerEnabled(z7);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i8) {
        return (SubMenu) super.O(i8);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i8) {
        return (SubMenu) super.R(i8);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.T(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i8) {
        this.f10543C.setIcon(i8);
        return this;
    }

    @Override // androidx.appcompat.view.menu.d, android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f10542B.setQwertyMode(z7);
    }

    @Override // androidx.appcompat.view.menu.d
    public d z() {
        return this.f10542B.z();
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.P(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.S(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f10543C.setIcon(drawable);
        return this;
    }
}
