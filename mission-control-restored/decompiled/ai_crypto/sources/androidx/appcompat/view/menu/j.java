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
    public d f6649B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f6650C;

    public j(Context context, d dVar, e eVar) {
        super(context);
        this.f6649B = dVar;
        this.f6650C = eVar;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean B() {
        return this.f6649B.B();
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean C() {
        return this.f6649B.C();
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean D() {
        return this.f6649B.D();
    }

    @Override // androidx.appcompat.view.menu.d
    public void L(d.a aVar) {
        this.f6649B.L(aVar);
    }

    public Menu W() {
        return this.f6649B;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean e(e eVar) {
        return this.f6649B.e(eVar);
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean g(d dVar, MenuItem menuItem) {
        return super.g(dVar, menuItem) || this.f6649B.g(dVar, menuItem);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f6650C;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean j(e eVar) {
        return this.f6649B.j(eVar);
    }

    @Override // androidx.appcompat.view.menu.d, android.view.Menu
    public void setGroupDividerEnabled(boolean z7) {
        this.f6649B.setGroupDividerEnabled(z7);
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
        this.f6650C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.d, android.view.Menu
    public void setQwertyMode(boolean z7) {
        this.f6649B.setQwertyMode(z7);
    }

    @Override // androidx.appcompat.view.menu.d
    public d z() {
        return this.f6649B.z();
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i7) {
        return (SubMenu) super.N(i7);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i7) {
        return (SubMenu) super.Q(i7);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i7) {
        this.f6650C.setIcon(i7);
        return this;
    }
}
