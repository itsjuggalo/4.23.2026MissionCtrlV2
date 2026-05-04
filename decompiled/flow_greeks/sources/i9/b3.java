package i9;

import android.database.Cursor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b3 implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f11878a;

    public b3(e3 e3Var) {
        this.f11878a = e3Var;
    }

    public static /* synthetic */ void a(b3 b3Var) {
        if (b3Var.f()) {
            Set setE = b3Var.e();
            o1 o1VarH = b3Var.f11878a.h();
            Iterator it = setE.iterator();
            while (it.hasNext()) {
                e9.j jVar = new e9.j((String) it.next());
                e3 e3Var = b3Var.f11878a;
                e1 e1VarE = e3Var.e(jVar, e3Var.d(jVar));
                HashSet hashSet = new HashSet();
                Iterator it2 = e1VarE.k().iterator();
                while (it2.hasNext()) {
                    hashSet.addAll(((k9.g) it2.next()).f());
                }
                new o(o1VarH, e1VarE, b3Var.f11878a.b(jVar), b3Var.f11878a.d(jVar)).o(hashSet);
            }
            b3Var.g();
        }
    }

    public static /* synthetic */ void c(Boolean[] boolArr, Cursor cursor) {
        try {
            if (h1.f11953b.equals(cursor.getString(0))) {
                boolArr[0] = Boolean.TRUE;
            }
        } catch (IllegalArgumentException e10) {
            throw n9.b.a("SQLitePersistence.DataMigration failed to parse: %s", e10);
        }
    }

    public final void d() {
        this.f11878a.l("build overlays", new Runnable() { // from class: i9.y2
            @Override // java.lang.Runnable
            public final void run() {
                b3.a(this.f12228a);
            }
        });
    }

    public final Set e() {
        final HashSet hashSet = new HashSet();
        this.f11878a.D("SELECT DISTINCT uid FROM mutation_queues").e(new n9.n() { // from class: i9.a3
            @Override // n9.n
            public final void accept(Object obj) {
                hashSet.add(((Cursor) obj).getString(0));
            }
        });
        return hashSet;
    }

    public boolean f() {
        final Boolean[] boolArr = {Boolean.FALSE};
        this.f11878a.D("SELECT migration_name FROM data_migrations").e(new n9.n() { // from class: i9.z2
            @Override // n9.n
            public final void accept(Object obj) {
                b3.c(boolArr, (Cursor) obj);
            }
        });
        return boolArr[0].booleanValue();
    }

    public final void g() {
        this.f11878a.w("DELETE FROM data_migrations WHERE migration_name = ?", h1.f11953b);
    }

    @Override // i9.f1
    public void run() {
        d();
    }
}
