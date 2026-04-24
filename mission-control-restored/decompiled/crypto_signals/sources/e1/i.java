package e1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import b1.EnumC0381c;
import f1.C0589e;
import f1.C0592h;
import f1.InterfaceC0590f;
import g1.InterfaceC0609b;
import n2.C0872a;
import t2.C1161l0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements InterfaceC0609b, InterfaceC0590f, X2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f6065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6067c;

    public /* synthetic */ i(Object obj, long j4, Object obj2) {
        this.f6066b = obj;
        this.f6067c = obj2;
        this.f6065a = j4;
    }

    @Override // g1.InterfaceC0609b
    public Object a() {
        j jVar = (j) this.f6066b;
        long jD = jVar.f6073g.d() + this.f6065a;
        C0592h c0592h = (C0592h) jVar.f6070c;
        Y0.j jVar2 = (Y0.j) this.f6067c;
        c0592h.getClass();
        c0592h.g(new C0589e(jD, jVar2));
        return null;
    }

    @Override // f1.InterfaceC0590f
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((EnumC0381c) this.f6067c).f4879a;
        String string = Integer.toString(i);
        String str = (String) this.f6066b;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, string});
        try {
            boolean z6 = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j4 = this.f6065a;
            if (z6) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j4 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i));
            contentValues.put("events_dropped_count", Long.valueOf(j4));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // X2.a
    public void b(X2.b bVar) {
        ((C0872a) bVar.get()).d((String) this.f6066b, this.f6065a, (C1161l0) this.f6067c);
    }

    public /* synthetic */ i(String str, long j4, C1161l0 c1161l0) {
        this.f6066b = str;
        this.f6065a = j4;
        this.f6067c = c1161l0;
    }
}
