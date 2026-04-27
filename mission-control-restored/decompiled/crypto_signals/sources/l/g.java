package l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f7976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7977b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7979d;
    public final LayoutInflater e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f7980f;

    public g(i iVar, LayoutInflater layoutInflater, boolean z6, int i) {
        this.f7979d = z6;
        this.e = layoutInflater;
        this.f7976a = iVar;
        this.f7980f = i;
        a();
    }

    public final void a() {
        i iVar = this.f7976a;
        j jVar = iVar.f7998s;
        if (jVar != null) {
            iVar.i();
            ArrayList arrayList = iVar.f7989j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((j) arrayList.get(i)) == jVar) {
                    this.f7977b = i;
                    return;
                }
            }
        }
        this.f7977b = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j getItem(int i) {
        ArrayList arrayListK;
        i iVar = this.f7976a;
        if (this.f7979d) {
            iVar.i();
            arrayListK = iVar.f7989j;
        } else {
            arrayListK = iVar.k();
        }
        int i6 = this.f7977b;
        if (i6 >= 0 && i >= i6) {
            i++;
        }
        return (j) arrayListK.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListK;
        i iVar = this.f7976a;
        if (this.f7979d) {
            iVar.i();
            arrayListK = iVar.f7989j;
        } else {
            arrayListK = iVar.k();
        }
        return this.f7977b < 0 ? arrayListK.size() : arrayListK.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z6 = false;
        if (view == null) {
            view = this.e.inflate(this.f7980f, viewGroup, false);
        }
        int i6 = getItem(i).f8003b;
        int i7 = i - 1;
        int i8 = i7 >= 0 ? getItem(i7).f8003b : i6;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f7976a.l() && i6 != i8) {
            z6 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z6);
        q qVar = (q) view;
        if (this.f7978c) {
            listMenuItemView.setForceShowIcon(true);
        }
        qVar.b(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
