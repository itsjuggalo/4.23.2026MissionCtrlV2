package P;

import P.b;
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
    public boolean f3367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cursor f3369c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f3370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C0056a f3372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DataSetObserver f3373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public P.b f3374i;

    /* JADX INFO: renamed from: P.a$a, reason: collision with other inner class name */
    public class C0056a extends ContentObserver {
        public C0056a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4) {
            a.this.i();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f3367a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f3367a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z4) {
        f(context, cursor, z4 ? 1 : 2);
    }

    @Override // P.b.a
    public void a(Cursor cursor) {
        Cursor cursorJ = j(cursor);
        if (cursorJ != null) {
            cursorJ.close();
        }
    }

    @Override // P.b.a
    public Cursor b() {
        return this.f3369c;
    }

    @Override // P.b.a
    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    public void f(Context context, Cursor cursor, int i4) {
        if ((i4 & 1) == 1) {
            i4 |= 2;
            this.f3368b = true;
        } else {
            this.f3368b = false;
        }
        boolean z4 = cursor != null;
        this.f3369c = cursor;
        this.f3367a = z4;
        this.f3370e = context;
        this.f3371f = z4 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i4 & 2) == 2) {
            this.f3372g = new C0056a();
            this.f3373h = new b();
        } else {
            this.f3372g = null;
            this.f3373h = null;
        }
        if (z4) {
            C0056a c0056a = this.f3372g;
            if (c0056a != null) {
                cursor.registerContentObserver(c0056a);
            }
            DataSetObserver dataSetObserver = this.f3373h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f3367a || (cursor = this.f3369c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        if (!this.f3367a) {
            return null;
        }
        this.f3369c.moveToPosition(i4);
        if (view == null) {
            view = g(this.f3370e, this.f3369c, viewGroup);
        }
        e(view, this.f3370e, this.f3369c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f3374i == null) {
            this.f3374i = new P.b(this);
        }
        return this.f3374i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        Cursor cursor;
        if (!this.f3367a || (cursor = this.f3369c) == null) {
            return null;
        }
        cursor.moveToPosition(i4);
        return this.f3369c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        Cursor cursor;
        if (this.f3367a && (cursor = this.f3369c) != null && cursor.moveToPosition(i4)) {
            return this.f3369c.getLong(this.f3371f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (!this.f3367a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f3369c.moveToPosition(i4)) {
            if (view == null) {
                view = h(this.f3370e, this.f3369c, viewGroup);
            }
            e(view, this.f3370e, this.f3369c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i4);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    public void i() {
        Cursor cursor;
        if (!this.f3368b || (cursor = this.f3369c) == null || cursor.isClosed()) {
            return;
        }
        this.f3367a = this.f3369c.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f3369c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0056a c0056a = this.f3372g;
            if (c0056a != null) {
                cursor2.unregisterContentObserver(c0056a);
            }
            DataSetObserver dataSetObserver = this.f3373h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f3369c = cursor;
        if (cursor == null) {
            this.f3371f = -1;
            this.f3367a = false;
            notifyDataSetInvalidated();
            return cursor2;
        }
        C0056a c0056a2 = this.f3372g;
        if (c0056a2 != null) {
            cursor.registerContentObserver(c0056a2);
        }
        DataSetObserver dataSetObserver2 = this.f3373h;
        if (dataSetObserver2 != null) {
            cursor.registerDataSetObserver(dataSetObserver2);
        }
        this.f3371f = cursor.getColumnIndexOrThrow("_id");
        this.f3367a = true;
        notifyDataSetChanged();
        return cursor2;
    }
}
