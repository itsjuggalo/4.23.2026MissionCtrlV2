package e1;

import K2.I;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import b1.EnumC0381c;
import f1.C0589e;
import f1.C0592h;
import g1.InterfaceC0609b;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import l2.InterfaceC0798f;
import l2.RunnableC0796d;
import l2.ScheduledExecutorServiceC0797e;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements InterfaceC0609b, InterfaceC0798f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f6062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6064d;
    public final /* synthetic */ Object e;

    public /* synthetic */ h(j jVar, Iterable iterable, Y0.j jVar2, long j4) {
        this.f6061a = 0;
        this.f6063c = jVar;
        this.f6064d = iterable;
        this.e = jVar2;
        this.f6062b = j4;
    }

    @Override // g1.InterfaceC0609b
    public Object a() {
        j jVar = (j) this.f6063c;
        C0592h c0592h = (C0592h) jVar.f6070c;
        c0592h.getClass();
        Iterable iterable = (Iterable) this.f6064d;
        if (iterable.iterator().hasNext()) {
            String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + C0592h.k(iterable);
            SQLiteDatabase sQLiteDatabaseD = c0592h.d();
            sQLiteDatabaseD.beginTransaction();
            try {
                sQLiteDatabaseD.compileStatement(str).execute();
                Cursor cursorRawQuery = sQLiteDatabaseD.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        c0592h.i(cursorRawQuery.getInt(0), EnumC0381c.MAX_RETRIES_REACHED, cursorRawQuery.getString(1));
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                }
                cursorRawQuery.close();
                sQLiteDatabaseD.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseD.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseD.endTransaction();
            }
        }
        c0592h.g(new C0589e(jVar.f6073g.d() + this.f6062b, (Y0.j) this.e));
        return null;
    }

    @Override // l2.InterfaceC0798f
    public ScheduledFuture b(Y3.j jVar) {
        switch (this.f6061a) {
            case 1:
                ScheduledExecutorServiceC0797e scheduledExecutorServiceC0797e = (ScheduledExecutorServiceC0797e) this.f6063c;
                return scheduledExecutorServiceC0797e.f8085b.schedule(new RunnableC0796d(scheduledExecutorServiceC0797e, (Runnable) this.f6064d, jVar, 1), this.f6062b, (TimeUnit) this.e);
            default:
                ScheduledExecutorServiceC0797e scheduledExecutorServiceC0797e2 = (ScheduledExecutorServiceC0797e) this.f6063c;
                return scheduledExecutorServiceC0797e2.f8085b.schedule(new I(scheduledExecutorServiceC0797e2, (Callable) this.f6064d, jVar, 2), this.f6062b, (TimeUnit) this.e);
        }
    }

    public /* synthetic */ h(ScheduledExecutorServiceC0797e scheduledExecutorServiceC0797e, Object obj, long j4, TimeUnit timeUnit, int i) {
        this.f6061a = i;
        this.f6063c = scheduledExecutorServiceC0797e;
        this.f6064d = obj;
        this.f6062b = j4;
        this.e = timeUnit;
    }
}
