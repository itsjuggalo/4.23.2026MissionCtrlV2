package f1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import i1.AbstractC0646a;

/* JADX INFO: renamed from: f1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0589e implements InterfaceC0590f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f6406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Y0.j f6407b;

    public /* synthetic */ C0589e(long j4, Y0.j jVar) {
        this.f6406a = j4;
        this.f6407b = jVar;
    }

    @Override // f1.InterfaceC0590f
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f6406a));
        Y0.j jVar = this.f6407b;
        String str = jVar.f3565a;
        V0.d dVar = jVar.f3567c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(AbstractC0646a.a(dVar))}) < 1) {
            contentValues.put("backend_name", jVar.f3565a);
            contentValues.put("priority", Integer.valueOf(AbstractC0646a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
