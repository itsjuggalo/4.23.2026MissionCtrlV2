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
    public d f6401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6402b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6403c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LayoutInflater f6405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6406g;

    public c(d dVar, LayoutInflater layoutInflater, boolean z4, int i4) {
        this.f6404e = z4;
        this.f6405f = layoutInflater;
        this.f6401a = dVar;
        this.f6406g = i4;
        a();
    }

    public void a() {
        e eVarT = this.f6401a.t();
        if (eVarT != null) {
            ArrayList arrayListV = this.f6401a.v();
            int size = arrayListV.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (((e) arrayListV.get(i4)) == eVarT) {
                    this.f6402b = i4;
                    return;
                }
            }
        }
        this.f6402b = -1;
    }

    public d b() {
        return this.f6401a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e getItem(int i4) {
        ArrayList arrayListV = this.f6404e ? this.f6401a.v() : this.f6401a.A();
        int i5 = this.f6402b;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return (e) arrayListV.get(i4);
    }

    public void d(boolean z4) {
        this.f6403c = z4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6402b < 0 ? (this.f6404e ? this.f6401a.v() : this.f6401a.A()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6405f.inflate(this.f6406g, viewGroup, false);
        }
        int groupId = getItem(i4).getGroupId();
        int i5 = i4 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f6401a.B() && groupId != (i5 >= 0 ? getItem(i5).getGroupId() : groupId));
        h.a aVar = (h.a) view;
        if (this.f6403c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i4), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
