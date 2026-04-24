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
    public d f6550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6551b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f6554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f6555f;

    public c(d dVar, LayoutInflater layoutInflater, boolean z7, int i7) {
        this.f6553d = z7;
        this.f6554e = layoutInflater;
        this.f6550a = dVar;
        this.f6555f = i7;
        a();
    }

    public void a() {
        e eVarT = this.f6550a.t();
        if (eVarT != null) {
            ArrayList arrayListV = this.f6550a.v();
            int size = arrayListV.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (((e) arrayListV.get(i7)) == eVarT) {
                    this.f6551b = i7;
                    return;
                }
            }
        }
        this.f6551b = -1;
    }

    public d b() {
        return this.f6550a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e getItem(int i7) {
        ArrayList arrayListV = this.f6553d ? this.f6550a.v() : this.f6550a.A();
        int i8 = this.f6551b;
        if (i8 >= 0 && i7 >= i8) {
            i7++;
        }
        return (e) arrayListV.get(i7);
    }

    public void d(boolean z7) {
        this.f6552c = z7;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6551b < 0 ? (this.f6553d ? this.f6550a.v() : this.f6550a.A()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6554e.inflate(this.f6555f, viewGroup, false);
        }
        int groupId = getItem(i7).getGroupId();
        int i8 = i7 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f6550a.B() && groupId != (i8 >= 0 ? getItem(i8).getGroupId() : groupId));
        h.a aVar = (h.a) view;
        if (this.f6552c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i7), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
