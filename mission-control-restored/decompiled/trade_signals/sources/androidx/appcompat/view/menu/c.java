package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f10443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10444b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f10447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10448f;

    public c(d dVar, LayoutInflater layoutInflater, boolean z7, int i8) {
        this.f10446d = z7;
        this.f10447e = layoutInflater;
        this.f10443a = dVar;
        this.f10448f = i8;
        a();
    }

    public void a() {
        e eVarT = this.f10443a.t();
        if (eVarT != null) {
            ArrayList arrayListV = this.f10443a.v();
            int size = arrayListV.size();
            for (int i8 = 0; i8 < size; i8++) {
                if (((e) arrayListV.get(i8)) == eVarT) {
                    this.f10444b = i8;
                    return;
                }
            }
        }
        this.f10444b = -1;
    }

    public d b() {
        return this.f10443a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e getItem(int i8) {
        ArrayList arrayListV = this.f10446d ? this.f10443a.v() : this.f10443a.A();
        int i9 = this.f10444b;
        if (i9 >= 0 && i8 >= i9) {
            i8++;
        }
        return (e) arrayListV.get(i8);
    }

    public void d(boolean z7) {
        this.f10445c = z7;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList arrayListV = this.f10446d ? this.f10443a.v() : this.f10443a.A();
        int i8 = this.f10444b;
        int size = arrayListV.size();
        return i8 < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i8) {
        return i8;
    }

    @Override // android.widget.Adapter
    public View getView(int i8, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f10447e.inflate(this.f10448f, viewGroup, false);
        }
        int groupId = getItem(i8).getGroupId();
        int i9 = i8 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f10443a.C() && groupId != (i9 >= 0 ? getItem(i9).getGroupId() : groupId));
        h.a aVar = (h.a) view;
        if (this.f10445c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i8), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
