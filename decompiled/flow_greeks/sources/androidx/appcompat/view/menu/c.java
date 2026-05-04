package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.h;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f1026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1027b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f1030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1031f;

    public c(d dVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f1029d = z10;
        this.f1030e = layoutInflater;
        this.f1026a = dVar;
        this.f1031f = i10;
        a();
    }

    public void a() {
        e eVarT = this.f1026a.t();
        if (eVarT != null) {
            ArrayList arrayListV = this.f1026a.v();
            int size = arrayListV.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((e) arrayListV.get(i10)) == eVarT) {
                    this.f1027b = i10;
                    return;
                }
            }
        }
        this.f1027b = -1;
    }

    public d b() {
        return this.f1026a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e getItem(int i10) {
        ArrayList arrayListV = this.f1029d ? this.f1026a.v() : this.f1026a.A();
        int i11 = this.f1027b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return (e) arrayListV.get(i10);
    }

    public void d(boolean z10) {
        this.f1028c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1027b < 0 ? (this.f1029d ? this.f1026a.v() : this.f1026a.A()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1030e.inflate(this.f1031f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i11 = i10 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1026a.C() && groupId != (i11 >= 0 ? getItem(i11).getGroupId() : groupId));
        h.a aVar = (h.a) view;
        if (this.f1028c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
