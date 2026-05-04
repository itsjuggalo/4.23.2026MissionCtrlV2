package i9;

import android.database.Cursor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r1 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f12145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f12146b;

    public r1(e3 e3Var, p pVar) {
        this.f12145a = e3Var;
        this.f12146b = pVar;
    }

    public static /* synthetic */ f9.e e(String str, Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new f9.e(str, cursor.getInt(0), new j9.v(new a7.s(cursor.getLong(1), cursor.getInt(2))), cursor.getInt(3), cursor.getLong(4));
    }

    public static /* synthetic */ f9.j f(r1 r1Var, String str, Cursor cursor) {
        r1Var.getClass();
        if (cursor == null) {
            return null;
        }
        try {
            return new f9.j(str, r1Var.f12146b.a(ab.a.h0(cursor.getBlob(2))), new j9.v(new a7.s(cursor.getLong(0), cursor.getInt(1))));
        } catch (com.google.protobuf.d0 e10) {
            throw n9.b.a("NamedQuery failed to parse: %s", e10);
        }
    }

    @Override // i9.a
    public f9.e a(final String str) {
        return (f9.e) this.f12145a.D("SELECT schema_version, create_time_seconds, create_time_nanos, total_documents,  total_bytes FROM bundles WHERE bundle_id = ?").b(str).d(new n9.t() { // from class: i9.p1
            @Override // n9.t
            public final Object apply(Object obj) {
                return r1.e(str, (Cursor) obj);
            }
        });
    }

    @Override // i9.a
    public void b(f9.e eVar) {
        this.f12145a.w("INSERT OR REPLACE INTO bundles (bundle_id, schema_version, create_time_seconds, create_time_nanos, total_documents, total_bytes) VALUES (?, ?, ?, ?, ?, ?)", eVar.a(), Integer.valueOf(eVar.c()), Long.valueOf(eVar.b().b().h()), Integer.valueOf(eVar.b().b().b()), Integer.valueOf(eVar.e()), Long.valueOf(eVar.d()));
    }

    @Override // i9.a
    public void c(f9.j jVar) {
        this.f12145a.w("INSERT OR REPLACE INTO named_queries (name, read_time_seconds, read_time_nanos, bundled_query_proto) VALUES (?, ?, ?, ?)", jVar.b(), Long.valueOf(jVar.c().b().h()), Integer.valueOf(jVar.c().b().b()), this.f12146b.j(jVar.a()).i());
    }

    @Override // i9.a
    public f9.j d(final String str) {
        return (f9.j) this.f12145a.D("SELECT read_time_seconds, read_time_nanos, bundled_query_proto FROM named_queries WHERE name = ?").b(str).d(new n9.t() { // from class: i9.q1
            @Override // n9.t
            public final Object apply(Object obj) {
                return r1.f(this.f12139a, str, (Cursor) obj);
            }
        });
    }
}
