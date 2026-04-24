package L;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import m.D0;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cursor f1024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1025d;
    public a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f1026f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f1027k;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f1024c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.e;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.f1026f;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f1024c = cursor;
            if (cursor != null) {
                a aVar2 = this.e;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.f1026f;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.f1025d = cursor.getColumnIndexOrThrow("_id");
                this.f1022a = true;
                notifyDataSetChanged();
            } else {
                this.f1025d = -1;
                this.f1022a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f1022a || (cursor = this.f1024c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1022a) {
            return null;
        }
        this.f1024c.moveToPosition(i);
        if (view == null) {
            D0 d02 = (D0) this;
            view = d02.f8218n.inflate(d02.f8217m, viewGroup, false);
        }
        a(view, this.f1024c);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f1027k == null) {
            d dVar = new d();
            dVar.f1028a = this;
            this.f1027k = dVar;
        }
        return this.f1027k;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Cursor cursor;
        if (!this.f1022a || (cursor = this.f1024c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f1024c;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        Cursor cursor;
        if (this.f1022a && (cursor = this.f1024c) != null && cursor.moveToPosition(i)) {
            return this.f1024c.getLong(this.f1025d);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1022a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f1024c.moveToPosition(i)) {
            throw new IllegalStateException(a3.d.f(i, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = d(viewGroup);
        }
        a(view, this.f1024c);
        return view;
    }
}
