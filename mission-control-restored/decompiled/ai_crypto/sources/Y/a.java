package Y;

import Y.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cursor f5507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f5508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0100a f5510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataSetObserver f5511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Y.b f5512h;

    /* JADX INFO: renamed from: Y.a$a, reason: collision with other inner class name */
    public class C0100a extends ContentObserver {
        public C0100a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            a.this.i();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f5505a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f5505a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z7) {
        f(context, cursor, z7 ? 1 : 2);
    }

    @Override // Y.b.a
    public void a(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    @Override // Y.b.a
    public Cursor b() {
        return this.f5507c;
    }

    @Override // Y.b.a
    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    public void f(Context context, Cursor cursor, int i7) {
        if ((i7 & 1) == 1) {
            i7 |= 2;
            this.f5506b = true;
        } else {
            this.f5506b = false;
        }
        boolean z7 = cursor != null;
        this.f5507c = cursor;
        this.f5505a = z7;
        this.f5508d = context;
        this.f5509e = z7 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i7 & 2) == 2) {
            this.f5510f = new C0100a();
            this.f5511g = new b();
        } else {
            this.f5510f = null;
            this.f5511g = null;
        }
        if (z7) {
            C0100a c0100a = this.f5510f;
            if (c0100a != null) {
                cursor.registerContentObserver(c0100a);
            }
            DataSetObserver dataSetObserver = this.f5511g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f5505a || (cursor = this.f5507c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f5505a) {
            return null;
        }
        this.f5507c.moveToPosition(i7);
        if (view == null) {
            view = g(this.f5508d, this.f5507c, viewGroup);
        }
        e(view, this.f5508d, this.f5507c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f5512h == null) {
            this.f5512h = new Y.b(this);
        }
        return this.f5512h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        Cursor cursor;
        if (!this.f5505a || (cursor = this.f5507c) == null) {
            return null;
        }
        cursor.moveToPosition(i7);
        return this.f5507c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        Cursor cursor;
        if (this.f5505a && (cursor = this.f5507c) != null && cursor.moveToPosition(i7)) {
            return this.f5507c.getLong(this.f5509e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f5505a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f5507c.moveToPosition(i7)) {
            if (view == null) {
                view = h(this.f5508d, this.f5507c, viewGroup);
            }
            e(view, this.f5508d, this.f5507c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i7);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    public void i() {
        Cursor cursor;
        if (!this.f5506b || (cursor = this.f5507c) == null || cursor.isClosed()) {
            return;
        }
        this.f5505a = this.f5507c.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f5507c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0100a c0100a = this.f5510f;
            if (c0100a != null) {
                cursor2.unregisterContentObserver(c0100a);
            }
            DataSetObserver dataSetObserver = this.f5511g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f5507c = cursor;
        if (cursor != null) {
            C0100a c0100a2 = this.f5510f;
            if (c0100a2 != null) {
                cursor.registerContentObserver(c0100a2);
            }
            DataSetObserver dataSetObserver2 = this.f5511g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f5509e = cursor.getColumnIndexOrThrow("_id");
            this.f5505a = true;
            notifyDataSetChanged();
        } else {
            this.f5509e = -1;
            this.f5505a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
